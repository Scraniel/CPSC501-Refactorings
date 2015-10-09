package cpsc501eclipse;

import java.util.Scanner;

abstract public class Employee {
	private String username, realname;
	private String id;
	public static int ENTRY_LEVEL_ID_CAP = 50;
	public static int MID_LEVEL_ID_CAP = 100;
	public static int HIGH_LEVEL_ID_CAP = 1000;
	protected static int ENTRY_LEVEL_MODIFIER = 1000;
	protected static int MID_LEVEL_MODIFIER = 500;
	protected static int HIGH_LEVEL_MODIFIER = 250;
	protected static String PASSWORD = "password123";
	protected static String SECURE_PASSWORD = "secretPassword";
	protected static String PIN = "123456";

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

	abstract public int getSalary();
	
	abstract public boolean authenticate(Scanner in);
}
