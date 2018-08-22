package co.grandcircus.coffeeshop;

public class User {
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private String password;
	//private String password2;
	

	public User() {
		
	}
	
	public User(String firstName, String lastName, String email, String phone, String password, String password2) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.password = password;
	//	this.password2 = password2;
	}
	
	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
//	public String getPassword2() {
//		return password2;
//	}
//
//
//	public void setPassword2(String password2) {
//		this.password2 = password2;
//	}





}

