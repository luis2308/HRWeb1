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



public class DAODepartamento {
LinkedList<DepartamentoVO> listaDepartamento=new LinkedList<DepartamentoVO>();
	
	private Connection getConnection() throws NamingException, SQLException {
		InitialContext context = new InitialContext();
		DataSource dataSource = (DataSource) context.lookup("jdbc/HRDS");

		return dataSource.getConnection();
	}
	public LinkedList<DepartamentoVO> getConsulta() throws Exception  {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String query = "select DEPARTMENT_ID, DEPARTMENT_NAME, MANAGER_ID, LOCATION_ID from DEPARTMENTS";
		
		
		try {
			connection = this.getConnection();
			statement = connection.prepareStatement(query);
			resultSet = statement.executeQuery();
			
			
			while (resultSet.next()) {
				DepartamentoVO departamento = new DepartamentoVO();
				departamento.setIdDepartamento(Integer.parseInt(resultSet.getString("DEPARTMENT_ID")));
				departamento.setNombreDepartamento(resultSet.getString("DEPARTMENT_NAME"));
				departamento.setIdGerente(resultSet.getString("MANAGER_ID"));
				departamento.setIdUbicacion(Integer.parseInt(resultSet.getString("LOCATION_ID")));
				
				
				listaDepartamento.add(departamento);		
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			resultSet.close();
			statement.close();
			connection.close();
		}
		return listaDepartamento;
	}
	
	public void insertarDepartamento(DepartamentoVO departamentoVO) throws Exception {
		Connection connection = null;
		PreparedStatement statement = null;
		String query = "insert into DEPARTMENTS(DEPARTMENT_ID,DEPARTMENT_NAME, MANAGER_ID, LOCATION_ID) "
				+ "VALUES(?,?,?,?)";
		String nextValQuery = "select DEPARTMENTS_seq.nextval from dual";
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
				throw new SQLException("Error al obtener el proximo valor de la secuencia de departamentos");
			}

			statement = connection.prepareStatement(query);

			statement.setInt(1, seq);
			statement.setString(2, departamentoVO.getNombreDepartamento());
			statement.setString(3, departamentoVO.getIdGerente());
			statement.setLong(4, departamentoVO.getIdUbicacion());
			statement.execute();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			try {
				seqResuset.close();
			} catch (Exception e) {
			}
			try {
				statementSeq.close();
			} catch (Exception e) {
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
	}
	
	public void eliminaDepartamento(DepartamentoVO departamentoVO) throws Exception {
		Connection connection = null;
		PreparedStatement statement = null;
		String query = "delete from DEPARTMENTS where DEPARTMENT_ID=?";
		try {
			connection = this.getConnection();
			statement = connection.prepareStatement(query);
			statement.setDouble(1, departamentoVO.getIdDepartamento());
			statement.executeQuery();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			statement.close();
			connection.close();
		}
	}
	
	public LinkedList<DepartamentoVO> getBusca(DepartamentoVO departamentovo) throws Exception  {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String query = "select * from DEPARTMENTS where DEPARTMENT_ID=?";
		
		try {
			connection = this.getConnection();
			statement = connection.prepareStatement(query);
			statement.setInt(1, departamentovo.getIdDepartamento());
			resultSet = statement.executeQuery();	
			
			
			while (resultSet.next()) {
				DepartamentoVO departamento = new DepartamentoVO();
				departamento.setIdDepartamento(Integer.parseInt(resultSet.getString("DEPARTMENT_ID")));
				departamento.setNombreDepartamento(resultSet.getString("DEPARTMENT_NAME"));
				departamento.setIdGerente(resultSet.getString("MANAGER_ID"));
				departamento.setIdUbicacion(Integer.parseInt(resultSet.getString("LOCATION_ID")));
				
				listaDepartamento.add(departamento);		
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			resultSet.close();
			statement.close();
			connection.close();
		}
		return listaDepartamento;
	}
	
	public void actualizaDepartamento(DepartamentoVO departamentoVO) throws Exception {
		Connection connection = null;
		PreparedStatement statement = null;
		
		String query = "update DEPARTMENTS set DEPARTMENT_NAME=?, MANAGER_ID=?, LOCATION_ID=?"
				+ " where DEPARTMENT_ID=?";
		
		try {
			connection = this.getConnection();

			statement = connection.prepareStatement(query);

		
			statement.setString(1, departamentoVO.getNombreDepartamento());
			statement.setString(2, departamentoVO.getIdGerente());
			statement.setInt(3, departamentoVO.getIdUbicacion());
			statement.setInt(4, departamentoVO.getIdDepartamento());
			
			statement.execute(); 
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

}
