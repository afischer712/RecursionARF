import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * 
 * This program takes in the numbers n and k from the user and finds how many ways k subsets can be
 * taken from n using recursive methods
 * 
 * @author Adam Fischer
 * @version 11/4/19
 * 
 * 
 * CS 215 Programming Project 3
 * Fall 2019
 * 
 */

public class BCRecursive {

	static int n;//						the number entered by the user that the subsets are taken of
	static double nFactorial=1;//		the factorial of n
	static int k;//						the number of subsets of n taken
	static double kFactorial = 1;//		the factorial of k
	static int nMinusK;//				n-k
	static double nMinusKFactorial =1;//the factorial of n-k
	static double r;//					the number of ways to take k subsets of n
	static String output;//				the results, which are put in a .txt file
	static long time = 0;
	static long startTime, endTime;//	keep track of the amount of time the program takes
	
	/**
	 * 
	 * @param number - n, the number entered by the user
	 * @return - n factorial
	 */
	public static double recursiveN(int number) {
		
		if(number<=1) {
			return nFactorial;
		}
		else {
			
			nFactorial = nFactorial * number;
			
			recursiveN(number-1);
			
		}
		
		return nFactorial;
		
	}// end recursive
	
	/**
	 * 
	 * @param number - k, which is entered by the user
	 * @return - k factorial
	 */
	public static double recursiveK(int number) {
		
		if(number<=1) {
			return kFactorial;
		}
		else {
			
			kFactorial = kFactorial * number;
			
			recursiveK(number-1);
			
		}
		
		return kFactorial;
		
	}// end recursive

	/**
	 * 
	 * @param number - n minus k
	 * @return - the factorial for n minus k
	 */
	public static double recursiveNK(int number) {
	
		if(number<=1) {
			return nMinusKFactorial;
		}
		else {
		
		nMinusKFactorial = nMinusKFactorial * number;
		
		recursiveNK(number-1);
		
		}
	
		return nMinusKFactorial;
	
	}// end recursive
	
	public static void main(String[] args) throws IOException {
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter N: ");
		n=input.nextInt();
		System.out.print("Enter K: ");
		k=input.nextInt();
		
		nMinusK = n - k;
		nMinusKFactorial = 1;
		nFactorial = 1;
		kFactorial = 1;
		
		startTime = System.currentTimeMillis();
		
		
		r = recursiveN(n) / (recursiveNK(nMinusK)*recursiveK(k));
		
		endTime = System.currentTimeMillis();
		
		time = (startTime-endTime)*1000000;
		
		if(time<1)
			time=1;

		System.out.print("There are "  + String.format("%.0f", r) + " ways to choose " + k + " subsets from " + n + " items.");
		
		output= n+", "+k+", "+String.format("%.0f", r)+", "+time+" seconds";
		
		FileWriter fileWriter = new FileWriter("BCRecursiveResults.txt");
		PrintWriter printWriter = new PrintWriter(fileWriter);
		printWriter.print(output);
		printWriter.close();

	}// end main


}// end class BCRecursive
