import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber1L;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.utilities.Reporter;
import components.xmltree.XMLTree;
import components.xmltree.XMLTree1;

/**
 * Program to evaluate XMLTree expressions of {@code int}.
 *
 * @author Put your name here
 *
 */
public final class XMLTreeNNExpressionEvaluator {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private XMLTreeNNExpressionEvaluator() {
    }

    /**
     * Evaluate the given expression.
     *
     * @param exp
     *            the {@code XMLTree} representing the expression
     * @return the value of the expression
     * @requires * [exp is a subtree of a well-formed XML arithmetic expression]
     *           and [the label of the root of exp is not "expression"]
     *
     * @ensures evaluate = [the value of the expression]
     */
    private static NaturalNumber evaluate(XMLTree exp) {
        assert exp != null : "Violation of: exp is not null";

        NaturalNumber res = new NaturalNumber1L(0);
        String operator;
        if (exp.label().equals("number")) {
            res = new NaturalNumber1L(Integer.parseInt(exp.attributeValue("value")));
        } else {
            operator = exp.label();
            NaturalNumber num1 = evaluate(exp.child(0));
            NaturalNumber num2 = evaluate(exp.child(1));
            if (operator.equals("plus")) {
                num1.add(num2);
            } else if (operator.equals("minus")) {
                if (num1.compareTo(num2) < 0) {
                    Reporter.fatalErrorToConsole("Cannot be negative.");
                } else {
                    num1.subtract(num2);
                }
            } else if (operator.equals("times")) {
                num1.multiply(num2);
            } else if (operator.equals("divide")) {
                if (!num2.isZero()) {
                    num1.divide(num2);
                } else {
                    Reporter.fatalErrorToConsole("Cannot divide by 0.");
                }
            }
            res.copyFrom(num1);
        }
        return res;
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

        out.print("Enter the name of an expression XML file: ");
        String file = in.nextLine();
        while (!file.equals("")) {
            XMLTree exp = new XMLTree1(file);
            out.println(evaluate(exp.child(0)));
            out.print("Enter the name of an expression XML file: ");
            file = in.nextLine();
        }

        in.close();
        out.close();
    }

}
