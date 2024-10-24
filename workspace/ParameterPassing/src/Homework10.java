import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Simple HelloWorld program (clear of Checkstyle and SpotBugs warnings).
 *
 * @author P. Bucci
 */
public final class Homework10 {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private Homework10() {
        // no code needed here
    }

    /**
     * 1. Swaps the two given {@code NaturalNumber}s.
     *
     * @param n1
     *            the first {@code NaturalNumber}
     * @param n2
     *            the second {@code NaturalNumber}
     * @updates n1
     * @updates n2
     * @ensures n1 = #n2 and n2 = #n1
     */
    private static void swapNN(NaturalNumber n1, NaturalNumber n2) {
        NaturalNumber tmp = new NaturalNumber2(n1);
        n1.copyFrom(n2);
        n2.copyFrom(tmp);
    }

    /**
     * 2. Swaps the two given {@code NaturalNumber}s.
     *
     * @param n1
     *            the first {@code NaturalNumber}
     * @param n2
     *            the second {@code NaturalNumber}
     * @updates n1
     * @updates n2
     * @ensures n1 = #n2 and n2 = #n1
     */
    private static void swapNNTransferFrom(NaturalNumber n1, NaturalNumber n2) {
        NaturalNumber tmp = new NaturalNumber2(n1);
        n1.transferFrom(n2);
        n2.transferFrom(tmp);
    }

    /**
     * 3. Squares a given {@code NaturalNumber}.
     *
     * @param n
     *            the number to square
     * @updates n
     * @ensures n = #n * #n
     */
    private static void square(NaturalNumber n) {
        NaturalNumber tmp = new NaturalNumber2(n);
        n.multiply(tmp);
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments; unused here
     */
    public static void main(String[] args) {
        SimpleWriter out = new SimpleWriter1L();
        SimpleReader in = new SimpleReader1L();

        NaturalNumber n1 = new NaturalNumber2(5);
        NaturalNumber n2 = new NaturalNumber2(10);

//        n1.multiply(n2);
        square(n1);
        out.println(n1);

        out.close();
    }

}
