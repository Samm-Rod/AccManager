package br.application.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.application.dao.DB;
import br.application.dao.DBException;
import br.application.data.InputData;
import br.application.impl.DaoImplet;

public class Storage implements  DaoImplet {
	Connection conn = null;
	
	public Storage(Connection conn) {
		this.conn = conn;
	}
	
	
	@Override
	public void insertNet(InputData obj) {
		PreparedStatement st = null;
		
		try {
			
			st = conn.prepareStatement(
					"INSERT INTO net_wifi "
					+ "(nameOwner, nameNetwork, passNetwork) "
					+ "VALUES "
					+ "(?,?,?) ",
					Statement.RETURN_GENERATED_KEYS);
			st.setString(1,obj.getOwner());
			st.setString(2,obj.getnNetwork());
			st.setString(3,obj.getPassword());
			
			int rows = st.executeUpdate();
			
			if(rows > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if(rs.next()) {
					int id = rs.getInt(1);
					obj.setId(id);
				}
				DB.closeResultSet(rs);
			}else {
				throw new DBException("Unexpected error! No Rows affected!");
			}
				
		}catch(SQLException e) {
			throw new DBException(e.getMessage());
		}finally {
			DB.closeStatement(st);
		}
		
	}

	@Override
	public void deleteNet(Integer id) {
		String sql = "DELETE FROM net_wifi WHERE idn = ? ";
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(sql);
			st.setInt(1, id);
			st.execute();
		}catch(SQLException e) {
			throw new DBException(e.getMessage());
		}finally {
			DB.closeStatement(st);
		}
		
		
	}

	@Override
	public void updateDatas(InputData obj) {
		String sql = "UPDATE net_wifi "
				+ "SET nameOwner = ?, "
				+ "nameNetwork = ?, "
				+ "passNetwork = ? "
				+ "WHERE idn = ? ";
		PreparedStatement st = null;
		try {
			
			st = conn.prepareStatement(sql);
			st.setString(1, obj.getOwner());
			st.setString(2, obj.getnNetwork());
			st.setString(3, obj.getPassword());
			st.setInt(4, obj.getId());
			
			st.executeUpdate();
			
		}catch(SQLException e) {
			throw new DBException(e.getMessage());
		}finally {
			DB.closeStatement(st);
		}
		
	}

	@Override
	public List<InputData> findAll() {
		String sql = "SELECT * FROM net_wifi";
		
		List<InputData> list = new ArrayList<>();
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			while(rs.next()) {
				InputData input = new InputData();
				input.setId(rs.getInt("idn"));
				input.setOwner(rs.getString("nameOwner"));
				input.setnNetwork(rs.getString("nameNetwork"));
				input.setPassword(rs.getString("passNetwork"));
				list.add(input);
			}
			
		}catch(SQLException e) {
			throw new DBException(e.getMessage());
		}finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
		}
		return list;
	}

	@Override
	public InputData findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			
			st = conn.prepareStatement(
					"SELECT * FROM net_wifi WHERE idn = ? ");
			st.setInt(1, id);
			rs = st.executeQuery();
			if(rs.next()) {
				InputData idata = new InputData();
				idata.setId(rs.getInt("idn"));
				idata.setOwner(rs.getString("nameOwner"));
				idata.setnNetwork(rs.getString("nameNetwork"));
				idata.setPassword(rs.getString("passNetwork"));
				return idata;
			}
			return null;
		}catch(SQLException e) {
			throw new DBException(e.getMessage());
		}finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}
	
	
	


}
