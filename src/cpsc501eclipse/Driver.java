package cpsc501eclipse;

import java.util.*;

public class Driver {
	static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		String username, realname, id;
		ArrayList<String> usernames = new ArrayList<String>();
		ArrayList<String> realnames = new ArrayList<String>();
		ArrayList<String> ids = new ArrayList<String>();
		boolean exit = false;
		
		
		while(!exit){
			
	        System.out.print("Please enter user name : ");
	        username = in.nextLine();
	        usernames.add(username);
	        
	        System.out.print("Please enter real name : ");
	        realname = in.nextLine();   
	        realnames.add(realname);
	        
	        System.out.print("Please enter id# : ");
	        id = in.nextLine();
	        ids.add(id);
	        
	        
	        int type = (int)Math.ceil((double)Integer.parseInt(id) / 50.0);
	        int salary = getSalary(type, Integer.parseInt(id));
	        System.out.println("Congratulations " + realname + ", your salary is : $" + salary);
	        
	        System.out.println("Do you want to log in? (y/n) : ");
	        String response = in.nextLine();
	        
	        if(response.compareToIgnoreCase("y") == 0)
	        {
	        	boolean authenticated = false;
	        	System.out.println("Please enter your username : ");
	        	String loggingIn = in.nextLine();
	        	int index = usernames.indexOf(loggingIn);
	        	
		        	
		        	if(index != -1)
		        	{
		        		type = (int)Math.ceil((double)Integer.parseInt(ids.get(index))/50.0);
		        		while(!authenticated){
		        			authenticated = authenticate(type, in);
			        	}
			        	System.out.println("Hello " + realnames.get(index) + "! \nYour ID# is : " + ids.get(index) + "\nYour salary is : $" + getSalary(type, Integer.parseInt(id)));
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
	
	public static int getSalary(int type, int id)
	{
		int salary = -1;
        switch(type)
        {
        case 0:
        case 1:
        	salary = id * 1000;
        	break;
        case 2:
        	salary = id * 500;
        	break;
        case 3:
        case 4:
        case 5:
        case 6:
        case 7:
        case 8:
        case 9:
        case 10:
        case 11:
        case 12:
        case 13:
        case 14:
        case 15:
        case 16:
        case 17:
        case 18:
        case 19:
        case 20:
        	salary = id * 250;
        }
        
        return salary;
	}
	
	public static boolean authenticate(int type, Scanner in)
	{
		boolean authenticated = false; 
		switch(type)
        {
        case 0:
        case 1:
        	authenticated = true;
        	break;
        case 2:
        	System.out.print("Please enter the password: ");
        	String password = in.nextLine();
        	if(password.compareTo("password123") != 0)
        	{
        		System.out.print("Sorry, please try again.");
        	}
        	else
        	{
        		authenticated = true;
        	}
        	break;
        case 3:
        case 4:
        case 5:
        case 6:
        case 7:
        case 8:
        case 9:
        case 10:
        case 11:
        case 12:
        case 13:
        case 14:
        case 15:
        case 16:
        case 17:
        case 18:
        case 19:
        case 20:
        	System.out.print("Please enter the password: ");
        	password = in.nextLine();
        	if(password.compareTo("secretPassword") != 0)
        	{
        		System.out.print("Sorry, please try again.");
        	}
        	else
        	{
        		System.out.print("Please enter the pin: ");
	        	password = in.nextLine();
	        	if(password.compareTo("123456") != 0)
	        	{
	        		System.out.print("Sorry, please try again.");
	        	}
	        	else{
	        		authenticated = true;
	        	}
        	}
        }
		return authenticated;
	}
}
