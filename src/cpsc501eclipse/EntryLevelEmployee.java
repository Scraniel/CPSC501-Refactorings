package cpsc501eclipse;

import java.util.Scanner;

public class EntryLevelEmployee extends Employee {

	@Override
	public int getSalary() {
		if(Integer.parseInt(super.getId()) > ENTRY_LEVEL_ID_CAP || Integer.parseInt(super.getId()) < 0)
			return -1;
		return Integer.parseInt(super.getId()) * ENTRY_LEVEL_MODIFIER;
	}

	@Override
	public boolean authenticate(Scanner in) {
		return true;
	}

}
