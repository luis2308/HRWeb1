package mx.indexpro.hr.webapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import mx.indexpro.hr.webapp.vo.DepartamentoVO;
import mx.indexpro.hr.webapp.vo.PaisVO;

public class DAOPais {
LinkedList<PaisVO> lista=new LinkedList<PaisVO>();
	
	private Connection getConnection() throws NamingException, SQLException {
		InitialContext context = new InitialContext();
		DataSource dataSource = (DataSource) context.lookup("jdbc/HRDS");

		return dataSource.getConnection();
	}
	public LinkedList<PaisVO> getConsulta() throws Exception  {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String query = "select COUNTRY_ID, COUNTRY_NAME, REGION_ID from countries";
		
		
		try {
			connection = this.getConnection();
			statement = connection.prepareStatement(query);
			resultSet = statement.executeQuery();
			
			
			while (resultSet.next()) {
				PaisVO pais = new PaisVO();
				pais.setIdPais((resultSet.getString("COUNTRY_ID")));
				pais.setNombre(resultSet.getString("COUNTRY_NAME"));
				pais.setIdRegion(Integer.parseInt(resultSet.getString("REGION_ID")));
				
				
				
				lista.add(pais);		
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
	
	public void insertarPais(PaisVO paisVO) throws Exception {
		Connection connection = null;
		PreparedStatement statement = null;
		String query = "insert into countries(COUNTRY_ID, COUNTRY_NAME, REGION_ID) "
				+ "VALUES(?,?,?)";
		try {
			//LOGGER.info("Iniciando apertura de conexion a la DB");
			connection = this.getConnection();
			//LOGGER.info("Obteniendo valor de la sequencia para ID...");
			//seqResuset = statementSeq.executeQuery();
			//LOGGER.info("Valor obtenido para ID: "+seq);
			
			statement = connection.prepareStatement(query);
			
			
			statement.setString(1,paisVO.getIdPais());
			statement.setString(2,paisVO.getNombre());
			statement.setInt(3,paisVO.getIdRegion());
			

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
	
	public void eliminaPais(PaisVO paisVO) throws Exception {
		Connection connection = null;
		PreparedStatement statement = null;
		String query = "delete from countries where COUNTRY_ID=?";
		try {
			connection = this.getConnection();
			statement = connection.prepareStatement(query);
			statement.setString(1, paisVO.getIdPais());
			statement.executeQuery();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			statement.close();
			connection.close();
		}
	}
	
	public LinkedList<PaisVO> getBusca(PaisVO paisVO) throws Exception  {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String query = "select * from countries where COUNTRY_ID=?";
		
		try {
			connection = this.getConnection();
			statement = connection.prepareStatement(query);
			statement.setString(1, paisVO.getIdPais());
			resultSet = statement.executeQuery();	
			
			
			while (resultSet.next()) {
				PaisVO pais = new PaisVO();
				pais.setIdPais(resultSet.getString("COUNTRY_ID"));
				pais.setNombre(resultSet.getString("COUNTRY_NAME"));
				pais.setIdRegion(Integer.parseInt(resultSet.getString("REGION_ID")));
				
				
				lista.add(pais);		
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
	
	public void actualizaPais(PaisVO paisVO) throws Exception {
		Connection connection = null;
		PreparedStatement statement = null;
		
		String query = "update countries set COUNTRY_NAME=?, REGION_ID=?"
				+ " where COUNTRY_ID=?";
		
		try {
			connection = this.getConnection();

			statement = connection.prepareStatement(query);

		
			statement.setString(1, paisVO.getNombre());
			statement.setInt(2, paisVO.getIdRegion());
			statement.setString(3, paisVO.getIdPais());
			
			
			statement.execute(); 
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

}
