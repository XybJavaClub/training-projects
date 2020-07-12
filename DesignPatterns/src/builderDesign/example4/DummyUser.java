package builderDesign.example4;

public class DummyUser {
	/*private String firstName = null;
	private String lastName = null;
	private int age = 0;
	private String phone = null;
	private String address = null;*/
	
	private final String firstName;
	private final String lastName;
	private final int age;
	private final String phone;
	private final String address;
    
	public DummyUser(String firstName, String lastName, int age, String phone, String address){
	    this.firstName = firstName;
	    this.lastName = lastName;
	    this.age = age;
	    this.phone = phone;
	    this.address = address;
	}
	
	/*public DummyUser(String firstName, String lastName, int age, String phone){  
	    this.firstName = firstName;
	    this.lastName = lastName;
	    this.age = age;
	    this.phone = phone;
	}
	public DummyUser(String firstName, String lastName, String phone, String address){   
	    this.firstName = firstName;
	    this.lastName = lastName;
	    this.phone = phone;
	    this.address = address;
	}
	public DummyUser(String firstName, String lastName, int age){ 
	    this.firstName = firstName;
	    this.lastName = lastName;
	    this.age = age;
	}
	public DummyUser(String firstName, String lastName){ 
	    this.firstName = firstName;
	    this.lastName = lastName;
	}*/
}
