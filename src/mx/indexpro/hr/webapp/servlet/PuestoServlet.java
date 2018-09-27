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
import mx.indexpro.hr.webapp.dao.DAOPuesto;
import mx.indexpro.hr.webapp.vo.EmpleadoVO;
import mx.indexpro.hr.webapp.vo.PuestoVO;

/**
 * Servlet implementation class PuestoServlet
 */
@WebServlet("/PuestoServlet")
public class PuestoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PuestoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String opc = request.getParameter("opcion");

		if (opc.equals("registra")) {
			try {

				RequestDispatcher dispatcher = request.getRequestDispatcher("/AltaPuesto.jsp");

				dispatcher.forward(request, response);

			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException(e);
			}
		} else if (opc.contentEquals("elimina")) {
			try {

				RequestDispatcher dispatcher = request.getRequestDispatcher("/BajaPuesto.jsp");

				dispatcher.forward(request, response);

			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException(e);
			}
		}
		else if (opc.equals("actualiza")) {
			DAOPuesto daoEmployee = new DAOPuesto();
			try {
				PuestoVO puestovo = new PuestoVO();
				request.setAttribute("listaEmpleado", daoEmployee.buscarPuesto(puestovo));
				RequestDispatcher dispatcher = request.getRequestDispatcher("/ActualizaPuesto.jsp");

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
		else if(opc.equals("consulta")){
		DAOPuesto daoEmployee = new DAOPuesto();

		try {
			request.setAttribute("lista", daoEmployee.getPuesto());

			RequestDispatcher dispatcher = request.getRequestDispatcher("/ConsultaPuesto.jsp");

			dispatcher.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
		}
	
	}

}
