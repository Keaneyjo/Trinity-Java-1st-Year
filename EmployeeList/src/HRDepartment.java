import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class HRDepartment implements HRCodes{

	ArrayList <Employee> employeeList;
	HRDepartment()
	{
		employeeList= new ArrayList<Employee>();
	}
	
	public void addEmployee(int employeeId, String name, int role)
	{
		Employee employee = new Employee(employeeId, name, role);
		employeeList.add(employee);
	}
	
	public void printAllEmployees()
	{
		for (int i = 0; i < employeeList.size(); i++)
		{
			Employee aEmployee = (Employee) employeeList.get(i);
			System.out.println(aEmployee.toString() + "\n");
		}
	}
	
	public Employee findEmployee (int EmployeeId)
	{
		for (int i = 0; i < employeeList.size(); i++)
		{
			Employee aEmployee = (Employee) employeeList.get(i);
			if (aEmployee.getEmployeeId() == EmployeeId)
			{
				return aEmployee;
			}
		}
		return null;
	}
	
	public boolean recordEmployeeAppraisal (int employeeId, Date appraisalDate, int score)
	{
		try
		{
			Employee aEmployee = findEmployee(employeeId);
			if (aEmployee == null)
				return false;
			else
			{
				EmployeeAppraisal aEmployeeAppraisal = new EmployeeAppraisal(appraisalDate, score);
				ArrayList<EmployeeAppraisal> aEmployeeAppraisalList = aEmployee.getAppraisalHistory();
				aEmployeeAppraisalList.add(aEmployeeAppraisal);
				return true;
			}
		}
		catch (Exception e)
		{
			return false;
		}
		
	}
	
	public boolean promoteEmployee(int employeeId)
	{
		
		Employee aEmployee = findEmployee(employeeId);
		ArrayList<EmployeeAppraisal> aEmployeeAppraisalList = aEmployee.getAppraisalHistory();
		if (aEmployeeAppraisalList.get(aEmployeeAppraisalList.size()-2).equals(EXCEEDED_EXPECTATIONS))
		{
			if (aEmployeeAppraisalList.get(aEmployeeAppraisalList.size()-1).equals(EXCEEDED_EXPECTATIONS))
			{
				Calendar calendar =Calendar.getInstance();
				calendar.setTime(new Date());
				calendar.add(Calendar.YEAR,-1);
				Date date = calendar.getTime();
						
				Calendar calendar2 =Calendar.getInstance();
				calendar2.setTime(new Date());
				Date date2 = calendar2.getTime();
				
				calendar2.add(Calendar.YEAR,-1);
				Date date3 = calendar2.getTime();
				if (date2.before(date3) || date2.equals(date3))
				{
					int role = aEmployee.getRole();
					if (role != 1)
						role = role - 1;
					aEmployee.setRole(role);
					return true;
				}
			}
		}
		return false;
	}

}
