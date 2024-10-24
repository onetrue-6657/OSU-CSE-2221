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
     * integer.
     *
     * @param n
     *            the starting integer
     * @param out
     *            the output stream
     */
    private static void generateSeries(int n, SimpleWriter out) {
        int len = 1;
        out.print(n + ", ");
        while (n != 1) {
            if (n % 2 == 0) {
                n = n / 2;
                len++;
                out.print(n);
                if (n != 1) {
                    out.print(", ");
                }
            } else {
                n = 3 * n + 1;
                out.print(n);
                len++;
                if (n != 1) {
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
        int x;
        x = in.nextInteger();
        generateSeries(x, out);
        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
