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
 * Class Switch.
 * 
 * @version $Revision$ $Date$
 */
public class Switch implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _name
     */
    private java.lang.String _name;

    /**
     * Field _branchList
     */
    private java.util.Vector _branchList;


      //----------------/
     //- Constructors -/
    //----------------/

    public Switch() 
     {
        super();
        _branchList = new Vector();
    } //-- dk.xml2domain.castor.xi.Switch()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addBranch
     * 
     * 
     * 
     * @param vBranch
     */
    public void addBranch(dk.xml2domain.castor.xi.Branch vBranch)
        throws java.lang.IndexOutOfBoundsException
    {
        _branchList.addElement(vBranch);
    } //-- void addBranch(dk.xml2domain.castor.xi.Branch) 

    /**
     * Method addBranch
     * 
     * 
     * 
     * @param index
     * @param vBranch
     */
    public void addBranch(int index, dk.xml2domain.castor.xi.Branch vBranch)
        throws java.lang.IndexOutOfBoundsException
    {
        _branchList.insertElementAt(vBranch, index);
    } //-- void addBranch(int, dk.xml2domain.castor.xi.Branch) 

    /**
     * Method enumerateBranch
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateBranch()
    {
        return _branchList.elements();
    } //-- java.util.Enumeration enumerateBranch() 

    /**
     * Method getBranch
     * 
     * 
     * 
     * @param index
     * @return Branch
     */
    public dk.xml2domain.castor.xi.Branch getBranch(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _branchList.size())) {
            throw new IndexOutOfBoundsException("getBranch: Index value '"+index+"' not in range [0.."+_branchList.size()+ "]");
        }
        
        return (dk.xml2domain.castor.xi.Branch) _branchList.elementAt(index);
    } //-- dk.xml2domain.castor.xi.Branch getBranch(int) 

    /**
     * Method getBranch
     * 
     * 
     * 
     * @return Branch
     */
    public dk.xml2domain.castor.xi.Branch[] getBranch()
    {
        int size = _branchList.size();
        dk.xml2domain.castor.xi.Branch[] mArray = new dk.xml2domain.castor.xi.Branch[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (dk.xml2domain.castor.xi.Branch) _branchList.elementAt(index);
        }
        return mArray;
    } //-- dk.xml2domain.castor.xi.Branch[] getBranch() 

    /**
     * Method getBranchCount
     * 
     * 
     * 
     * @return int
     */
    public int getBranchCount()
    {
        return _branchList.size();
    } //-- int getBranchCount() 

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
     * Method removeAllBranch
     * 
     */
    public void removeAllBranch()
    {
        _branchList.removeAllElements();
    } //-- void removeAllBranch() 

    /**
     * Method removeBranch
     * 
     * 
     * 
     * @param index
     * @return Branch
     */
    public dk.xml2domain.castor.xi.Branch removeBranch(int index)
    {
        java.lang.Object obj = _branchList.elementAt(index);
        _branchList.removeElementAt(index);
        return (dk.xml2domain.castor.xi.Branch) obj;
    } //-- dk.xml2domain.castor.xi.Branch removeBranch(int) 

    /**
     * Method setBranch
     * 
     * 
     * 
     * @param index
     * @param vBranch
     */
    public void setBranch(int index, dk.xml2domain.castor.xi.Branch vBranch)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _branchList.size())) {
            throw new IndexOutOfBoundsException("setBranch: Index value '"+index+"' not in range [0.."+_branchList.size()+ "]");
        }
        _branchList.setElementAt(vBranch, index);
    } //-- void setBranch(int, dk.xml2domain.castor.xi.Branch) 

    /**
     * Method setBranch
     * 
     * 
     * 
     * @param branchArray
     */
    public void setBranch(dk.xml2domain.castor.xi.Branch[] branchArray)
    {
        //-- copy array
        _branchList.removeAllElements();
        for (int i = 0; i < branchArray.length; i++) {
            _branchList.addElement(branchArray[i]);
        }
    } //-- void setBranch(dk.xml2domain.castor.xi.Branch) 

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
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return Switch
     */
    public static dk.xml2domain.castor.xi.Switch unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (dk.xml2domain.castor.xi.Switch) Unmarshaller.unmarshal(dk.xml2domain.castor.xi.Switch.class, reader);
    } //-- dk.xml2domain.castor.xi.Switch unmarshal(java.io.Reader) 

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
