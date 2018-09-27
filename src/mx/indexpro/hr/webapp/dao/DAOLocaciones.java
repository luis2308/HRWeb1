package mx.indexpro.hr.webapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import mx.indexpro.hr.webapp.vo.LocacionVO;





public class DAOLocaciones {

	LinkedList<LocacionVO> consulta = new LinkedList<LocacionVO>();

	private Connection getConnection() throws NamingException, SQLException {
		InitialContext context = new InitialContext();
		DataSource dataSource = (DataSource)context.lookup("jdbc/HRDS");
		return dataSource.getConnection();
	}
	public  LinkedList<LocacionVO> getLocaciones() throws Exception  {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		String query = "select LOCATION_ID,STREET_ADDRESS,POSTAL_CODE,CITY,STATE_PROVINCE,COUNTRY_ID from LOCATIONS";
		
		try {
			connection = this.getConnection();
			statement = connection.prepareStatement(query);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
			
				LocacionVO consultaA = new LocacionVO();
				//AQUI SE PONE EL VALOR DE LA BD Y CON EL GET SE OPTIENE los valores en azul deben se iguales a los de la bd
				//ya que es una consulta a ella.
				consultaA.setIdLocacion(Integer.parseInt(resultSet.getString("LOCATION_ID")));
				consultaA.setDireccion(resultSet.getString("STREET_ADDRESS"));
				consultaA.setCodigo((resultSet.getString("POSTAL_CODE")));
				consultaA.setCiudad(resultSet.getString("CITY"));
				consultaA.setEstado(resultSet.getString("STATE_PROVINCE"));
				consultaA.setPais(resultSet.getString("COUNTRY_ID"));

				consulta.add(consultaA);
			
							
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			resultSet.close();
			statement.close();
			connection.close();
		}
		return consulta;
	}
	public void registroLocacion(LocacionVO insertarvo ) throws Exception  {
		Connection connection = null;
		PreparedStatement statement = null;
		String query = "INSERT INTO LOCATIONS(location_id, street_address, postal_code, city,state_province,"
				+ "country_id)"
				+ "VALUES (?, ?, ?, ?, ?, ?)";
		String nextValQuery = "select locations_seq.nextval from dual";
		PreparedStatement statementSeq = null;
		ResultSet seqResuset = null;
		int seq = 0;
		
		try {
			
			connection = this.getConnection();
			statementSeq = connection.prepareStatement(nextValQuery);
			seqResuset = statementSeq.executeQuery();
			if (seqResuset.next()) {
				seq = seqResuset.getInt(1);
			} else {
				throw new SQLException("Error al obtener el proximo valor de la secuencia de empleados");
			}
			
			statement = connection.prepareStatement(query);
			
			statement.setInt(1, seq);
			statement.setString(2, insertarvo.getDireccion());
			statement.setString(3, insertarvo.getCodigo());
			statement.setString(4, insertarvo.getCiudad());
			statement.setString(5, insertarvo.getEstado());
			statement.setString(6, insertarvo.getPais());
	
			
			
			statement.execute();
			
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			try {seqResuset.close();} catch (Exception e) {	}
			try {statementSeq.close(); } catch (Exception e) { }
			try {statement.close(); } catch (Exception e) { }
			try {connection.close(); } catch (Exception e) { }
		}

	}
	
	
	public void suprimirLocacion(LocacionVO eliminarvo) throws Exception {
		Connection connection = null;
		PreparedStatement statement = null;
		String query = "delete from LOCATIONS where LOCATION_ID=?";
		try {
			
			connection = this.getConnection();
			
			
			statement = connection.prepareStatement(query);
			statement.setInt(1, eliminarvo.getIdLocacion());
			
			
			statement.execute();
			
			

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
		}
		try {
			statement.close();
		} catch (Exception e) {
		}
		try {
			connection.close();
		} catch (Exception e) {
		}

}
	
	public LinkedList<LocacionVO> buscarLocacion(LocacionVO locacionvo) throws Exception{
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String query = "select * from LOCATIONS where LOCATION_ID=?";

		try {
			
			connection = this.getConnection();
			statement = connection.prepareStatement(query);
			statement.setInt(1, locacionvo.getIdLocacion());
			resultSet = statement.executeQuery();

				while (resultSet.next()) {
					
					LocacionVO consultaLo= new LocacionVO();
					consultaLo.setIdLocacion(Integer.parseInt(resultSet.getString("location_id")));
					consultaLo.setDireccion(resultSet.getString("street_address"));
					consultaLo.setCodigo(resultSet.getString("postal_code"));
					consultaLo.setCiudad(resultSet.getString("city"));
					consultaLo.setEstado(resultSet.getString("state_province"));
					consultaLo.setPais(resultSet.getString("country_id"));
					consulta.add(consultaLo);			
				}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			resultSet.close();
			statement.close();
			connection.close();
		}
		return consulta;
	}

	
	public void updateEmpleado(LocacionVO actualizarVO) throws Exception {
		Connection connection = null;
		PreparedStatement statement = null;
				String query ="update LOCATIONS set street_address=?, postal_code=?, city=?, state_province=?, "
						+ "country_id=? where location_id=?";
		
		try {
			
			connection = this.getConnection();
			statement = connection.prepareStatement(query);
			
			statement.setString(1, actualizarVO.getDireccion());
			statement.setString(2, actualizarVO.getCodigo());
			statement.setString(3, actualizarVO.getCiudad());
			statement.setString(4, actualizarVO.getEstado());
			statement.setString(5, actualizarVO.getPais());
			statement.setInt(6, actualizarVO.getIdLocacion());
			
			
			statement.executeQuery();
			
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
