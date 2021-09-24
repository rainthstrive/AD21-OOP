# Genéricos (Generics)

Presentados en J2SE 5.0 (Java Platform, Standard Edition 5), este es una mejora en el sistema de tipos de datos que nos permite operar en objetos de cualquier tipo, mientras proveen seguridad de tipado, brindando estabilidad a tu código haciendo que los bugs sean más sencillos de detectar a tiempo de compilado.

## Introducción

Los Generics nos permiten abstraer sobre tipos de datos. Ejemplos más comunes son los contenedores de tipos, así como aquellos en la jerarquía de la clase Collections (List, LinkedList).

``` java
List myIntList = new LinkedList(); // 1
myIntList.add(new Integer(0)); // 2
Integer x = (Integer) myIntList.iterator().next(); // 3
```

El casteo en la línea 3 es algo molesto. Típicamente, el programador sabe qué tipo de dato será aplicado a una lista en particular. Aún así, el casteo es esencial. El compilador puede solamente garantizar que un **`Object`** será retornado por el **`iterator`**. Para asegurarnos que una asignación de una variable de tipo **`Integer`** sea segura, el casteo entonces es requerido.

Claro, el casteo no solamente presenta código "extra", también introduce la posibilidad de un error al tiempo de ejecución, ya que el programador puede equivocarse.

¿Qué pasaría si los programadores pudieran expresar su intención, y marcar una lista como un contenedor restringido a un tipo particular de datos? Esta es la idea central detrás de los *generics*.

Podemos ver una versión del fragmento de código visto más arriba, pero ahora usando *generics*:

``` java
List<Integer> myIntList = new LinkedList<Integer>(); // 1'
myIntList.add(new Integer(0)); // 2'
Integer x = myIntList.iterator().next(); // 3'
```

Nota cómo el tipo de declaración de la variable **`myIntList`** ha cambiado. Esta especifica que no solamente es una **`List`** arbitraria, sino que en realidad es una **`List`** de **`Integers`**. Podemos decir que **`List`** es una interface genérica que toma un **tipo de parámetro** -- en este caso, **`Integer`**. Podríamos especificar un tipo de parámetro cuando creamos el objeto lista.

*También cabe notar, que el casteo de la linea 3 ha desaparecido.*

Hay una gran diferencia entre los dos ejemplos, y eso es que el compilador ahora puede verificar el tipo de dato correcto en el tiempo de compilación.  Cuando decimos que **`myIntList`** es declarado con el tipo **`List<Integer>`**, esto nos dice algo acerca de la variable **`myIntList`**,  el cual se mantendrá en `true` cuando sea y donde sea que es usado, y el compilador lo va a garantizar. En contraste, el casteo nos dice que el programador piensa que algo es verdad a un solo punto en el código.

**El efecto neto, específicamente en programas grandes, es una mejor legibilidad y robustez de código.**

# Definiendo Genéricos Simples

Veamos primero el siguiente programa:
```java
public class Main {

	public static void main(String[] args) {
		Integer[] intArray = {5, 7, 3};
		Character[] charArray = {'b', 'e', 'm', 'a', 'n', 'i'};
		
		printArray(intArray);
		printArray(charArray);
	}
	
	public static void printArray(Integer[] array) {
		for(Integer el: array)
			System.out.printf("%s", el);
		System.out.println();
	}
	public static void printArray(Character[] array) {
		for(Character el: array)
			System.out.printf("%s", el);
		System.out.println();
	}
}

```

El resultado de este código sería:
```shell
573
bemani
```
___

Mientras que el código de arriba es funcional, representa ciertos problemas al momento de escalar el proyecto y crear nuevos tipos de dato. No solamente usaríamos wrappers, también podríamos estar usando clases propias.

Para solventar esto, usamos métodos genéricos.

```java
public class Main {

	public static void main(String[] args) {
		Object[] intArray = {5, 7, 3};
		Object[] charArray = {'b', 'e', 'm', 'a', 'n', 'i'};
		
		printArray(intArray);
		printArray(charArray);
	}
	
	public static <T> void printArray(T[] array) {
		for(T el: array)
			System.out.printf("%s", el);
		System.out.println();
	}
}

```

El resultado de este código sería:
```shell
573
bemani
```

### ¿Qué sucedio?
Básicamente, en lugar de sobrecargar un método con diferentes parámetros, hemos logrado ingresar un tipo de dato genérico `T`  en los parámetros de nuestra función `printArray`, escribiéndola una única vez. Gracias a esto, evitamos duplicar código innecesario que hace exactamente lo mismo, pero solo varía el tipo de dato.

Nota como no tuvimos que pasar el tipo de argumento al método genérico. El compilador infiere el tipo de argumento por nosotros, basado en el tipo de los propios argumentos. Generalmente va a inferir el tipo de argumento más específico que hace a la llamada correcta en su tipo de dato.

Aún así, tenemos la libertad de pasar el tipo de dato sin problema:

```java
public class Main {

	public static void main(String[] args) {
		Integer[] intArray = {5, 7, 3};
		Character[] charArray = {'b', 'e', 'm', 'a', 'n', 'i'};
		
		printArray(intArray);
		printArray(charArray);
	}
	
	public static <T> void printArray(T[] array) {
		for(T el: array)
			System.out.printf("%s", el);
		System.out.println();
	}
}

```

El resultado de este código sería:
```shell
573
bemani
```

## Wildcards

Las *wildcards* (comodines) nos permiten flexibilidad al momento de evaluar entre métodos genéricos.
En el siguiente ejemplo, presentamos el siguiente problema:

```java
public class Wildcards<T extends Number> {
	T num;
	Wildcards(T t){
		this.num = t;
	}
	boolean absoluteEqual(Wildcards<T> t) {
		if(Math.abs(num.doubleValue()) == Math.abs(t.num.doubleValue()))
			return true;
		return false;
	}
}
```

```java
public class Main {

	public static void main(String[] args) {
		Wildcards<Integer> integerW = new Wildcards<Integer>(5); // Línea 6
		Wildcards<Double> doubleW = new Wildcards<Double>(-5.0); // Línea 7
		
		System.out.println(integerW.absoluteEqual(doubleW)); // Línea 9
	}
}
```

El resultado traerá lo siguiente:
```shell
Exception in thread "main" java.lang.Error: Unresolved compilation problem: 
	The method absoluteEqual(Wildcards<Integer>) in the type Wildcards<Integer> is not applicable for the arguments (Wildcards<Double>)

	at clase15.Main.main(Main.java:9)
```
___
La problemática aquí es que, mientras que tenemos dos objetos cuya clase genérica se adapta por ambos ser subclases de `Number`, la comparativa del método `absoluteEqual` solamente está validando tipos de dato `double`. Es aquí donde podemos hacer uso de *wildcards* para solventar este problema.

Sencillamente, corregimos cambiando `T` por `?` en la definición de `absoluteEqual`

```java
public class Wildcards<T extends Number> {
	T num;
	Wildcards(T t){
		this.num = t;
	}
	boolean absoluteEqual(Wildcards<?> t) {
		if(Math.abs(num.doubleValue()) == Math.abs(t.num.doubleValue()))
			return true;
		return false;
	}
}
```
```java
public class Main {

	public static void main(String[] args) {
		Wildcards<Integer> integerW = new Wildcards<Integer>(5); // Línea 6
		Wildcards<Double> doubleW = new Wildcards<Double>(-5.0); // Línea 7
		
		System.out.println(integerW.absoluteEqual(doubleW)); // Línea 9
	}
}
```

Ahora el resultado será:
```shell
true
```

## ¿Por qué usar Generics?

Los generics permiten a los *types* (clases e interfaces) ser parámetros cuando definimos clases, interfaces, y métodos. Algo como los más familiares parámetros formales usados en declaraciones de métodos, los parámetros de tipo (types) proveen una forma para que puedas reusar el mismo código con diferentes entradas de datos.
La diferencia es que las entradas a parámetros formales son **valores**, mientras que las entradas de parámetros de tipo son *tipos*. Entre sus beneficios:
- Verificación fuerte de tipos en tiempo de compilación.
- Eliminación de casteos
- Permitir a los programadores usar algoritmos genéricos.

## Referencias
- https://docs.oracle.com/javase/tutorial/java/generics/index.html
- https://youtu.be/ZoJaD0Qoi0o
- https://www.youtube.com/watch?v=h7piyWnQbZA