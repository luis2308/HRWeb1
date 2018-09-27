package mx.indexpro.hr.webapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import mx.indexpro.hr.webapp.vo.EmpleadoVO;
import mx.indexpro.hr.webapp.vo.PuestoVO;

public class DAOPuesto {
	LinkedList<PuestoVO> lista = new LinkedList<PuestoVO>();
	private Connection getConnection() throws NamingException, SQLException {
		InitialContext context = new InitialContext();
		DataSource dataSource = (DataSource)context.lookup("jdbc/HRDS");
		
		return dataSource.getConnection();
	}
	
	public LinkedList<PuestoVO> getPuesto() throws Exception  {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String query = "select JOB_ID, JOB_TITLE, MIN_SALARY, MAX_SALARY from jobs";
		//String query = "select employee_id, first_name from employees";
		
		try {
			connection = this.getConnection();
			statement = connection.prepareStatement(query);
			resultSet = statement.executeQuery();
			
			
			while (resultSet.next()) {
				PuestoVO puesto = new PuestoVO();
				puesto.setIdPuesto(resultSet.getString("job_id"));
				puesto.setNomPuesto(resultSet.getString("job_title"));
				puesto.setMinSalario(Integer.parseInt(resultSet.getString("min_salary")));
				puesto.setMaxSalario(Integer.parseInt(resultSet.getString("max_salary")));
				
			

				
				lista.add(puesto);		
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			resultSet.close();
			statement.close();
			connection.close();
		}
		return lista;
	}

	
	public void insertarPuesto(PuestoVO puestoVO) throws Exception  {
		//LOGGER.setLevel(Level.ALL);
	    //LOGGER.addHandler(new ConsoleHandler());
		Connection connection = null;
		PreparedStatement statement = null;
		String query = "insert into jobs(job_id,job_title, min_salary, max_salary) "
				+ "VALUES(?,?,?,?)";

		try {
			//LOGGER.info("Iniciando apertura de conexion a la DB");
			connection = this.getConnection();
			//LOGGER.info("Obteniendo valor de la sequencia para ID...");
			//seqResuset = statementSeq.executeQuery();
			//LOGGER.info("Valor obtenido para ID: "+seq);
			
			statement = connection.prepareStatement(query);
			
			
			statement.setString(1,puestoVO.getIdPuesto());
			statement.setString(2,puestoVO.getNomPuesto());
			statement.setInt(3,puestoVO.getMinSalario());
			statement.setInt(4,puestoVO.getMaxSalario());

			//LOGGER.info("Ejecutando insert...");
			statement.execute();
			//LOGGER.info("Registro almacenado");
		   } 
		catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {			
			try {statement.close(); } catch (Exception e) { }
			try {connection.close(); } catch (Exception e) { }
		}
	}
	public LinkedList<PuestoVO> buscarPuesto(PuestoVO puestoVO) throws Exception {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		String query = "select * from JOBS where JOB_ID=?";
		try {
			connection = this.getConnection();
			statement = connection.prepareStatement(query);
			statement.setString(1, puestoVO.getIdPuesto());
			resultSet =statement.executeQuery();
			while (resultSet.next()) {
				PuestoVO puesto = new PuestoVO();
				puesto.setIdPuesto(resultSet.getString("JOB_ID"));
				puesto.setNomPuesto(resultSet.getString("JOB_TITLE"));
				puesto.setMinSalario(Integer.parseInt(resultSet.getString("MIN_SALARY")));
				puesto.setMaxSalario(Integer.parseInt(resultSet.getString("MAX_SALARY")));
				lista.add(puesto);
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
	public void actualizarPuesto(PuestoVO puestoVO) throws Exception  {
		
		Connection connection = null;
		PreparedStatement statement = null;
		String query ="update JOBS set JOB_TITLE=?, MIN_SALARY=?, MAX_SALARY=? where JOB_ID=?";
		
		try {
		connection = this.getConnection();
		statement = connection.prepareStatement(query);
		statement.setString(1,puestoVO.getNomPuesto());
		statement.setInt(2,puestoVO.getMinSalario());
		statement.setInt(3,puestoVO.getMaxSalario());
		statement.setString(4,puestoVO.getIdPuesto());
		
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
	public void eliminaPuesto(PuestoVO puestovo) throws Exception {
		Connection connection = null;
		PreparedStatement statement = null;
		String query = "delete from JOBS where JOB_ID=?";
		try {
			connection = this.getConnection();
			statement = connection.prepareStatement(query);
			statement.setString(1, puestovo.getIdPuesto());
			statement.executeQuery();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			statement.close();
			connection.close();
		}
	}

}
