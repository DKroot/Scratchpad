package dk.xml2domain.xom;

import java.util.Iterator;

import nu.xom.Element;
import nu.xom.Elements;


public class ChildrenElements implements Iterable<Element> {
    private Elements list;
    private int index = 0;
    
    public ChildrenElements(Element elem, String nsURI) {
        this(elem, null, nsURI);
    }
    
    public ChildrenElements(Element elem, String childTagName, String nsURI) {
        list = elem.getChildElements(childTagName, nsURI);
    }
    
    public Iterator<Element> iterator() {
        return new ChildElementIterator();
    }
    
    class ChildElementIterator implements Iterator<Element> {
        public boolean hasNext() {
            return index < list.size();
        }

        public Element next() {
            return (Element) list.get(index++);
        }

        public void remove() {
            //do nothing
        }
    }
}

