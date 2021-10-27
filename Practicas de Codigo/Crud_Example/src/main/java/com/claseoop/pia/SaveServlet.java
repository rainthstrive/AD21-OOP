package com.claseoop.pia;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SaveServlet
 */
@WebServlet(description = "Servlet para guardar empleados", urlPatterns = { "/SaveServlet" })
public class SaveServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String country = request.getParameter("country");

		Emp e = new Emp();
		e.setName(name);
		e.setPassword(password);
		e.setEmail(email);
		e.setCountry(country);

		int status = EmpDao.SaveEmp(e);
		if (status > 0) {
			out.print("<p>Se ha guardado el nuevo empleado!</p>");
			request.getRequestDispatcher("index.html").include(request, response);
		} else {
			out.println("El empleado no se ha podido guardar.");
		}

		out.close();
	}
}
