package mx.indexpro.hr.webapp.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class principalServlet
 */
@WebServlet("/principalServlet")
public class principalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public principalServlet() {
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
		
		// TODO Auto-generated method stub

		String opc = request.getParameter("opcion");
		if (opc.equals("paises")) {
			try {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/Paises.jsp");

				dispatcher.forward(request, response);

			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException(e);
			}
		} else if (opc.equals("empleados")) {
			try {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/Empleados.jsp");

				dispatcher.forward(request, response);

			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException(e);
			}
		}
		else if (opc.equals("departamento")) {
			try {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/Departamento.jsp");

				dispatcher.forward(request, response);

			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException(e);
			}
		}
		else if (opc.equals("puesto")) {
			try {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/Puesto.jsp");

				dispatcher.forward(request, response);

			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException(e);
			}
		}
		else if (opc.equals("locaciones")) {
			try {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/Locacion.jsp");

				dispatcher.forward(request, response);

			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException(e);
			}
		}
		else if (opc.equals("regiones")) {
			try {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/Regiones.jsp");

				dispatcher.forward(request, response);

			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException(e);
			}
		}
		else {
			try {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/Index.jsp");

				dispatcher.forward(request, response);

			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException(e);
			}
		}

	}

	private String getElementByName(String string) {
		// TODO Auto-generated method stub
		return null;
	}
	}

