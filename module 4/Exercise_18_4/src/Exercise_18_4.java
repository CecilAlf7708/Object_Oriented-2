import java.util.Scanner;

public class Exercise_18_4 {
	public static void main(String[] args) {
		Scanner input =  new Scanner(System.in);
		System.out.print("Please enter a String: ");
		String s = input.nextLine();
		reverseDisplay(s);
	}
	
	public static void reverseDisplay(String s) {
		
		if(s.length() > 0) {
			System.out.print(s.charAt(s.length() - 1));
			reverseDisplay(s.substring(0, s.length() - 1));
		}
	}
}
