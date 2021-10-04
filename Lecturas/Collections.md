# Collections

Las colecciones en Java son un **framework** que provee una arquitectura para **guardar y manipular grupos de objetos**.  Pueden realizar operaciones de datos como **buscar**, **organizar**, **insertar**, **manipular**, y **borrar**.
Estas colecciones son una sola unidad de objetos, donde el framework provee las siguientes interfaces: Set, List, Queue, Deque. 
Asimismo provee las siguientes clases: ArrayList, Vector, LinkedList, PriorityQueue, HashSet, LinkedHashSet, TreeSet.

Aunque son llamados como un framework, funciona a manera de librería.

## ¿Qué es un framework?

Un framework, o marco de trabajo, es un set de clases e interfaces que proveen una arquitectura lista para utilizarse. Para poder implementar una nueva característica o clase, no hay necesidad de implementar un framework, porque un diseño orientado a objetos ya incluirá uno con una colección de clases para que todas las clases realicen el mismo tipo de tarea.

## La necesidad del Collection Framework

Antes del JDK 1.2, los métodos estándares para agrupar objetos en Java eran **arreglos**, **vectores**, o **hashtables**. Estos tipos de colecciones no tenían una interface común. Por lo tanto, aunque el objetivo de estas es el mismo, sus implementaciones son independientes y no tienen una correlación entre ellas. También, es algo complicado para los usuarios el recordar todos los diferentes métodos, sintaxis, y constructores presentes en cada clase de colección. 

## Jerarquía de la Collection Framework

El paquete *java.util* contiene todas las clases e interfaces para este framework. Contiene una interface llamada *iterable interface* el cual provee el iterador (capacidad de repetir operaciones) para recorrer alrededor de todas las colecciones. Esta interface es **extendida** por la interface principal de colecciones, la cual actúa como la raíz de este framework.
Todas las colecciones extienden a esta interface de colección, por lo que extienden las propiedades del iterador y todos los métodos de esta interface.

![enter image description here](https://marcus-biel.com/wp-content/uploads/2015/08/class-and-interface-hierarchy.png)

### Recordatorios
| Concepto | Descripción |
|--|--|
| Class | Una clase es la definición del cual un objeto es creado. Representa el set de propiedades o métodos que son comunes para todos los objetos de un tipo. |
| Interface | Como una clase, una interface puede tener métodos y variables, pero los métodos que son declarados en una interface son por default abstractos (solo tienen la firma del método, no cuerpo de método). Las interfaces especifican **que debe hacer una clase y no el cómo**. Preceden la definición de una clase. |

## ArrayList

La clase **`ArrayList`** es una clase de arreglos redimensionables, que se encuentra dentro de *java.util*.

La diferencia entre un arreglo nativo y un **`ArrayList`** en Java, es que la capacidad de un arreglo no puede ser modificada (si quieres añadir o remover elementos al/desde el arreglo, tienes que crear uno nuevo). Por otro lado, los elementos pueden ser añadidos o removidos desde un **`ArrayList`** cuando uno lo necesite. La sintaxis entre ambos también varía un poco:

### Ejemplos

#### Crear objeto

Crea un objeto **`ArrayList`** llamado cars, que guardará valores:

```java
import java.util.ArrayList; // importamos la clase ArrayList
ArrayList<String> cars= new ArrayList<String>(); // Creamos el objeto ArrayList
```

#### Añadir elementos

La clase **`ArrayList`** tiene muchos métodos útiles. Por ejemplo, para añadir elementos hacia el **`ArrayList`**, usamos el método `add()`

```java
import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {
    ArrayList<String> cars = new ArrayList<String>();
    cars.add("Volvo");
    cars.add("BMW");
    cars.add("Ford");
    cars.add("Mazda");
    System.out.println(cars);
  }
}
```

#### Acceder a un elemento

Para acceder a un elemento en **`ArrayList`**, usamos el método `get()` y referimos al número del índice:

```java
cars.get(0);
```

> Nota: Los índices de arreglos empiezan con 0: [0] es el primer
> elemento. [1] es el segundo elemento, etcétera.

#### Modificar un elemento

Para modificar un elemento, usa el método `set()` y el número de índice para cambiar uno:

```java
cars.set(0, "Opel");
```

#### Eliminar un elemento

Para eliminar un elemento, usa el método `remove()` y el número de índice para cambiar uno:

```java
cars.remove(0);
```

Para eliminar **TODOS** los elementos en **`ArrayList`**, usamos el método `clear()`:

```java
cars.clear();
```

#### Tamaño de un ArrayList

Para saber cuántos elementos tiene un **`ArrayList`**, usa el método `size()`:

```java
cars.size();
```

#### Recorrer un ArrayList

Hacemos un bucle para recorrer los elementos en un **`ArrayList`** con un loop `for`, y usamos el método `size()` para especificar cuántas veces el bucle se deba repetir:

```java
public class Main {
  public static void main(String[] args) {
    ArrayList<String> cars = new ArrayList<String>();
    cars.add("Volvo");
    cars.add("BMW");
    cars.add("Ford");
    cars.add("Mazda");
    for (int i = 0; i < cars.size(); i++) {
      System.out.println(cars.get(i));
    }
  }
}
```

También podemos recorrer un **`ArrayList`** usando un bucle de `for` mejorado, el `for-each`:

```java
public class Main {
  public static void main(String[] args) {
    ArrayList<String> cars = new ArrayList<String>();
    cars.add("Volvo");
    cars.add("BMW");
    cars.add("Ford");
    cars.add("Mazda");
    for (String i : cars) {
      System.out.println(i);
    }
  }
}
```

### Otros Tipos de Datos

Elementos en un **`ArrayList`** son objetos, en realidad. En los ejemplos previos, creamos elementos (objetos) del tipo ***String***. Recordemos que un String en Java es un objeto (no un tipo de dato primitivo). Para usar otros tipos, como un ***int***,  debemos especificar una *clase wrapper* : ***Integer***.
Para otros tipos primitivos, usa: **`Boolean`** para booleanos, **`Character`** para char, etc.

#### Ejemplo

Crea un **`ArrayList`** para guardar números (añadir elementos del tipo **`Integer`**):

```java
import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {
    ArrayList<Integer> myNumbers = new ArrayList<Integer>();
    myNumbers.add(10);
    myNumbers.add(15);
    myNumbers.add(20);
    myNumbers.add(25);
    for (int i : myNumbers) {
      System.out.println(i);
    }
  }
}
```

### Ordenar un ArrayList

Otra clase útil en el paquete ***java.util*** es la ya mencionada ***clase Collections***, la cual incluye el método **`sort()`** para ordenar listas alfabéticamente o numéricamente.

#### Ejemplo

Ordenar un ArrayList de Strings:

```java
import java.util.ArrayList;
import java.util.Collections;  // Importamos la clase Collections

public class Main {
  public static void main(String[] args) {
    ArrayList<String> cars = new ArrayList<String>();
    cars.add("Volvo");
    cars.add("BMW");
    cars.add("Ford");
    cars.add("Mazda");
    Collections.sort(cars);  // Ordena cars
    for (String i : cars) {
      System.out.println(i);
    }
  }
}
```

Ordenando un ArrayList de Integers:

```java
import java.util.ArrayList;
import java.util.Collections;  // Importamos la clase Collections

public class Main {
  public static void main(String[] args) {
    ArrayList<Integer> myNumbers = new ArrayList<Integer>();
    myNumbers.add(33);
    myNumbers.add(15);
    myNumbers.add(20);
    myNumbers.add(34);
    myNumbers.add(8);
    myNumbers.add(12);

    Collections.sort(myNumbers);  // Ordena myNumbers

    for (int i : myNumbers) {
      System.out.println(i);
    }
  }
}
```

## Referencias
- https://www.geeksforgeeks.org/collections-in-java-2/
- https://marcus-biel.com/java-collections-framework/
- https://www.javatpoint.com/collections-in-java

### Lecturas Recomendadas
- Buscar en una Lista para Objetos personalizados https://www.youtube.com/watch?v=CemH5eOY8Rs
- Búsqueda Binaria (más rápida y sin loops) https://www.geeksforgeeks.org/collections-binarysearch-java-examples/