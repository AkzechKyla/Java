import java.util.Scanner;

public class Receipt {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("MATERIALS");
		System.out.println("-------------");
		System.out.println("Enter the cost of the following: ");
		System.out.print("Paper	:	");
		double paperPrice = scan.nextDouble();
		
		System.out.print("\nPencil	:	");
		double pencilPrice = scan.nextDouble();
		
		System.out.print("\nScissors:	");
		double scissorsPrice = scan.nextDouble();
		
		System.out.print("\nEraser	:	");
		double eraserPrice = scan.nextDouble();
		
		System.out.println(paperPrice);
		System.out.println(pencilPrice);
		System.out.println(scissorsPrice);
		System.out.println(eraserPrice);
		
		System.out.println("\nPURCHASE");
		System.out.println("-------------");
		System.out.println("How many items of the following did you buy?");
		System.out.print("Paper	:	");
		int paperQuantity = scan.nextInt();
		
		System.out.print("\nPencil	:	");
		int pencilQuantity = scan.nextInt();
		
		System.out.print("\nScissors:	");
		int scissorsQuantity = scan.nextInt();
		
		System.out.print("\nEraser	:	");
		int eraserQuantity = scan.nextInt();
		
		double price = (paperPrice * paperQuantity) + (pencilPrice * pencilQuantity) +
			(scissorsPrice * scissorsQuantity) + (eraserPrice * eraserQuantity);
		
		System.out.printf("\n\nTHE TOTAL PRICE IS P %.2f", price);
		
		System.out.print("\nEnter Cash	: P ");
		double cash = scan.nextDouble();
	}
}
