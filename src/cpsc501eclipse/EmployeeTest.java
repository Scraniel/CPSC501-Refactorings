package cpsc501eclipse;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import org.junit.Test;

public class EmployeeTest {

	@Test
	public void testGetSalaryEntryLevel() {
		Employee tester = new EntryLevelEmployee();
		
		// Testing edge cases
		tester.setId("0");
		assertEquals(0, tester.getSalary());
		
		tester.setId("50");
		assertEquals(50000, tester.getSalary());
		
		// Testing typical case
		tester.setId("20");
		assertEquals(20000, tester.getSalary());
		
		
		// Testing fail cases
		tester.setId("-1");
		assertEquals(-1, tester.getSalary());
		
		tester.setId("51");
		assertEquals(-1, tester.getSalary());
		
	}
	
	@Test
	public void testGetSalaryMidLevel() {
		Employee tester = new MidLevelEmployee();
		
		// Testing edge cases
		tester.setId("51");
		assertEquals(25500, tester.getSalary());
		
		tester.setId("100");
		assertEquals(50000, tester.getSalary());
		
		// Testing typical case
		tester.setId("75");
		assertEquals(37500, tester.getSalary());
		
		
		// Testing fail cases
		tester.setId("-1");
		assertEquals(-1, tester.getSalary());
		
		tester.setId("101");
		assertEquals(-1, tester.getSalary());
		
	}
	
	@Test
	public void testGetSalaryHighLevel() {
		Employee tester = new HighLevelEmployee();
		
		// Testing edge cases
		tester.setId("101");
		assertEquals(25250, tester.getSalary());
		
		tester.setId("1000");
		assertEquals(250000, tester.getSalary());
		
		// Testing typical case
		tester.setId("500");
		assertEquals(125000, tester.getSalary());
		
		
		// Testing fail cases
		tester.setId("-1");
		assertEquals(-1, tester.getSalary());
		
		tester.setId("1001");
		assertEquals(-1, tester.getSalary());
		
	}

	@Test
	public void testAuthenticateEntryLevel() {
		Employee tester = new EntryLevelEmployee();
		
		// Only 1 case for entry level guys
		assertTrue(tester.authenticate(new Scanner(System.in)));
			
		System.setIn(System.in);
	}
	
	public void testAuthenticateMidLevel()
	{
		Employee tester = new MidLevelEmployee();

		// Testing typical case
		String data = "password123\r\n";
		setSystemIn(data);
		assertTrue(tester.authenticate(new Scanner(System.in)));
		
		//wrong password
		data = "password\r\n";
		setSystemIn(data);
		assertFalse(tester.authenticate(new Scanner(System.in)));
		
		System.setIn(System.in);		
	}
	
	public void testAuthenticationHighLevel()
	{
		Employee tester = new HighLevelEmployee();
		
		String data = "secretPassword\r\n123456\r\n";
		setSystemIn(data);
		assertTrue(tester.authenticate(new Scanner(System.in)));	

		data = "secretPasswordf\r\n123456\r\n";
		setSystemIn(data);
		assertFalse(tester.authenticate(new Scanner(System.in)));
		
		// right password, wrong pin
		data = "secretPassword\r\n1234567\r\n";
		setSystemIn(data);
		assertFalse(tester.authenticate(new Scanner(System.in)));
		
		System.setIn(System.in);
	}
	
	// changes System.in to a byte stream for testing.
	public void setSystemIn(String data)
	{
		System.setIn(new ByteArrayInputStream(data.getBytes()));		 	
	}

}
