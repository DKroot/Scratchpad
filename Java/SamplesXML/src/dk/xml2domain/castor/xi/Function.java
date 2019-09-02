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

import java.io.IOException;
import java.io.Reader;
import java.io.Serializable;
import java.io.Writer;
import java.util.Enumeration;
import java.util.Vector;
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;
import org.exolab.castor.xml.ValidationException;
import org.xml.sax.ContentHandler;

/**
 * Class Function.
 * 
 * @version $Revision$ $Date$
 */
public class Function implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _name
     */
    private java.lang.String _name;

    /**
     * Field _scope
     */
    private java.lang.Object _scope;

    /**
     * Field _pm
     */
    private java.lang.Object _pm;

    /**
     * Field _items
     */
    private java.util.Vector _items;


      //----------------/
     //- Constructors -/
    //----------------/

    public Function() 
     {
        super();
        _items = new Vector();
    } //-- dk.xml2domain.castor.xi.Function()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addFunctionItem
     * 
     * 
     * 
     * @param vFunctionItem
     */
    public void addFunctionItem(dk.xml2domain.castor.xi.FunctionItem vFunctionItem)
        throws java.lang.IndexOutOfBoundsException
    {
        _items.addElement(vFunctionItem);
    } //-- void addFunctionItem(dk.xml2domain.castor.xi.FunctionItem) 

    /**
     * Method addFunctionItem
     * 
     * 
     * 
     * @param index
     * @param vFunctionItem
     */
    public void addFunctionItem(int index, dk.xml2domain.castor.xi.FunctionItem vFunctionItem)
        throws java.lang.IndexOutOfBoundsException
    {
        _items.insertElementAt(vFunctionItem, index);
    } //-- void addFunctionItem(int, dk.xml2domain.castor.xi.FunctionItem) 

    /**
     * Method enumerateFunctionItem
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateFunctionItem()
    {
        return _items.elements();
    } //-- java.util.Enumeration enumerateFunctionItem() 

    /**
     * Method getFunctionItem
     * 
     * 
     * 
     * @param index
     * @return FunctionItem
     */
    public dk.xml2domain.castor.xi.FunctionItem getFunctionItem(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _items.size())) {
            throw new IndexOutOfBoundsException("getFunctionItem: Index value '"+index+"' not in range [0.."+_items.size()+ "]");
        }
        
        return (dk.xml2domain.castor.xi.FunctionItem) _items.elementAt(index);
    } //-- dk.xml2domain.castor.xi.FunctionItem getFunctionItem(int) 

    /**
     * Method getFunctionItem
     * 
     * 
     * 
     * @return FunctionItem
     */
    public dk.xml2domain.castor.xi.FunctionItem[] getFunctionItem()
    {
        int size = _items.size();
        dk.xml2domain.castor.xi.FunctionItem[] mArray = new dk.xml2domain.castor.xi.FunctionItem[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (dk.xml2domain.castor.xi.FunctionItem) _items.elementAt(index);
        }
        return mArray;
    } //-- dk.xml2domain.castor.xi.FunctionItem[] getFunctionItem() 

    /**
     * Method getFunctionItemCount
     * 
     * 
     * 
     * @return int
     */
    public int getFunctionItemCount()
    {
        return _items.size();
    } //-- int getFunctionItemCount() 

    /**
     * Returns the value of field 'name'.
     * 
     * @return String
     * @return the value of field 'name'.
     */
    public java.lang.String getName()
    {
        return this._name;
    } //-- java.lang.String getName() 

    /**
     * Returns the value of field 'pm'.
     * 
     * @return Object
     * @return the value of field 'pm'.
     */
    public java.lang.Object getPm()
    {
        return this._pm;
    } //-- java.lang.Object getPm() 

    /**
     * Returns the value of field 'scope'.
     * 
     * @return Object
     * @return the value of field 'scope'.
     */
    public java.lang.Object getScope()
    {
        return this._scope;
    } //-- java.lang.Object getScope() 

    /**
     * Method isValid
     * 
     * 
     * 
     * @return boolean
     */
    public boolean isValid()
    {
        try {
            validate();
        }
        catch (org.exolab.castor.xml.ValidationException vex) {
            return false;
        }
        return true;
    } //-- boolean isValid() 

    /**
     * Method marshal
     * 
     * 
     * 
     * @param out
     */
    public void marshal(java.io.Writer out)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        
        Marshaller.marshal(this, out);
    } //-- void marshal(java.io.Writer) 

    /**
     * Method marshal
     * 
     * 
     * 
     * @param handler
     */
    public void marshal(org.xml.sax.ContentHandler handler)
        throws java.io.IOException, org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        
        Marshaller.marshal(this, handler);
    } //-- void marshal(org.xml.sax.ContentHandler) 

    /**
     * Method removeAllFunctionItem
     * 
     */
    public void removeAllFunctionItem()
    {
        _items.removeAllElements();
    } //-- void removeAllFunctionItem() 

    /**
     * Method removeFunctionItem
     * 
     * 
     * 
     * @param index
     * @return FunctionItem
     */
    public dk.xml2domain.castor.xi.FunctionItem removeFunctionItem(int index)
    {
        java.lang.Object obj = _items.elementAt(index);
        _items.removeElementAt(index);
        return (dk.xml2domain.castor.xi.FunctionItem) obj;
    } //-- dk.xml2domain.castor.xi.FunctionItem removeFunctionItem(int) 

    /**
     * Method setFunctionItem
     * 
     * 
     * 
     * @param index
     * @param vFunctionItem
     */
    public void setFunctionItem(int index, dk.xml2domain.castor.xi.FunctionItem vFunctionItem)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _items.size())) {
            throw new IndexOutOfBoundsException("setFunctionItem: Index value '"+index+"' not in range [0.."+_items.size()+ "]");
        }
        _items.setElementAt(vFunctionItem, index);
    } //-- void setFunctionItem(int, dk.xml2domain.castor.xi.FunctionItem) 

    /**
     * Method setFunctionItem
     * 
     * 
     * 
     * @param functionItemArray
     */
    public void setFunctionItem(dk.xml2domain.castor.xi.FunctionItem[] functionItemArray)
    {
        //-- copy array
        _items.removeAllElements();
        for (int i = 0; i < functionItemArray.length; i++) {
            _items.addElement(functionItemArray[i]);
        }
    } //-- void setFunctionItem(dk.xml2domain.castor.xi.FunctionItem) 

    /**
     * Sets the value of field 'name'.
     * 
     * @param name the value of field 'name'.
     */
    public void setName(java.lang.String name)
    {
        this._name = name;
    } //-- void setName(java.lang.String) 

    /**
     * Sets the value of field 'pm'.
     * 
     * @param pm the value of field 'pm'.
     */
    public void setPm(java.lang.Object pm)
    {
        this._pm = pm;
    } //-- void setPm(java.lang.Object) 

    /**
     * Sets the value of field 'scope'.
     * 
     * @param scope the value of field 'scope'.
     */
    public void setScope(java.lang.Object scope)
    {
        this._scope = scope;
    } //-- void setScope(java.lang.Object) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return Function
     */
    public static dk.xml2domain.castor.xi.Function unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (dk.xml2domain.castor.xi.Function) Unmarshaller.unmarshal(dk.xml2domain.castor.xi.Function.class, reader);
    } //-- dk.xml2domain.castor.xi.Function unmarshal(java.io.Reader) 

    /**
     * Method validate
     * 
     */
    public void validate()
        throws org.exolab.castor.xml.ValidationException
    {
        org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
        validator.validate(this);
    } //-- void validate() 

}
