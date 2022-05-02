import java.util.*;

class Year{
	String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
	
	public void PrintMonth (int monthNumber) {
		try{
			System.out.println ("Your month is: " + months[monthNumber - 1]);
		}
		catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("This month doesn't exist. Please type 1-12 number");
		}
	}
}

public class Month {
	public static void main (String[] args) {
		Year num = new Year();
		Scanner scanner = new Scanner(System.in);
		System.out.println ("Enter the number of the month: ");
		int monthNumber = scanner.nextInt();
		num.PrintMonth(monthNumber);
	}
}
