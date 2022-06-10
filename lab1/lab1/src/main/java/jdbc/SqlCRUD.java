package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import servlet.LabCRUDinterface;
import sports.Sport;

public class SqlCRUD implements LabCRUDinterface<Sport> {
	
	Connection connection;
	
	public SqlCRUD() {
		
		this.connection = new Connect().getCon();
		System.out.println(connection);
		
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void create(Sport t) {
		// TODO Auto-generated method stub
		try (PreparedStatement st = connection.prepareStatement("INSERT INTO Sport (title,price,desc) " + "VALUES (?,?,?)")) {
			st.setString(1, t.getTitle());
			st.setFloat(2, t.getPrice());
			st.setString(3, t.getDesc());
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Sport> read() {
		// TODO Auto-generated method stub
		List<Sport> list = new ArrayList<>();

		try (Statement st = connection.createStatement(); ResultSet rs = st.executeQuery("SELECT * FROM Sport;");) {
			while (rs.next()) {
				list.add(new Sport(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getString(4)));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public void update(int id, Sport t) {
		// TODO Auto-generated method stub
		try (PreparedStatement st = connection.prepareStatement("UPDATE Sport" + "SET  \\\"title\\\"=?, \\\"price\\\"=?, \\\"desc\\\"=?,  WHERE id=?;")) {
			st.setString(1, t.getTitle());
			st.setFloat(2, t.getPrice());
			st.setString(3, t.getDesc());
			st.setInt(4, id);
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		try(PreparedStatement st = 
				connection.prepareStatement("DELETE FROM Sport WHERE id=?");)
			{
				st.setInt(1, id);
				st.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

}