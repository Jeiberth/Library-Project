package WebLibraryREST;

public class User {
	
	
	private String u_id;
	private String u_name;
	private String u_password;
	private int u_age;
	private boolean u_admin;
	
	public User(String u_id, String u_name, String u_password, int u_age, boolean admin) {
		super();
		this.u_id = u_id;
		this.u_name = u_name;
		this.u_password = u_password;
		this.u_age = u_age;
		this.u_admin = admin;
	}
	public String getU_id() {
		return u_id;
	}
	public void setU_id(String u_id) {
		this.u_id = u_id;
	}
	public String getU_name() {
		return u_name;
	}
	public void setU_name(String u_name) {
		this.u_name = u_name;
	}
	public String getU_password() {
		return u_password;
	}
	public void setU_password(String u_password) {
		this.u_password = u_password;
	}
	public int getU_age() {
		return u_age;
	}
	public void setU_age(int u_age) {
		this.u_age = u_age;
	}
	public boolean isAdmin() {
		return u_admin;
	}
	public void setAdmin(boolean u_admin) {
		this.u_admin = u_admin;
	}
	@Override
	public String toString() {
		return "User [u_id=" + u_id + ", u_name=" + u_name + ", u_password=" + u_password + ", u_age=" + u_age
				+ ", u_admin=" + u_admin + "]";
	}
}
