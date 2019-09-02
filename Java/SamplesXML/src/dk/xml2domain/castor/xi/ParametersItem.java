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
 * Class ParametersItem.
 * 
 * @version $Revision$ $Date$
 */
public class ParametersItem implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _paramList
     */
    private java.util.Vector _paramList;


      //----------------/
     //- Constructors -/
    //----------------/

    public ParametersItem() 
     {
        super();
        _paramList = new Vector();
    } //-- dk.xml2domain.castor.xi.ParametersItem()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addParam
     * 
     * 
     * 
     * @param vParam
     */
    public void addParam(dk.xml2domain.castor.xi.Param vParam)
        throws java.lang.IndexOutOfBoundsException
    {
        _paramList.addElement(vParam);
    } //-- void addParam(dk.xml2domain.castor.xi.Param) 

    /**
     * Method addParam
     * 
     * 
     * 
     * @param index
     * @param vParam
     */
    public void addParam(int index, dk.xml2domain.castor.xi.Param vParam)
        throws java.lang.IndexOutOfBoundsException
    {
        _paramList.insertElementAt(vParam, index);
    } //-- void addParam(int, dk.xml2domain.castor.xi.Param) 

    /**
     * Method enumerateParam
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateParam()
    {
        return _paramList.elements();
    } //-- java.util.Enumeration enumerateParam() 

    /**
     * Method getParam
     * 
     * 
     * 
     * @param index
     * @return Param
     */
    public dk.xml2domain.castor.xi.Param getParam(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _paramList.size())) {
            throw new IndexOutOfBoundsException("getParam: Index value '"+index+"' not in range [0.."+_paramList.size()+ "]");
        }
        
        return (dk.xml2domain.castor.xi.Param) _paramList.elementAt(index);
    } //-- dk.xml2domain.castor.xi.Param getParam(int) 

    /**
     * Method getParam
     * 
     * 
     * 
     * @return Param
     */
    public dk.xml2domain.castor.xi.Param[] getParam()
    {
        int size = _paramList.size();
        dk.xml2domain.castor.xi.Param[] mArray = new dk.xml2domain.castor.xi.Param[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (dk.xml2domain.castor.xi.Param) _paramList.elementAt(index);
        }
        return mArray;
    } //-- dk.xml2domain.castor.xi.Param[] getParam() 

    /**
     * Method getParamCount
     * 
     * 
     * 
     * @return int
     */
    public int getParamCount()
    {
        return _paramList.size();
    } //-- int getParamCount() 

    /**
     * Method removeAllParam
     * 
     */
    public void removeAllParam()
    {
        _paramList.removeAllElements();
    } //-- void removeAllParam() 

    /**
     * Method removeParam
     * 
     * 
     * 
     * @param index
     * @return Param
     */
    public dk.xml2domain.castor.xi.Param removeParam(int index)
    {
        java.lang.Object obj = _paramList.elementAt(index);
        _paramList.removeElementAt(index);
        return (dk.xml2domain.castor.xi.Param) obj;
    } //-- dk.xml2domain.castor.xi.Param removeParam(int) 

    /**
     * Method setParam
     * 
     * 
     * 
     * @param index
     * @param vParam
     */
    public void setParam(int index, dk.xml2domain.castor.xi.Param vParam)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _paramList.size())) {
            throw new IndexOutOfBoundsException("setParam: Index value '"+index+"' not in range [0.."+_paramList.size()+ "]");
        }
        _paramList.setElementAt(vParam, index);
    } //-- void setParam(int, dk.xml2domain.castor.xi.Param) 

    /**
     * Method setParam
     * 
     * 
     * 
     * @param paramArray
     */
    public void setParam(dk.xml2domain.castor.xi.Param[] paramArray)
    {
        //-- copy array
        _paramList.removeAllElements();
        for (int i = 0; i < paramArray.length; i++) {
            _paramList.addElement(paramArray[i]);
        }
    } //-- void setParam(dk.xml2domain.castor.xi.Param) 

}
