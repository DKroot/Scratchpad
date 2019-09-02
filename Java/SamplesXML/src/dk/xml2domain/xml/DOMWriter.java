package dk.xml2domain.xml;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Arrays;

import org.w3c.dom.Document;
import org.w3c.dom.DocumentType;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * <b><code>DOMSerializer</code></b> will take a DOM
 *   tree and serialize that tree.
 */
public class DOMWriter {

    /** Indentation to use */
    private String indent;

    /** Line separator to use */
    private String tagSeparator;

    /**
     * <p> This initializes the needed settings. </p>
     */
    public DOMWriter(int indent, String tagSeparator) {
        char[] filler = new char[indent];
        Arrays.fill(filler, ' ');
        this.indent = new String(filler);
        
        this.tagSeparator = tagSeparator;
    }

    /** 
     * <p> This sets the indentation to use. </p>
     *
     * @param indent the indentation <code>String</code> to use.
     */
    public void setIndent(String indent) {
        this.indent = indent;
    }

    /**
     * <p> This sets the line separator to use. </p>
     *
     * @param tagSeparator line separator to use.
     */
    public void setLineSeparator(String lineSeparator) {
        this.tagSeparator = lineSeparator;
    }

    /**
     * <p> This serializes a DOM tree to the supplied
     *  <code>OutputStream</code>.</p>
     *
     * @param doc DOM tree to serialize.
     * @param out <code>OutputStream</code> to write to.
     */
    public void write(Document doc, OutputStream out)
        throws IOException {
        
        Writer writer = new OutputStreamWriter(out);
        write(doc, writer);
    }

    /**
     * <p> This serializes a DOM tree to the supplied
     *  <code>OutputStream</code>.</p>
     *
     * @param doc DOM tree to serialize.
     * @param file <code>File</code> to write to.
     */
    public void write(Document doc, File file)
        throws IOException {

        Writer writer = new FileWriter(file);
        write(doc, writer);
    }

    /**
     * <p> This serializes a DOM tree to the supplied
     *  <code>OutputStream</code>.</p>
     *
     * @param doc DOM tree to serialize.
     * @param writer <code>Writer</code> to write to.
     */
    public void write(Document doc, Writer writer)
        throws IOException {

        // Start serialization recursion with no indenting
        write(doc, writer, "", true, false);
        writer.flush();
    }

    /**
     * <p> This will serialize a DOM <code>Node</code> to
     *   the supplied <code>Writer</code>. </p>
     *
     * @param node DOM <code>Node</code> to serialize.
     * @param writer <code>Writer</code> to write to.
     * @param nodeIndent current indentation.
     */   
    public void write(Node node, Writer writer, 
            String nodeIndent, boolean writeNodeItself, boolean trimWhitespace)
        throws IOException {

        // Determine action based on node type
        switch (node.getNodeType()) {
            case Node.DOCUMENT_NODE:
                if (writeNodeItself) {
                    writer.write("<?xml version=\"1.0\"?>");
                    writer.write(tagSeparator);
                }
                
                // recurse on each child
                NodeList nodes = node.getChildNodes();
                if (nodes != null) {
                    for (int i=0; i<nodes.getLength(); i++) {
                        write(nodes.item(i), writer, "", true, trimWhitespace);
                    }
                }
                /*
                Document doc = (Document)node;
                serializeNode(doc.getDocumentElement(), writer, "");
                */
                break;
            
            case Node.ELEMENT_NODE:
                String name = null;
                if (writeNodeItself) {
                    name = node.getNodeName();
                    writer.write(nodeIndent + "<" + name);
                    NamedNodeMap attributes = node.getAttributes();
                    for (int i=0; i<attributes.getLength(); i++) {
                        Node current = attributes.item(i);
                        writer.write(" " + current.getNodeName() +
                                     "=\"" + current.getNodeValue() +
                                     "\"");
                    }
                    writer.write(">");
                }
                
                // recurse on each child
                NodeList children = node.getChildNodes();
                if (children != null) {
                    if ((children.item(0) != null) &&
                        (children.item(0).getNodeType() == 
                        Node.ELEMENT_NODE)) {
                            
                        writer.write(tagSeparator);
                    }
                    for (int i=0; i<children.getLength(); i++) {                        
                        write(children.item(i), writer,
                                nodeIndent + indent, true, trimWhitespace);
                    }
                    if ((children.item(0) != null) &&
                        (children.item(children.getLength()-1)
                                .getNodeType() ==
                        Node.ELEMENT_NODE)) {
                     
                        writer.write(nodeIndent);       
                    }
                }
                
                if (writeNodeItself) {
                    writer.write("</" + name + ">");
                    writer.write(tagSeparator);
                }
                break;
            
            case Node.TEXT_NODE:
                if (trimWhitespace) {
                    writer.write(node.getNodeValue().trim());
                } else {
                    writer.write(node.getNodeValue());
                }
                break;

            case Node.CDATA_SECTION_NODE:
                writer.write("<![CDATA[" +
                             node.getNodeValue() + "]]>");
                break;

            case Node.COMMENT_NODE:
                writer.write(nodeIndent + "<!-- " +
                             node.getNodeValue() + " -->");
                writer.write(tagSeparator);
                break;
            
            case Node.PROCESSING_INSTRUCTION_NODE:
                writer.write("<?" + node.getNodeName() +
                             " " + node.getNodeValue() +
                             "?>");                
                writer.write(tagSeparator);
                break;
            
            case Node.ENTITY_REFERENCE_NODE:
                writer.write("&" + node.getNodeName() + ";");    
                break;
                
            case Node.DOCUMENT_TYPE_NODE: 
                DocumentType docType = (DocumentType)node;
                writer.write("<!DOCTYPE " + docType.getName());
                if (docType.getPublicId() != null)  {
                    System.out.print(" PUBLIC \"" + 
                        docType.getPublicId() + "\" ");                    
                } else {
                    writer.write(" SYSTEM ");
                }
                writer.write("\"" + docType.getSystemId() + "\">");                                
                writer.write(tagSeparator);
                break;                
        }        
    }
}