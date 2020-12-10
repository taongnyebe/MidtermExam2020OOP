import java.util.Scanner;

public class RoomInfo {
	private int roomNo;
	private String roomType;
	private String roomArea;
	private String aCMachineType;
	private int aCMachineCount;
	
	Filters filters = new Filters();
	Scanner input = new Scanner(System.in);
	
	public RoomInfo(int roomNo, String roomType, String roomArea, String aCMachineType, int aCMachineCount)
	{
		this.roomNo = roomNo;
		this.roomType = roomType;
		this.roomArea = roomArea;
		this.aCMachineType = aCMachineType;
		this.aCMachineCount = aCMachineCount;
		
	}
	
	public void SetData(int state)
	{
		
		switch (state)
		{
		case 1:
			setRoomType(input.nextLine());
			break;
		case 2:
			setRoomArea (input.nextLine());
			break;
		case 3:
			setACMachineType (input.nextLine());
			break;
		case 4:
			SetACMachineCount(Filters.FilterInt());
			break;
		}
		
	}
	
	// this is better if it will adjust based on what will be returned
	void DisplayData(int state)
	{
		 switch (state)
		 {
		 case 1:
			 System.out.println(this.roomNo);
			 break;
		 case 2:
			 System.out.println(this.roomType);
			 break;
		 case 3:
			 System.out.println(this.roomArea);
			 break;
		 case 4:
			 System.out.println(this.aCMachineType);
			 break;
		 case 5:
			 System.out.println(this.aCMachineCount);
		 }
	}
	
	private void setRoomType(String roomType)
	{
		this.roomType = roomType;
	}
	
	private void setRoomArea(String roomArea)
	{
		this.roomArea = roomArea;
	}
	
	private void setACMachineType(String aCMachineType)
	{
		this.aCMachineType = aCMachineType;
	}
	
	private void SetACMachineCount(int aCMachineCount)
	{
		this.aCMachineCount = aCMachineCount;
	}
}
