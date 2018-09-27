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
 * Servlet implementation class FuncionLocacion
 */
@WebServlet("/FuncionLocacion")
public class FuncionLocacion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FuncionLocacion() {
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
			DAOLocaciones daoInsertar = new DAOLocaciones();

			try {
				LocacionVO locacionvo = new LocacionVO();

				locacionvo.setDireccion(request.getParameter("direccion"));
				locacionvo.setCodigo(request.getParameter("codigo"));
				locacionvo.setCiudad(request.getParameter("ciudad"));
				locacionvo.setEstado(request.getParameter("estado"));
				locacionvo.setPais(request.getParameter("pais"));
				
				daoInsertar.registroLocacion(locacionvo);
			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException(e);
			}
			
			request.setAttribute("MSG", "Registro almacenado correctament.");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/Locacion.jsp");
			dispatcher.forward(request, response);
			
	}else if(opc.equals("elimina")) {
	
		try {
			LocacionVO eliminarvo= new LocacionVO();
			//el set esta poniendo un valor en la variable eliminarvo y el get esta obteniendo el valor de la caja
			eliminarvo.setIdLocacion(Integer.parseInt(request.getParameter("location_id")));
			
			DAOLocaciones eliminarDao = new DAOLocaciones();
			eliminarDao.suprimirLocacion(eliminarvo);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}	
		
		request.setAttribute("MSG", "Registro de empleado eliminado correctament.");
		RequestDispatcher dispatcher =  request.getRequestDispatcher("/Locacion.jsp");
		dispatcher.forward(request, response);
	}
		else if(opc.equals("busca")){
			DAOLocaciones daolocacion = new DAOLocaciones();

			try {
				LocacionVO locacionvo = new LocacionVO();
				locacionvo.setIdLocacion(Integer.parseInt(request.getParameter("id_locacion")));
				
				request.setAttribute("lista", daolocacion.buscarLocacion(locacionvo));
				RequestDispatcher dispatcher = request.getRequestDispatcher("/ActualizaLocacion.jsp");

				dispatcher.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException(e);
			}
			

		
		}
		else if(opc.equals("actualizar")){
			try {
				LocacionVO locacionVO = new LocacionVO();
				locacionVO.setDireccion(request.getParameter("direccion"));
				locacionVO.setCodigo(request.getParameter("codigo"));
				locacionVO.setCiudad(request.getParameter("ciudad"));
				locacionVO.setEstado(request.getParameter("estado"));
				locacionVO.setPais(request.getParameter("pais"));
				locacionVO.setIdLocacion(Integer.parseInt(request.getParameter("id_locacion")));
				

			DAOLocaciones daoactualiza = new DAOLocaciones();

			daoactualiza.updateEmpleado(locacionVO);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
		//LOGGER.info("Finaliza el DAO y redirigiendo a la JSP");
		request.setAttribute("MSG", "Actualizado correctamente.");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Locacion.jsp");
		dispatcher.forward(request, response);
			
			
			
			
		}
		
		
	}
	

}
