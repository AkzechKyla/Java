/**
 * Write a program that displays the conversion of 1887 into 1000’s, 500’s, 100’s,50’s 
20’s ,10’s, 5’s and 1’s
Sample output Cash on hand : 1887
Denominations :
1000 – 1
 500 - 1
 100 - 3
 50 – 1
 20 – 1
 10 – 1
 5 - 1
 1 - 2
 */

 
//import java.util.ArrayList;
//import java.util.Arrays;


public class Denomination {
	public static void main(String[] args) {
		
		int cash = 1887;
		int[] moneyList = {1000, 500, 100, 50, 20, 10, 5, 1};
		//ArrayList<Integer> moneyList = new ArrayList<Integer>
		//(Arrays.asList(1000, 500, 100, 50, 20, 10, 5, 1));
		
		System.out.println("Cash on hand : " + cash);

		for (int i = 0; i < moneyList.length; i++) {
			int num = moneyList[i];
			System.out.println(num + " = " + cash/num);
			cash %= num;
		}
		
		// for (int i = 0; i < moneyList.size(); i++) {
		// 	int num = moneyList.get(i);
		// 	System.out.println(num + " = " + cash/num);
		// 	cash %= num;
		// }
	}
}

