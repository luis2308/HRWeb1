package mx.indexpro.hr.webapp.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.indexpro.hr.webapp.dao.DAODepartamento;
import mx.indexpro.hr.webapp.dao.DAOPais;
import mx.indexpro.hr.webapp.vo.DepartamentoVO;
import mx.indexpro.hr.webapp.vo.PaisVO;

/**
 * Servlet implementation class FuncionPais
 */
@WebServlet("/FuncionPais")
public class FuncionPais extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FuncionPais() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String funcion = request.getParameter("accion");
		if (funcion.equals("alta")) {
			try {
				PaisVO paisVO = new PaisVO();
				paisVO.setIdPais(request.getParameter("id_pais"));
				paisVO.setNombre(request.getParameter("nombre"));
				paisVO.setIdRegion(Integer.parseInt(request.getParameter("region")));

				DAOPais daoInsertar = new DAOPais();

				daoInsertar.insertarPais(paisVO);

				RequestDispatcher dispatcher = request.getRequestDispatcher("/Pais.jsp");
				dispatcher.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException(e);
			}
		}
		else if (funcion.equals("elimina")) {
			try {
				PaisVO paisVO = new PaisVO();
				paisVO.setIdPais(request.getParameter("id_pais"));

				DAOPais daoElimina = new DAOPais();

				daoElimina.eliminaPais(paisVO);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/Pais.jsp");
				dispatcher.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException(e);
			}

		}else if(funcion.equals("busca")) {
			try {
				DAOPais daobusca = new DAOPais();
				PaisVO paisVO = new PaisVO();
				paisVO.setIdPais(request.getParameter("id_pais"));
				
				request.setAttribute("lista", daobusca.getBusca(paisVO));

				RequestDispatcher dispatcher = request.getRequestDispatcher("/ActualizaPais.jsp");

				dispatcher.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException(e);
			}
			
		}else if(funcion.equals("actualizar")) {
			try {
				PaisVO paisVO = new PaisVO();
				paisVO.setNombre(request.getParameter("nombre"));
				paisVO.setIdRegion(Integer.parseInt(request.getParameter("region")));
				paisVO.setIdPais(request.getParameter("id_pais"));
				

				DAOPais daoPais = new DAOPais();
				

				daoPais.actualizaPais(paisVO);

				RequestDispatcher dispatcher = request.getRequestDispatcher("/Pais.jsp");
				dispatcher.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException(e);
			}
			
		}
	}


}
