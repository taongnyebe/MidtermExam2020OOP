import java.util.Scanner;

public class AddressBookEntry {
	private String name;
	private String address;
	private String telNo;
	private String email;
	private int listNo;
	
	private Scanner input = new Scanner(System.in);
	
	public AddressBookEntry(int listNo, String name, String address, String telNo, String email)
	{
		this.listNo = listNo;
		this.name = name;
		this.address = address;
		this.telNo  = telNo;
		this.email = email;
	}
	
	public void SetData(int state)
	{
		switch(state)
		{
		case 1:
			setName(input.nextLine());
			break;
		case 2:
			setAddress(input.nextLine());
			break;
		case 3:
			setTelNo(input.nextLine());
			break;
		case 4:
			setEmail(input.nextLine());
			break;
		}
		
	}
	
	public void DisplayData(int state)
	{
		switch (state)
		{
		case 1:
			System.out.println(this.listNo);
			break;
		case 2:
			System.out.println(this.name);
			break;
		case 3:
			System.out.println(this.address);
			break;
		case 4:
			System.out.println(this.telNo);
			break;
		case 5:
			System.out.println(this.email);
			break;
		}
	}
	
	private void setName(String name)
	{
		this.name = name;
	}
	
	private void setAddress(String address)
	{
		this.address = address;
	}
	
	private void setTelNo(String telNo)
	{
		if (telNo.length() == 11)
			this.telNo = telNo;
		else 
			this.telNo = "Invalid";
	}
	
	private void setEmail(String email)
	{
		if (email.contains(".edu"))
			this.email = email;
		else 
			this.telNo = "Invalid";
	}
}
