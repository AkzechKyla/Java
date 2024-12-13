/**
 * LABORATORY EXERCISE #4
 * Write a program that inputs the hourly rate and number of hours worked. 
 * Compute and display the gross pay (hourly rate * hours worked), 
 * your withholding tax, which is 15% of your gross pay 
 * and your net pay (gross pay – withholding tax). 
 * Sample output : 
 * Hourly rate : 104.65
 * Hours worked : 22
 * Gross pay : 2302.3
 * Withholding tax : 345.345
 * Net pay : 1956.955
 */

import java.util.Scanner;


public class TaxPay {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\tPAYCHECK CALCULATOR\n");
		
		System.out.print("How much is your hourly rate?\n>>> ");
		double hourlyRate = sc.nextDouble();
		System.out.print("How many hours do you work?\n>>> ");
		int hoursWorked = sc.nextInt();
		
		double grossPay = hourlyRate * hoursWorked;
		double withholdTax = grossPay * 0.15;
		double netPay = grossPay - withholdTax;
		
		// Outputs
		System.out.println("\nHourly rate : " + hourlyRate);
		System.out.println("Hours worked : " + hoursWorked);
		System.out.println("Gross pay : " + grossPay);
		System.out.println("Withholding tax : " + withholdTax);
		System.out.printf("Net pay : %.3f", netPay);

	}
}
