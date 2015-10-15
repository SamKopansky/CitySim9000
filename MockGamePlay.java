import java.util.Random;


//This class is a mock version of GamePlay for testing the start() method. 
//It stubs all other methods for easy testing.
public class MockGamePlay
{
	private Driver driver;
	private int driverNumber;
	private Random rand;
	
	public MockGamePlay(Driver d, int dnum, Random r)
	{
		driver = d;
		driverNumber = dnum;
		rand = r;
	}
	
	public boolean start()
	{
		int oldLoc = 0;
		do
		{
			oldLoc = driver.getLocation();
			update();
			output(oldLoc, driver.getLocation());
			
		} while (driver.getLocation() != 4);
		outputOutro();
		return true;
	}
	
	private void update()
	{
		driver.setLocation(4);
	}
	
	private void output(int oldLoc, int newLoc)
	{
		System.out.println("Driver " + driverNumber + " heading from " + decode(oldLoc) + " to " + decode(newLoc) + getStreet(oldLoc, newLoc));
	}
	
	private void outputOutro()
	{
		System.out.println("Driver " + driverNumber + " has left the city!");
		System.out.println("-----");
	}
	
	public String decode(int num)
	{
		return "Outside City";
	}
	
	public int getNewLoc(int oldLoc, int newLoc)
	{
		
		return 4;
		
	}
	
	public String getStreet(int oldLoc, int newLoc)
	{
		return " via Fifth Ave.";
	}
	
	public int getNewDirection(Random r)
	{
		return r.nextInt(2);
	}
}
