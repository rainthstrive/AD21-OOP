# Clases Wrapper

Las clases de envoltura, *wrapper*, proveen una forma de usar tipos de datos primitivos (`int`, `boolean`, entre otros) como **objetos**. Existen 8 tipos de primitivos predefinidos en Java. Estos no son objetos, por lo que no poseen métodos (como la clase String, por ejemplo). Sin embargo, cada uno de estos tipos tienen clases wrapper asociadas para convertirlos de primitivos a objetos.

Todos lo Wrappers a su vez dependen de Java.lang.Object ya que, como vemos, los Wrappers no dejan de ser objetos, y por lo tanto, vienen de la clase Object.

![Imagen de Profile.es here](https://profile.es/wp-content/media/image-51.png)
___

La siguiente tabla muestra los tipos de datos primitivos y su equivalente clase ***wrapper***:

| Tipo de dato Primitivo | Clase Wrapper |
|--|--|
| `byte` | **`Byte`**  |
| `short` | **`Short`**  |
| `int` | **`Integer`**  |
| `long` | **`Long`**  |
| `float` | **`Float`**  |
| `double` | **`Double`**  |
| `boolean` | **`Boolean`**  |
| `char` | **`Character`**  |

Algunas veces debemos usar las clases *wrapper*, por ejemplo, cuando trabajamos con objetos *Collection*, como **`ArrayList`**, donde los tipos de datos primitivos no pueden ser usados (la lista solo puede guardar objetos):

### Ejemplo

```java
ArrayList<int> myNumbers = new ArrayList<int>(); // Código NO Valido

```
```java
ArrayList<Integer> myNumbers = new ArrayList<Integer>(); // Código Valido
```
## Creando Objetos Wrapper

Para crear una clase *wrapper*, hay que usar la propia clase wrapper en lugar de su tipado primitivo. Para obtener el valor, se puede simplemente imprimir el objeto:

### Ejemplo

```java
public class Main {
  public static void main(String[] args) {
    Integer myInt = 5;
    Double myDouble = 5.99;
    Character myChar = 'A';
    System.out.println(myInt);
    System.out.println(myDouble);
    System.out.println(myChar);
  }
}
```
___

Ahora que se está trabajando con objetos, se pueden usar ciertos métodos para obtener información acerca de algún objeto específico.

Por ejemplo, los siguientes métodos son usados para obtener el valor asociado con el objeto ***wrapper*** correspondiente: **`intValue()`**, **`byteValue()`**, **`shortValue()`**, **`longValue()`**, **`floatValue()`**, **`doubleValue()`**, **`charValue()`**, **`booleanValue()`**

### Ejemplo

```java
public class Main {
  public static void main(String[] args) {
    Integer myInt = 5;
    Double myDouble = 5.99;
    Character myChar = 'A';
    System.out.println(myInt.intValue());
    System.out.println(myDouble.doubleValue());
    System.out.println(myChar.charValue());
  }
}
```
___

Otro método útil es el **`toString()`**, el cual es usado para convertir objetos *wrapper* hacia cadenas de texto.

En el siguiente ejemplo, convertimos un **`Integer`** hacia un **`String`**, y usamos el método **`length()`** de la clase **`String`** para imprimir el tamaño de "string":

### Ejemplo

```java
public class Main {
  public static void main(String[] args) {
    Integer myInt = 100;
    String myString = myInt.toString();
    System.out.println(myString.length());
  }
}
```

## Autoboxing y Auto Unboxing

### Autoboxing
Se define como *Autoboxing* (*wrapping* automático) al proceso de conversión automática que realiza el compilador de Java **para que un tipo primitivo pase a ser un objeto** utilizando su envoltura, su ***wrapper***.

El proceso de autoboxing se puede apreciar de la siguiente manera:

```java
public class Main {
   public static void main(String[] args) {
       Character chWrapped = 'a'; //Autoboxing
       System.out.println(chWrapped.getClass());
   }
}
```
La salida de este programa sería:
    class java.lang.Character

Lo que sucede realmente es que Java internamente realiza una especie de conversión (casteo) hacia un objeto "similar" a la siguiente:

```java
public class Main {
   public static void main(String[] args) {
       char ch = 'a';
       System.out.println(((Object) ch).getClass());
   }
}
```
La salida de este programa seguiría siendo:
    class java.lang.Character

### Auto Unboxing
El *Auto Unboxing* (*unwrapping* automático) es el proceso de conversión automática que realiza el compilador de Java para que un objeto Wrapper pase a ser primitivo de nuevo, perdiendo con ello sus métodos de envoltura.

![Imagen de Profile.es](https://profile.es/wp-content/media/image-58.png)

## Boxing y Unboxing

En Java, la forma correcta de realizar un Wrapper sería mediante el uso de **`valueOf`**.

### Ejemplo

```java
public class Main {
   public static void main(String[] args) {
       // Declarando una variable primitiva
       int numPrimitive = 6;
       Integer numWrapperFormI = Integer.valueOf(numPrimitive); // Usando el tipado primitivo
       Integer numWrapperFormII = Integer.valueOf(55); // Usando el valor directo
   }
}
```

Podemos apreciar un ejemplo más avanzado respecto al anterior:

### Ejemplo

```java
public class Main {
   public static void main(String[] args) {
       // Declarando una variable primitiva
	       int numI = 6;
	       // Se imprimen los datos
	       Main m = new Main();
	       // Comparamos 6 (valor de numI) vs 6, e imprime 0
	       m.checkNumber(numI, 6);
	       // Comparamos 6 (valor de numI) vs 1, e imprime 1
	       m.checkNumber(numI, 1);
	       // Comparamos 6 (valor de numI) vs 33, e imprime -1
	       m.checkNumber(numI, 33);
	   }

	   private static void checkNumber(int numberToWrapper, int numberToCheck) {
		   // Usando el dato primitivo Form I 
	       Integer numWrapped = Integer.valueOf(numberToWrapper);
	       if (numWrapped.compareTo(numberToCheck) == 0) {
	           System.out.println(numberToWrapper + " = " + numberToCheck + " y el compareTo devolverá " + numWrapped.compareTo(numberToCheck));
	       } else if (numWrapped.compareTo(numberToCheck) == 1) {
	           System.out.println(numberToWrapper + " > " + numberToCheck + " y el compareTo devolverá " + numWrapped.compareTo(numberToCheck));
	       } else if (numWrapped.compareTo(numberToCheck) == -1) {
	           System.out.println(numberToWrapper + " < " + numberToCheck + " y el compareTo devolverá " + numWrapped.compareTo(numberToCheck));
	       }
	}
}
```

## Referencias
- https://www.w3schools.com/java/java_wrapper_classes.asp
- https://profile.es/blog/clases-wrapper-envoltorio-en-java/