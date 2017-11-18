package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.User;

public class UserApp {

	public static void main(String[] args) {
		
		User u = new User("iga", "ig@wp.ru", "iggu");
		
		String dbName = "warsztat_2";
		Connection conn = null;
		PreparedStatement prepStmt = null;
		
			try {
				System.out.println("Connecting to database...");
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + dbName + "?useSSL=false", "root",
						"coderslab");
				u.setUserGroupId(1); // bez tego wyjatek
				u.save(conn);
				// User u2 = User.loadById(2);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		
	}
	
	public static User getById(long id){
		String sql = "";
		//execute sql
		User u = new User();
		return u;
	}

}
