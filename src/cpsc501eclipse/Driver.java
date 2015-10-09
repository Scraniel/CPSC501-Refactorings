package cpsc501eclipse;

import java.util.*;

public class Driver {
	static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {

		ArrayList<Employee> employees = new ArrayList<Employee>();
		boolean exit = false;
		
		
		while(!exit){
			Employee newGuy = new Employee();
			
	        System.out.print("Please enter user name : ");
	        newGuy.setUsername(in.nextLine());
	        
	        System.out.print("Please enter real name : ");
	        newGuy.setRealname(in.nextLine());
	        
	        System.out.print("Please enter id# : ");
	        newGuy.setId(in.nextLine());
	        
	        int type = (int)Math.ceil((double)Integer.parseInt(newGuy.getId()) / 50.0);
	        newGuy.setType(type);
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
	        		type = loggingInEmployee.getType();
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
