import static org.junit.Assert.assertEquals;

import org.junit.Test;

import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;

public class toStringWithCommasTest {

    /**
     * Calls the method under test.
     *
     * @param n
     *            the number to pass to the method under test
     * @return the {@code String} returned by the method under test
     * @ensures <pre>
     * redirectToMethodUnderTest = [String returned by the method under test]
     * </pre>
     */
    private static String redirectToMethodUnderTest(NaturalNumber n) {
        return NaturalNumberStaticOps.toStringWithCommas(n);
    }

    @Test
    public void test1() {
        NaturalNumber NN = new NaturalNumber2(1);
        String n = redirectToMethodUnderTest(NN);
        String nExpected = "1";
        assertEquals(nExpected, n);
    }

    @Test
    public void test2() {
        NaturalNumber NN = new NaturalNumber2(11);
        String n = redirectToMethodUnderTest(NN);
        String nExpected = "11";
        assertEquals(nExpected, n);
    }

    @Test
    public void test3() {
        NaturalNumber NN = new NaturalNumber2(114);
        String n = redirectToMethodUnderTest(NN);
        String nExpected = "114";
        assertEquals(nExpected, n);
    }

    @Test
    public void test4() {
        NaturalNumber NN = new NaturalNumber2(1145);
        String n = redirectToMethodUnderTest(NN);
        String nExpected = "1,145";
        assertEquals(nExpected, n);
    }

    @Test
    public void test5() {
        NaturalNumber NN = new NaturalNumber2(11451);
        String n = redirectToMethodUnderTest(NN);
        String nExpected = "11,451";
        assertEquals(nExpected, n);
    }

    @Test
    public void test6() {
        NaturalNumber NN = new NaturalNumber2(114514);
        String n = redirectToMethodUnderTest(NN);
        String nExpected = "114,514";
        assertEquals(nExpected, n);
    }

    @Test
    public void test7() {
        NaturalNumber NN = new NaturalNumber2(1919810);
        String n = redirectToMethodUnderTest(NN);
        String nExpected = "1,919,810";
        assertEquals(nExpected, n);
    }

    @Test
    public void test8() {
        NaturalNumber NN = new NaturalNumber2(0);
        String n = redirectToMethodUnderTest(NN);
        String nExpected = "0";
        assertEquals(nExpected, n);
    }

    @Test
    public void test9() {
        NaturalNumber n9NN = new NaturalNumber2(1000);
        String n = redirectToMethodUnderTest(n9NN);
        String nExpected = "1,000";
        assertEquals(nExpected, n);
    }

    @Test
    public void test10() {
        NaturalNumber NN = new NaturalNumber2(100);
        String n = redirectToMethodUnderTest(NN);
        String nExpected = "100";
        assertEquals(nExpected, n);
    }

    @Test
    public void test11() {
        NaturalNumber NN = new NaturalNumber2("9223372036854775808");
        String n = redirectToMethodUnderTest(NN);
        String nExpected = "9,223,372,036,854,775,808";
        assertEquals(nExpected, n);
    }
}
