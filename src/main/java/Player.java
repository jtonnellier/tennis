
public class Player {
	
	String firstName ="first name";
	String lastName = "last name";
	
	public Player(String firstName,	String lastName) {		
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public String toString() {
		return firstName + ' ' + lastName;
	}
}
