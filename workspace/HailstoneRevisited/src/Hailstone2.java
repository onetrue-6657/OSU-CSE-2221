import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Put a short phrase describing the program here.
 *
 * @author Put your name here
 *
 */
public final class Hailstone2 {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private Hailstone2() {
    }

    /**
     * Generates and outputs the Hailstone series starting with the given
     * {@code NaturalNumber}.
     *
     * @param n
     *            the starting natural number
     * @param out
     *            the output stream
     * @updates out.content
     * @requires n > 0 and out.is_open
     * @ensures out.content = #out.content * [the Hailstone series starting with
     *          n]
     */
    private static void generateSeries(NaturalNumber n, SimpleWriter out) {
        int len = 1;
        out.print(n + ", ");
        NaturalNumber zero = new NaturalNumber2(0);
        NaturalNumber one = new NaturalNumber2(1);
        NaturalNumber two = new NaturalNumber2(2);
        NaturalNumber three = new NaturalNumber2(3);
        while (!n.equals(one)) {
            NaturalNumber copy = new NaturalNumber2(n);
            if (copy.divide(two).equals(zero)) {
                n.divide(two);
                out.print(n);
                len++;
                if (!n.equals(one)) {
                    out.print(", ");
                }
            } else {
                n.multiply(three);
                n.add(one);
                out.print(n);
                len++;
                if (!n.equals(one)) {
                    out.print(", ");
                }
            }
        }
        out.println();
        out.println("Length: " + len);
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
        /*
         * Put your main program code here; it may call myMethod as shown
         */
        String s;
        s = in.nextLine();
        NaturalNumber x = new NaturalNumber2(s);
        generateSeries(x, out);
        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
