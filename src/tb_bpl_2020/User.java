package tb_bpl_2020;


public class User {
	private String username;
	private String date;
	private String email;
	private String password;
	
	public User(String username, String date, String password) {
		this.username = username;
		this.date = date;
		this.password = password;
	}

	public User(String username, String date, String email, String password) {
		this.username = username;
		this.date = date;
		this.email = email; 
		this.password = password;
	}
	
	public String getPassword() {
		return password;
	}
		
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
