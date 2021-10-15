# Servlets

Los servlets son la tecnología en Java para extender y mejorar servidores Web. Proveen un método para construir aplicaciones web basadas en componentes, y son independientes de plataforma. En su tiempo, esto evitaba el interactuar con mecanismos de extensiones de servers, como Netscape Server API, o módulos Apache. Fueron creados por Sun Microsystems en 1997.

Aunque los servlets pueden responder a cualquier tipo de solicitudes, estos son utilizados comúnmente para extender las aplicaciones alojadas por servidores web, de tal manera que pueden ser vistos como applets de Java que se ejecutan en servidores en vez de navegadores web. Este tipo de servlets son la contraparte Java de otras tecnologías de contenido dinámico Web, como PHP y ASP.NET.

> La palabra  _servlet_  deriva de otra anterior, applet que se refiere a pequeños programas que se ejecutan en el contexto de un navegador web.

El uso más común de los  _servlets_  es generar páginas web de forma dinámica a partir de los parámetros de la petición que envíe el navegador web

## Ejemplo procesando una petición GET
```java
package org.pruebas;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EjemploServlet extends HttpServlet {

/**
 * Servlet de ejemplo que procesa una petición GET
 * @param request
 * @param response
 * @throws ServletException
 * @throws IOException 
 */
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">");
        out.println("<html>");
        out.println("<head><title>Ejemplo de Servlet</title></head>");
        out.println("<body>");
        out.println("<h1>¡Hola Mundo!</h1>");
        out.println("</body></html>");
    }
}
```

## ¿Qué son las aplicaciones web dinámicas?

Una aplicación web puede ser descrita como una colección de páginas web, y cuando la llamamos dinámica, simplemente significa que las páginas web no serán las mismas para todos los usuarios, ya que serían generadas en el lado del servidor mediante peticiones del cliente (el navegador de internet del usuario). En cambio, las páginas estáticas, como el nombre lo indica, se mantienen igual para todos los usuarios.

## ¿Qué es en sí un servlet?

Un Servlet es un objeto java que pertenece a una clase que extiende javax.servlet.http.HttpServlet. Esto no es del todo exacto ya que existen diferentes tipos de Servlets pero con diferencia HttpServlet es el más usado.

### ¿Qué es un contenedor de Servlets?

Un contenedor de Servlet es un programa capaz de recibir peticiones de páginas web y redireccionar estas peticiones a un objeto Servlet.

Estos funcionan de la siguiente manera:

1.  El Browser pide una página al servidor HTTP que es un contenedor de Servlets
2.  El contenedor de Servlets delega la petición a un Servlet en particular elegido de entre los Servlets que contiene.
3.  El Servlet, que es una objeto java, se encarga de generar el texto de la página web que se entrega al contenedor.
4.  El contenedor devuelve la página web al Browser que la solicitó.

## Entendiendo HTTP

HTTP es el protocolo que permite enviar documentos de un lado a otro en la web. Solo tiene dos funciones diferentes: servidor, y cliente.
Cada mensaje HTTP se compone de una cabecera, y un cuerpo. En REST, los datos de cabecera suelen ser más importantes que el cuerpo.

### URL
Las URL son para identificar las cosas en las que deseas operar. Decimos que cada URL identifica un recurso. Estas son exactamente las mismas URL que se asignan a las páginas web.

![enter image description here](https://developer.mozilla.org/en-US/docs/Learn/Common_questions/What_is_a_URL/mdn-url-all.png)

### Verbos HTTP
Cada solicitud especifica un cierto verbo o método HTTP, en el encabezado de la solicitud, e indican al servidor qué hacer con los datos identificados por la URL.​ En REST, los verbos siempre van en el encabezado, jamás en la URL.
Los verbos más usados e importantes son:​
| Verbo | Descripción |
|--|--|
| GET | El método GET solicita una representación de un recurso específico. Las peticiones de este tipo solo deben usarse para recuperar datos. |
| POST | El método POST se utiliza para enviar una entidad a un recurso en específico, causando a menudo un cambio en el estado o efectos secundarios en el servidor. |
| PUT | El método PUT reemplaza todas las representaciones actuales del recurso de destino con la carga útil de la petición. |
| DELETE | El método DELETE borra un recurso en específico. |
| PATCH | El método PATCH es utilizado para aplicar modificaciones parciales a un recurso. |

### Códigos de Respuesta
Los códigos de respuesta HTTP estandarizan una forma de informar al cliente sobre el resultado de su solicitud. Se encuentran en la cabecera de respuesta de las solicitudes, y se definen por los siguientes números.
| Número | Descripción |
|--|--|
| 2XX | Petición exitosa |
| 3XX | Redirección de recurso |
| 4XX | Error de petición |
| 5XX | Error en el servidor |


## Prerequisitos para desarrollar servlets

 1. Conocimiento básico de Java
 2. Conocimiento básico de métodos HTTP
 3. Instalar Apache Tomcat https://tomcat.apache.org/download-80.cgi

## Estructurando y desplegando un Servlet

Dentro de nuestra instalación de Apache Tomcat, tenemos un directorio llamado webapps\. Nuestras aplicaciones irán en este directorio para que el servidor local pueda mostrarlas en el navegador.

Una aplicación web hecha con servlets tiene un estándar creado por el comité J2EE. Dicho estándar denomina una estructura de directorios y un archivo llamado web.xml, como en la siguiente imagen:

![enter image description here](https://www.javawebtutor.com/images/servlets/web_application.gif)

### Directorio Raíz
El directorio raíz de tu aplicación web puede tener cualquier nombre. En el ejemplo de arriba es llamado mywebapp. Dentro de este, podemos agregar todos los archivos que deberían ser accesibles en la aplicación.
Si tu aplicación está mapeada al url http://localhost:8080/mywebapp/ entonces la página index.html será accedida desde http://localhost:8080/mywebapp/index.html
Si creas subdirectorios bajo la carpeta raíz, y en el agregas archivos, entonces estos serán accesibles por la ruta *subdirectorio/archivo*. Por ejemplo, si tenemos un subdirectorio llamado *pages*, y agregamos el archivo *register.jsp* en, entonces para acceder a ese archivo, el url final sería http://localhost:8080/mywebapp/pages/index.jsp

### El Directorio WEB-INF

Este es un directorio de información de metadatos. Los archivos guardados aquí no pueden ser accedidos por el navegador (aunque tu aplicación **si** los puede acceder internamente).

Dentro de WEB-INF existen dos directorios importantes, y un archivo xml:

#### web.xml
Este es el archivo que contiene la información acerca de la aplicación web, el cual es usado por el servidor web Java o contenedor de servlet, para adecuadamente desplegar y ejecutar la aplicación. Por ejemplo, el web.xml contiene información acerca de cuales servlets una app debe desplegar, y que urls debería tener mapeadas.

#### Directorio classes
Este directorio contiene todas las clases de Java que son parte de tu aplicación. Las clases deben estar localizadas en una estructura de directorio igual que la estructura del package.

#### Directorio lib
Este directorio contiene todos los archivos JAR usados por tu aplicación web. Usualmente se trata de código externo que use tu aplicación. Aunque también podrían ser tus propias clases como un archivo JAR.

## Creando el servlet

Vamos a crear un servlet llamado **com.claseoop.servlets.FirstServlet** con el siguiente código:

```java
package com.claseoop.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet {

	@Override

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("hoy es " + new Date());
		out.println("</body>");
		out.println("</html>");
	}

}

```
La clase FirstServlet extiende **javax.servlet.http.HttpServlet** y sobrescribe el método **doGet(HttpServletRequest req, HttpServletResponse resp)** que es llamado cuando el Servidor Http recibe una petición de tipo GET desde el navegador.

El método  **doGet**  recibe dos parámetros, el primero es un objeto de tipo  **HttpServletRequest**  que contiene toda la información acerca de la petición de la página web y el segundo es un objeto de tipo  **HttpServletResponse**  que se utiliza para rellenar la respuesta que será enviada al Browser.

En el código fuente se puede ver como obtenemos un objeto  **java.io.PrintWriter** del objeto  **HttpServletResponse**  y lo usamos para enviar una página web con la fecha actual tomada del sistema usando un objeto del tipo  **java.util.Date**.

Para desplegar este Servlet en el servidor debemos copiar el archivo compilado FirstServlet.class el directorio WEB-INF\classes\ como se mostró la estructura anteriormente. 

Por último solo nos resta configurar el archivo  **web.xml**  para que Tomcat sepa cuando debe llamar al Servlet FirstServlet. Vamos a configurarlo para que sea llamado cuando alguien pregunte por  **http://localhost:8080/first-servlet/what-time-is-it**

```xml
<web-app>
	<servlet>
		<servlet-name>timeservlet</servlet-name>
		<servlet-class>com.claseoop.servlets.FirstServlet</servlet-class>
	</servlet>
	<servlet-mapping>
		<servlet-name>timeservlet</servlet-name>
		<url-pattern>/what-time-is-it</url-pattern>
	</servlet-mapping>
</web-app>
```

**web-app** es el primer elemento en **web.xml.** Dentro, el elemento **servlet** indica que se creará un Servlet de la clase **com.edu4java.servlets.FirstServlet** bajo el nombre interno **timeservlet**. El elemento **servlet-mapping** asociará el URL **/what-time-is-it** al Servlet con nombre interno **timeservlet**.

Para comprobar la ejecución correcta de nuestro servlet, debemos ir hacia la siguiente ruta:
**http://localhost:8080/first-servlet/what-time-is-it** .

Hay que verificar bien los nombres de las rutas y del proyecto para confirmar que el url sea correcto, así como reiniciar el servidor de ser necesario.

## Fuentes

- https://es.wikipedia.org/wiki/Java_Servlet
- https://www.oracle.com/java/technologies/servlet-technology.html
- https://web.archive.org/web/20130704055325/http://www.lab.inf.uc3m.es/~a0080802/RAI/servlet.html
- https://www.redhat.com/es/topics/api/what-is-a-rest-api
- https://www.javawebtutor.com/articles/servlets/structure_of_java_web_application.php

### Instalando Apache Tomcat en Eclipse IDE
- https://beginnersbook.com/2017/06/how-to-configure-apache-tomcat-server-in-eclipse-ide/
### Creando y ejecutando servlets en Eclipse IDE
- https://beginnersbook.com/2017/07/how-to-create-and-run-servlet-in-eclipse-ide/

### Lecturas SUPER recomendadas
- Toda la serie de tutoriales de http://www.edu4java.com/es/servlet/servlet.html