public class Main {

	private static Filters filter = new Filters();
	
	public static void main(String[] args) {
		Activity1 activity1 = new Activity1(5);
		Activity2 activity2 = new Activity2();
		AddressBook activity3 = new AddressBook(100);
		
		while (true)
		{
			int choice = Menu();
			switch (choice)
			{
			case 1:
				activity1.SubMenuUI();
				break;
			case 2:
				activity2.SubMenuUI();
				break;
			case 3:
				activity3.SubMenuUI();
				break;
			case 4:
				About();
				break;
			case 0:
				System.exit(0);
				break;
			default: AddressBook.terminate(); break;
			}
		}
	}
	
	private static int Menu()
	{
		System.out.println("--------------------------------");
		System.out.println("\t Main Menu Tab");
		System.out.println("\t  - Mid Term");
		System.out.println("\t    Activity");
		System.out.println("--------------------------------");
		
		System.out.println('\n' + "--------------------------------");
		System.out.println("1. Activity 1: Room Class");
		System.out.println("2. Activity 2: Address Book Entry\n    (Experimental Extension)");
		System.out.println("3. Activity 3: Address Book");
		System.out.println("4. About");
		System.out.println("0. Exit");
		int choice = filter.NonStaticFilterInt();
		System.out.println("--------------------------------");
		
		
		return choice;
	}

	private static void About()
	{
		System.out.println("--------------------------------");
		System.out.println("\t About Tab");
		System.out.println("--------------------------------");
		
		System.out.println('\n' + "--------------------------------");
		System.out.println("Compose of 7 Java Class");
		System.out.println("- Main.java");
		System.out.println("- Filters.java");
		System.out.println("- Activity1.java");
		System.out.println("- Activity2.java");
		System.out.println("- RoomInfo");
		System.out.println("- AddressBook");
		System.out.println("- AddressBookEntry");
		System.out.println("--------------------------------");
		
		System.out.println('\n' + "--------------------------------");
		System.out.println("Created in 4 Days 08/12/2020 - 11/12/2020");
		System.out.println("Developer: Ramirez, Ian \"Zyx\"");
		System.out.println("Bachelor of Science in Computer Science");
		System.out.println("--------------------------------");
		
		System.out.println('\n' + "--------------------------------");
		System.out.println("Isabela State University - Echague, Main Campus");
		System.out.println("Object Oriented Programming in Java");
		System.out.println("Prof. Rowel Dellosa");
		System.out.println("--------------------------------");
	}
}
