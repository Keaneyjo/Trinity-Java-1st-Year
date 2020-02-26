
public class Person {
	
	

	protected String firstName;
	protected String lastName;
	protected String address;
	protected int id;
	
	Person()
	{
		
	}
	
	Person (String firstName, String lastName, String address, int id)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.id = id;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String toString()
	{
		return ("n%s%,%n%s,%n%s,");
	}

}
