package builderDesign.example4;

//https://howtodoinjava.com/design-patterns/creational/builder-pattern-in-java/

public class UserDemo {
	public static void main(String[] args) {
	    User user1 = new User.UserBuilder("Lokesh", "Gupta")
	    .age(30).address("Fake address 1234").address1("Test")
	    .phone("1234567")
	    .build();
	 
	    System.out.println(user1);
	 
	    User user2 = new User.UserBuilder("Jack", "Reacher")
	    .age(40)
	    .phone("5655")
	    //no address
	    .build();
	 
	    System.out.println(user2);
	 
	    User user3 = new User.UserBuilder("Super", "Man")
	    //No age
	    //No phone
	    //no address
	    .build();
	 
	    System.out.println(user3.getFirstName());
	}
}
