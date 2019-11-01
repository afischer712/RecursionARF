import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * 
 * This program accepts a number n and determines its Catalan number dynamically
 * 
 * @author Adam Fischer
 * @version 11/4/19
 * 
 * 
 * CS 215 Programming Project 3
 * Fall 2019
 * 
 */

public class CatalanDynamic {
	
	public static double n;
	public static double nFact=1;					// the factorial for n
	public static double nPlusFact=1;				// the factorial for n+1
	public static double n2Fact=1;					// the factorial for 2*n
	public static String output;					// the string sent to the txt file with the results
	public static double time, startTime, endTime;	// keeps track of the time the program takes
	public static double r;
	
	/**
	 * 
	 * @param n - the number entered by the user
	 * @param nPlus - the number + 1
	 * @param n2 - the number * 2
	 * @return - the catalan number for n
	 */
	public static double dynamic(double n, double nPlus, double n2) {
		
		while(n>=1) {
			nFact*=n;
			n--;
		}
		
		while(n2>=1) {
			n2Fact*=n2;
			n2--;
		}
		
		while(nPlus>=1) {
			nPlusFact*=nPlus;
			nPlus--;
		}
		
		double result = n2Fact / (nPlusFact * nFact);
		
		return result;
	}// end dynamic

	public static void main(String[] args) throws IOException {

		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter N: ");
		n=input.nextInt();
		
		startTime = System.currentTimeMillis();
		
		
		r = dynamic(n,n+1,2*n);
		
				
		endTime = System.currentTimeMillis();
		
		time = (startTime-endTime)*1000000;
		
		if(time<1)
			time=1;

		System.out.print("C("+String.format("%.0f", n)+") = "+String.format("%.0f", r));
		
		output=String.format("%.0f", n)+", "+String.format("%.0f", r)+", "+time+" seconds.";
		
		FileWriter fileWriter = new FileWriter("CatalanDynamicResults.txt");
		PrintWriter printWriter = new PrintWriter(fileWriter);
		printWriter.print(output);
		printWriter.close();
		
	}// end main

}// end class Catalan Dynamic
