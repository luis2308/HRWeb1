package mx.indexpro.hr.webapp.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mx.indexpro.hr.webapp.dao.DAORegion;
import mx.indexpro.hr.webapp.vo.RegionVO;

/**
 * Servlet implementation class RegionServlet
 */
@WebServlet("/RegionServlet")
public class RegionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegionServlet() {
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

				RequestDispatcher dispatcher = request.getRequestDispatcher("/AltaRegion.jsp");

				dispatcher.forward(request, response);

			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException(e);
			}
		} else if (opc.contentEquals("elimina")) {
			try {

				RequestDispatcher dispatcher = request.getRequestDispatcher("/BajaRegion.jsp");

				dispatcher.forward(request, response);

			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException(e);
			}
		}
		else if (opc.equals("actualiza")) {
			DAORegion daoEmployee = new DAORegion();
			try {
				RegionVO regionVO = new RegionVO();
				request.setAttribute("lista", daoEmployee.buscarRegion(regionVO));
				RequestDispatcher dispatcher = request.getRequestDispatcher("/ActualizaRegion.jsp");
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
		DAORegion daoEmployee = new DAORegion();

		try {
			request.setAttribute("lista", daoEmployee.getRegion());

			RequestDispatcher dispatcher = request.getRequestDispatcher("/ConsultaRegion.jsp");

			dispatcher.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
		}
	}

}
