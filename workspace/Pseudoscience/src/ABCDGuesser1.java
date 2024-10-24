import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.utilities.FormatChecker;

/**
 * This program is used to simulate the de Jager formula. [CSE 2221 - Project 3]
 *
 * @author Zheng Ni | ni.459@buckeyemail.osu.edu
 *
 */
public final class ABCDGuesser1 {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private ABCDGuesser1() {
    }

    /**
     * Repeatedly asks the user for a positive real number until the user enters
     * one. Returns the positive real number.
     *
     * @param in
     *            the input stream
     * @param out
     *            the output stream
     * @return a positive real number entered by the user
     */
    private static double getPositiveDouble(SimpleReader in, SimpleWriter out) {
        String inp = "";
        while (!(FormatChecker.canParseDouble(inp) && Double.parseDouble(inp) >= 0.0)) {
            out.print("Enter a positive real number: ");
            inp = in.nextLine();
        }
        return Double.parseDouble(inp);
    }

    /**
     * Repeatedly asks the user for a positive real number not equal to 1.0
     * until the user enters one. Returns the positive real number.
     *
     * @param in
     *            the input stream
     * @param out
     *            the output stream
     * @return a positive real number not equal to 1.0 entered by the user
     */
    private static double getPositiveDoubleNotOne(SimpleReader in, SimpleWriter out) {
        String inp = "";
        while (!(FormatChecker.canParseDouble(inp) && Double.parseDouble(inp) != 1.0
                && Double.parseDouble(inp) >= 0.0)) {
            out.print("Enter a positive real number not equal to 1.0: ");
            inp = in.nextLine();
        }
        return Double.parseDouble(inp);
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();

        double mu;
        double w, x, y, z;
        final double[] set = { -5, -4, -3, -2, -1, -1 / 2.0, -1 / 3.0, -1 / 4.0, 0,
                1 / 4.0, 1 / 3.0, 1 / 2.0, 1, 2, 3, 4, 5 };
        // Initialize the a, b, c, d set.
        final int percentageCalculateParam = 100;
        final double acceptableRelativeError = 0.01;

        out.print("Enter your favorite number - ");
        mu = getPositiveDouble(in, out);

        out.print("Enter the value of w: ");
        w = getPositiveDoubleNotOne(in, out);

        out.print("Enter the value of x: ");
        x = getPositiveDoubleNotOne(in, out);

        out.print("Enter the value of y: ");
        y = getPositiveDoubleNotOne(in, out);

        out.print("Enter the value of z: ");
        z = getPositiveDoubleNotOne(in, out);

        double minDiff, diff;
        minDiff = Math.abs(Math.pow(w, set[0]) * Math.pow(x, set[0]) * Math.pow(y, set[0])
                * Math.pow(z, set[0]) - mu); // Initialize the minimum difference value.
        double minA = set[0], minB = set[0], minC = set[0], minD = set[0],
                minResult = Math.pow(w, set[0]) * Math.pow(x, set[0])
                        * Math.pow(y, set[0]) * Math.pow(z, set[0]);
        // The minimum values are all set to the value when a, b, c, d are -5 (set[0]),
        // this can avoid the situation that there are no outputs available.
        int aLoopCount = 0, bLoopCount = 0, cLoopCount = 0, dLoopCount = 0; //
        double a, b, c, d;
        // These are the temporary variables that will be assigned to different
        // values in each loop.

        while (aLoopCount < set.length) {
            while (bLoopCount < set.length) {
                while (cLoopCount < set.length) {
                    while (dLoopCount < set.length) {
                        a = set[aLoopCount];
                        b = set[bLoopCount];
                        c = set[cLoopCount];
                        d = set[dLoopCount];
                        diff = Math.abs(Math.pow(w, a) * Math.pow(x, b) * Math.pow(y, c)
                                * Math.pow(z, d) - mu);
                        // The difference is converted to absolute value,
                        // which makes it convenient to compare.
                        if (diff < minDiff) {
                            minResult = Math.pow(w, a) * Math.pow(x, b) * Math.pow(y, c)
                                    * Math.pow(z, d);
                            minDiff = diff;
                            minA = a;
                            minB = b;
                            minC = c;
                            minD = d;
                            // The corresponding difference value, a, b, c, d
                        }
                        dLoopCount++;
                    }
                    cLoopCount++;
                    dLoopCount = 0;
                    // l begins another loop from 0 to 16.
                    // In a while loop, the value needs to be manually reset.
                }
                bLoopCount++;
                cLoopCount = 0;
                // Same as above.
            }
            aLoopCount++;
            bLoopCount = 0;
            // Same as above.
        }

        if (minDiff / mu > acceptableRelativeError) {
            out.println("The minimum relative error for these four constants is greater "
                    + "than 1%. You have successfully disproven the de Jager formula.");
            out.println(
                    "The minimum relative error for these constants is listed below:");
        } // Will notify user if user disproves the formula

        out.println("The values of a, b, c, d: a = " + minA + ", b = " + minB + ", c = "
                + minC + ", d = " + minD);
        out.print("The result of the formula w^a*x^b*y^c*z^d: ");
        out.println(minResult, 0, false);
        out.print("The relative error: ");
        out.print(minDiff * percentageCalculateParam / mu, 2, false);
        out.println("%");
        // To calculate a percentage number x, x * 100 / total

        in.close();
        out.close();
    }
} //
