# Manejo de Archivos

El manejo de archivos es una parte importante de cualquier aplicación.
Java tiene diferentes maneras de crear, leer, actualizar, y borrar archivos.

La clase **`File`** del paquete **`java.io`** nos permite trabajar con archivos.
Para usar la clase **`File`**, crea un objeto de la clase, y especifica el nombre del archivo, o nombre del directorio:
```java
import java.io.File;     //Importamos la clase File
    
File myObj = new File("filename.txt");    //Especificamos el nombre del archivo
```

La clase **`File`** tiene muchos métodos útiles para crear y obtener información de archivos. Por ejemplo:
| Método | Tipo | Descripción |
|--|--|--|
| `canRead()` | *Boolean* | Prueba si un archivo es legible o no |
| `canWrite()` | *Boolean* | Prueba si un archivo es escribible o no |
| `creatNewFile()` | *Boolean* | Crea un archivo vacío |
| `delete()` | *Boolean* | Borra un archivo |
| `exists()` | *Boolean* | Prueba si el archivo existe |
| `getName()` | *String* | Retorna el nombre del archivo |
| `getAbsolutePath()` | *String* | Retorna el nombre de la ruta absoluta del archivo |
| `length()` | *Long* | Retorna el tamaño del archivo en bytes |
| `list()` | *String[]* | Retorna un arreglo de los archivos en el directorio |
| `mkdir()` | *Boolean* | Crea un directorio |

## Creando archivos

Para crear un archivo en Java, se puede usar el método **`createNewFile()`**. Este método retorna un valor booleano: **`true`** si el archivo fue creado exitosamente, y **`false`** si el archivo ya existe. Hay que notar que el método debe estar encerrado en un bloque **`try ... catch`**. Esto es necesario porque el método retorna un  **`IOException`** si un error ocurre (si el archivo no pudo ser creado por alguna razón):

### Ejemplo

```java
import java.io.File;  // Importamos la clase File
import java.io.IOException;  // Importamos la clase IOException para manejar errores

public class CreateFile {
  public static void main(String[] args) {
    try {
      File myObj = new File("filename.txt");
      if (myObj.createNewFile()) {
        System.out.println("Archivo creado: " + myObj.getName());
      } else {
        System.out.println("El archivo ya existe.");
      }
    } catch (IOException e) {
      System.out.println("Ocurrió un error.");
      e.printStackTrace();
    }
  }
}
```

La salida de esto sería:
`Archivo creado: filename.txt`

___

Para crear un archivo en un directorio específico (esto requiere permisos), se especifica la ruta del archivo y se usan backlashes dobles para escapar el carácter "`\`"  (esto es para Windows). En Mac y Linux se puede escribir la ruta en forma normal como: **`/Users/name/filename.txt`**

Ejemplo:
```java
File myObj = new File("C:\\Users\\MyName\\filename.txt");
```

## Escribir hacia un archivo

En el siguiente ejemplo, usamos la clase **`FileWriter`** junto con el método **`write()`** para escribir algo de texto hacia el archivo que hemos creado en el ejemplo anterior. Hay que notar que cuando terminas de escribir hacia un archivo, este debe cerrarse con el método **`close()`**

### Ejemplo

```java
import java.io.FileWriter;   // Importa la clase FileWriter
import java.io.IOException;  // Importa IOException class to handle errors

public class WriteToFile {
  public static void main(String[] args) {
    try {
      FileWriter myWriter = new FileWriter("filename.txt");
      myWriter.write("Los archivos en Java pueden ser complicados, ¡pero es divertido de desarrollar!");
      myWriter.close();
      System.out.println("Se escribió al archivo exitosamente.");
    } catch (IOException e) {
      System.out.println("Ocurrió un error.");
      e.printStackTrace();
    }
  }
}
```
La salida de esto sería:
`Se escribió al archivo exitosamente.`

## Lectura de Archivos

En este ejemplo, usaremos la clase **`Scanner`** para leer los contenidos del archivo de texto que creamos previamente:

### Ejemplo

```java
import java.io.File;  // Importamos la clase File
import java.io.FileNotFoundException;  // Importamos esta clase para manejar errores
import java.util.Scanner; // Importamos la clase Scanner para leer archivos de texto

public class ReadFile {
  public static void main(String[] args) {
    try {
      File myObj = new File("filename.txt");
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        System.out.println(data);
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("Ocurrió un error.");
      e.printStackTrace();
    }
  }
}
```
La salida de esto sería:
`Los archivos en Java pueden ser complicados, ¡pero es divertido de desarrollar!`

## Obtener información de Archivos

Para obtener información sobre un archivo, se puede usar cualquier método de **`File`**

### Ejemplo
```java
import java.io.File;  // Importamos la clase File

public class GetFileInfo {   public static void main(String[] args) {
    File myObj = new File("filename.txt");
    if (myObj.exists()) {
      System.out.println("Nombre de archivo: " + myObj.getName());
      System.out.println("Ruta absoluta: " + myObj.getAbsolutePath());
      System.out.println("¿Es escribible?: " + myObj.canWrite());
      System.out.println("¿Es legible? " + myObj.canRead());
      System.out.println("Tamaño del archivo en bytes " + myObj.length());
    } else {
      System.out.println("El archivo no existe.");
    }
  }
}
```
La salida de esto sería:

    Nombre de archivo: filename.txt  
    Ruta absoluta: C:\Users\MyName\filename.txt  
    ¿Es escribible?: true  
    ¿Es legible?: true  
    Tamaño del archivo en bytes: 0

**Nota**: Existen más clases en la API de Java que pueden ser usados para escribir y leer archivos: **`FileReader`**, **`BufferedReader`**, **`Files`**, **`Scanner`**, **`FileInputStream`**, **`FileWriter`**, **`BufferedWriter`**, **`FileOutputStream`**, entre otros. Cual usar depende en la versión de Java con la que se trabaja, t si se necesita leer bytes o caracteres, y del tamaño del archivo/líneas etc. 

## Borrar Archivos

Para borrar un archivo en Java, usa el método **`delete()`**:

### Ejemplo
```java
import java.io.File;  // Importamos la clase File

public class DeleteFile {
  public static void main(String[] args) { 
    File myObj = new File("filename.txt"); 
    if (myObj.delete()) { 
      System.out.println("Se borró el archivo: " + myObj.getName());
    } else {
      System.out.println("Ocurrió un error al borrar el archivo.");
    } 
  } 
}
```
La salida de esto sería:
`Se borró el archivo: filename.txt`

## Borrar una Carpeta
También se puede borrar una carpeta. Pero, esta debe estar vacía:

### Ejemplo
```java
import java.io.File; 

public class DeleteFolder {
  public static void main(String[] args) { 
    File myObj = new File("C:\\Users\\MyName\\Test"); 
    if (myObj.delete()) { 
      System.out.println("Se ha borrado la carpeta: " + myObj.getName());
    } else {
      System.out.println("Ocurrió un error al intentar borrar la carpeta.");
    } 
  } 

```
La salida de esto sería:
`Se ha borrado la carpeta: Test`


## Referencias
- https://www.w3schools.com/java/java_files.asp
- https://www.w3schools.com/java/java_files_create.asp
- https://www.w3schools.com/java/java_files_read.asp
- https://www.w3schools.com/java/java_files_delete.asp