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
 * Class TaskItem.
 * 
 * @version $Revision$ $Date$
 */
public class TaskItem implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _parameters
     */
    private dk.xml2domain.castor.xi.Parameters _parameters;

    /**
     * This is a placeholder for the process script elements
     */
    private dk.xml2domain.castor.xi.Script _script;


      //----------------/
     //- Constructors -/
    //----------------/

    public TaskItem() 
     {
        super();
    } //-- dk.xml2domain.castor.xi.TaskItem()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'parameters'.
     * 
     * @return Parameters
     * @return the value of field 'parameters'.
     */
    public dk.xml2domain.castor.xi.Parameters getParameters()
    {
        return this._parameters;
    } //-- dk.xml2domain.castor.xi.Parameters getParameters() 

    /**
     * Returns the value of field 'script'. The field 'script' has
     * the following description: This is a placeholder for the
     * process script elements
     * 
     * @return Script
     * @return the value of field 'script'.
     */
    public dk.xml2domain.castor.xi.Script getScript()
    {
        return this._script;
    } //-- dk.xml2domain.castor.xi.Script getScript() 

    /**
     * Sets the value of field 'parameters'.
     * 
     * @param parameters the value of field 'parameters'.
     */
    public void setParameters(dk.xml2domain.castor.xi.Parameters parameters)
    {
        this._parameters = parameters;
    } //-- void setParameters(dk.xml2domain.castor.xi.Parameters) 

    /**
     * Sets the value of field 'script'. The field 'script' has the
     * following description: This is a placeholder for the process
     * script elements
     * 
     * @param script the value of field 'script'.
     */
    public void setScript(dk.xml2domain.castor.xi.Script script)
    {
        this._script = script;
    } //-- void setScript(dk.xml2domain.castor.xi.Script) 

}
