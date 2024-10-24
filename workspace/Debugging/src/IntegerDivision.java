import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Simple HelloWorld program (clear of Checkstyle and SpotBugs warnings).
 *
 * @author P. Bucci
 */
public final class IntegerDivision {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private IntegerDivision() {
        // no code needed here
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments; unused here
     */
    public static void main(String[] args) {
        SimpleWriter out = new SimpleWriter1L();
        final long microsPerDay = 24 * 60 * 60 * 1000L * 1000;
        final int millisPerDay = 24 * 60 * 60 * 1000;
        out.println(microsPerDay / millisPerDay);
        out.close();
    }
}
