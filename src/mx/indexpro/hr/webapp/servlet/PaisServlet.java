package mx.indexpro.hr.webapp.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.indexpro.hr.webapp.dao.DAOPais;
import mx.indexpro.hr.webapp.dao.DAOPuesto;
import mx.indexpro.hr.webapp.vo.PaisVO;
import mx.indexpro.hr.webapp.vo.PuestoVO;

/**
 * Servlet implementation class PaisServlet
 */
@WebServlet("/PaisServlet")
public class PaisServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaisServlet() {
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

				RequestDispatcher dispatcher = request.getRequestDispatcher("/AltaPais.jsp");

				dispatcher.forward(request, response);

			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException(e);
			}
		} else if (opc.contentEquals("elimina")) {
			try {

				RequestDispatcher dispatcher = request.getRequestDispatcher("/BajaPais.jsp");

				dispatcher.forward(request, response);

			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException(e);
			}
		}
		else if (opc.equals("actualiza")) {
			DAOPais daopais = new DAOPais();
			try {
				PaisVO paisvo = new PaisVO();
				request.setAttribute("lista", daopais.getBusca(paisvo));
				RequestDispatcher dispatcher = request.getRequestDispatcher("/ActualizaPais.jsp");

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
		DAOPais daopais = new DAOPais();

		try {
			request.setAttribute("lista", daopais.getConsulta());

			RequestDispatcher dispatcher = request.getRequestDispatcher("/ConsultaPais.jsp");

			dispatcher.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
		}
	
	}
	

}
