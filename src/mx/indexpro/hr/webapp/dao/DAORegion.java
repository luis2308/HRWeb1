package mx.indexpro.hr.webapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import mx.indexpro.hr.webapp.vo.RegionVO;

public class DAORegion {
	LinkedList<RegionVO> lista = new LinkedList<RegionVO>();
	private Connection getConnection() throws NamingException, SQLException {
		InitialContext context = new InitialContext();
		DataSource dataSource = (DataSource)context.lookup("jdbc/HRDS");
		
		return dataSource.getConnection();
	}
	
	public LinkedList<RegionVO> getRegion() throws Exception  {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String query = "select REGION_ID, REGION_NAME from regions";
		//String query = "select employee_id, first_name from employees";
		
		try {
			connection = this.getConnection();
			statement = connection.prepareStatement(query);
			resultSet = statement.executeQuery();
			
			
			while (resultSet.next()) {
				RegionVO region = new RegionVO();
				region.setId_Regions(Integer.parseInt(resultSet.getString("REGION_ID")));
				region.setNombre_Region(resultSet.getString("REGION_NAME"));
				
				
			

				
				lista.add(region);		
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

	
	public void insertarRegion(RegionVO regionVO) throws Exception  {
		//LOGGER.setLevel(Level.ALL);
	    //LOGGER.addHandler(new ConsoleHandler());
		Connection connection = null;
		PreparedStatement statement = null;
		String query = "insert into regions(REGION_ID,REGION_NAME) "
				+ "VALUES(?,?)";
		String queryID = "SELECT * FROM REGIONS"
				+ " WHERE REGION_ID = (SELECT MAX(REGION_ID) from REGIONS)";
		PreparedStatement statementSeq = null;
		ResultSet seqResuset = null;
		int seq = 0;

		try {
			//LOGGER.info("Iniciando apertura de conexion a la DB");
			connection = this.getConnection();
			statementSeq = connection.prepareStatement(queryID);
			seqResuset = statementSeq.executeQuery();
			if (seqResuset.next()) {
				seq = (seqResuset.getInt(1))+1;
			} else {
				throw new SQLException("Error al obtener el proximo valor de la secuencia de empleados");
			}
			//LOGGER.info("Obteniendo valor de la sequencia para ID...");
			//seqResuset = statementSeq.executeQuery();
			//LOGGER.info("Valor obtenido para ID: "+seq);
			
			statement = connection.prepareStatement(query);
			
			
			statement.setInt(1, seq);
			statement.setString(2,regionVO.getNombre_Region());
			

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
	public LinkedList<RegionVO> buscarRegion(RegionVO regionVO) throws Exception {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		String query = "select * from regions where REGION_ID=?";
		try {
			connection = this.getConnection();
			statement = connection.prepareStatement(query);
			statement.setInt(1, regionVO.getId_Regions());
			resultSet =statement.executeQuery();
			while (resultSet.next()) {
				RegionVO region = new RegionVO();
				region.setId_Regions(Integer.parseInt(resultSet.getString("REGION_ID")));
				region.setNombre_Region(resultSet.getString("REGION_NAME"));
				
				lista.add(region);
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
	public void actualizarRegion(RegionVO regionVO) throws Exception  {
		
		Connection connection = null;
		PreparedStatement statement = null;
		String query ="update regions set  REGION_NAME=? where REGION_ID=?";
		
		try {
		connection = this.getConnection();
		statement = connection.prepareStatement(query);
		statement.setString(1,regionVO.getNombre_Region());
		statement.setInt(2,regionVO.getId_Regions());
		;
		
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
	public void eliminaRegion(RegionVO regionVO) throws Exception {
		Connection connection = null;
		PreparedStatement statement = null;
		String query = "delete from regions where region_id=?";
		try {
			connection = this.getConnection();
			statement = connection.prepareStatement(query);
			statement.setInt(1, regionVO.getId_Regions());
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
