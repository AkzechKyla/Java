import java.util.*;

public class Sample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of an array: ");
        int n = scanner.nextInt();

        int[] unsortedNum = new int[n];
        System.out.printf("\nEnter %d numbers...\n", n);
        for (int i = 0; i < n; i++) {
            System.out.printf("\nEnter number %d: ", i + 1);
            unsortedNum[i] = scanner.nextInt();
        }

        int temp = 0;
        for (int i = 0; i <= n; i++) {
            System.out.println(unsortedNum[i]);
            if (unsortedNum[i] > unsortedNum[i + 1]) {
                unsortedNum[i] = temp;
                unsortedNum[i + 1] = unsortedNum[i];
                temp = unsortedNum[i + 1];
            }
        }

        System.out.println(unsortedNum[0]);
        System.out.println(unsortedNum[1]);
    }
}
