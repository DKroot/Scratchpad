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
 * Class HeaderItem.
 * 
 * @version $Revision$ $Date$
 */
public class HeaderItem implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Alias id will be used in the attribute 'domain' to refer to
     * the domain
     *  The full uri of the domain specified in the attribute
     * 'name' of the alias
     *  
     */
    private java.util.Vector _aliasList;


      //----------------/
     //- Constructors -/
    //----------------/

    public HeaderItem() 
     {
        super();
        _aliasList = new Vector();
    } //-- dk.xml2domain.castor.xi.HeaderItem()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addAlias
     * 
     * 
     * 
     * @param vAlias
     */
    public void addAlias(dk.xml2domain.castor.xi.Alias vAlias)
        throws java.lang.IndexOutOfBoundsException
    {
        _aliasList.addElement(vAlias);
    } //-- void addAlias(dk.xml2domain.castor.xi.Alias) 

    /**
     * Method addAlias
     * 
     * 
     * 
     * @param index
     * @param vAlias
     */
    public void addAlias(int index, dk.xml2domain.castor.xi.Alias vAlias)
        throws java.lang.IndexOutOfBoundsException
    {
        _aliasList.insertElementAt(vAlias, index);
    } //-- void addAlias(int, dk.xml2domain.castor.xi.Alias) 

    /**
     * Method enumerateAlias
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateAlias()
    {
        return _aliasList.elements();
    } //-- java.util.Enumeration enumerateAlias() 

    /**
     * Method getAlias
     * 
     * 
     * 
     * @param index
     * @return Alias
     */
    public dk.xml2domain.castor.xi.Alias getAlias(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _aliasList.size())) {
            throw new IndexOutOfBoundsException("getAlias: Index value '"+index+"' not in range [0.."+_aliasList.size()+ "]");
        }
        
        return (dk.xml2domain.castor.xi.Alias) _aliasList.elementAt(index);
    } //-- dk.xml2domain.castor.xi.Alias getAlias(int) 

    /**
     * Method getAlias
     * 
     * 
     * 
     * @return Alias
     */
    public dk.xml2domain.castor.xi.Alias[] getAlias()
    {
        int size = _aliasList.size();
        dk.xml2domain.castor.xi.Alias[] mArray = new dk.xml2domain.castor.xi.Alias[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (dk.xml2domain.castor.xi.Alias) _aliasList.elementAt(index);
        }
        return mArray;
    } //-- dk.xml2domain.castor.xi.Alias[] getAlias() 

    /**
     * Method getAliasCount
     * 
     * 
     * 
     * @return int
     */
    public int getAliasCount()
    {
        return _aliasList.size();
    } //-- int getAliasCount() 

    /**
     * Method removeAlias
     * 
     * 
     * 
     * @param index
     * @return Alias
     */
    public dk.xml2domain.castor.xi.Alias removeAlias(int index)
    {
        java.lang.Object obj = _aliasList.elementAt(index);
        _aliasList.removeElementAt(index);
        return (dk.xml2domain.castor.xi.Alias) obj;
    } //-- dk.xml2domain.castor.xi.Alias removeAlias(int) 

    /**
     * Method removeAllAlias
     * 
     */
    public void removeAllAlias()
    {
        _aliasList.removeAllElements();
    } //-- void removeAllAlias() 

    /**
     * Method setAlias
     * 
     * 
     * 
     * @param index
     * @param vAlias
     */
    public void setAlias(int index, dk.xml2domain.castor.xi.Alias vAlias)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _aliasList.size())) {
            throw new IndexOutOfBoundsException("setAlias: Index value '"+index+"' not in range [0.."+_aliasList.size()+ "]");
        }
        _aliasList.setElementAt(vAlias, index);
    } //-- void setAlias(int, dk.xml2domain.castor.xi.Alias) 

    /**
     * Method setAlias
     * 
     * 
     * 
     * @param aliasArray
     */
    public void setAlias(dk.xml2domain.castor.xi.Alias[] aliasArray)
    {
        //-- copy array
        _aliasList.removeAllElements();
        for (int i = 0; i < aliasArray.length; i++) {
            _aliasList.addElement(aliasArray[i]);
        }
    } //-- void setAlias(dk.xml2domain.castor.xi.Alias) 

}
