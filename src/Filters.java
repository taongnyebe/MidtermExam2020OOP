import java.util.Scanner;

public class Filters {

	static Scanner input = new Scanner(System.in);
	
	public static int FilterInt()
	{
		int checked;
		
		while(true)
		{
			
			if(input.hasNextInt())
			{
				checked = input.nextInt();
				break;
			}
			else 
			{
				System.out.println("Invalid Please Re-Enter");
			}
		}
		
		return checked;
	}
	
	public int NonStaticFilterInt()
	{
		int checked;
		
		while(true)
		{
			
			if(input.hasNextInt())
			{
				checked = input.nextInt();
				break;
			}
			else 
			{
				System.out.println("Invalid Please Re-Enter");
			}
		}
		
		return checked;
	}

}
