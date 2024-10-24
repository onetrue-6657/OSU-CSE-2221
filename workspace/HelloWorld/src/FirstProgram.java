import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * This is an age output code segment 2-2.
 *
 * @author idk (forced to do this for HW)
 */
public final class FirstProgram {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private FirstProgram() {

    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments; unused here
     */
    public static void main(String[] args) {
        SimpleReader input;
        SimpleWriter output;
        String yourName;
        int yourAge;
        final int ageUpperBound = 3, ageLowerBound = 0;
        input = new SimpleReader1L();
        output = new SimpleWriter1L();
        output.print("What is your name? ");
        yourName = input.nextLine();
        output.print("What is your age? ");
        yourAge = input.nextInteger();
        output.println("Hi " + yourName);
        if ((ageLowerBound <= yourAge) && (yourAge <= ageUpperBound)) {
            output.println("\"My, just " + yourAge + " years old!");
            output.println("What a cute little baby.\"");
        } else {
            output.println("\"Thanks for entering your age.\".");
        }
        input.close();
        output.close();
    }
}
