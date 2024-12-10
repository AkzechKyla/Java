import java.util.Scanner;

public class ProgTask1 {

	public static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.print("Enter area: ");
		double area = scanner.nextDouble();

		System.out.print("Enter down payment: ");
		double downPayment = scanner.nextDouble();
		
		System.out.print("Enter number of years to pay: ");
		int yearsToPay = scanner.nextInt();

		// Get Area Information
		String unitType = getUnitTypeInfo(area);
		double pricePerSquareMeter = getPricePerSquareMeter(area);
		double totalUnitPrice = calculateTotalUnitPrice(area, pricePerSquareMeter);

		// Display Area Information
		System.out.println("\nAREA (in square meters)");
		System.out.println("Unit Type: " + unitType);
		System.out.println("Price per Square Meter: " + pricePerSquareMeter);
		System.out.println("Total Unit Price: " + totalUnitPrice);

		// Get Downpayment Amount Information
		double downPaymentPercentage = calculateDownPaymentPercentage(downPayment, totalUnitPrice);
		double amountBalance = calculateBalance(totalUnitPrice, downPayment);
		double discountPercentage = calculateDiscountPercentage(downPaymentPercentage);
		double lessDiscountAmount = calculateLessDiscountAmount(amountBalance, discountPercentage);

		// Display Downpayment Amount Information
		System.out.println("\nDownpayment Amount");
		System.out.println("Downpayment in Percentage: " + downPaymentPercentage);
		System.out.println("Balance: " + amountBalance);
		System.out.println("Discount: " + discountPercentage);
		System.out.println("Less Discount Amount: " + lessDiscountAmount);
		
		// Get Years to Pay Information
		double interestPercentage = getInterestPercentage(yearsToPay);
		double interestAmount = getInterestAmount(amountBalance, lessDiscountAmount, interestPercentage);
		double contractPrice = getContractPrice(amountBalance, lessDiscountAmount, interestAmount);
		double monthlyAmortization = getMonthlyAmortization(contractPrice, yearsToPay);

		// Display Years to Pay Information
		System.out.println("\nYears to Pay");
		System.out.println("Interest (applied to Balance Less Discount): " + interestPercentage);
		System.out.println("Interest Amount: " + interestAmount);
		System.out.println("Contract Price: " + contractPrice);
		System.out.println("Monthly Amortization: " + monthlyAmortization);
	}

	public static String getUnitTypeInfo(double area) {
		String unitType = "";

		if (area >= 28.5 && area < 52) {
			unitType = "Studio Type";
		} else if (area >= 52.0 && area < 86.5) {
			unitType = "2 Bedroom";
		} else if (area >= 86.5) {
			unitType = "3 Bedroom";
		}

		return unitType;
	}

	public static double getPricePerSquareMeter(double area) {
		double pricePerSquareMeter = 0;

		if (area >= 28.5 && area < 52) {
			pricePerSquareMeter = 65892.00;
		} else if (area >= 52.0 && area < 86.5) {
			pricePerSquareMeter = 58807.00;
		} else if (area >= 86.5) {
			pricePerSquareMeter = 53380.00;
		}

		return pricePerSquareMeter;
	}

	public static double calculateTotalUnitPrice(double area, double pricePerSquareMeter) {
		double totalUnitPrice = area * pricePerSquareMeter;
		return totalUnitPrice;
	}

	public static double calculateDownPaymentPercentage(double downPayment, double totalUnitPrice) {
		double downPaymentPercentage = (downPayment / totalUnitPrice) * 100;
		return downPaymentPercentage;
	}

	public static double calculateDiscountPercentage(double downPaymentPercentage) {
		/* if "down payment" < 20%:
			No discount
		if "down payment" >= 20% && < 30%:
			3% discount
		if "down payment" >= 30% && < 40%:
			4% discount
		if "down payment" >= 40%:
			5% discount */
		double discountPercentage = 0;

		if (downPaymentPercentage < 20) {
			discountPercentage = 0;
		} else if (downPaymentPercentage >= 20 && downPaymentPercentage < 30) {
			discountPercentage = 0.03;
		} else if (downPaymentPercentage >= 30 && downPaymentPercentage < 40) {
			discountPercentage = 0.04;
		} else if (downPaymentPercentage >= 40) {
			discountPercentage = 0.05;
		}

		return discountPercentage;
	}
	
	public static double calculateBalance(double totalUnitPrice, double downPayment) {
		double amountBalance = totalUnitPrice - downPayment;
		return amountBalance;
	}
	
	public static double calculateLessDiscountAmount(double amountBalance, double discountPercentage) {
		double lessDiscountAmount = amountBalance * discountPercentage;
		return lessDiscountAmount;
	}
	
	public static double getInterestPercentage(int yearsToPay) {
		double interestPercentage = 0;

		if (yearsToPay == 5) {
			interestPercentage = 0.04;
		} else if (yearsToPay == 10) {
			interestPercentage = 0.06;
		} else if (yearsToPay == 15) {
			interestPercentage = 0.08;
		} else if (yearsToPay == 20) {
			interestPercentage = 0.1;
		}

		return interestPercentage;
	}
	
	public static double getInterestAmount(double amountBalance, double lessDiscountAmount, double interestPercentage) {
		double interestAmount = (amountBalance - lessDiscountAmount) * interestPercentage;
		return interestAmount;
	}
	
	public static double getContractPrice(double amountBalance, double lessDiscountAmount, double interestAmount) {
		double contractPrice = amountBalance - lessDiscountAmount + interestAmount;
		return contractPrice;
	}
	
	public static double getMonthlyAmortization(double contractPrice, int yearsToPay) {
		double monthlyAmortization = contractPrice / (yearsToPay * 12);
		return monthlyAmortization;
	}

}
