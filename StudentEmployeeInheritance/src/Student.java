
public class Student extends Person
{
	protected int gpa;

	Student(String firstName, String lastName, String address, int id, int gpa)
	{
		super(firstName, lastName, address, id);
		
		this.gpa = gpa;
	}
	
	public void setGPA(int gpa)
	{
		this.gpa = gpa;
	}
	
	public double getGPA()
	{
		return gpa;
	}
	
	
}


