import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DriverTest
{
	@Before
	public void setUp() throws Exception
	{
		
	}

	@After
	public void tearDown() throws Exception
	{
		
	}
	
	@Test
	public void testGetLocation()
	{
		Driver d = new Driver(0); //Test double
		assertEquals(0, d.getLocation());
	}
	
	@Test
	public void testSetLocation()
	{
		Driver d = new Driver(0); //Test double
		d.setLocation(1);
		assertEquals(1, d.getLocation());
	}
	
	
}
