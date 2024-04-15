package WebLibraryREST;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Library {

	private final String idLibrary;
	private ArrayList<Book> bks=new ArrayList<Book>();
	private ArrayList<Reservesations> rvs=new ArrayList<Reservesations>();
	private ArrayList<User> usr=new ArrayList<User>();
	private int IdRevCounter = 1000;
	
	//Constructors
	public Library(ArrayList<Book> bks, ArrayList<User> usr, ArrayList<Reservesations> rvs, String idLibrary) {
		super();
		this.idLibrary = idLibrary;
		this.bks = bks;
		this.rvs = rvs;
		this.usr = usr;
	}	
	public Library() {
		super();
		this.idLibrary = "0000";
		// TODO Auto-generated constructor stub
	}
	
	//Getters and setters
	public ArrayList<Book> getBks() {
		return bks;
	}
	public void setBks(ArrayList<Book> bks) {
		this.bks = bks;
	}
	public ArrayList<Reservesations> getRvs() {
		return rvs;
	}
	public void setRvs(ArrayList<Reservesations> rvs) {
		this.rvs = rvs;
	}
	public ArrayList<User> getUsr() {
		return usr;
	}
	public void setUsr(ArrayList<User> usr) {
		this.usr = usr;
	}

	public void addBook(String b_id, String b_name, String b_author, String b_topic, int b_yearpub){
		bks.add(new Book(b_id, b_name, b_author, b_topic, b_yearpub, idLibrary));
	}
	public void addBook(Book e) {
		bks.add(e);
	}
	
	public void addUser(String u_id, String u_name, String u_password, int u_age, boolean admin) {
		usr.add(new User(u_id, u_name, u_password, u_age, admin));
	}
	public void addUser(User e) {
		usr.add(e);
	}

	public String MakeReservation(String b_id, String u_id) {
		Book b = SearchBookID(b_id);
		User u = SearchUser(u_id);
		if(b==null)
			return "No book founded";
		if(u==null)
			return "No user Founded";
		if(b.getU_id()!=idLibrary)
			return "Book already booked";
		
        Date today = new Date();

        // Add 10 days to today's date
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);
        calendar.add(Calendar.DAY_OF_YEAR, 10);

        // Get the date after adding 10 days
        Date DayExpecBookBack = calendar.getTime();
		
        IdRevCounter++;
		rvs.add(new Reservesations(String.valueOf(IdRevCounter),b_id,u_id,today,DayExpecBookBack, false));
		b.setU_id(u_id); //Change the u_id in the book to the user id one
		return "Success, Your Reservation ID is "+IdRevCounter;
	}
	
	public Book SearchBookID(String b_id) {
		for(Book x:bks) {
			if(x.getB_id().equalsIgnoreCase(b_id)) {
				return x;
			}
		}
		return null;
	}
	
	
	public Book SearchBook(String b_name) {
		for(Book x:bks) {
			if(x.getB_name().equalsIgnoreCase(b_name)) {
				return x;
			}
		}
		return null;
	}
	
	public User SearchUser(String u_id) {
		for(User x:usr) {
			if(x.getU_id().equalsIgnoreCase(u_id)) {
				return x;
			}
		}
		return null;
	}
	
	public Reservesations SearchReservation(String r_id) {
		for(Reservesations x:rvs) {
			if(x.getR_id().equalsIgnoreCase(r_id)) {
				return x;
			}
		}
		return null;
	}
	
	public String ReturnBook(String r_id) {
		Reservesations r = SearchReservation(r_id);
		if (r==null) {return "No found";}
		r.setR_returnedbook(true);
		SearchBookID(r.getB_id()).setU_id(idLibrary); //Change the u_id in the book to the library one 
		return "Success";
	}
	
	@Override
	public String toString() {
		return "Library [idLibrary=" + idLibrary + ", bks=" + bks + ", rvs=" + rvs + ", usr=" + usr + ", IdRevCounter="
				+ IdRevCounter + "]";
	}
	
}
