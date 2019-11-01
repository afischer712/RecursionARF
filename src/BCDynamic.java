/**
 * 
 * This program takes in two numbers from the user (n and k) and determines how many ways k subsets can
 * be taken of n through dynamics
 * 
 * @author Adam Fischer
 * @version 11/4/19
 * 
 * 
 * CS 215 Programming Project 3
 * Fall 2019
 * 
 */

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class BCDynamic {
	
	static int n;//					the number entered by the user that the subsets are taken of
	static int k;//					the number of subsets taken
	static String r;//				the number of ways to take k subsets of n
	static String output;//			the results of the program (in .txt file)
	static long time = 0;
	static long startTime, endTime;//keeps track of the time the program takes
	
	/**
	 * 
	 * @param n - the number that the subsets are taken of
	 * @param k - the number of subsets taken
	 * @param nMk - n minus k
	 * @return - the number of ways to take k subsets of n
	 */
	public static String dynamic(int n, int k, int nMk) {
		
		startTime = System.currentTimeMillis();

		double nFactorial = 1;//		the factorial for n
		double kFactorial = 1;//		the factorial for k
		double nMinusKFactorial = 1;//  the factorial for n-k
		double result=0;
		
		while(n>0) {
			nFactorial*=n;
			n--;
		}// end while for n factorial
		
		while(k>0) {
			kFactorial*=k;
			k--;
		}// end while for k factorial
		
		while(nMk>0) {
			nMinusKFactorial*=nMk;
			nMk--;
		}// end while for n-k factorial
		
		double div =  kFactorial * nMinusKFactorial;
		
		result = nFactorial / (div);
		
		endTime = System.currentTimeMillis();
		
		
		
		return String.format("%.0f", result);
	}// end dynamic

	
	
	public static void main(String[] args) throws IOException {
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter N: ");
		n=input.nextInt();
		System.out.print("Enter K: ");
		k=input.nextInt();
		
		r = dynamic(n,k, n-k);
		
		time = (startTime-endTime)*1000000;
		
		if(time<1)
			time=1;

		System.out.print("There are "  + r + " ways to choose " + k + " subsets from " + n + " items.");
		output= n+", "+k+", "+r+", "+time+" seconds";
		
		FileWriter fileWriter = new FileWriter("BCDynamicResults.txt");
		PrintWriter printWriter = new PrintWriter(fileWriter);
		printWriter.print(output);
		printWriter.close();
		
		
	}// end main
	
	
	
} // end class BCDynamic
