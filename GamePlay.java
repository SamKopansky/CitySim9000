import java.util.Random;

public class GamePlay
{
	private Driver driver;
	private int driverNumber;
	private Random rand;
	
	public GamePlay(Driver d, int dnum, Random r)
	{
		driver = d;
		driverNumber = dnum;
		rand = r;
	}
	
	public void start()
	{
		int oldLoc = 0;
		do
		{
			oldLoc = driver.getLocation();
			update(oldLoc);
			output(oldLoc, driver.getLocation());
			
		} while (driver.getLocation() != 4);
		outputOutro();
	}
	
	private void update(int oldLoc)
	{
		int newLoc = getNewLoc(oldLoc, getNewDirection(rand));
		driver.setLocation(newLoc);
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
		if (num == 0)
		{
			return "Mall";
		}
		else if (num == 1)
		{
			return "Bookstore";
		}
		else if (num == 2)
		{
			return "Coffee Shop";
		}
		else if (num == 3)
		{
			return "University";
		}
		return "Outside City";
	}
	
	public int getNewLoc(int oldLoc, int newLoc)
	{
		if (oldLoc == 0 && newLoc == 0)
		{
			return 1; //bookstore
		}
		else if (oldLoc == 0 && newLoc == 1)
		{
			return 2; //coffee
		}
		else if (oldLoc == 1 && newLoc == 0)
		{
			return 4; //outside
		}
		else if (oldLoc == 1 && newLoc == 1)
		{
			return 3; //university
		}
		else if (oldLoc == 2 && newLoc == 0)
		{
			return 4; //outside
		}
		else if (oldLoc == 2 && newLoc == 1)
		{
			return 0; //mall
		}
		else if (oldLoc == 3 && newLoc == 0)
		{
			return 2; //coffee
		}
		else if (oldLoc == 3 && newLoc == 1)
		{
			return 1; //bookstore
		}
		else if (oldLoc == 4 && newLoc == 0)
		{
			return 0; //mall
		}
		return 3; //university
		
	}
	
	public String getStreet(int oldLoc, int newLoc)
	{
		if (oldLoc == 0 && newLoc == 1)
		{
			return " via Fourth Ave.";
		}
		else if (oldLoc == 0 && newLoc == 2)
		{
			return " via Meow St.";
		}
		else if (oldLoc == 1 && newLoc == 4)
		{
			return " via Fourth Ave."; 
		}
		else if (oldLoc == 1 && newLoc == 3)
		{
			return " via Chirp St.";
		}
		else if (oldLoc == 2 && newLoc == 4)
		{
			return " via Fifth Ave.";
		}
		else if (oldLoc == 2 && newLoc == 0)
		{
			return " via Meow St.";
		}
		else if (oldLoc == 3 && newLoc == 2)
		{
			return " via Fifth Ave.";
		}
		else if (oldLoc == 3 && newLoc == 1)
		{
			return " via Chirp St.";
		}
		else if (oldLoc == 4 && newLoc == 0)
		{
			return " via Fourth Ave.";
		}
		return " via Fifth Ave.";
	}
	
	public int getNewDirection(Random r)
	{
		return r.nextInt(2);
	}
}
