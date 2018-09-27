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
 * Servlet implementation class DepartamentoServlet
 */
@WebServlet("/DepartamentoServlet")
public class DepartamentoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepartamentoServlet() {
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
		String opcion=request.getParameter("menu");
		try {
			if(opcion.equals("consulta")) {
				try {
					DAODepartamento daoDep = new DAODepartamento();

					request.setAttribute("listaDepartamento", daoDep.getConsulta());

					RequestDispatcher dispatcher = request.getRequestDispatcher("/ConsultaDepartamento.jsp");

					dispatcher.forward(request, response);
				} catch (Exception e) {
					e.printStackTrace();
					throw new ServletException(e);
				}
			}else if(opcion.equals("alta")) {
				request.getRequestDispatcher("AltaDepartamento.jsp") .forward(request, response);
			}else if(opcion.equals("elimina")) {
				request.getRequestDispatcher("BajaDepartamento.jsp") .forward(request, response);
			}else if(opcion.equals("regresa")){
				try {
					RequestDispatcher dispatcher = request.getRequestDispatcher("/Index.jsp");

					dispatcher.forward(request, response);

				} catch (Exception e) {
					e.printStackTrace();
					throw new ServletException(e);
				}
					
				}
			else if (opcion.equals("actualiza")) {
				DAODepartamento daodepartamento = new DAODepartamento();
				DepartamentoVO departamento=new DepartamentoVO();
				request.setAttribute("listaDepartamento", daodepartamento.getBusca(departamento));
				request.getRequestDispatcher("ActualizaDepartamento.jsp").forward(request, response);
			}
		}catch (Exception e){
			e.printStackTrace();
			throw new ServletException(e);
		}
	}

}
