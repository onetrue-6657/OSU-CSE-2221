import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber1L;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.xmltree.XMLTree;

/**
 * Put a short phrase describing the program here.
 *
 * @author Put your name here
 *
 */
public final class Homework13 {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private Homework13() {
    }

    /**
     * Returns the product of the digits of {@code n}.
     *
     * @param n
     *            {@code NaturalNumber} whose digits to multiply
     * @return the product of the digits of {@code n}
     * @clears n
     * @ensures productOfDigits1 = [product of the digits of n]
     */
    private static NaturalNumber productOfDigits1(NaturalNumber n) {
        int digit = n.divideBy10();
        NaturalNumber digitNN = new NaturalNumber1L(digit);
        NaturalNumber res = new NaturalNumber1L(1);
        if (n.isZero()) {
            res.copyFrom(digitNN);
        } else {
            res.multiply(digitNN);
            res.multiply(productOfDigits1(n));
        }
        return res;
    }

    /**
     * Returns the product of the digits of {@code n}.
     *
     * @param n
     *            {@code NaturalNumber} whose digits to multiply
     * @return the product of the digits of {@code n}
     * @ensures productOfDigits2 = [product of the digits of n]
     */
    private static NaturalNumber productOfDigits2(NaturalNumber n) {
        int digit = n.divideBy10();
        NaturalNumber digitNN = new NaturalNumber1L(digit);
        NaturalNumber res = new NaturalNumber1L(1);
        if (n.isZero()) {
            res.copyFrom(digitNN);
        } else {
            res.multiply(digitNN);
            res.multiply(productOfDigits2(n));
        }
        n.multiplyBy10(digit);
        return res;
    }

    /**
     * Reports the value of {@code n} as an {@code int}, when {@code n} is small
     * enough.
     *
     * @param n
     *            the given {@code NaturalNumber}
     * @return the value
     * @requires n <= Integer.MAX_VALUE
     * @ensures toInt = n
     */
    private static int toInt(NaturalNumber n) {
        int digit = n.divideBy10();
        int res = 0;
        if (n.isZero()) {
            res = digit;
        } else {
            res += digit;
            res += toInt(n) * 10;
        }
        return res;
    }

    /**
     * Reports whether the given tag appears in the given {@code XMLTree}.
     *
     * @param xml
     *            the {@code XMLTree}
     * @param tag
     *            the tag name
     * @return true if the given tag appears in the given {@code XMLTree}, false
     *         otherwise
     * @ensures <pre>
     * findTag =
     *    [true if the given tag appears in the given {@code XMLTree}, false otherwise]
     * </pre>
     */
    private static boolean findTag(XMLTree xml, String tag) {
        boolean res = false;
        int numOfChildren = xml.numberOfChildren();
        if (numOfChildren > 0) {
            for (int i = 0; i < numOfChildren; i++) {
                if (xml.child(i).isTag() && xml.child(i).equals(tag)) {
                    res = true;
                } else {
                    res = findTag(xml.child(i), tag);
                }
            }
        }
        if ((xml.child(0).isTag() && xml.child(0).equals(tag)) || res) {
            res = true;
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
        NaturalNumber NN = new NaturalNumber1L(114514);
        out.println(NN);
        out.println(productOfDigits2(NN));
        out.println(NN);
        in.close();
        out.close();
    }

}
