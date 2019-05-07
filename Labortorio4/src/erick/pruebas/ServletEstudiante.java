package erick.pruebas;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletEstudiante
 */
@WebServlet("/ServletEstudiante")
public class ServletEstudiante extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletEstudiante() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		Estudiante e = new Estudiante();
		
		String nombre = request.getParameter("nombre");
		
		String edad1 = request.getParameter("edad");
		
		String id1 = request.getParameter("id");
		
		int edad = Integer.parseInt(edad1);
		
		int id = Integer.parseInt(id1);
		
		e.setNombre(nombre);
		
		e.setEdad(edad);
		
		e.setId(id);
		
		request.setAttribute("estudiante", e);
		
		RequestDispatcher ourDispacher = request.getRequestDispatcher("/jsp/JSTL1.jsp");
		
		ourDispacher.forward(request,response);
	}

}
