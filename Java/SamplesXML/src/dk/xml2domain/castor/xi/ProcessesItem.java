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
 * Class ProcessesItem.
 * 
 * @version $Revision$ $Date$
 */
public class ProcessesItem implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _processList
     */
    private java.util.Vector _processList;


      //----------------/
     //- Constructors -/
    //----------------/

    public ProcessesItem() 
     {
        super();
        _processList = new Vector();
    } //-- dk.xml2domain.castor.xi.ProcessesItem()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addProcess
     * 
     * 
     * 
     * @param vProcess
     */
    public void addProcess(dk.xml2domain.castor.xi.Process vProcess)
        throws java.lang.IndexOutOfBoundsException
    {
        _processList.addElement(vProcess);
    } //-- void addProcess(dk.xml2domain.castor.xi.Process) 

    /**
     * Method addProcess
     * 
     * 
     * 
     * @param index
     * @param vProcess
     */
    public void addProcess(int index, dk.xml2domain.castor.xi.Process vProcess)
        throws java.lang.IndexOutOfBoundsException
    {
        _processList.insertElementAt(vProcess, index);
    } //-- void addProcess(int, dk.xml2domain.castor.xi.Process) 

    /**
     * Method enumerateProcess
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateProcess()
    {
        return _processList.elements();
    } //-- java.util.Enumeration enumerateProcess() 

    /**
     * Method getProcess
     * 
     * 
     * 
     * @param index
     * @return Process
     */
    public dk.xml2domain.castor.xi.Process getProcess(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _processList.size())) {
            throw new IndexOutOfBoundsException("getProcess: Index value '"+index+"' not in range [0.."+_processList.size()+ "]");
        }
        
        return (dk.xml2domain.castor.xi.Process) _processList.elementAt(index);
    } //-- dk.xml2domain.castor.xi.Process getProcess(int) 

    /**
     * Method getProcess
     * 
     * 
     * 
     * @return Process
     */
    public dk.xml2domain.castor.xi.Process[] getProcess()
    {
        int size = _processList.size();
        dk.xml2domain.castor.xi.Process[] mArray = new dk.xml2domain.castor.xi.Process[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (dk.xml2domain.castor.xi.Process) _processList.elementAt(index);
        }
        return mArray;
    } //-- dk.xml2domain.castor.xi.Process[] getProcess() 

    /**
     * Method getProcessCount
     * 
     * 
     * 
     * @return int
     */
    public int getProcessCount()
    {
        return _processList.size();
    } //-- int getProcessCount() 

    /**
     * Method removeAllProcess
     * 
     */
    public void removeAllProcess()
    {
        _processList.removeAllElements();
    } //-- void removeAllProcess() 

    /**
     * Method removeProcess
     * 
     * 
     * 
     * @param index
     * @return Process
     */
    public dk.xml2domain.castor.xi.Process removeProcess(int index)
    {
        java.lang.Object obj = _processList.elementAt(index);
        _processList.removeElementAt(index);
        return (dk.xml2domain.castor.xi.Process) obj;
    } //-- dk.xml2domain.castor.xi.Process removeProcess(int) 

    /**
     * Method setProcess
     * 
     * 
     * 
     * @param index
     * @param vProcess
     */
    public void setProcess(int index, dk.xml2domain.castor.xi.Process vProcess)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _processList.size())) {
            throw new IndexOutOfBoundsException("setProcess: Index value '"+index+"' not in range [0.."+_processList.size()+ "]");
        }
        _processList.setElementAt(vProcess, index);
    } //-- void setProcess(int, dk.xml2domain.castor.xi.Process) 

    /**
     * Method setProcess
     * 
     * 
     * 
     * @param processArray
     */
    public void setProcess(dk.xml2domain.castor.xi.Process[] processArray)
    {
        //-- copy array
        _processList.removeAllElements();
        for (int i = 0; i < processArray.length; i++) {
            _processList.addElement(processArray[i]);
        }
    } //-- void setProcess(dk.xml2domain.castor.xi.Process) 

}
