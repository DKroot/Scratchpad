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
 * Class VariantItem.
 * 
 * @version $Revision$ $Date$
 */
public class VariantItem implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _memberList
     */
    private java.util.Vector _memberList;


      //----------------/
     //- Constructors -/
    //----------------/

    public VariantItem() 
     {
        super();
        _memberList = new Vector();
    } //-- dk.xml2domain.castor.xi.VariantItem()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addMember
     * 
     * 
     * 
     * @param vMember
     */
    public void addMember(dk.xml2domain.castor.xi.Member vMember)
        throws java.lang.IndexOutOfBoundsException
    {
        _memberList.addElement(vMember);
    } //-- void addMember(dk.xml2domain.castor.xi.Member) 

    /**
     * Method addMember
     * 
     * 
     * 
     * @param index
     * @param vMember
     */
    public void addMember(int index, dk.xml2domain.castor.xi.Member vMember)
        throws java.lang.IndexOutOfBoundsException
    {
        _memberList.insertElementAt(vMember, index);
    } //-- void addMember(int, dk.xml2domain.castor.xi.Member) 

    /**
     * Method enumerateMember
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateMember()
    {
        return _memberList.elements();
    } //-- java.util.Enumeration enumerateMember() 

    /**
     * Method getMember
     * 
     * 
     * 
     * @param index
     * @return Member
     */
    public dk.xml2domain.castor.xi.Member getMember(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _memberList.size())) {
            throw new IndexOutOfBoundsException("getMember: Index value '"+index+"' not in range [0.."+_memberList.size()+ "]");
        }
        
        return (dk.xml2domain.castor.xi.Member) _memberList.elementAt(index);
    } //-- dk.xml2domain.castor.xi.Member getMember(int) 

    /**
     * Method getMember
     * 
     * 
     * 
     * @return Member
     */
    public dk.xml2domain.castor.xi.Member[] getMember()
    {
        int size = _memberList.size();
        dk.xml2domain.castor.xi.Member[] mArray = new dk.xml2domain.castor.xi.Member[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (dk.xml2domain.castor.xi.Member) _memberList.elementAt(index);
        }
        return mArray;
    } //-- dk.xml2domain.castor.xi.Member[] getMember() 

    /**
     * Method getMemberCount
     * 
     * 
     * 
     * @return int
     */
    public int getMemberCount()
    {
        return _memberList.size();
    } //-- int getMemberCount() 

    /**
     * Method removeAllMember
     * 
     */
    public void removeAllMember()
    {
        _memberList.removeAllElements();
    } //-- void removeAllMember() 

    /**
     * Method removeMember
     * 
     * 
     * 
     * @param index
     * @return Member
     */
    public dk.xml2domain.castor.xi.Member removeMember(int index)
    {
        java.lang.Object obj = _memberList.elementAt(index);
        _memberList.removeElementAt(index);
        return (dk.xml2domain.castor.xi.Member) obj;
    } //-- dk.xml2domain.castor.xi.Member removeMember(int) 

    /**
     * Method setMember
     * 
     * 
     * 
     * @param index
     * @param vMember
     */
    public void setMember(int index, dk.xml2domain.castor.xi.Member vMember)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _memberList.size())) {
            throw new IndexOutOfBoundsException("setMember: Index value '"+index+"' not in range [0.."+_memberList.size()+ "]");
        }
        _memberList.setElementAt(vMember, index);
    } //-- void setMember(int, dk.xml2domain.castor.xi.Member) 

    /**
     * Method setMember
     * 
     * 
     * 
     * @param memberArray
     */
    public void setMember(dk.xml2domain.castor.xi.Member[] memberArray)
    {
        //-- copy array
        _memberList.removeAllElements();
        for (int i = 0; i < memberArray.length; i++) {
            _memberList.addElement(memberArray[i]);
        }
    } //-- void setMember(dk.xml2domain.castor.xi.Member) 

}
