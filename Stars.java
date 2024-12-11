
public class Stars {
	public static void main(String[] args) {
		int size = 15;
		int odd = 1;

		for (int i = 0; i <= size/2; i++) {
			System.out.println("");
			for (int j = size/2; j > i; j--) {
				System.out.print(" ");
			}
			for (int l = 1; l <= odd; l++) {
				System.out.print("*");
			}
			odd += 2;
		}

		for (int i = 0; i <= size/2; i++) {
			odd -= 2;
			System.out.println("");
			for (int j = 1; j <= i; j++) {
				System.out.print(" ");
			}
			for (int l = 1; l <= odd; l++) {
				System.out.print("*");
			}
		}

	}
}
