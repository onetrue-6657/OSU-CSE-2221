import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * This is a Java program that repeatedly asks the user whether they wish to
 * calculate a square root. The method used to calculate the square root is
 * Newton Iteration. Comparing to Newton1, it now solves the problem of user
 * inputing a 0.
 *
 * @author Zheng Ni
 *
 */
public final class Newton2 {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private Newton2() {
    }

    /**
     * Computes estimate of square root of x to within relative error 0.01%.
     *
     * @param x
     *            positive number to compute square root of
     * @return estimate of square root
     */
    private static double sqrt(double x) {
        double r;
        final double epsilon = 0.0001;
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
        String inp = "y";

        while (inp.equals("y")) {
            out.print("Please input a number to calculate the square root of it: ");
            double num = in.nextDouble();
            if (num >= 0) {
                out.println("The square root of " + num + " using Newton Iteration is: "
                        + sqrt(num));
                out.print("Do you want to continue? ");
                inp = in.nextLine();
            } else {
                out.print("Negative numbers do not have a square root, "
                        + "Do you want to try again? ");
                inp = in.nextLine();
            }
        }

        in.close();
        out.close();
    }

}
