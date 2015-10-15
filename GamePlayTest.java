import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.Random;

public class GamePlayTest
{
	@Before
	public void setUp() throws Exception
	{
		
	}

	@After
	public void tearDown() throws Exception
	{
		
	}

	//Test getNewDirection(), simply see if it returns the expected value
	@Test
	public void testGetNewDirection()
	{
		Random r = new Random(10);
		GamePlay gp = new GamePlay(new Driver(0), 0, r);
		int nd = gp.getNewDirection(r);
		assertTrue(nd == 0 || nd == 1);
	}
	
	
	//Tests if all four locations in the city have readable names & exist 
	//This test uses 5 doubles
	@Test
	public void testCityLocs()
	{
		Random r = new Random(10);
		GamePlay gp = new GamePlay(new Driver(0), 0, r);
		assertTrue("Mall".equals(gp.decode(0)));
		assertTrue("Bookstore".equals(gp.decode(1)));
		assertTrue("Coffee Shop".equals(gp.decode(2)));
		assertTrue("University".equals(gp.decode(3)));
		assertTrue("Outside City".equals(gp.decode(4)));
	}
	
	//This test uses a number that is not mapped to a location in the city
	//THIS SHOULD FAIL
	@Test
	public void testOutOfCity()
	{
		Random r = new Random(10);
		GamePlay gp = new GamePlay(new Driver(0), 0, r);
		assertTrue("Nothing".equals(gp.decode(9))); //This should fail since 9 is not on the map
	}
	
	
	//Test to make sure all street names are in the system
	@Test
	public void testStreetNames()
	{
		Random r = new Random(10);
		GamePlay gp = new GamePlay(new Driver(0), 0, r);
		assertTrue(gp.getStreet(0, 1).equals(" via Fourth Ave."));
		assertTrue(gp.getStreet(0, 2).equals(" via Meow St."));
		assertTrue(gp.getStreet(1, 4).equals(" via Fourth Ave."));
		assertTrue(gp.getStreet(1, 3).equals(" via Chirp St."));
		assertTrue(gp.getStreet(2, 4).equals(" via Fifth Ave."));
		assertTrue(gp.getStreet(2, 0).equals(" via Meow St."));
		assertTrue(gp.getStreet(3, 2).equals(" via Fifth Ave."));
		assertTrue(gp.getStreet(3, 1).equals(" via Chirp St."));
		assertTrue(gp.getStreet(4, 0).equals(" via Fourth Ave."));
		assertTrue(gp.getStreet(4, 3).equals(" via Fifth Ave."));
	}
	
	//Sees if two non-connected locations can be visited directly
	//THIS SHOULD FAIL
	@Test
	public void testNonExistentStreet()
	{
		Random r = new Random(10);
		GamePlay gp = new GamePlay(new Driver(0), 0, r);
		assertTrue(gp.getStreet(4, 1).equals(" via Sidewalk"));
	}
	
	//Test checking if all numbers map to the correct next location.
	@Test
	public void testMapNumbers()
	{
		Random r = new Random(10);
		GamePlay gp = new GamePlay(new Driver(0), 0, r);
		assertEquals(gp.getNewLoc(0, 0), 1);
		assertEquals(gp.getNewLoc(0, 1), 2);
		assertEquals(gp.getNewLoc(1, 0), 4);
		assertEquals(gp.getNewLoc(1, 1), 3);
		assertEquals(gp.getNewLoc(2, 0), 4);
		assertEquals(gp.getNewLoc(2, 1), 0);
		assertEquals(gp.getNewLoc(3, 0), 2);
		assertEquals(gp.getNewLoc(3, 1), 1);
		assertEquals(gp.getNewLoc(4, 0), 0);
		assertEquals(gp.getNewLoc(4, 1), 3);
	}
	
	//Test checking if non-existent location can be reached
	//THIS TEST SHOULD FAIL
		@Test
		public void testGoToBadLocation()
		{
			Random r = new Random(10);
			GamePlay gp = new GamePlay(new Driver(0), 0, r);
			assertEquals(gp.getNewLoc(9, 0), 0);
			
		}
	
	//This test uses a mock class and stubs for almost all methods 
	//in GamePlay to quickly test the start() method without as many calculations
	@Test
	public void testStart()
	{
		Random r = new Random(10);
		MockGamePlay mgp = new MockGamePlay(new Driver(0), 0, r);
		assertTrue(mgp.start());
	}
	
}
