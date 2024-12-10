import java.util.Scanner;

public class Practice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a positive integer: ");
        int number = scanner.nextInt();

        System.out.println("Prime factorization of " + number + ":");
        primeFactorization(number);
    }

    public static void primeFactorization(int num) {
        if (num < 2) {
            System.out.println("Prime factorization is not defined for numbers less than 2.");
            return;
        }

        for (int i = 2; i <= num; i++) {
            while (num % i == 0) {
                System.out.print(i + " ");
                num /= i;
            }
        }
    }
}
