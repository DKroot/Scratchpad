package dk.xslt;

import java.io.File;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class XSLT {
    private static final transient Log log = LogFactory.getLog(XSLT.class);

    public XSLT() {
    }

    /**
     * <p>Transforms XML via XSL.</p>
     *
     * @param xsl URI to build XML document from.
     */
    public void transform(File xsl, File xml) throws Exception {
      TransformerFactory xsltFactory = TransformerFactory.newInstance();
      log.debug("TransformerFactory instantiated: " + xsltFactory);
      Transformer transformer = xsltFactory.newTransformer(new StreamSource(xsl));
      transformer.transform(new StreamSource(xml), new StreamResult(System.out));
    }

    /**
     * <p> Static entry point for running the viewer. </p>
     */
    public static void main(String[] args) {
        try {
            if (args.length < 2) {
                System.out.println("Usage: XSLT <XSL stylesheet> <XML Document URI>");
                System.exit(0);
            }

            XSLT xslt = new XSLT();
            xslt.transform(new File(args[0]), new File(args[1]));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
