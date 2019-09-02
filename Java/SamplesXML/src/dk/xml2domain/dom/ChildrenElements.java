package dk.xml2domain.dom;

import java.util.Iterator;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ChildrenElements implements Iterable<Element> {
    private String nsURI;
    private String tagName;

    private NodeList list;
    private int index = 0;
    
    public ChildrenElements(Element elem, String nsURI) {
        this.nsURI = nsURI; 
        list = elem.getChildNodes();
    }
    
    public ChildrenElements(Element elem, String childTagName, String nsURI) {
        this(elem, nsURI);
        tagName = childTagName;
    }
    
    public Iterator<Element> iterator() {
        return new ChildElementIterator();
    }
    
    class ChildElementIterator implements Iterator<Element> {
        public boolean hasNext() {
            skipOtherNodes();
            return index < list.getLength();
        }

        public Element next() {
            skipOtherNodes();
            return (Element) list.item(index++);
        }

        public void remove() {
            //do nothing
        }

        // Skip nodes that we are not interested in
        private void skipOtherNodes() {
            while ( index < list.getLength() ) {
                Node node = list.item(index);
                if ( node.getNodeType() == Node.ELEMENT_NODE &&
                        ( nsURI == null || node.getNamespaceURI().equals(nsURI) ) &&
                        ( tagName == null || node.getLocalName().equals(tagName) ) ) {
                    return; //the right element is found!
                }
                
                index++;
            }     
        }
        
    }
}

