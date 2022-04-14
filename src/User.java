
public class User {
	
	private String name;
	private String email;
	private String code;
	
	public User(String name,String email,String code) {
		this.name = name;
		this.email= email;
		this.code= code;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public void setName(String s) {
		 name=s;
	}
	public void setEmail(String s) {
		 email=s;
	}
	
	
	

}
