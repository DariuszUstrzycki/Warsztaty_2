package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.mindrot.jbcrypt.BCrypt;

public class User {

	/*
	 * id BIGINT(20) AUTO_INCREMENT, username VARCHAR(255), email VARCHAR(255)
	 * UNIQUE, password VARCHAR(255), user_group_id INT,
	 */

	private long id;
	private String username;
	private String email;
	private String password;
	private int userGroupId;
	
	public User() {
		super();
		this.id = 0L;
		this.username = "";
		this.email = "";
		this.password = "";
		this.userGroupId = 0;
	}

	public User(String username, String email, String password) {
		super();
		this.id = 0L;
		this.username = username;
		this.email = email;
		setPassword(password);
		this.userGroupId = 0;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = BCrypt.hashpw(password, BCrypt.gensalt());
	}
	
	public void checkPassword(String password){
		BCrypt.checkpw(password, this.password);
	}

	public int getUserGroupId() {
		return userGroupId;
	}

	public void setUserGroupId(int userGroupId) {
		this.userGroupId = userGroupId;
	}

	public long getId() {
		return id;
	}

	public void save(Connection conn) throws SQLException {
		if (this.id == 0) { // if true insert new object into db
			
			String sql = "INSERT INTO users( username, email, password, user_group_id)" + "VALUES(?, ?, ?, ?);";
			String[] generatedColumns = { "ID" }; // not case sensitive
			PreparedStatement ps = conn.prepareStatement(sql, generatedColumns);
			ps.setString(1, this.username);
			ps.setString(2, this.email);
			ps.setString(3, this.password);
			ps.setInt(4, this.userGroupId);
			ps.executeUpdate();
			
			ResultSet rs = ps.getGeneratedKeys();
			if(rs.next()){
				this.id = rs.getLong(1);
			}
			rs.close();
			ps.close();
		} else { // update project
			
			String sql = "UPDATE users SET usename=?, email=?, password=?, user_group_id-? " 
					+ "WHERE id=?; ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, this.username);
			ps.setString(2, this.email);
			ps.setString(3, this.password);
			ps.setInt(4, this.userGroupId);
			ps.setLong(5, this.id);
			ps.executeUpdate();
			ps.close();
			
		}
	} 
}
