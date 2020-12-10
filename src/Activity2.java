import java.util.LinkedList;
import java.util.Scanner;

public class Activity2 {

	private final int STATEAVAILABLE = 5; // this is the equivalent value able to modify in the RoomInfo Class
	private final int NOTINUSE = 0; // this is used to indicate that it was not used
	
	private static Filters filter = new Filters();
	private Scanner input = new Scanner(System.in);
	private static AddressBookEntry list;
	private LinkedList<AddressBookEntry> bookSlot = new LinkedList<AddressBookEntry>();
	
	public void SubMenuUI()
	{
		boolean back = false;
		while(!back)
		{
			System.out.println("\n\n\n\n");
			System.out.println("--------------------------------");
			System.out.println("Activty 2: Address Book Entry");
			System.out.println("--------------------------------");
			
			System.out.println('\n' + "--------------------------------");
			System.out.println("1. Check List of Addresses");
			System.out.println("2. Add Address in List");
			System.out.println("3. Edit Address in List");
			System.out.println("4. Delete Address in List");
			System.out.println("0. Exit");
			int choice = filter.NonStaticFilterInt();
			System.out.println("--------------------------------");
			
			switch (choice)
			{
			case 0: back = true; break;
			case 1:	DisplayUI(); break;
			case 2: AddUI(); break;
			case 3: EditUI(); break;
			case 4: DeleteUI(); break;
			default: terminate(); break;
				
			}
		}
	}
	
	private void DisplayUI()
	{
		if (bookSlot.size() == 0) 
		{
			System.out.println("\n" + "--------------------------------");
			System.out.println("The List is currently Empty!");
			System.out.println("Please add before checking");
			System.out.println("--------------------------------");
		}
		else
		{
		for (int i = 0; i < bookSlot.size(); i++)
			{
				System.out.println("\n" + "--------------------------------");
				SetterGetterCaller(1, i, 0);
				System.out.println("--------------------------------");
			}
		}
	}
	
	private void AddUI() 
	{
		int number = (bookSlot.size()) + 1;
		
		list = new AddressBookEntry(number, "Unknown", "Unknown", "Unknown", "Unknown"); // this will clear the slot and only set the number
		bookSlot.add(list);
		
		int slot = bookSlot.size() - 1;
		while (true)
		{
			System.out.println("\n" + "--------------------------------");
			AddingInfoUI(1, slot);
			System.out.println("--------------------------------");
			
			System.out.println("\n" + "--------------------------------"); // this will be displayed to be checked
			SetterGetterCaller(1, slot, NOTINUSE);
			System.out.println("--------------------------------");
			
			System.out.println("Confirm? [y/n]"); // if everything is good then it will end
			if (input.hasNext("y") || input.hasNext("Y"))
			{
				@SuppressWarnings("unused")
				String a = input.next();
				break;
			}
			
			
		}
	}

	private void EditUI()
	{
		System.out.println("\n" + "--------------------------------");
		System.out.println("Addresses Number: " + bookSlot.size() + '\n');
		System.out.println("! Enter 0 to Exit !");
		System.out.println("Enter Which Number to Edit: ");
		int number = filter.NonStaticFilterInt();
		System.out.println("--------------------------------");
		
		if (number == 0)
		{
			this.SubMenuUI();
			return;
		}
		
		if (number < 0 && number > bookSlot.size())
			terminate();
		
		number--;
		while (true)
		{		
			// display before edit
			System.out.println("\n" + "--------------------------------");
			SetterGetterCaller(1, number, NOTINUSE);
			System.out.println("--------------------------------");
			
			System.out.println("\n" + "--------------------------------");
			System.out.println("1. Edit Available Data of Address");
			System.out.println("2. Edit Name");
			System.out.println("3. Edit Address");
			System.out.println("4. Edit Phone Number");
			System.out.println("5. Edit Mail Address");
			System.out.println("0. Back");
			int choice = filter.NonStaticFilterInt();
			System.out.println("--------------------------------");
				
			if (choice == 0)
			{
				SubMenuUI();
				return;
			}
			AddingInfoUI(choice, number);
		}
	}
	
	private void AddingInfoUI(int state, int roomNo)
	{
		switch (state)
		{
		case 1:
			for (int i = 1; i < STATEAVAILABLE; i++)
			{
				SetterGetterCaller(2, roomNo, i);
			}
			break;
		case 2:
			SetterGetterCaller(2, roomNo, 1);
			break;
		case 3:
			SetterGetterCaller(2, roomNo, 2);
			break;
		case 4:
			SetterGetterCaller(2, roomNo, 3);
			break;
		case 5:
			SetterGetterCaller(2, roomNo, 4);
			break;
		default:
			System.out.println("Error!");
			break;
		}
	}
	
	private void DeleteUI()
	{
		System.out.println('\n' + "--------------------------------");
		System.out.println("Addresses Number: " + bookSlot.size() + '\n');
		System.out.println("! Enter 0 to Exit !");
		System.out.println("Enter Which Number to Delete: ");
		int listNo = filter.NonStaticFilterInt();
		System.out.println("--------------------------------");
		
		if (listNo == 0)
		{
			SubMenuUI();
			return;
		}
		
		listNo--;
		System.out.println("Confirm? [y/n]"); // if everything is good then it will end
		if (input.hasNext("y") || input.hasNext("Y"))
		{
			@SuppressWarnings("unused")
			String a = input.next();
			bookSlot.remove(listNo);
			
			System.out.println( "\n\n" + "Delete Confirm!");
		}
		
		
		
	}
	
	private void SetterGetterCaller(int use, int slotNo, int state)
	{
		// use 1. Get 2. Set
		if (use == 1)
		{
			for (int i = 1; i <= STATEAVAILABLE; i++)
			{
				WordDisplay(i, false);
				bookSlot.get(slotNo).DisplayData(i);
			}
		}
		else if (use == 2)
		{
			int w_state = state + 1; 
			WordDisplay(w_state, true);
			bookSlot.get(slotNo).SetData(state);
		}
		else
		{
			terminate();
		}
	}
	
	private void WordDisplay(int state, boolean use)
	{
		switch (state)
		{
		case 1:
			System.out.println("Number: ");
			break;
		case 2:
			System.out.println("Name: ");
			break;
		case 3:
			System.out.println("Address: ");
			break;
		case 4:
			if (use) System.out.println("! Requires of 11 values !");
			System.out.println("Phone Number: ");
			break;
		case 5:
			if (use) System.out.println("! Input Mail with .edu extension !");
			System.out.println("Mail Address: ");
			break;
		}
	}
	
	private static void terminate()
	{
		System.out.println("Out of Scope!");
		System.exit(0);
	}
}
