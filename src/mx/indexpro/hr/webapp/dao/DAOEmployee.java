package mx.indexpro.hr.webapp.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;


import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import mx.indexpro.hr.webapp.vo.EmpleadoVO;

public class DAOEmployee {
	 LinkedList<EmpleadoVO> listaEmpleado=new LinkedList<EmpleadoVO>();
	
	private Connection getConnection() throws NamingException, SQLException {
		InitialContext context = new InitialContext();
		DataSource dataSource = (DataSource)context.lookup("jdbc/HRDS");
		
		return dataSource.getConnection();
	}
	
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public LinkedList<EmpleadoVO> getEmployees() throws Exception  {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String query = "select employee_id, first_name, last_name, email, salary,phone_number from employees";
		//String query = "select employee_id, first_name from employees";
		
		try {
			connection = this.getConnection();
			statement = connection.prepareStatement(query);
			resultSet = statement.executeQuery();
			
			
			while (resultSet.next()) {
				EmpleadoVO empleado = new EmpleadoVO();
				empleado.setIdEmpleado(Integer.parseInt(resultSet.getString("employee_id")));
				empleado.setNombre(resultSet.getString("first_name"));
				empleado.setApellido(resultSet.getString("last_name"));
				empleado.setEmail(resultSet.getString("email"));
				empleado.setSalario(Double.parseDouble(resultSet.getString("salary")));
				empleado.setTelefono(resultSet.getString("phone_number"));
			

				
				listaEmpleado.add(empleado);		
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			resultSet.close();
			statement.close();
			connection.close();
		}
		return listaEmpleado;
	}



}
