import java.util.Scanner;

public class RealEstateCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter area (in square meters): ");
        double area = scanner.nextDouble();

        System.out.print("Enter down payment (in Pesos): ");
        double downPayment = scanner.nextDouble();

        System.out.print("Enter years to pay: ");
        int yearsToPay = scanner.nextInt();

        // Calculate and print unit information
        String unitInfo = calculateUnitInformation(area);

        // Calculate and print down payment information
        String downPaymentInfo = calculateDownPaymentInformation(area, downPayment);

        // Calculate and print interest information
        String interestInfo = calculateInterestInformation(area, yearsToPay);

        // Print the output table
        printOutputTable(unitInfo, downPaymentInfo, interestInfo);

        scanner.close();
    }

    public static String calculateUnitInformation(double area) {
        double pricePerSquareMeter = 0;
        String unitType = "";

        if (area < 28.5) {
            return "Area is below 28.5 sqm, no unit available.";
        } else if (area < 52.0) {
            unitType = "Studio Type";
            pricePerSquareMeter = 892.00;
        } else if (area < 86.5) {
            unitType = "2 Bedroom";
            pricePerSquareMeter = 807.00;
        } else {
            unitType = "3 Bedroom";
            pricePerSquareMeter = 380.00;
        }

        double totalPrice = area * pricePerSquareMeter;

        return String.format("Unit Type: %s\nPrice per Square Meter: $%.2f/sqm\nTotal Unit Price: $%.2f", unitType, pricePerSquareMeter, totalPrice);
    }

    public static String calculateDownPaymentInformation(double area, double downPayment) {
        double discountPercentage = 0;
        double discountAmount = 0;
        double pricePerSquareMeter = 0; // Define pricePerSquareMeter here

        if (area < 28.5) {
            return "Area is below 28.5 sqm, no unit available.";
        } else if (area < 52.0) {
            pricePerSquareMeter = 892.00;
        } else if (area < 86.5) {
            pricePerSquareMeter = 807.00;
        } else {
            pricePerSquareMeter = 380.00;
        }

        double totalPrice = area * pricePerSquareMeter;

        if (downPayment < 0.20 * totalPrice) {
            discountPercentage = 0;
        } else if (downPayment < 0.30 * totalPrice) {
            discountPercentage = 0.03;
        } else if (downPayment < 0.40 * totalPrice) {
            discountPercentage = 0.04;
        } else {
            discountPercentage = 0.05;
        }

        discountAmount = discountPercentage * totalPrice;

        return String.format("Down Payment in Percentage: %.2f%%\nDiscount: %.2f%%\nDiscount Amount: $%.2f", (discountPercentage * 100), (discountPercentage * 100), discountAmount);
    }

    public static String calculateInterestInformation(double area, int yearsToPay) {
        double interestRate = 0;
        double pricePerSquareMeter = 0; // Define pricePerSquareMeter here

        if (area < 28.5) {
            return "Area is below 28.5 sqm, no unit available.";
        } else if (area < 52.0) {
            pricePerSquareMeter = 892.00;
        } else if (area < 86.5) {
            pricePerSquareMeter = 807.00;
        } else {
            pricePerSquareMeter = 380.00;
        }

        if (yearsToPay == 5) {
            interestRate = 0.04;
        } else if (yearsToPay == 10) {
            interestRate = 0.06;
        } else if (yearsToPay == 15) {
            interestRate = 0.08;
        } else if (yearsToPay == 20) {
            interestRate = 0.10;
        } else {
            return "Invalid number of years to pay.";
        }

        double interestAmount = area * pricePerSquareMeter * interestRate;
        double contractPrice = (area * pricePerSquareMeter) + interestAmount;
        double monthlyAmortization = contractPrice / (yearsToPay * 12);

        return String.format("Interest: %.2f%%\nInterest Amount: $%.2f\nContract Price: $%.2f\nMonthly Amortization: $%.2f", (interestRate * 100), interestAmount, contractPrice, monthlyAmortization);
    }

    public static void printOutputTable(String unitInfo, String downPaymentInfo, String interestInfo) {
        System.out.println("\nOutput Table:");
        System.out.printf("| %-40s | %-40s | %-40s |\n", "Unit Information", "Down Payment Information", "Interest Information");
        System.out.printf("| %-40s | %-40s | %-40s |\n", unitInfo, downPaymentInfo, interestInfo);
    }
}
