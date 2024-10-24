import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * This is a Java program that repeatedly asks the user whether they wish to
 * calculate a square root. The method used to calculate the square root is
 * Newton Iteration. Comparing to the previous 3 programs, Newton4 repeats
 * asking the user for a number to enter, and quits when user inputs a negative
 * number.
 *
 * @author Zheng Ni
 *
 */
public final class Newton4 {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private Newton4() {
    }

    /**
     * Computes estimate of square root of x to within relative error 0.01%.
     *
     * @param x
     *            positive number to compute square root of
     * @param epsilon
     *            the relative error value epsilon, used to satisfy the error
     *            range requirement
     * @return estimate of square root
     */
    private static double sqrt(double x, double epsilon) {
        double r;
        if (x == 0) {
            r = 0.0;
        } else {
            r = x;
            while (Math.abs(r * r - x) / x >= epsilon * epsilon) {
                // Continue updating r until the relative error
                // of the guess r is less than epsilon
                r = (r + x / r) / 2; // This is the process of a Newton Iteration
            }
        }
        return r;
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments; unused here
     */
    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();
        double num = 0;
        out.print("Please input the value of the relative error value epsilon: ");
        double eps = in.nextDouble();

        while (num >= 0) {
            out.print("Please input a number to calculate the square root of it: ");
            num = in.nextDouble();
            out.println("The square root of " + num + " using Newton Iteration is: "
                    + sqrt(num, eps));
        }

        in.close();
        out.close();
    }

}
