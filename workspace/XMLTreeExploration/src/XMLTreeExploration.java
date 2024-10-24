import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.xmltree.XMLTree;
import components.xmltree.XMLTree1;

/**
 * Put a short phrase describing the program here.
 *
 * @author Put your name here
 *
 */
public final class XMLTreeExploration {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private XMLTreeExploration() {
    }

    /**
     * Output information about the middle child of the given {@code XMLTree}.
     *
     * @param xt
     *            the {@code XMLTree} whose middle child is to be printed
     * @param out
     *            the output stream
     * @updates out.content
     * @requires * [the label of the root of xt is a tag] and [xt has at least
     *           one child] and out.is_open
     *
     * @ensures * out.content = #out.content * [the label of the middle child of
     *          xt, whether the root of the middle child is a tag or text, and
     *          if it is a tag, the number of children of the middle child]
     *
     */
    private static void printMiddleNode(XMLTree xt, SimpleWriter out) {
        int len = xt.numberOfChildren();
        int mid = len / 2;
        out.println(xt.child(mid));
        out.println(xt.child(mid).isTag());
        if (xt.child(mid).isTag()) {
            out.println(xt.child(mid).numberOfChildren());
        }
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
        XMLTree xml = new XMLTree1("https://cse22x1.engineering.osu.edu/2221/web-sw1/"
                + "extras/instructions/xmltree-model/columbus-weather.xml");

        XMLTree results = xml.child(0);
        XMLTree channel = results.child(0);
        XMLTree title = channel.child(1);
        XMLTree titleText = title.child(0);
        XMLTree better = xml.child(0).child(0).child(1).child(0);

        XMLTree astronomy = channel.child(10);

        // out.println(xml.toString());
        xml.display();
        printMiddleNode(channel, out);

        // out.println(xml.isTag());
        // out.println(xml.label());

        // out.println(channel.numberOfChildren());
        // out.println(titleText.label());
        // out.println(better.label());

        // out.println(astronomy.label());
        // out.println(astronomy.hasAttribute("sunset"));
        // out.println(astronomy.hasAttribute("midday"));
        // out.println(astronomy.attributeValue("sunset"));
        // out.println(astronomy.attributeValue("midday"));

        in.close();
        out.close();
    }

}
