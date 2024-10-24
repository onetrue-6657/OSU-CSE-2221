import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

public final class Newton5 {

    private Newton5() {
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
        double eps = in.nextDouble();

        while (judge) {
            out.print("Please input a number to calculate the square root of it: ");
            double num = in.nextDouble();
            out.print("Please input the k-th root you want in the Newton iteration: ");
            int k = in.nextInteger();
            out.println("The " + k + "th root of " + num + " using Newton Iteration is: "
                    + sqrt(num, eps, k));
            if (num < 0) {
                judge = false;
            }
        }

        in.close();
        out.close();
    }

}
