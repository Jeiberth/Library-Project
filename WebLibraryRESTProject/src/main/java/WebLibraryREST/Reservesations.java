package WebLibraryREST;

import java.util.Date;

public class Reservesations {

	private String r_id;
	private String b_id;
	private String u_id;
	private Date r_daytaken;
	private Date r_maxdayret;
	private boolean r_returnedbook;
	
	public Reservesations(String r_id, String b_id, String u_id, Date r_daytaken, Date r_maxdayret,
			boolean r_returnedbook) {
		super();
		this.r_id = r_id;
		this.b_id = b_id;
		this.u_id = u_id;
		this.r_daytaken = r_daytaken;
		this.r_maxdayret = r_maxdayret;
		this.r_returnedbook = r_returnedbook;
	}
	
	public String getR_id() {
		return r_id;
	}
	public void setR_id(String r_id) {
		this.r_id = r_id;
	}
	public String getB_id() {
		return b_id;
	}
	public void setB_id(String b_id) {
		this.b_id = b_id;
	}
	public String getU_id() {
		return u_id;
	}
	public void setU_id(String u_id) {
		this.u_id = u_id;
	}
	public Date getR_daytaken() {
		return r_daytaken;
	}
	public void setR_daytaken(Date r_daytaken) {
		this.r_daytaken = r_daytaken;
	}
	public Date getR_maxdayret() {
		return r_maxdayret;
	}
	public void setR_maxdayret(Date r_maxdayret) {
		this.r_maxdayret = r_maxdayret;
	}
	public boolean isR_returnedbook() {
		return r_returnedbook;
	}
	public void setR_returnedbook(boolean r_returnedbook) {
		this.r_returnedbook = r_returnedbook;
	}
	
	@Override
	public String toString() {
		return "Reservesations [r_id=" + r_id + ", b_id=" + b_id + ", u_id=" + u_id + ", r_daytaken=" + r_daytaken
				+ ", r_maxdayret=" + r_maxdayret + ", r_returnedbook=" + r_returnedbook + "]";
	}
	
}
