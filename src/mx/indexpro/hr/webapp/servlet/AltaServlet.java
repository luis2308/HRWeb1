package mx.indexpro.hr.webapp.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.logging.Logger;

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
 * Servlet implementation class AltaServlet
 */
@WebServlet("/AltaServlet")
public class AltaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AltaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    private static Logger LOGGER = Logger.getLogger( DAOInsertar.class.getName() );

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
			DAOInsertar daoInsertar = new DAOInsertar();
		try {

			EmpleadoVO empleadoVO = new EmpleadoVO();
			empleadoVO.setNombre(request.getParameter("nombre"));
			empleadoVO.setApellido(request.getParameter("ap_paterno"));
			empleadoVO.setEmail(request.getParameter("email"));
			empleadoVO.setTelefono(request.getParameter("num_tel"));
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			empleadoVO.setFechaContratacion(format.parse(request.getParameter("fech_ncont")));
			empleadoVO.setIdPuesto(request.getParameter("id_trab"));
			empleadoVO.setSalario(Double.parseDouble(request.getParameter("salario")));
			empleadoVO.setComision(Double.parseDouble(request.getParameter("comision")));
			empleadoVO.setIdSuperior(Integer.parseInt(request.getParameter("id_gerente")));
			empleadoVO.setIdDepartamento(Integer.parseInt(request.getParameter("id_dep")));

			

			daoInsertar.insertarEmpleado(empleadoVO);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
		LOGGER.info("Finaliza el DAO y redirigiendo a la JSP");
		request.setAttribute("MSG", "Registro de empleado almacenado correctament.");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Empleados.jsp");
		dispatcher.forward(request, response);
	}
		else if(opc.equals("elimina")) {
		EmpleadoVO empleadoVO = new EmpleadoVO();
		empleadoVO.setIdEmpleado(Integer.parseInt(request.getParameter("id_emp")));
		
		DAOInsertar daoInsertar = new DAOInsertar();
		
		try {
			daoInsertar.eliminaEmpleado(empleadoVO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("MSG", "Empleado borrado correctamente.");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Empleados.jsp");
		dispatcher.forward(request, response);
	}
	else if(opc.equals("busca")){
		DAOInsertar daoEmployee = new DAOInsertar();

		try {
			EmpleadoVO empleadoVO = new EmpleadoVO();
			empleadoVO.setIdEmpleado(Integer.parseInt(request.getParameter("id_emp")));
			
			request.setAttribute("listaEmpleado", daoEmployee.buscarEmpleados(empleadoVO));
			RequestDispatcher dispatcher = request.getRequestDispatcher("/ActualizaEmp.jsp");

			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
		

	
	}
	else if(opc.equals("actualizar")){
		try {
		EmpleadoVO empleadoVO = new EmpleadoVO();
		empleadoVO.setNombre(request.getParameter("nombre"));
		empleadoVO.setApellido(request.getParameter("ap_paterno"));
		empleadoVO.setEmail(request.getParameter("email"));
		empleadoVO.setTelefono(request.getParameter("num_tel"));
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		empleadoVO.setFechaContratacion(format.parse(request.getParameter("fech_ncont")));
		empleadoVO.setIdPuesto(request.getParameter("id_trab"));
		empleadoVO.setSalario(Double.parseDouble(request.getParameter("salario")));
		empleadoVO.setComision(Double.parseDouble(request.getParameter("comision")));
		empleadoVO.setIdSuperior(Integer.parseInt(request.getParameter("id_gerente")));
		empleadoVO.setIdDepartamento(Integer.parseInt(request.getParameter("id_dep")));
		empleadoVO.setIdEmpleado(Integer.parseInt(request.getParameter("id_empleado")));

		DAOInsertar daoInsertar = new DAOInsertar();

		daoInsertar.actualizarEmpleado(empleadoVO);
	} catch (Exception e) {
		e.printStackTrace();
		throw new ServletException(e);
	}
	//LOGGER.info("Finaliza el DAO y redirigiendo a la JSP");
	request.setAttribute("MSG", "Actualizado correctamente.");
	RequestDispatcher dispatcher = request.getRequestDispatcher("/Empleados.jsp");
	dispatcher.forward(request, response);
		
		
	}
		
	}
	
	}



