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
public final class CoinChange2 {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private CoinChange2() {
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
        final String[] name = { "Dollar", "half-dollar", "quarter", "dime", "nickel",
                "penny" };
        final int[] coin = { 100, 50, 25, 10, 5, 1 };
        int[] amount = new int[coin.length];
        int num;
        num = in.nextInteger();
        for (int i = 0; i < coin.length; i++) {
            amount[i] = num / coin[i];
            num = num - amount[i] * coin[i];
            out.print(name[i] + ": " + amount[i] + "; ");
        }
        in.close();
        out.close();
    }

}
