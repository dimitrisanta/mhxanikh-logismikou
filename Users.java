package mhxalog;

public class Users {
	private String username;
	private String password;
	private int status;
	
	
	public Users(String username,String password,int status){
		this.username = username;
		this.password = password;
		this.status = status;
	}
public int getStatus() {
	return status;
}
}