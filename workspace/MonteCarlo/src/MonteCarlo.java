import components.random.Random;
import components.random.Random1L;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Monte Carlo Estimate: compute percentage of pseudo-random points in [0.0,1.0)
 * interval that fall in the left half subinterval [0.0,0.5).
 */
public final class MonteCarlo {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private MonteCarlo() {
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments; unused here
     */
    public static void main(String[] args) {
        SimpleReader input = new SimpleReader1L();
        SimpleWriter output = new SimpleWriter1L();

        output.print("Number of points: ");
        int n = input.nextInteger();
        int ptsInInterval = 0, ptsInSubinterval = 0;
        Random rnd = new Random1L();
        final double rootParameter = 0.5;

        while (ptsInInterval < n) {
            double x = 2.0 * rnd.nextDouble();
            double y = 2.0 * rnd.nextDouble();
            ptsInInterval++;
            if (Math.pow(((x - 1.0) * (x - 1.0) + (y - 1.0) * (y - 1.0)),
                    rootParameter) <= 1.0) {
                ptsInSubinterval++;
            }
        }

        final double percentParameter = 100.0;
        double estimate = (percentParameter * ptsInSubinterval) / ptsInInterval;
        output.println("Estimate of percentage: " + estimate + "%");

        input.close();
        output.close();
    }

}
