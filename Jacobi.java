import java.util.Arrays;

public class Jacobi {
    public static void main(String[] args) {
        double a11 = 4.0, a12 = 2.0, a13 = 1.0;
        double a21 = 1.0, a22 = 5.0, a23 = 2.0;
        double a31 = 2.0, a32 = 1.0, a33 = 7.0;
        double b1 = 4.0, b2 = 10.0, b3 = 14.0;

        double[] result = jacobiMethod(a11, a12, a13, b1, a21, a22, a23, b2, a31, a32, a33, b3, 0.000000000000001, 1000);

        System.out.println("\nJacobi: \n[" + result[0] + ", " + result[1] + ", " + result[2] + "]");
        System.out.println("\nIterations: " + (int) result[3]);
        System.out.println("\nError: " + result[4]);
    }

    public static double[] jacobiMethod(double a11, double a12, double a13, double b1,
                                        double a21, double a22, double a23, double b2,
                                        double a31, double a32, double a33, double b3,
                                        double tolerance, int maxIterations) {
        double x = 0, y = 0, z = 0;
        double error = 1.0;
        int iterations = 0;

        while (error > tolerance && iterations < maxIterations) {
            double newX = (b1 - ((a12 * y) + (a13 * z))) / a11;
            double newY = (b2 - ((a21 * x) + (a23 * z))) / a22;
            double newZ = (b3 - ((a31 * x) + (a33 * y))) / a33;

            double[] errors = {0, 0, 0};
            double errorX = Math.abs((newX - x) / newX);
            double errorY = Math.abs((newY - y) / newY);
            double errorZ = Math.abs((newZ - z) / newZ);

            error = (errorX + errorY + errorZ) / 3.0;
            x = newX; y = newY; z = newZ;
            iterations++;
        }
        return new double[]{x, y, z, iterations, error};
    }
}
