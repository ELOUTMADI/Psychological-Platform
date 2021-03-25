package rh1;

public class affect {
	
	private String id;
	private String email;
	
	
	

	public affect(String id, String email) {
		this.id = id;
		this.email = email;
	}




	public String getId() {
		return id;
	}




	public void setId(String id) {
		this.id = id;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	@Override
	public String toString() {
		return "affect [id=" + id + ", email=" + email + "]";
	}
	
	

}


