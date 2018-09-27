package mx.indexpro.hr.webapp.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.indexpro.hr.webapp.dao.DAODepartamento;
import mx.indexpro.hr.webapp.vo.DepartamentoVO;



/**
 * Servlet implementation class FuncionDepartamento
 */
@WebServlet("/FuncionDepartamento")
public class FuncionDepartamento extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FuncionDepartamento() {
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
		String funcion = request.getParameter("accion");

		if (funcion.equals("alta")) {
			try {
				DepartamentoVO departamentoVO = new DepartamentoVO();
				departamentoVO.setNombreDepartamento(request.getParameter("nom_dep"));
				departamentoVO.setIdGerente(request.getParameter("id_gerente"));
				departamentoVO.setIdUbicacion(Integer.parseInt(request.getParameter("id_ubicacion")));

				DAODepartamento daoInsertar = new DAODepartamento();

				daoInsertar.insertarDepartamento(departamentoVO);

				RequestDispatcher dispatcher = request.getRequestDispatcher("/Departamento.jsp");
				dispatcher.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException(e);
			}
		} else if (funcion.equals("elimina")) {
			try {
				DepartamentoVO departamentoVO = new DepartamentoVO();
				departamentoVO.setIdDepartamento(Integer.parseInt(request.getParameter("id_dep")));

				DAODepartamento daoElimina = new DAODepartamento();

				daoElimina.eliminaDepartamento(departamentoVO);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/Departamento.jsp");
				dispatcher.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException(e);
			}

		}else if(funcion.equals("busca")) {
			try {
				DAODepartamento daobusca = new DAODepartamento();
				DepartamentoVO departamentoVO = new DepartamentoVO();
				departamentoVO.setIdDepartamento(Integer.parseInt(request.getParameter("id_dep")));
				
				request.setAttribute("listaDepartamento", daobusca.getBusca(departamentoVO));

				RequestDispatcher dispatcher = request.getRequestDispatcher("/ActualizaDepartamento.jsp");

				dispatcher.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException(e);
			}
			
		}else if(funcion.equals("actualiza")) {
			try {
				DepartamentoVO departamentoVO = new DepartamentoVO();
				departamentoVO.setNombreDepartamento(request.getParameter("nom_dep"));
				departamentoVO.setIdGerente(request.getParameter("id_gerente"));
				departamentoVO.setIdUbicacion(Integer.parseInt(request.getParameter("id_ubicacion")));
				departamentoVO.setIdDepartamento(Integer.parseInt(request.getParameter("id_dep")));

				DAODepartamento daoDepartamento = new DAODepartamento();
				

				daoDepartamento.actualizaDepartamento(departamentoVO);

				RequestDispatcher dispatcher = request.getRequestDispatcher("/Departamento.jsp");
				dispatcher.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException(e);
			}
			
		}
	}

}
