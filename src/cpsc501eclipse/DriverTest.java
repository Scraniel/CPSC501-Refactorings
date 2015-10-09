package cpsc501eclipse;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import org.junit.Test;

public class DriverTest {

	@Test
	public void testGetSalary() {
		// Testing edge cases
		int type = 0;
		int id = 0;
		assertEquals(0, Driver.getSalary(type, id));
		
		type = 20;
		id = 1000;
		assertEquals(250000, Driver.getSalary(type, id));
		
		
		// Testing typical case
		type = 2;
		id = 60;
		assertEquals(30000, Driver.getSalary(type, id));
		
		// Testing fail cases
		type = -1;
		assertEquals(-1, Driver.getSalary(type, id));
		
		type = 21;
		assertEquals(-1, Driver.getSalary(type, id));
		
	}

	@Test
	public void testAuthenticate() {
		// Testing edge cases
		int type = 0;
		String data = "";
		assertTrue(Driver.authenticate(type, new Scanner(System.in)));
		
		type = 20;
		data = "secretPassword\r\n123456\r\n";
		setSystemIn(data);
		assertTrue(Driver.authenticate(type, new Scanner(System.in)));
		
		
		// Testing typical case
		type = 2;
		data = "password123\r\n";
		setSystemIn(data);
		assertTrue(Driver.authenticate(type, new Scanner(System.in)));
		
		// Testing fail cases
		type = -1;
		assertFalse(Driver.authenticate(type, new Scanner(System.in)));
		
		type = 21;
		assertFalse(Driver.authenticate(type, new Scanner(System.in)));
		
		//wrong passwords
		type = 2;
		data = "password\r\n";
		setSystemIn(data);
		assertFalse(Driver.authenticate(type, new Scanner(System.in)));
		
		type = 20;
		data = "secretPasswordf\r\n123456\r\n";
		setSystemIn(data);
		assertFalse(Driver.authenticate(type, new Scanner(System.in)));
		
		// right passwrod, wrong pin
		type = 20;
		data = "secretPassword\r\n1234567\r\n";
		setSystemIn(data);
		assertFalse(Driver.authenticate(type, new Scanner(System.in)));
		
		
		System.setIn(System.in);
	}
	
	// changes System.in to a byte stream for testing.
	public void setSystemIn(String data)
	{
		System.setIn(new ByteArrayInputStream(data.getBytes()));		 	
	}

}
