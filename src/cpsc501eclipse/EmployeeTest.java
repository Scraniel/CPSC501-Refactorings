package cpsc501eclipse;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import org.junit.Test;

public class EmployeeTest {

	@Test
	public void testGetSalary() {
		Employee tester = new Employee();
		
		// Testing edge cases
		tester.setType(0);
		tester.setId("0");
		assertEquals(0, tester.getSalary());
		
		tester.setType(20);
		tester.setId("1000");
		assertEquals(250000, tester.getSalary());
		
		
		// Testing typical case
		tester.setType(2);
		tester.setId("60");
		assertEquals(30000, tester.getSalary());
		
		// Testing fail cases
		tester.setType(-1);
		assertEquals(-1, tester.getSalary());
		
		tester.setType(21);
		assertEquals(-1, tester.getSalary());
		
	}

	@Test
	public void testAuthenticate() {
		Employee tester = new Employee();
		
		// Testing edge cases
		tester.setType(0);
		String data = "";
		assertTrue(tester.authenticate(new Scanner(System.in)));
		
		tester.setType(20);
		data = "secretPassword\r\n123456\r\n";
		setSystemIn(data);
		assertTrue(tester.authenticate(new Scanner(System.in)));
		
		
		// Testing typical case
		tester.setType(2);
		data = "password123\r\n";
		setSystemIn(data);
		assertTrue(tester.authenticate(new Scanner(System.in)));
		
		// Testing fail cases
		tester.setType(-1);
		assertFalse(tester.authenticate(new Scanner(System.in)));
		
		tester.setType(21);
		assertFalse(tester.authenticate(new Scanner(System.in)));
		
		//wrong passwords
		tester.setType(2);
		data = "password\r\n";
		setSystemIn(data);
		assertFalse(tester.authenticate(new Scanner(System.in)));
		
		tester.setType(20);
		data = "secretPasswordf\r\n123456\r\n";
		setSystemIn(data);
		assertFalse(tester.authenticate(new Scanner(System.in)));
		
		// right passwrod, wrong pin
		tester.setType(20);
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
