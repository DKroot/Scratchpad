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
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;

/**
 * Class XIItem.
 * 
 * @version $Revision$ $Date$
 */
public class XIItem implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _domain
     */
    private dk.xml2domain.castor.xi.Domain _domain;


      //----------------/
     //- Constructors -/
    //----------------/

    public XIItem() 
     {
        super();
    } //-- dk.xml2domain.castor.xi.XIItem()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'domain'.
     * 
     * @return Domain
     * @return the value of field 'domain'.
     */
    public dk.xml2domain.castor.xi.Domain getDomain()
    {
        return this._domain;
    } //-- dk.xml2domain.castor.xi.Domain getDomain() 

    /**
     * Sets the value of field 'domain'.
     * 
     * @param domain the value of field 'domain'.
     */
    public void setDomain(dk.xml2domain.castor.xi.Domain domain)
    {
        this._domain = domain;
    } //-- void setDomain(dk.xml2domain.castor.xi.Domain) 

}
