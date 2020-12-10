import java.util.LinkedList;

public class Activity1 {

	private final int STATEAVAILABLE = 5; // this is the equivalent value able to modify in the RoomInfo Class
	private final int NOTINUSE = 0; // this is used to indicate that it was not used
	
	private int roomCount;
	
	private static Filters filter = new Filters();
	private static RoomInfo roomInfo;
	private LinkedList<RoomInfo> rooms = new LinkedList<RoomInfo>();
	
	public Activity1(int roomCount)
	{
		this.roomCount = roomCount;
		
		for (int a = 1; a <= roomCount; a++)// this will create a specified slots
		{
			roomInfo = new RoomInfo(a, "Unknown", "Unknown", "Not Specified", 0);
			
			rooms.add(roomInfo);
		}
	}
	
	public void SubMenuUI()
	{
		System.out.println("\n\n\n\n");
		boolean back = false;
		while(!back)
		{
			System.out.println("--------------------------------");
			System.out.println("Activty 1: Room List");
			System.out.println("--------------------------------");
			
			System.out.println('\n' + "--------------------------------");
			System.out.println("1. Check Rooms");
			System.out.println("2. Edit Room Info");
			System.out.println("0. Exit");
			int choice = filter.NonStaticFilterInt();
			System.out.println("--------------------------------");
			
			switch (choice)
			{
			case 0: back = true; break;
			case 1:	DisplayUI(); break;
			case 2: EditMenuUI(); break;
			default: terminate(); break;
			}
		}
		
	}
	
	private void DisplayUI()
	{
		System.out.println("\n\n\n\n");
		System.out.println("--------------------------------");
		System.out.println("Addresses Number: " + rooms.size() + '\n');
		System.out.println("--------------------------------");
		
		for (int i = 0; i < STATEAVAILABLE; i++)
		{
			System.out.println("\n" + "--------------------------------");
			SetterGetterCaller(1, i, 0);
			System.out.println("--------------------------------");
		}		
	}
	
	private void EditMenuUI()
	{	
		@SuppressWarnings("unused")
		int optionCount = 4;
		
		System.out.println("\n\n\n\n");
		System.out.println("--------------------------------");
		System.out.println("Number of Room Available: " + rooms.size() + "\n");
		System.out.println("Which Room you want to edit? \n(Enter 0 to go back)");
		int roomNo = filter.NonStaticFilterInt();
		System.out.println("--------------------------------");
		
		if (roomNo == 0) // go Back
		{
			SubMenuUI();
			return;
		}
		if (roomNo < 0 || roomNo > this.roomCount)
			terminate();
		
		roomNo--; // to match it to human conventional numbering to the computer
		while (true)
		{		
			// display before edit
			System.out.println("\n" + "--------------------------------");
			SetterGetterCaller(1, roomNo, NOTINUSE);
			System.out.println("--------------------------------");
			
			System.out.println("\n" + "--------------------------------");
			System.out.println("1. Edit Available Data of Room");
			System.out.println("2. Edit Room Type");
			System.out.println("3. Edit Room Area");
			System.out.println("4. Edit AC Type and Count");
			System.out.println("0. Back");
			int choice = filter.NonStaticFilterInt();
			System.out.println("--------------------------------");
				
			if (choice == 0)
			{
				break;
			}
			AddingInfoUI(choice, roomNo);
		}
	}
	
	private void AddingInfoUI(int state, int roomNo)
	{
		System.out.println("\n" + "-------------------------------------");
		System.out.println("Please Input the details of the Room");
		System.out.println("-------------------------------------");
		
		switch (state)
		{
		case 1:// add all data
			for (int i = 1; i < STATEAVAILABLE; i++)
			{
				SetterGetterCaller(2, roomNo, i);
			}
			break;
		case 2:// add room Type
			SetterGetterCaller(2, roomNo, 1);
			break;
		case 3:// add room Area
			SetterGetterCaller(2, roomNo, 2);
			break;
		case 4:// add AC type
			SetterGetterCaller(2, roomNo, 3);
			SetterGetterCaller(2, roomNo, 4);
			break;
		default:
			System.out.println("Error!");
			break;
		}
	}
	
	private void SetterGetterCaller(int use, int roomNo, int state)
	{
		// use 1. Get 2. Set
		
		if (use == 1)
		{
			for (int i = 1; i <= STATEAVAILABLE; i++)
			{
				WordDisplay(i);
				rooms.get(roomNo).DisplayData(i);
			}
		}
		else if (use == 2)
		{
			int w_state = state + 1; 
			WordDisplay(w_state);
			rooms.get(roomNo).SetData(state);
		}
		else
		{
			terminate();
		}
	}

	// Used for additional Infos used with the RoomInfo
	private void WordDisplay(int state)
	{
		switch (state)
		{
		case 1:
			System.out.println("Room No.:");
			break;
		case 2:
			System.out.println("Room Type:");
			break;
		case 3:
			System.out.println("Room Area:");
			break;
		case 4:
			System.out.println("Room Air Condition Type:");
			break;
		case 5:
			System.out.println("Room Air Condition Count:");
			break;
		}
	}
	
	private static void terminate()
	{
		System.out.println("Out of Scope!");
		System.exit(0);
	}
}
