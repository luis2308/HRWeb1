package mx.indexpro.hr.webapp.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.indexpro.hr.webapp.dao.DAOLocaciones;
import mx.indexpro.hr.webapp.dao.DAOPuesto;
import mx.indexpro.hr.webapp.vo.LocacionVO;
import mx.indexpro.hr.webapp.vo.PuestoVO;



/**
 * Servlet implementation class LocacionServlet
 */
@WebServlet("/LocacionServlet")
public class LocacionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LocacionServlet() {
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

				RequestDispatcher dispatcher = request.getRequestDispatcher("/AltaLocacion.jsp");

				dispatcher.forward(request, response);

			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException(e);
			}
		} else if (opc.contentEquals("elimina")) {
			try {

				RequestDispatcher dispatcher = request.getRequestDispatcher("/BajaLocacion.jsp");

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
		else if (opc.equals("actualiza")) {
			DAOLocaciones daolocacion = new DAOLocaciones();
			try {
				LocacionVO locacionVo = new LocacionVO();
				request.setAttribute("lista", daolocacion.buscarLocacion(locacionVo));
				RequestDispatcher dispatcher = request.getRequestDispatcher("/ActualizaLocacion.jsp");

				dispatcher.forward(request, response);

			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException(e);
			}
		}else if(opc.equals("consulta")){
			DAOLocaciones daoEmployee = new DAOLocaciones();

		try {
			request.setAttribute("lista", daoEmployee.getLocaciones());

			RequestDispatcher dispatcher = request.getRequestDispatcher("/ConsultaLocacion.jsp");

			dispatcher.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
		}
	}
	

}
