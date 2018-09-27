package mx.indexpro.hr.webapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import mx.indexpro.hr.webapp.vo.EmpleadoVO;

public class DAOInsertar {

	LinkedList<EmpleadoVO> lista = new LinkedList<EmpleadoVO>();
	private Connection getConnection() throws NamingException, SQLException {
		InitialContext context = new InitialContext();
		DataSource dataSource = (DataSource)context.lookup("jdbc/HRDS");
		
		return dataSource.getConnection();
	}
	private static Logger LOGGER = Logger.getLogger( DAOInsertar.class.getName() );

	public void insertarEmpleado(EmpleadoVO empleadoVO) throws Exception  {
		LOGGER.setLevel(Level.ALL);
	    LOGGER.addHandler(new ConsoleHandler());
		Connection connection = null;
		PreparedStatement statement = null;
		String query = "insert into employees(EMPLOYEE_ID,FIRST_NAME, LAST_NAME, EMAIL, PHONE_NUMBER, "
				+ "HIRE_DATE, JOB_ID, SALARY,COMMISSION_PCT, MANAGER_ID,DEPARTMENT_ID) "
				+ "VALUES(?,?,?,?,?,?,?,?,?,?,?)";
		String nextValQuery = "select employees_seq.nextval from dual";
		PreparedStatement statementSeq = null;
		ResultSet seqResuset = null;
		int seq = 0;
		String formatoFecha = "dd/MM/yyyy";
		SimpleDateFormat dateFormat = new SimpleDateFormat(formatoFecha);
		try {
			LOGGER.info("Iniciando apertura de conexion a la DB");
			connection = this.getConnection();
			statementSeq = connection.prepareStatement(nextValQuery);
			LOGGER.info("Obteniendo valor de la sequencia para ID...");
			seqResuset = statementSeq.executeQuery();
			if (seqResuset.next()) {
				seq = seqResuset.getInt(1);
			} else {
				throw new SQLException("Error al obtener el proximo valor de la secuencia de empleados");
			}
			LOGGER.info("Valor obtenido para ID: "+seq);
			
			statement = connection.prepareStatement(query);
			
			statement.setInt(1, seq);
			statement.setString(2,empleadoVO.getNombre());
			statement.setString(3,empleadoVO.getApellido());
			statement.setString(4,empleadoVO.getEmail());
			statement.setString(5,empleadoVO.getTelefono());
			statement.setDate(6, new java.sql.Date(empleadoVO.getFechaContratacion().getTime()));
			
			statement.setString(7,empleadoVO.getIdPuesto());
			statement.setDouble(8,empleadoVO.getSalario());
			statement.setDouble(9,empleadoVO.getComision());
			statement.setDouble(10,empleadoVO.getIdSuperior());
			statement.setDouble(11,empleadoVO.getIdDepartamento());
			LOGGER.info("Ejecutando insert...");
			statement.execute();
			LOGGER.info("Registro almacenado");
		   } 
		catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			try {seqResuset.close();} catch (Exception e) {	}
			try {statementSeq.close(); } catch (Exception e) { }
			try {statement.close(); } catch (Exception e) { }
			try {connection.close(); } catch (Exception e) { }
		}
	}
	public void eliminaEmpleado(EmpleadoVO empleadoVO) throws Exception {
		Connection connection = null;
		PreparedStatement statement = null;
		String query = "delete from EMPLOYEES where EMPLOYEE_ID=?";
		try {
			connection = this.getConnection();
			statement = connection.prepareStatement(query);
			statement.setDouble(1, empleadoVO.getIdEmpleado());
			statement.executeQuery();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			statement.close();
			connection.close();
		}
	}
	
	public LinkedList<EmpleadoVO> buscarEmpleados(EmpleadoVO empleadovo) throws Exception {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		String query = "select * from EMPLOYEES where EMPLOYEE_ID=?";
		try {
			connection = this.getConnection();
			statement = connection.prepareStatement(query);
			statement.setDouble(1, empleadovo.getIdEmpleado());
			resultSet =statement.executeQuery();
			while (resultSet.next()) {
				EmpleadoVO empleado = new EmpleadoVO();
				empleado.setIdEmpleado(Integer.parseInt(resultSet.getString("employee_id")));
				empleado.setNombre(resultSet.getString("first_name"));
				empleado.setApellido(resultSet.getString("last_name"));
				empleado.setEmail(resultSet.getString("email"));
				empleado.setSalario(Double.parseDouble(resultSet.getString("salary")));
				empleado.setTelefono(resultSet.getString("phone_number"));
				empleado.setFechaContratacion(resultSet.getDate("hire_date"));
				empleado.setIdPuesto(resultSet.getString("job_id"));
				empleado.setComision(resultSet.getDouble("commission_pct"));
				empleado.setIdSuperior(Integer.parseInt(resultSet.getString("manager_id")));
				empleado.setIdDepartamento(Integer.parseInt(resultSet.getString("department_id")));
				lista.add(empleado);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			statement.close();
			connection.close();
		}
		return lista;
		
	}
	public void actualizarEmpleado(EmpleadoVO empleadoVO) throws Exception  {
		
		Connection connection = null;
		PreparedStatement statement = null;
		String query ="update employees set FIRST_NAME=?, LAST_NAME=?, EMAIL=?, PHONE_NUMBER=?, HIRE_DATE=?, JOB_ID=?,"
				+ "SALARY=?, COMMISSION_PCT=?, MANAGER_ID=?, DEPARTMENT_ID=? where employee_id=?";
		String formatoFecha = "dd/MM/yyyy";
		SimpleDateFormat dateFormat = new SimpleDateFormat(formatoFecha);
		try {
		connection = this.getConnection();
		statement = connection.prepareStatement(query);
		statement.setString(1,empleadoVO.getNombre());
		statement.setString(2,empleadoVO.getApellido());
		statement.setString(3,empleadoVO.getEmail());
		statement.setString(4,empleadoVO.getTelefono());
		statement.setDate(5, new java.sql.Date(empleadoVO.getFechaContratacion().getTime()));
		statement.setString(6,empleadoVO.getIdPuesto());
		statement.setDouble(7,empleadoVO.getSalario());
		statement.setDouble(8,empleadoVO.getComision());
		statement.setDouble(9,empleadoVO.getIdSuperior());
		statement.setDouble(10,empleadoVO.getIdDepartamento());
		statement.setInt(11, empleadoVO.getIdEmpleado());
		//LOGGER.info("Ejecutando insert...");
		statement.execute();
	  } 
			catch (Exception e) {
				e.printStackTrace();
				throw e;
			} finally {
				
				
				try {statement.close(); } catch (Exception e) { }
				try {connection.close(); } catch (Exception e) { }
			}
	}

	}


	
		
