package com.example;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
public class ServletparameterServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request,HttpServletResponse response)
		throws ServletException,IOException{
			ServletConfig c = this.getServletConfig();
			PrintWriter writer = response.getWriter();
			writer.append("database: ").append(c.getInitParameter("database"))
				.append(" , server: ").append(c.getInitParameter("server"));
		}
}
