import java.util.*;

public class CitySim9000
{
	public static void main(String[] args)
	{
		int seed = 0;
		String youShouldntBeHere = "";
		
		try
		{
			youShouldntBeHere = args[1];
			System.out.println("\nToo many arguments. System exiting.\n");
			System.exit(0);
		}
		catch (Exception e)
		{
		}
		
		try
		{
			seed = Integer.parseInt(args[0]);
		}
		catch (Exception e)
		{
			System.out.println("\nSeed argument invalid or missing. System exiting.\n");
			System.exit(0);
		}
		
		
		//here comes actual gameplay
		Random r = new Random(seed);
		for (int i = 0; i < 5; i++)
		{
			GamePlay gamePlay = new GamePlay(new Driver(getStartLocation(r)), i, r);
			gamePlay.start();
		}
		
	}
	
	private static int getStartLocation(Random r)
	{
		return r.nextInt(5);
	}
	
}
