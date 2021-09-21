# Genéricos (Generics)

Presentados en J2SE 5.0 (Java Platform, Standard Edition 5), este es una mejora en el sistema de tipado que nos permite a un tipo o método para operar en objetos de varios tipos, mientras proveen seguridad de tipado a tiempo de compilación. Esto añade seguridad en la *Collections Framework* y elimina la necesidad del casteo.

## Introducción

Los Generics nos permiten abstraer sobre tipos de datos. Ejemplos más comunes son los contenedores de tipos, así como aquellos en la jerarquía de Collections.

``` java
List myIntList = new LinkedList(); // 1
myIntList.add(new Integer(0)); // 2
Integer x = (Integer) myIntList.iterator().next(); // 3
```

El casteo en la línea 3 es algo molesto. Típicamente, el programador sabe qué tipo de dato será aplicado a una lista en particular. Aún así, el casteo es esencial. El compilador puede solamente garantizar que un **`Object`** será retornado por el **`iterator`**. Para asegurarnos que una asignación de una variable de tipo **`Integer`** sea seguro, el casteo entonces es requerido.

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

## Referencias
- https://docs.oracle.com/javase/tutorial/extra/generics/index.html por *Gilad Bracha*