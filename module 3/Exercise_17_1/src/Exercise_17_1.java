import java.util.Scanner;
import java.io.*;
import java.util.Arrays;

public class Exercise_17_1 {
	public static void main(String[] args) throws IOException{
		int[] array = new int[100];
		for(int x = 0;x < array.length;x++) {
			array[x] = (int)(Math.random() * 101);
		}
		
		
		File myFile = new File("Ex17_1.txt");
		try(
		PrintWriter output = new PrintWriter(
			new BufferedOutputStream(new FileOutputStream("Ex17_1.txt", true)));
		){
			for(int x = 0;x < array.length; x++) {
			output.print(array[x] + " ");
			System.out.print(array[x] + " ");
			}
		}
		
	
	}
}
