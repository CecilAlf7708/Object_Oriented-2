import java.util.Scanner;
import java.io.*;
import java.util.Arrays;
import java.util.InputMismatchException;

public class Exercise_17_3 {
	public static void main(String[] args) throws IOException{
		outputStream();
		inputStream();
	
	}
	public static void outputStream() throws IOException {
		
		try(
		DataOutputStream output = new DataOutputStream(new FileOutputStream("Ex17_3.dat", true));
				
		){
			for(int i = 0; i < 100; i++) {
				int y = (int)(Math.random() * 101);
				output.writeInt(y);
				System.out.print(y + " ");
			}
		}
			catch(IOException ex) {
			System.out.println("File couldn't be opened.");
			}
	}
	
	public static void inputStream() throws IOException {
		int sum = 0;
		try(
				DataInputStream input = new DataInputStream(new FileInputStream("Ex17_3.dat"));
						
			){
			while(true) {
				sum += input.readInt();
			}
		}
		catch(EOFException ex) {
			System.out.print("\nSum is: " + sum);
		}
	}
}
