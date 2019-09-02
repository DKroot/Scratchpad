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
 * Class FieldItem.
 * 
 * @version $Revision$ $Date$
 */
public class FieldItem implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _fieldList
     */
    private java.util.Vector _fieldList;


      //----------------/
     //- Constructors -/
    //----------------/

    public FieldItem() 
     {
        super();
        _fieldList = new Vector();
    } //-- dk.xml2domain.castor.xi.FieldItem()


      //-----------/
     //- Methods -/
    //-----------/

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
     * Method removeAllField
     * 
     */
    public void removeAllField()
    {
        _fieldList.removeAllElements();
    } //-- void removeAllField() 

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

}
