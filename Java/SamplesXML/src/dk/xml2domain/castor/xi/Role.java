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
 * Class Role.
 * 
 * @version $Revision$ $Date$
 */
public class Role implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _name
     */
    private java.lang.String _name;

    /**
     * Field _id
     */
    private java.lang.String _id;

    /**
     * Field _parent
     */
    private java.lang.String _parent;

    /**
     * Field _scope
     */
    private java.lang.Object _scope;

    /**
     * Attribute can contain any XML inside
     */
    private java.util.Vector _attributeList;

    /**
     * Field _fieldList
     */
    private java.util.Vector _fieldList;

    /**
     * Field _functionList
     */
    private java.util.Vector _functionList;


      //----------------/
     //- Constructors -/
    //----------------/

    public Role() 
     {
        super();
        _attributeList = new Vector();
        _fieldList = new Vector();
        _functionList = new Vector();
    } //-- dk.xml2domain.castor.xi.Role()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addAttribute
     * 
     * 
     * 
     * @param vAttribute
     */
    public void addAttribute(dk.xml2domain.castor.xi.Attribute vAttribute)
        throws java.lang.IndexOutOfBoundsException
    {
        _attributeList.addElement(vAttribute);
    } //-- void addAttribute(dk.xml2domain.castor.xi.Attribute) 

    /**
     * Method addAttribute
     * 
     * 
     * 
     * @param index
     * @param vAttribute
     */
    public void addAttribute(int index, dk.xml2domain.castor.xi.Attribute vAttribute)
        throws java.lang.IndexOutOfBoundsException
    {
        _attributeList.insertElementAt(vAttribute, index);
    } //-- void addAttribute(int, dk.xml2domain.castor.xi.Attribute) 

    /**
     * Method addField
     * 
     * 
     * 
     * @param vField
     */
    public void addField(dk.xml2domain.castor.xi.Field vField)
        throws java.lang.IndexOutOfBoundsException
    {
        _fieldList.addElement(vField);
    } //-- void addField(dk.xml2domain.castor.xi.Field) 

    /**
     * Method addField
     * 
     * 
     * 
     * @param index
     * @param vField
     */
    public void addField(int index, dk.xml2domain.castor.xi.Field vField)
        throws java.lang.IndexOutOfBoundsException
    {
        _fieldList.insertElementAt(vField, index);
    } //-- void addField(int, dk.xml2domain.castor.xi.Field) 

    /**
     * Method addFunction
     * 
     * 
     * 
     * @param vFunction
     */
    public void addFunction(dk.xml2domain.castor.xi.Function vFunction)
        throws java.lang.IndexOutOfBoundsException
    {
        _functionList.addElement(vFunction);
    } //-- void addFunction(dk.xml2domain.castor.xi.Function) 

    /**
     * Method addFunction
     * 
     * 
     * 
     * @param index
     * @param vFunction
     */
    public void addFunction(int index, dk.xml2domain.castor.xi.Function vFunction)
        throws java.lang.IndexOutOfBoundsException
    {
        _functionList.insertElementAt(vFunction, index);
    } //-- void addFunction(int, dk.xml2domain.castor.xi.Function) 

    /**
     * Method enumerateAttribute
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateAttribute()
    {
        return _attributeList.elements();
    } //-- java.util.Enumeration enumerateAttribute() 

    /**
     * Method enumerateField
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateField()
    {
        return _fieldList.elements();
    } //-- java.util.Enumeration enumerateField() 

    /**
     * Method enumerateFunction
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateFunction()
    {
        return _functionList.elements();
    } //-- java.util.Enumeration enumerateFunction() 

    /**
     * Method getAttribute
     * 
     * 
     * 
     * @param index
     * @return Attribute
     */
    public dk.xml2domain.castor.xi.Attribute getAttribute(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _attributeList.size())) {
            throw new IndexOutOfBoundsException("getAttribute: Index value '"+index+"' not in range [0.."+_attributeList.size()+ "]");
        }
        
        return (dk.xml2domain.castor.xi.Attribute) _attributeList.elementAt(index);
    } //-- dk.xml2domain.castor.xi.Attribute getAttribute(int) 

    /**
     * Method getAttribute
     * 
     * 
     * 
     * @return Attribute
     */
    public dk.xml2domain.castor.xi.Attribute[] getAttribute()
    {
        int size = _attributeList.size();
        dk.xml2domain.castor.xi.Attribute[] mArray = new dk.xml2domain.castor.xi.Attribute[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (dk.xml2domain.castor.xi.Attribute) _attributeList.elementAt(index);
        }
        return mArray;
    } //-- dk.xml2domain.castor.xi.Attribute[] getAttribute() 

    /**
     * Method getAttributeCount
     * 
     * 
     * 
     * @return int
     */
    public int getAttributeCount()
    {
        return _attributeList.size();
    } //-- int getAttributeCount() 

    /**
     * Method getField
     * 
     * 
     * 
     * @param index
     * @return Field
     */
    public dk.xml2domain.castor.xi.Field getField(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _fieldList.size())) {
            throw new IndexOutOfBoundsException("getField: Index value '"+index+"' not in range [0.."+_fieldList.size()+ "]");
        }
        
        return (dk.xml2domain.castor.xi.Field) _fieldList.elementAt(index);
    } //-- dk.xml2domain.castor.xi.Field getField(int) 

    /**
     * Method getField
     * 
     * 
     * 
     * @return Field
     */
    public dk.xml2domain.castor.xi.Field[] getField()
    {
        int size = _fieldList.size();
        dk.xml2domain.castor.xi.Field[] mArray = new dk.xml2domain.castor.xi.Field[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (dk.xml2domain.castor.xi.Field) _fieldList.elementAt(index);
        }
        return mArray;
    } //-- dk.xml2domain.castor.xi.Field[] getField() 

    /**
     * Method getFieldCount
     * 
     * 
     * 
     * @return int
     */
    public int getFieldCount()
    {
        return _fieldList.size();
    } //-- int getFieldCount() 

    /**
     * Method getFunction
     * 
     * 
     * 
     * @param index
     * @return Function
     */
    public dk.xml2domain.castor.xi.Function getFunction(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _functionList.size())) {
            throw new IndexOutOfBoundsException("getFunction: Index value '"+index+"' not in range [0.."+_functionList.size()+ "]");
        }
        
        return (dk.xml2domain.castor.xi.Function) _functionList.elementAt(index);
    } //-- dk.xml2domain.castor.xi.Function getFunction(int) 

    /**
     * Method getFunction
     * 
     * 
     * 
     * @return Function
     */
    public dk.xml2domain.castor.xi.Function[] getFunction()
    {
        int size = _functionList.size();
        dk.xml2domain.castor.xi.Function[] mArray = new dk.xml2domain.castor.xi.Function[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (dk.xml2domain.castor.xi.Function) _functionList.elementAt(index);
        }
        return mArray;
    } //-- dk.xml2domain.castor.xi.Function[] getFunction() 

    /**
     * Method getFunctionCount
     * 
     * 
     * 
     * @return int
     */
    public int getFunctionCount()
    {
        return _functionList.size();
    } //-- int getFunctionCount() 

    /**
     * Returns the value of field 'id'.
     * 
     * @return String
     * @return the value of field 'id'.
     */
    public java.lang.String getId()
    {
        return this._id;
    } //-- java.lang.String getId() 

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
     * Returns the value of field 'parent'.
     * 
     * @return String
     * @return the value of field 'parent'.
     */
    public java.lang.String getParent()
    {
        return this._parent;
    } //-- java.lang.String getParent() 

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
     * Method removeAllAttribute
     * 
     */
    public void removeAllAttribute()
    {
        _attributeList.removeAllElements();
    } //-- void removeAllAttribute() 

    /**
     * Method removeAllField
     * 
     */
    public void removeAllField()
    {
        _fieldList.removeAllElements();
    } //-- void removeAllField() 

    /**
     * Method removeAllFunction
     * 
     */
    public void removeAllFunction()
    {
        _functionList.removeAllElements();
    } //-- void removeAllFunction() 

    /**
     * Method removeAttribute
     * 
     * 
     * 
     * @param index
     * @return Attribute
     */
    public dk.xml2domain.castor.xi.Attribute removeAttribute(int index)
    {
        java.lang.Object obj = _attributeList.elementAt(index);
        _attributeList.removeElementAt(index);
        return (dk.xml2domain.castor.xi.Attribute) obj;
    } //-- dk.xml2domain.castor.xi.Attribute removeAttribute(int) 

    /**
     * Method removeField
     * 
     * 
     * 
     * @param index
     * @return Field
     */
    public dk.xml2domain.castor.xi.Field removeField(int index)
    {
        java.lang.Object obj = _fieldList.elementAt(index);
        _fieldList.removeElementAt(index);
        return (dk.xml2domain.castor.xi.Field) obj;
    } //-- dk.xml2domain.castor.xi.Field removeField(int) 

    /**
     * Method removeFunction
     * 
     * 
     * 
     * @param index
     * @return Function
     */
    public dk.xml2domain.castor.xi.Function removeFunction(int index)
    {
        java.lang.Object obj = _functionList.elementAt(index);
        _functionList.removeElementAt(index);
        return (dk.xml2domain.castor.xi.Function) obj;
    } //-- dk.xml2domain.castor.xi.Function removeFunction(int) 

    /**
     * Method setAttribute
     * 
     * 
     * 
     * @param index
     * @param vAttribute
     */
    public void setAttribute(int index, dk.xml2domain.castor.xi.Attribute vAttribute)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _attributeList.size())) {
            throw new IndexOutOfBoundsException("setAttribute: Index value '"+index+"' not in range [0.."+_attributeList.size()+ "]");
        }
        _attributeList.setElementAt(vAttribute, index);
    } //-- void setAttribute(int, dk.xml2domain.castor.xi.Attribute) 

    /**
     * Method setAttribute
     * 
     * 
     * 
     * @param attributeArray
     */
    public void setAttribute(dk.xml2domain.castor.xi.Attribute[] attributeArray)
    {
        //-- copy array
        _attributeList.removeAllElements();
        for (int i = 0; i < attributeArray.length; i++) {
            _attributeList.addElement(attributeArray[i]);
        }
    } //-- void setAttribute(dk.xml2domain.castor.xi.Attribute) 

    /**
     * Method setField
     * 
     * 
     * 
     * @param index
     * @param vField
     */
    public void setField(int index, dk.xml2domain.castor.xi.Field vField)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _fieldList.size())) {
            throw new IndexOutOfBoundsException("setField: Index value '"+index+"' not in range [0.."+_fieldList.size()+ "]");
        }
        _fieldList.setElementAt(vField, index);
    } //-- void setField(int, dk.xml2domain.castor.xi.Field) 

    /**
     * Method setField
     * 
     * 
     * 
     * @param fieldArray
     */
    public void setField(dk.xml2domain.castor.xi.Field[] fieldArray)
    {
        //-- copy array
        _fieldList.removeAllElements();
        for (int i = 0; i < fieldArray.length; i++) {
            _fieldList.addElement(fieldArray[i]);
        }
    } //-- void setField(dk.xml2domain.castor.xi.Field) 

    /**
     * Method setFunction
     * 
     * 
     * 
     * @param index
     * @param vFunction
     */
    public void setFunction(int index, dk.xml2domain.castor.xi.Function vFunction)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _functionList.size())) {
            throw new IndexOutOfBoundsException("setFunction: Index value '"+index+"' not in range [0.."+_functionList.size()+ "]");
        }
        _functionList.setElementAt(vFunction, index);
    } //-- void setFunction(int, dk.xml2domain.castor.xi.Function) 

    /**
     * Method setFunction
     * 
     * 
     * 
     * @param functionArray
     */
    public void setFunction(dk.xml2domain.castor.xi.Function[] functionArray)
    {
        //-- copy array
        _functionList.removeAllElements();
        for (int i = 0; i < functionArray.length; i++) {
            _functionList.addElement(functionArray[i]);
        }
    } //-- void setFunction(dk.xml2domain.castor.xi.Function) 

    /**
     * Sets the value of field 'id'.
     * 
     * @param id the value of field 'id'.
     */
    public void setId(java.lang.String id)
    {
        this._id = id;
    } //-- void setId(java.lang.String) 

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
     * Sets the value of field 'parent'.
     * 
     * @param parent the value of field 'parent'.
     */
    public void setParent(java.lang.String parent)
    {
        this._parent = parent;
    } //-- void setParent(java.lang.String) 

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
     * @return Role
     */
    public static dk.xml2domain.castor.xi.Role unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (dk.xml2domain.castor.xi.Role) Unmarshaller.unmarshal(dk.xml2domain.castor.xi.Role.class, reader);
    } //-- dk.xml2domain.castor.xi.Role unmarshal(java.io.Reader) 

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
