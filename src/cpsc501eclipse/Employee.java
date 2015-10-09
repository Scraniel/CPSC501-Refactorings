package cpsc501eclipse;

import java.util.Scanner;

public class Employee {
	private String username, realname, id;
	private int type;
	private static int ENTRY_LEVEL_MODIFIER = 1000;
	private static int MID_LEVEL_MODIFIER = 500;
	private static int HIGH_LEVEL_MODIFIER = 250;
	private static String PASSWORD = "password123";
	private static String SECURE_PASSWORD = "secretPassword";
	private static String PIN = "123456";
	
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getSalary()
	{
		int salary = -1;
		int id = Integer.parseInt(this.id);
        switch(type)
        {
        case 0:
        case 1:
        	salary = id * ENTRY_LEVEL_MODIFIER;
        	break;
        case 2:
        	salary = id * MID_LEVEL_MODIFIER;
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
        	salary = id * HIGH_LEVEL_MODIFIER;
        }
        
        return salary;
	}
	
	public boolean authenticate(Scanner in)
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
        	if(password.compareTo(PASSWORD) != 0)
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
        	if(password.compareTo(SECURE_PASSWORD) != 0)
        	{
        		System.out.print("Sorry, please try again.");
        	}
        	else
        	{
        		System.out.print("Please enter the pin: ");
	        	password = in.nextLine();
	        	if(password.compareTo(PIN) != 0)
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
