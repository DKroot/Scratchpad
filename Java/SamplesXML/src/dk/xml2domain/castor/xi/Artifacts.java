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
 * Artifacts of domain
 * 
 * @version $Revision$ $Date$
 */
public class Artifacts implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _items
     */
    private java.util.Vector _items;


      //----------------/
     //- Constructors -/
    //----------------/

    public Artifacts() 
     {
        super();
        _items = new Vector();
    } //-- dk.xml2domain.castor.xi.Artifacts()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addArtifactsItem
     * 
     * 
     * 
     * @param vArtifactsItem
     */
    public void addArtifactsItem(dk.xml2domain.castor.xi.ArtifactsItem vArtifactsItem)
        throws java.lang.IndexOutOfBoundsException
    {
        _items.addElement(vArtifactsItem);
    } //-- void addArtifactsItem(dk.xml2domain.castor.xi.ArtifactsItem) 

    /**
     * Method addArtifactsItem
     * 
     * 
     * 
     * @param index
     * @param vArtifactsItem
     */
    public void addArtifactsItem(int index, dk.xml2domain.castor.xi.ArtifactsItem vArtifactsItem)
        throws java.lang.IndexOutOfBoundsException
    {
        _items.insertElementAt(vArtifactsItem, index);
    } //-- void addArtifactsItem(int, dk.xml2domain.castor.xi.ArtifactsItem) 

    /**
     * Method enumerateArtifactsItem
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateArtifactsItem()
    {
        return _items.elements();
    } //-- java.util.Enumeration enumerateArtifactsItem() 

    /**
     * Method getArtifactsItem
     * 
     * 
     * 
     * @param index
     * @return ArtifactsItem
     */
    public dk.xml2domain.castor.xi.ArtifactsItem getArtifactsItem(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _items.size())) {
            throw new IndexOutOfBoundsException("getArtifactsItem: Index value '"+index+"' not in range [0.."+_items.size()+ "]");
        }
        
        return (dk.xml2domain.castor.xi.ArtifactsItem) _items.elementAt(index);
    } //-- dk.xml2domain.castor.xi.ArtifactsItem getArtifactsItem(int) 

    /**
     * Method getArtifactsItem
     * 
     * 
     * 
     * @return ArtifactsItem
     */
    public dk.xml2domain.castor.xi.ArtifactsItem[] getArtifactsItem()
    {
        int size = _items.size();
        dk.xml2domain.castor.xi.ArtifactsItem[] mArray = new dk.xml2domain.castor.xi.ArtifactsItem[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (dk.xml2domain.castor.xi.ArtifactsItem) _items.elementAt(index);
        }
        return mArray;
    } //-- dk.xml2domain.castor.xi.ArtifactsItem[] getArtifactsItem() 

    /**
     * Method getArtifactsItemCount
     * 
     * 
     * 
     * @return int
     */
    public int getArtifactsItemCount()
    {
        return _items.size();
    } //-- int getArtifactsItemCount() 

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
     * Method removeAllArtifactsItem
     * 
     */
    public void removeAllArtifactsItem()
    {
        _items.removeAllElements();
    } //-- void removeAllArtifactsItem() 

    /**
     * Method removeArtifactsItem
     * 
     * 
     * 
     * @param index
     * @return ArtifactsItem
     */
    public dk.xml2domain.castor.xi.ArtifactsItem removeArtifactsItem(int index)
    {
        java.lang.Object obj = _items.elementAt(index);
        _items.removeElementAt(index);
        return (dk.xml2domain.castor.xi.ArtifactsItem) obj;
    } //-- dk.xml2domain.castor.xi.ArtifactsItem removeArtifactsItem(int) 

    /**
     * Method setArtifactsItem
     * 
     * 
     * 
     * @param index
     * @param vArtifactsItem
     */
    public void setArtifactsItem(int index, dk.xml2domain.castor.xi.ArtifactsItem vArtifactsItem)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _items.size())) {
            throw new IndexOutOfBoundsException("setArtifactsItem: Index value '"+index+"' not in range [0.."+_items.size()+ "]");
        }
        _items.setElementAt(vArtifactsItem, index);
    } //-- void setArtifactsItem(int, dk.xml2domain.castor.xi.ArtifactsItem) 

    /**
     * Method setArtifactsItem
     * 
     * 
     * 
     * @param artifactsItemArray
     */
    public void setArtifactsItem(dk.xml2domain.castor.xi.ArtifactsItem[] artifactsItemArray)
    {
        //-- copy array
        _items.removeAllElements();
        for (int i = 0; i < artifactsItemArray.length; i++) {
            _items.addElement(artifactsItemArray[i]);
        }
    } //-- void setArtifactsItem(dk.xml2domain.castor.xi.ArtifactsItem) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return Artifacts
     */
    public static dk.xml2domain.castor.xi.Artifacts unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (dk.xml2domain.castor.xi.Artifacts) Unmarshaller.unmarshal(dk.xml2domain.castor.xi.Artifacts.class, reader);
    } //-- dk.xml2domain.castor.xi.Artifacts unmarshal(java.io.Reader) 

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
