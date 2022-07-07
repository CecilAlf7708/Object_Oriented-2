/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.*;

public class Exercise_17_7 {
    public static void main(String[] args) throws FileNotFoundException {
        Loan loan1 = new Loan();
        Loan loan2 = new Loan(1.8, 10, 10000);
        
        try (
                ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("Ex17_7.dat"));
        ) {
            output.writeObject(loan1);
            output.writeObject(loan2);
            outputData();
        } 
        catch (IOException ex) {
            System.out.println("File could not be opened");
        }
        
    }
    
    public static void outputData() throws IOException {
    	double lTotal = 0;
    	
    	try(	 ObjectInputStream input = new ObjectInputStream(
    			new BufferedInputStream(new FileInputStream("Ex17_7.dat")));
    			
    	){
    		
    		while(true) {
    			Loan loan3 = (Loan)(input.readObject());
    			lTotal += loan3.getLoanAmount();
    		}
    	}
    	catch(EOFException ex) {
    		System.out.print("The total loan amount is " + lTotal + "\n");
    		
    	}
    	catch(Exception ex) {
    		System.out.print(ex);
    	}
    }
    
}
