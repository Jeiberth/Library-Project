package WebLibraryREST;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("Lib")
public class LibraryResource {

	private Library L = new Library(
			new ArrayList<>(Arrays.asList(new Book("1", "The Great Gatsby", "F. Scott Fitzgerald", "Fiction", 1925, "7777"),
									        new Book("2", "To Kill a Mockingbird", "Harper Lee", "Fiction", 1960, "7777"),
									        new Book("3", "1984", "George Orwell", "Dystopian", 1949, "7777"),
									        new Book("4", "The Catcher in the Rye", "J.D. Salinger", "Fiction", 1951, "7777"),
									        new Book("5", "Pride and Prejudice", "Jane Austen", "Classic", 1813, "7777"),
									        new Book("6", "The Hobbit", "J.R.R. Tolkien", "Fantasy", 1937, "7777"),
									        new Book("7", "Harry Potter and the Sorcerer's Stone", "J.K. Rowling", "Fantasy", 1997, "7777"),
									        new Book("8", "The Lord of the Rings", "J.R.R. Tolkien", "Fantasy", 1954, "7777"),
									        new Book("9", "The Da Vinci Code", "Dan Brown", "Mystery", 2003, "7777"),
									        new Book("10", "The Alchemist", "Paulo Coelho", "Fiction", 1988, "7777"))),
			new ArrayList<>(Arrays.asList(new User("User1", "John Doe", "password1", 25, true),
							                new User("User2", "Jane Smith", "password2", 30, false),
							                new User("User3", "Bob Johnson", "password3", 22, false),
							                new User("User4", "Alice Brown", "password4", 28, true),
							                new User("User5", "Charlie Wilson", "password5", 35, false))),
			new ArrayList<>(Arrays.asList(new Reservesations("2000", "10", "User4", new Date(), new Date(), false))),
			"7777"
			);
	

	@GET
	@Path("addB")
	@Produces(MediaType.TEXT_HTML)
	public String RAddBook(@QueryParam("b_id")String b_id, @QueryParam("b_name")String b_name, @QueryParam("b_author")String b_author, @QueryParam("b_topic")String b_topic, @QueryParam("b_yearpub")int b_yearpub) {
		L.addBook(b_id, b_name, b_author, b_topic, b_yearpub);
		return "<html><title>Library</title><body><h1>The book was added succesfully</h1><br>" + L.getBks().get(L.getBks().size()-1) + "</body></html>";
	}
	
	@GET
	@Path("addU")
	@Produces(MediaType.APPLICATION_JSON)
	public User RAddUser(@QueryParam("u_id")String u_id, @QueryParam("u_name")String u_name, @QueryParam("u_password")String u_password, @QueryParam("u_age")int u_age, @QueryParam("admin")boolean admin) {
		L.addUser(u_id, u_name, u_password, u_age, admin);
		return L.getUsr().get(L.getUsr().size()-1);
	}
	
	@GET
	@Path("/MakeReserv/{b_id}/{u_id}")
	@Produces(MediaType.TEXT_PLAIN)
	public String RMakeReservation(@PathParam("b_id")String b_id, @PathParam("u_id")String u_id) {	
		return L.MakeReservation(b_id, u_id);		
	}
	
	
	@GET
	@Path("SearchBook")
	@Produces(MediaType.APPLICATION_JSON)
	public Book RSearchBook(@QueryParam("b_name")String b_name) {	
		return L.SearchBook(b_name);		
	}	
	
	@GET
	@Path("/Book")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Book> RGetBooks() {	
		return L.getBks();		
	}
	
	@GET
	@Path("/ReturnBook/{r_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Reservesations RReturnBook(@PathParam("r_id")String r_id) {	
		L.ReturnBook(r_id);		
		return L.SearchReservation(r_id);
	}	
			
	
	
}
