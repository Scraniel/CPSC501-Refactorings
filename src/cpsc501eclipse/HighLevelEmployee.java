package cpsc501eclipse;

import java.util.Scanner;

public class HighLevelEmployee extends Employee {

	@Override
	public int getSalary() {
		if(Integer.parseInt(super.getId()) > HIGH_LEVEL_ID_CAP || Integer.parseInt(super.getId()) < 0)
			return -1;
		return Integer.parseInt(super.getId()) * HIGH_LEVEL_MODIFIER;
	}

	@Override
	public boolean authenticate(Scanner in) {
		System.out.print("Please enter the password: ");
		String password = in.nextLine();
    	if(password.compareTo(SECURE_PASSWORD) != 0)
    	{
    		System.out.print("Sorry, please try again.");
    		return false;
    	}
    	else
    	{
    		System.out.print("Please enter the pin: ");
        	password = in.nextLine();
        	if(password.compareTo(PIN) != 0)
        	{
        		System.out.print("Sorry, please try again.");
        		return false;
        	}
        	else{
        		return true;
        	}
    	}
	}

}
