import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * 
 * This program uses recursion to calculate the Catalan number for a number entered by the user
 * 
 * @author Adam Fischer
 * @version 11/4/19
 * 
 * 
 * CS 215 Programming Project 3
 * Fall 2019
 * 
 */

public class CatalanRecursive {
	
	public static double n;
	public static double r;
	public static double nFact =1;//				the factorial for the number entered by the user
	public static double n2Fact=1;//				the factorial for n*2
	public static double nPlus1Fact=1;//			the factorial for n+1
	public static double time, endTime, startTime;//keeps track of the time the program takes
	public static String output;
	
	/**
	 * 
	 * @param n - the number entered by the user
	 * @return - the factorial for n
	 */
	public static double recursiveN(double n) {
		
		if(n<=1) {
			return nFact;
		}
		else {
			nFact*=n;
			recursiveN(n-1);
		}
		
		return nFact;
		
	}// end recursiveN
	
	/**
	 * 
	 * @param n - the number entered by the user *2
	 * @return - the factorial for 2n
	 */
	public static double recursive2N(double n) {
		
		if(n<=1) {
			return n2Fact;
		}
		else {
			n2Fact*=n;
			recursive2N(n-1);
		}
		
		return n2Fact;
		
	}// end recursiveN

	/**
	 * 
	 * @param n - the number entered by the user + 1
	 * @return - the factorial for n + 1
	 */
	public static double recursiveNPlus1(double n) {
	
		if(n<=1) {
			return nPlus1Fact;
		}
		else {
			nPlus1Fact*=n;
			recursiveNPlus1(n-1);
		}
		
		return nPlus1Fact;
	
	}// end recursiveN

	public static void main(String[] args) throws IOException {
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter N: ");
		n=input.nextInt();
		
		startTime = System.currentTimeMillis();
		
		
		r = recursive2N(2*n) / (recursiveN(n) * recursiveNPlus1(n+1));
		
		
				
		endTime = System.currentTimeMillis();
		
		time = (startTime-endTime)*1000000;
		
		if(time<1)
			time=1;

		System.out.print("C("+String.format("%.0f", n)+") = "+String.format("%.0f", r));
		
		output=String.format("%.0f", n)+", "+String.format("%.0f", r)+", "+time+" seconds.";
		
		FileWriter fileWriter = new FileWriter("CatalanRecursiveResults.txt");
		PrintWriter printWriter = new PrintWriter(fileWriter);
		printWriter.print(output);
		printWriter.close();

	}// end main

}// end class Catalan Recursive
