package mx.indexpro.hr.webapp.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.indexpro.hr.webapp.dao.DAOEmployee;
import mx.indexpro.hr.webapp.dao.DAOInsertar;
import mx.indexpro.hr.webapp.vo.EmpleadoVO;

/**
 * Servlet implementation class EmpleadosServlet
 */
@WebServlet("/EmpleadosServlet")
public class EmpleadosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmpleadosServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 * 
	 * 
	 *      /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String opc = request.getParameter("opcion");

		if (opc.equals("registra")) {
			try {

				RequestDispatcher dispatcher = request.getRequestDispatcher("/Alta.jsp");

				dispatcher.forward(request, response);

			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException(e);
			}
		} else if (opc.contentEquals("elimina")) {
			try {

				RequestDispatcher dispatcher = request.getRequestDispatcher("/bajaEmp.jsp");

				dispatcher.forward(request, response);

			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException(e);
			}
		}
		else if (opc.equals("actualiza")) {
			DAOInsertar daoEmployee = new DAOInsertar();
			try {
				EmpleadoVO empleadoVO = new EmpleadoVO();
				request.setAttribute("listaEmpleado", daoEmployee.buscarEmpleados(empleadoVO));
				RequestDispatcher dispatcher = request.getRequestDispatcher("/ActualizaEmp.jsp");

				dispatcher.forward(request, response);

			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException(e);
			}
		}
		else if(opc.equals("regresa")){
			try {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/Index.jsp");

			dispatcher.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
			
		}
		else {
		DAOEmployee daoEmployee = new DAOEmployee();

		try {
			request.setAttribute("listaEmpleado", daoEmployee.getEmployees());

			RequestDispatcher dispatcher = request.getRequestDispatcher("/consultaEmp.jsp");

			dispatcher.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
		}
	}

}
