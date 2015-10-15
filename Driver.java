public class Driver
{
	private int currentLoc;
	
	public Driver(int loc)
	{
		currentLoc = loc;
	}
	
	public int setLocation(int newLoc)
	{
		currentLoc = newLoc;
		return currentLoc;
	}
	
	public int getLocation()
	{
		return currentLoc;
	}
}
