package model;

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

	public User(String username, String email, String password) {
		super();
		this.id = 0L;
		this.username = username;
		this.email = email;
		this.password = password;
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
		this.password = password;
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
	
	

}
