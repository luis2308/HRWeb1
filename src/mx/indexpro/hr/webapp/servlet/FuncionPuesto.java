package mx.indexpro.hr.webapp.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;

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
 * Servlet implementation class FuncionPuesto
 */
@WebServlet("/FuncionPuesto")
public class FuncionPuesto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FuncionPuesto() {
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
			DAOPuesto daoInsertar = new DAOPuesto();
		try {

			PuestoVO puestoVO = new PuestoVO();
			puestoVO.setIdPuesto(request.getParameter("id_puesto"));
			puestoVO.setNomPuesto(request.getParameter("nom_puesto"));
			puestoVO.setMinSalario(Integer.parseInt(request.getParameter("min_salario")));
			puestoVO.setMaxSalario(Integer.parseInt(request.getParameter("max_salario")));
			
			

			daoInsertar.insertarPuesto(puestoVO);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
		//LOGGER.info("Finaliza el DAO y redirigiendo a la JSP");
		request.setAttribute("MSG", "Registro de empleado almacenado correctament.");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Puesto.jsp");
		dispatcher.forward(request, response);
	}else if(opc.equals("elimina")) {
		PuestoVO puestovo = new PuestoVO();
		puestovo.setIdPuesto(request.getParameter("id_puesto"));
		
		DAOPuesto daoeliminar = new DAOPuesto();
		
		try {
			daoeliminar.eliminaPuesto(puestovo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("MSG", "Empleado borrado correctamente.");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Puesto.jsp");
		dispatcher.forward(request, response);
	}
		
		else if(opc.equals("busca")){
			DAOPuesto daopuesto = new DAOPuesto();

			try {
				PuestoVO puestovo = new PuestoVO();
				puestovo.setIdPuesto(request.getParameter("id_puesto"));
				
				request.setAttribute("listaEmpleado", daopuesto.buscarPuesto(puestovo));
				RequestDispatcher dispatcher = request.getRequestDispatcher("/ActualizaPuesto.jsp");

				dispatcher.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException(e);
			}
			

		
		}
		else if(opc.equals("actualizar")){
			try {
				PuestoVO puestovo = new PuestoVO();
				puestovo.setNomPuesto(request.getParameter("nom_puesto"));
				puestovo.setMinSalario(Integer.parseInt(request.getParameter("min_salario")));
				puestovo.setMaxSalario(Integer.parseInt(request.getParameter("max_salario")));
				puestovo.setIdPuesto(request.getParameter("id_puesto"));

			DAOPuesto daoactualiza = new DAOPuesto();

			daoactualiza.actualizarPuesto(puestovo);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
		//LOGGER.info("Finaliza el DAO y redirigiendo a la JSP");
		request.setAttribute("MSG", "Actualizado correctamente.");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Puesto.jsp");
		dispatcher.forward(request, response);
			
			
		}
		
		
	}

}
