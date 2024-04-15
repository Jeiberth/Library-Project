package WebLibraryREST;

public class Book {
	
	private String b_id;
	private String b_name;
	private String b_author;
	private String b_topic;
	private int b_yearpub;
	private String u_id; //Who has the book
		
	public Book(String b_id, String b_name, String b_author, String b_topic, int b_yearpub, String u_id) {
		super();
		this.b_id = b_id;
		this.b_name = b_name;
		this.b_author = b_author;
		this.b_topic = b_topic;
		this.b_yearpub = b_yearpub;
		this.u_id = u_id;
	}
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getB_id() {
		return b_id;
	}
	public void setB_id(String b_id) {
		this.b_id = b_id;
	}
	public String getB_name() {
		return b_name;
	}
	public void setB_name(String b_name) {
		this.b_name = b_name;
	}
	public String getB_author() {
		return b_author;
	}
	public void setB_author(String b_author) {
		this.b_author = b_author;
	}
	public String getB_topic() {
		return b_topic;
	}
	public void setB_topic(String b_topic) {
		this.b_topic = b_topic;
	}
	public int getB_yearpub() {
		return b_yearpub;
	}
	public void setB_yearpub(int b_yearpub) {
		this.b_yearpub = b_yearpub;
	}
	public String getU_id() {
		return u_id;
	}
	public void setU_id(String u_id) {
		this.u_id = u_id;
	}
	@Override
	public String toString() {
		return "Book [b_id=" + b_id + ", b_name=" + b_name + ", b_author=" + b_author + ", b_topic=" + b_topic
				+ ", b_yearpub=" + b_yearpub + ", u_id=" + u_id + "]";
	}
	
	
}
