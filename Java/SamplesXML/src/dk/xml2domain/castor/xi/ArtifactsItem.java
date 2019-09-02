/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 0.9.9.1</a>, using an XML
 * Schema.
 * $Id$
 */

package dk.xml2domain.castor.xi;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import java.io.Serializable;
import java.util.Enumeration;
import java.util.Vector;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;

/**
 * Class ArtifactsItem.
 * 
 * @version $Revision$ $Date$
 */
public class ArtifactsItem implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Internal choice value storage
     */
    private java.lang.Object _choiceValue;

    /**
     * Field _eventList
     */
    private java.util.Vector _eventList;

    /**
     * Field _documentList
     */
    private java.util.Vector _documentList;

    /**
     * Field _variantList
     */
    private java.util.Vector _variantList;

    /**
     * Field _roleList
     */
    private java.util.Vector _roleList;

    /**
     * Field _productList
     */
    private java.util.Vector _productList;


      //----------------/
     //- Constructors -/
    //----------------/

    public ArtifactsItem() 
     {
        super();
        _eventList = new Vector();
        _documentList = new Vector();
        _variantList = new Vector();
        _roleList = new Vector();
        _productList = new Vector();
    } //-- dk.xml2domain.castor.xi.ArtifactsItem()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addDocument
     * 
     * 
     * 
     * @param vDocument
     */
    public void addDocument(dk.xml2domain.castor.xi.Document vDocument)
        throws java.lang.IndexOutOfBoundsException
    {
        _documentList.addElement(vDocument);
    } //-- void addDocument(dk.xml2domain.castor.xi.Document) 

    /**
     * Method addDocument
     * 
     * 
     * 
     * @param index
     * @param vDocument
     */
    public void addDocument(int index, dk.xml2domain.castor.xi.Document vDocument)
        throws java.lang.IndexOutOfBoundsException
    {
        _documentList.insertElementAt(vDocument, index);
    } //-- void addDocument(int, dk.xml2domain.castor.xi.Document) 

    /**
     * Method addEvent
     * 
     * 
     * 
     * @param vEvent
     */
    public void addEvent(dk.xml2domain.castor.xi.Event vEvent)
        throws java.lang.IndexOutOfBoundsException
    {
        _eventList.addElement(vEvent);
    } //-- void addEvent(dk.xml2domain.castor.xi.Event) 

    /**
     * Method addEvent
     * 
     * 
     * 
     * @param index
     * @param vEvent
     */
    public void addEvent(int index, dk.xml2domain.castor.xi.Event vEvent)
        throws java.lang.IndexOutOfBoundsException
    {
        _eventList.insertElementAt(vEvent, index);
    } //-- void addEvent(int, dk.xml2domain.castor.xi.Event) 

    /**
     * Method addProduct
     * 
     * 
     * 
     * @param vProduct
     */
    public void addProduct(dk.xml2domain.castor.xi.Product vProduct)
        throws java.lang.IndexOutOfBoundsException
    {
        _productList.addElement(vProduct);
    } //-- void addProduct(dk.xml2domain.castor.xi.Product) 

    /**
     * Method addProduct
     * 
     * 
     * 
     * @param index
     * @param vProduct
     */
    public void addProduct(int index, dk.xml2domain.castor.xi.Product vProduct)
        throws java.lang.IndexOutOfBoundsException
    {
        _productList.insertElementAt(vProduct, index);
    } //-- void addProduct(int, dk.xml2domain.castor.xi.Product) 

    /**
     * Method addRole
     * 
     * 
     * 
     * @param vRole
     */
    public void addRole(dk.xml2domain.castor.xi.Role vRole)
        throws java.lang.IndexOutOfBoundsException
    {
        _roleList.addElement(vRole);
    } //-- void addRole(dk.xml2domain.castor.xi.Role) 

    /**
     * Method addRole
     * 
     * 
     * 
     * @param index
     * @param vRole
     */
    public void addRole(int index, dk.xml2domain.castor.xi.Role vRole)
        throws java.lang.IndexOutOfBoundsException
    {
        _roleList.insertElementAt(vRole, index);
    } //-- void addRole(int, dk.xml2domain.castor.xi.Role) 

    /**
     * Method addVariant
     * 
     * 
     * 
     * @param vVariant
     */
    public void addVariant(dk.xml2domain.castor.xi.Variant vVariant)
        throws java.lang.IndexOutOfBoundsException
    {
        _variantList.addElement(vVariant);
    } //-- void addVariant(dk.xml2domain.castor.xi.Variant) 

    /**
     * Method addVariant
     * 
     * 
     * 
     * @param index
     * @param vVariant
     */
    public void addVariant(int index, dk.xml2domain.castor.xi.Variant vVariant)
        throws java.lang.IndexOutOfBoundsException
    {
        _variantList.insertElementAt(vVariant, index);
    } //-- void addVariant(int, dk.xml2domain.castor.xi.Variant) 

    /**
     * Method enumerateDocument
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateDocument()
    {
        return _documentList.elements();
    } //-- java.util.Enumeration enumerateDocument() 

    /**
     * Method enumerateEvent
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateEvent()
    {
        return _eventList.elements();
    } //-- java.util.Enumeration enumerateEvent() 

    /**
     * Method enumerateProduct
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateProduct()
    {
        return _productList.elements();
    } //-- java.util.Enumeration enumerateProduct() 

    /**
     * Method enumerateRole
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateRole()
    {
        return _roleList.elements();
    } //-- java.util.Enumeration enumerateRole() 

    /**
     * Method enumerateVariant
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateVariant()
    {
        return _variantList.elements();
    } //-- java.util.Enumeration enumerateVariant() 

    /**
     * Returns the value of field 'choiceValue'. The field
     * 'choiceValue' has the following description: Internal choice
     * value storage
     * 
     * @return Object
     * @return the value of field 'choiceValue'.
     */
    public java.lang.Object getChoiceValue()
    {
        return this._choiceValue;
    } //-- java.lang.Object getChoiceValue() 

    /**
     * Method getDocument
     * 
     * 
     * 
     * @param index
     * @return Document
     */
    public dk.xml2domain.castor.xi.Document getDocument(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _documentList.size())) {
            throw new IndexOutOfBoundsException("getDocument: Index value '"+index+"' not in range [0.."+_documentList.size()+ "]");
        }
        
        return (dk.xml2domain.castor.xi.Document) _documentList.elementAt(index);
    } //-- dk.xml2domain.castor.xi.Document getDocument(int) 

    /**
     * Method getDocument
     * 
     * 
     * 
     * @return Document
     */
    public dk.xml2domain.castor.xi.Document[] getDocument()
    {
        int size = _documentList.size();
        dk.xml2domain.castor.xi.Document[] mArray = new dk.xml2domain.castor.xi.Document[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (dk.xml2domain.castor.xi.Document) _documentList.elementAt(index);
        }
        return mArray;
    } //-- dk.xml2domain.castor.xi.Document[] getDocument() 

    /**
     * Method getDocumentCount
     * 
     * 
     * 
     * @return int
     */
    public int getDocumentCount()
    {
        return _documentList.size();
    } //-- int getDocumentCount() 

    /**
     * Method getEvent
     * 
     * 
     * 
     * @param index
     * @return Event
     */
    public dk.xml2domain.castor.xi.Event getEvent(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _eventList.size())) {
            throw new IndexOutOfBoundsException("getEvent: Index value '"+index+"' not in range [0.."+_eventList.size()+ "]");
        }
        
        return (dk.xml2domain.castor.xi.Event) _eventList.elementAt(index);
    } //-- dk.xml2domain.castor.xi.Event getEvent(int) 

    /**
     * Method getEvent
     * 
     * 
     * 
     * @return Event
     */
    public dk.xml2domain.castor.xi.Event[] getEvent()
    {
        int size = _eventList.size();
        dk.xml2domain.castor.xi.Event[] mArray = new dk.xml2domain.castor.xi.Event[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (dk.xml2domain.castor.xi.Event) _eventList.elementAt(index);
        }
        return mArray;
    } //-- dk.xml2domain.castor.xi.Event[] getEvent() 

    /**
     * Method getEventCount
     * 
     * 
     * 
     * @return int
     */
    public int getEventCount()
    {
        return _eventList.size();
    } //-- int getEventCount() 

    /**
     * Method getProduct
     * 
     * 
     * 
     * @param index
     * @return Product
     */
    public dk.xml2domain.castor.xi.Product getProduct(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _productList.size())) {
            throw new IndexOutOfBoundsException("getProduct: Index value '"+index+"' not in range [0.."+_productList.size()+ "]");
        }
        
        return (dk.xml2domain.castor.xi.Product) _productList.elementAt(index);
    } //-- dk.xml2domain.castor.xi.Product getProduct(int) 

    /**
     * Method getProduct
     * 
     * 
     * 
     * @return Product
     */
    public dk.xml2domain.castor.xi.Product[] getProduct()
    {
        int size = _productList.size();
        dk.xml2domain.castor.xi.Product[] mArray = new dk.xml2domain.castor.xi.Product[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (dk.xml2domain.castor.xi.Product) _productList.elementAt(index);
        }
        return mArray;
    } //-- dk.xml2domain.castor.xi.Product[] getProduct() 

    /**
     * Method getProductCount
     * 
     * 
     * 
     * @return int
     */
    public int getProductCount()
    {
        return _productList.size();
    } //-- int getProductCount() 

    /**
     * Method getRole
     * 
     * 
     * 
     * @param index
     * @return Role
     */
    public dk.xml2domain.castor.xi.Role getRole(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _roleList.size())) {
            throw new IndexOutOfBoundsException("getRole: Index value '"+index+"' not in range [0.."+_roleList.size()+ "]");
        }
        
        return (dk.xml2domain.castor.xi.Role) _roleList.elementAt(index);
    } //-- dk.xml2domain.castor.xi.Role getRole(int) 

    /**
     * Method getRole
     * 
     * 
     * 
     * @return Role
     */
    public dk.xml2domain.castor.xi.Role[] getRole()
    {
        int size = _roleList.size();
        dk.xml2domain.castor.xi.Role[] mArray = new dk.xml2domain.castor.xi.Role[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (dk.xml2domain.castor.xi.Role) _roleList.elementAt(index);
        }
        return mArray;
    } //-- dk.xml2domain.castor.xi.Role[] getRole() 

    /**
     * Method getRoleCount
     * 
     * 
     * 
     * @return int
     */
    public int getRoleCount()
    {
        return _roleList.size();
    } //-- int getRoleCount() 

    /**
     * Method getVariant
     * 
     * 
     * 
     * @param index
     * @return Variant
     */
    public dk.xml2domain.castor.xi.Variant getVariant(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _variantList.size())) {
            throw new IndexOutOfBoundsException("getVariant: Index value '"+index+"' not in range [0.."+_variantList.size()+ "]");
        }
        
        return (dk.xml2domain.castor.xi.Variant) _variantList.elementAt(index);
    } //-- dk.xml2domain.castor.xi.Variant getVariant(int) 

    /**
     * Method getVariant
     * 
     * 
     * 
     * @return Variant
     */
    public dk.xml2domain.castor.xi.Variant[] getVariant()
    {
        int size = _variantList.size();
        dk.xml2domain.castor.xi.Variant[] mArray = new dk.xml2domain.castor.xi.Variant[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (dk.xml2domain.castor.xi.Variant) _variantList.elementAt(index);
        }
        return mArray;
    } //-- dk.xml2domain.castor.xi.Variant[] getVariant() 

    /**
     * Method getVariantCount
     * 
     * 
     * 
     * @return int
     */
    public int getVariantCount()
    {
        return _variantList.size();
    } //-- int getVariantCount() 

    /**
     * Method removeAllDocument
     * 
     */
    public void removeAllDocument()
    {
        _documentList.removeAllElements();
    } //-- void removeAllDocument() 

    /**
     * Method removeAllEvent
     * 
     */
    public void removeAllEvent()
    {
        _eventList.removeAllElements();
    } //-- void removeAllEvent() 

    /**
     * Method removeAllProduct
     * 
     */
    public void removeAllProduct()
    {
        _productList.removeAllElements();
    } //-- void removeAllProduct() 

    /**
     * Method removeAllRole
     * 
     */
    public void removeAllRole()
    {
        _roleList.removeAllElements();
    } //-- void removeAllRole() 

    /**
     * Method removeAllVariant
     * 
     */
    public void removeAllVariant()
    {
        _variantList.removeAllElements();
    } //-- void removeAllVariant() 

    /**
     * Method removeDocument
     * 
     * 
     * 
     * @param index
     * @return Document
     */
    public dk.xml2domain.castor.xi.Document removeDocument(int index)
    {
        java.lang.Object obj = _documentList.elementAt(index);
        _documentList.removeElementAt(index);
        return (dk.xml2domain.castor.xi.Document) obj;
    } //-- dk.xml2domain.castor.xi.Document removeDocument(int) 

    /**
     * Method removeEvent
     * 
     * 
     * 
     * @param index
     * @return Event
     */
    public dk.xml2domain.castor.xi.Event removeEvent(int index)
    {
        java.lang.Object obj = _eventList.elementAt(index);
        _eventList.removeElementAt(index);
        return (dk.xml2domain.castor.xi.Event) obj;
    } //-- dk.xml2domain.castor.xi.Event removeEvent(int) 

    /**
     * Method removeProduct
     * 
     * 
     * 
     * @param index
     * @return Product
     */
    public dk.xml2domain.castor.xi.Product removeProduct(int index)
    {
        java.lang.Object obj = _productList.elementAt(index);
        _productList.removeElementAt(index);
        return (dk.xml2domain.castor.xi.Product) obj;
    } //-- dk.xml2domain.castor.xi.Product removeProduct(int) 

    /**
     * Method removeRole
     * 
     * 
     * 
     * @param index
     * @return Role
     */
    public dk.xml2domain.castor.xi.Role removeRole(int index)
    {
        java.lang.Object obj = _roleList.elementAt(index);
        _roleList.removeElementAt(index);
        return (dk.xml2domain.castor.xi.Role) obj;
    } //-- dk.xml2domain.castor.xi.Role removeRole(int) 

    /**
     * Method removeVariant
     * 
     * 
     * 
     * @param index
     * @return Variant
     */
    public dk.xml2domain.castor.xi.Variant removeVariant(int index)
    {
        java.lang.Object obj = _variantList.elementAt(index);
        _variantList.removeElementAt(index);
        return (dk.xml2domain.castor.xi.Variant) obj;
    } //-- dk.xml2domain.castor.xi.Variant removeVariant(int) 

    /**
     * Method setDocument
     * 
     * 
     * 
     * @param index
     * @param vDocument
     */
    public void setDocument(int index, dk.xml2domain.castor.xi.Document vDocument)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _documentList.size())) {
            throw new IndexOutOfBoundsException("setDocument: Index value '"+index+"' not in range [0.."+_documentList.size()+ "]");
        }
        _documentList.setElementAt(vDocument, index);
    } //-- void setDocument(int, dk.xml2domain.castor.xi.Document) 

    /**
     * Method setDocument
     * 
     * 
     * 
     * @param documentArray
     */
    public void setDocument(dk.xml2domain.castor.xi.Document[] documentArray)
    {
        //-- copy array
        _documentList.removeAllElements();
        for (int i = 0; i < documentArray.length; i++) {
            _documentList.addElement(documentArray[i]);
        }
    } //-- void setDocument(dk.xml2domain.castor.xi.Document) 

    /**
     * Method setEvent
     * 
     * 
     * 
     * @param index
     * @param vEvent
     */
    public void setEvent(int index, dk.xml2domain.castor.xi.Event vEvent)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _eventList.size())) {
            throw new IndexOutOfBoundsException("setEvent: Index value '"+index+"' not in range [0.."+_eventList.size()+ "]");
        }
        _eventList.setElementAt(vEvent, index);
    } //-- void setEvent(int, dk.xml2domain.castor.xi.Event) 

    /**
     * Method setEvent
     * 
     * 
     * 
     * @param eventArray
     */
    public void setEvent(dk.xml2domain.castor.xi.Event[] eventArray)
    {
        //-- copy array
        _eventList.removeAllElements();
        for (int i = 0; i < eventArray.length; i++) {
            _eventList.addElement(eventArray[i]);
        }
    } //-- void setEvent(dk.xml2domain.castor.xi.Event) 

    /**
     * Method setProduct
     * 
     * 
     * 
     * @param index
     * @param vProduct
     */
    public void setProduct(int index, dk.xml2domain.castor.xi.Product vProduct)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _productList.size())) {
            throw new IndexOutOfBoundsException("setProduct: Index value '"+index+"' not in range [0.."+_productList.size()+ "]");
        }
        _productList.setElementAt(vProduct, index);
    } //-- void setProduct(int, dk.xml2domain.castor.xi.Product) 

    /**
     * Method setProduct
     * 
     * 
     * 
     * @param productArray
     */
    public void setProduct(dk.xml2domain.castor.xi.Product[] productArray)
    {
        //-- copy array
        _productList.removeAllElements();
        for (int i = 0; i < productArray.length; i++) {
            _productList.addElement(productArray[i]);
        }
    } //-- void setProduct(dk.xml2domain.castor.xi.Product) 

    /**
     * Method setRole
     * 
     * 
     * 
     * @param index
     * @param vRole
     */
    public void setRole(int index, dk.xml2domain.castor.xi.Role vRole)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _roleList.size())) {
            throw new IndexOutOfBoundsException("setRole: Index value '"+index+"' not in range [0.."+_roleList.size()+ "]");
        }
        _roleList.setElementAt(vRole, index);
    } //-- void setRole(int, dk.xml2domain.castor.xi.Role) 

    /**
     * Method setRole
     * 
     * 
     * 
     * @param roleArray
     */
    public void setRole(dk.xml2domain.castor.xi.Role[] roleArray)
    {
        //-- copy array
        _roleList.removeAllElements();
        for (int i = 0; i < roleArray.length; i++) {
            _roleList.addElement(roleArray[i]);
        }
    } //-- void setRole(dk.xml2domain.castor.xi.Role) 

    /**
     * Method setVariant
     * 
     * 
     * 
     * @param index
     * @param vVariant
     */
    public void setVariant(int index, dk.xml2domain.castor.xi.Variant vVariant)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _variantList.size())) {
            throw new IndexOutOfBoundsException("setVariant: Index value '"+index+"' not in range [0.."+_variantList.size()+ "]");
        }
        _variantList.setElementAt(vVariant, index);
    } //-- void setVariant(int, dk.xml2domain.castor.xi.Variant) 

    /**
     * Method setVariant
     * 
     * 
     * 
     * @param variantArray
     */
    public void setVariant(dk.xml2domain.castor.xi.Variant[] variantArray)
    {
        //-- copy array
        _variantList.removeAllElements();
        for (int i = 0; i < variantArray.length; i++) {
            _variantList.addElement(variantArray[i]);
        }
    } //-- void setVariant(dk.xml2domain.castor.xi.Variant) 

}
