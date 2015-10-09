package cpsc501eclipse;

import java.util.*;

public class Driver {
	static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		// Had to add these back in as temp variables to decide which type
		// of employee to make
		String username, realname, id;
		ArrayList<Employee> employees = new ArrayList<Employee>();
		boolean exit = false;
		
		
		while(!exit){
			Employee newGuy = null;
			
			
	        System.out.print("Please enter user name : ");
	        username = in.nextLine();
	        
	        System.out.print("Please enter real name : ");
	        realname = in.nextLine();
	        
	        System.out.print("Please enter id# : ");
	        id = in.nextLine();
	        
	        int type = (int)Math.ceil((double)Integer.parseInt(id) / 50.0);
	        if(type <= Employee.ENTRY_LEVEL_ID_CAP)
	        {
	        	newGuy = new EntryLevelEmployee();
	        }
	        else if (type <= Employee.MID_LEVEL_ID_CAP)
	        {
	        	newGuy = new MidLevelEmployee();
	        }
	        else if (type <= Employee.HIGH_LEVEL_ID_CAP)
	        {
	        	newGuy = new HighLevelEmployee();
	        	
	        }
	        else
	        {
	        	System.out.println("Invalid ID. Goodbye.");
	        	return;
	        }
	        newGuy.setId(id);
	        newGuy.setRealname(realname);
	        newGuy.setUsername(username);       
	        employees.add(newGuy);

	        System.out.println("Congratulations " + newGuy.getRealname() + ", your salary is : $" + newGuy.getRealname());
	        
	        System.out.println("Do you want to log in? (y/n) : ");
	        String response = in.nextLine();
	        
	        if(response.compareToIgnoreCase("y") == 0)
	        {
	        	boolean authenticated = false;
	        	System.out.println("Please enter your username : ");
	        	String loggingInUsername = in.nextLine();
	        	Employee loggingInEmployee = null;
	        	
	        	// Finding the employee
	        	for(int i = 0; i < employees.size(); i++)
	        	{
	        		if(employees.get(i).getUsername().compareTo(loggingInUsername) == 0)
	        		{
	        			loggingInEmployee = employees.get(i);
	        			break;
	        		}
	        	}
	        		
	        	if(loggingInEmployee != null)
	        	{
	        		while(!authenticated){
	        			authenticated = loggingInEmployee.authenticate(in);
		        	}
		        	System.out.println("Hello " + loggingInEmployee.getRealname() + "! \nYour ID# is : " + loggingInEmployee.getId() + "\nYour salary is : $" + loggingInEmployee.getSalary());
	        	}
	        	else{
	        		System.out.println("No such user.");
	        	}
	        	
	        }
	        
	        System.out.println("Do you want to add another user? (y/n) : ");
	        response = in.nextLine();
	        
	        if(response.compareToIgnoreCase("n") == 0)
	        {
	        	exit = true;
	        }
		}
		
		System.out.println("Ok bye!");
        
        
	}
	
	
}
