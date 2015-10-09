package cpsc501eclipse;

import java.util.Scanner;

public class MidLevelEmployee extends Employee {

	@Override
	public int getSalary() {
		if(Integer.parseInt(super.getId()) > MID_LEVEL_ID_CAP || Integer.parseInt(super.getId()) < 0)
			return -1;
		return Integer.parseInt(super.getId()) * MID_LEVEL_MODIFIER;
	}

	@Override
	public boolean authenticate(Scanner in) {
		System.out.print("Please enter the password: ");
    	String password = in.nextLine();
    	if(password.compareTo(PASSWORD) != 0)
    	{
    		System.out.print("Sorry, please try again.");
    		return false;
    	}

    	return true;
	}

}
