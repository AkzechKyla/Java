/**
 * LABORATORY EXERCISE #3.a
 * Write a Java program that prints...:
 * The value of A is 2 while B is 4
 * Letter c
 * Initial value of Sagot is true
 * Pi contains the value of 3.14
 * Sagot is now false
 * **for the last line of output, determine if A is greater than B
 */

public class TestVariables {
	public static void main(String[] args) {
		boolean Sagot = true;
		int A = 2, B = 4;
		char Letter = 'c';
		double Pi = 3.14;
		
		System.out.println("The value of A is " + A + " while B is " + B);
		System.out.println("Letter " + Letter);
		System.out.println("Inital value of Sagot is " + Sagot);
		System.out.println("Pi contains the value " + Pi);
		
		Sagot = false;
		
		System.out.println("Sagot is now " + Sagot);
		
		boolean compareValues = A > B;
		
		System.out.println("Is A greater than B? " + compareValues);
		
		
	}
}
