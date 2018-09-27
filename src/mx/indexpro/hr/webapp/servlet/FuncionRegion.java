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
 * Servlet implementation class FuncionRegion
 */
@WebServlet("/FuncionRegion")
public class FuncionRegion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FuncionRegion() {
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
		String opc = request.getParameter("opcion");
		if (opc.equals("registra")) {
			DAORegion daoInsertar = new DAORegion();
		try {

			RegionVO regionVO = new RegionVO();
			
			regionVO.setNombre_Region(request.getParameter("nom_region"));
			
			
			

			daoInsertar.insertarRegion(regionVO);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
		//LOGGER.info("Finaliza el DAO y redirigiendo a la JSP");
		request.setAttribute("MSG", "Registro de empleado almacenado correctament.");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Regiones.jsp");
		dispatcher.forward(request, response);
	}else if(opc.equals("elimina")) {
		RegionVO regionVO = new RegionVO();
		regionVO.setId_Regions(Integer.parseInt(request.getParameter("id_region")));
		
		DAORegion daoeliminar = new DAORegion();
		
		try {
			daoeliminar.eliminaRegion(regionVO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("MSG", "Region borrada correctamente.");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Regiones.jsp");
		dispatcher.forward(request, response);
	}
		
		else if(opc.equals("busca")){
			DAORegion daoregion = new DAORegion();

			try {
				RegionVO regionVO = new RegionVO();
				regionVO.setId_Regions(Integer.parseInt(request.getParameter("id_region")));
				
				request.setAttribute("lista", daoregion.buscarRegion(regionVO));
				RequestDispatcher dispatcher = request.getRequestDispatcher("/ActualizaRegion.jsp");

				dispatcher.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException(e);
			}
			

		
		}
		else if(opc.equals("actualizar")){
			try {
				RegionVO regionVO = new RegionVO();
				regionVO.setId_Regions(Integer.parseInt(request.getParameter("id_region")));
				regionVO.setNombre_Region(request.getParameter("nom_region"));
				

				DAORegion daoactualiza = new DAORegion();

			daoactualiza.actualizarRegion(regionVO);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
		//LOGGER.info("Finaliza el DAO y redirigiendo a la JSP");
		request.setAttribute("MSG", "Actualizado correctamente.");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Regiones.jsp");
		dispatcher.forward(request, response);
			
			
		}
		
		
	
	}

}
