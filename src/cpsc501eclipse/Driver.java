package cpsc501eclipse;

import java.util.*;

public class Driver {
	
	public static void main(String[] args) {
		String x, y, z;
		ArrayList<String> usernames = new ArrayList<String>();
		ArrayList<String> realnames = new ArrayList<String>();
		ArrayList<String> ids = new ArrayList<String>();
		boolean exit = false;
		
		while(!exit){
			Scanner in = new Scanner(System.in);
	        System.out.print("Please enter user name : ");
	        x = in.nextLine();
	        usernames.add(x);
	        
	        System.out.print("Please enter real name : ");
	        y = in.nextLine();   
	        realnames.add(y);
	        
	        System.out.print("Please enter id# : ");
	        z = in.nextLine();
	        ids.add(z);
	        
	        int salary = 0;
	        int type = (int)Math.ceil((double)Integer.parseInt(z)/50.0);
	        switch(type)
	        {
	        case 0:
	        case 1:
	        	salary = Integer.parseInt(z) * 1000;
	        	break;
	        case 2:
	        	salary = Integer.parseInt(z) * 500;
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
	        	salary = Integer.parseInt(z) * 250;
	        }
	        
	        System.out.println("Congratulations " + y + ", your salary is : $" + salary);
	        
	        System.out.println("Do you want to log in? (y/n) : ");
	        String response = in.nextLine();
	        
	        if(response.compareToIgnoreCase("y") == 0)
	        {
	        	boolean notAuthenticated = true;
	        	System.out.println("Please enter your username : ");
	        	String loggingIn = in.nextLine();
	        	int index = usernames.indexOf(loggingIn);
	        	
		        	
		        	if(index != -1)
		        	{
		        		while(notAuthenticated){
		        			type = (int)Math.ceil((double)Integer.parseInt(ids.get(index))/50.0);
		        			switch(type)
			    	        {
			    	        case 0:
			    	        case 1:
			    	        	notAuthenticated = false;
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
			    	        		notAuthenticated = false;
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
				    	        		notAuthenticated = false;
				    	        	}
			    	        	}
			    	        }
			        	}
			        	System.out.println("Hello " + realnames.get(index) + "! \nYour ID# is : " + ids.get(index) + "\nYour salary is : $" + salary);
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
