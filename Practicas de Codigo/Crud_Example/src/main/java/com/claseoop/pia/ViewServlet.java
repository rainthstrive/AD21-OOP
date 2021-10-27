package com.claseoop.pia;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewServlet
 */
@WebServlet(description = "Servlet para ver la lista de empleados", urlPatterns = { "/ViewServlet" })
public class ViewServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)   
            throws ServletException, IOException {  
     response.setContentType("text/html");         
     ArrayList<Emp> list = EmpDao.GetAllEmps();  
     
     PrintWriter out=response.getWriter();  
     out.println("<a href='index.html'>Agregar nuevo Empleado</a>");  
     out.println("<h1>Lista de Empleados</h1>");  
     out.print("<table border='1' width='100%'");  
     out.print("<tr><th>Id</th><th>Nombre</th><th>Contrasena</th><th>Correo</th><th>Pais</th><th>Editar</th><th>Borrar</th></tr>");  
     
     for(Emp e:list){  
      out.print("<tr><td>"+e.getId()+"</td><td>"+e.getName()+"</td><td>"+e.getPassword()+"</td>");
      out.print("<td>"+e.getEmail()+"</td><td>"+e.getCountry()+"</td><td><a href='EditServlet?id="+e.getId()+"'>editar</a></td>");
      out.print("<td><a href='DeleteServlet?id="+e.getId()+"'>borrar</a></td></tr>");  
     }  
     
     out.print("</table>");  
       
     out.close();  
 }  
}
