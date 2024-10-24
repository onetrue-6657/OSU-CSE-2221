import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.utilities.FormatChecker;

public final class Newton6 {

    private Newton6() {
    }

    private static double sqrt(double x, double epsilon, int k) {
        if (x == 0) {
            return 0.0; // I am not sure if it is the case here.
        } else {
            double r = x;
            while (Math.abs(r * r - x) / x >= epsilon * epsilon && k != 0) {
                r = (r + x / r) / 2;
                k--;
            }
            return r;
        }
    }

    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();
        boolean judge = true;
        String inp;
        out.print("Please input the value of the relative error value epsilon: ");
        String eps = in.nextLine();
        boolean eps_check = FormatChecker.canParseDouble(eps);
        double eps_double = Double.parseDouble(eps);
        if (!(eps_double >= 0.0 && eps_check)) {
            out.println("Invalid input");
            eps_check = false;
        }

        while (judge && eps_check) {
            out.print("Please input a number to calculate the square root of it: ");
            String num = in.nextLine();
            boolean num_check = FormatChecker.canParseDouble(num);
            double num_double = Double.parseDouble(num);
            if (!num_check) {
                out.println("Invalid input");
                break;
            }
            out.print("Please input the k-th root you want in the Newton iteration: ");
            int k = in.nextInteger();
            out.println("The " + k + "th root of " + num + " using Newton Iteration is: "
                    + sqrt(num_double, eps_double, k));
            if (num_double < 0) {
                judge = false;
            }
        }

        in.close();
        out.close();
    }

}
