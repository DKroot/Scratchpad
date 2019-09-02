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
 * Class ProcessItem.
 * 
 * @version $Revision$ $Date$
 */
public class ProcessItem implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _fieldList
     */
    private java.util.Vector _fieldList;

    /**
     * Field _taskList
     */
    private java.util.Vector _taskList;


      //----------------/
     //- Constructors -/
    //----------------/

    public ProcessItem() 
     {
        super();
        _fieldList = new Vector();
        _taskList = new Vector();
    } //-- dk.xml2domain.castor.xi.ProcessItem()


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
     * Method addTask
     * 
     * 
     * 
     * @param vTask
     */
    public void addTask(dk.xml2domain.castor.xi.Task vTask)
        throws java.lang.IndexOutOfBoundsException
    {
        _taskList.addElement(vTask);
    } //-- void addTask(dk.xml2domain.castor.xi.Task) 

    /**
     * Method addTask
     * 
     * 
     * 
     * @param index
     * @param vTask
     */
    public void addTask(int index, dk.xml2domain.castor.xi.Task vTask)
        throws java.lang.IndexOutOfBoundsException
    {
        _taskList.insertElementAt(vTask, index);
    } //-- void addTask(int, dk.xml2domain.castor.xi.Task) 

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
     * Method enumerateTask
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateTask()
    {
        return _taskList.elements();
    } //-- java.util.Enumeration enumerateTask() 

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
     * Method getTask
     * 
     * 
     * 
     * @param index
     * @return Task
     */
    public dk.xml2domain.castor.xi.Task getTask(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _taskList.size())) {
            throw new IndexOutOfBoundsException("getTask: Index value '"+index+"' not in range [0.."+_taskList.size()+ "]");
        }
        
        return (dk.xml2domain.castor.xi.Task) _taskList.elementAt(index);
    } //-- dk.xml2domain.castor.xi.Task getTask(int) 

    /**
     * Method getTask
     * 
     * 
     * 
     * @return Task
     */
    public dk.xml2domain.castor.xi.Task[] getTask()
    {
        int size = _taskList.size();
        dk.xml2domain.castor.xi.Task[] mArray = new dk.xml2domain.castor.xi.Task[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (dk.xml2domain.castor.xi.Task) _taskList.elementAt(index);
        }
        return mArray;
    } //-- dk.xml2domain.castor.xi.Task[] getTask() 

    /**
     * Method getTaskCount
     * 
     * 
     * 
     * @return int
     */
    public int getTaskCount()
    {
        return _taskList.size();
    } //-- int getTaskCount() 

    /**
     * Method removeAllField
     * 
     */
    public void removeAllField()
    {
        _fieldList.removeAllElements();
    } //-- void removeAllField() 

    /**
     * Method removeAllTask
     * 
     */
    public void removeAllTask()
    {
        _taskList.removeAllElements();
    } //-- void removeAllTask() 

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
     * Method removeTask
     * 
     * 
     * 
     * @param index
     * @return Task
     */
    public dk.xml2domain.castor.xi.Task removeTask(int index)
    {
        java.lang.Object obj = _taskList.elementAt(index);
        _taskList.removeElementAt(index);
        return (dk.xml2domain.castor.xi.Task) obj;
    } //-- dk.xml2domain.castor.xi.Task removeTask(int) 

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
     * Method setTask
     * 
     * 
     * 
     * @param index
     * @param vTask
     */
    public void setTask(int index, dk.xml2domain.castor.xi.Task vTask)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _taskList.size())) {
            throw new IndexOutOfBoundsException("setTask: Index value '"+index+"' not in range [0.."+_taskList.size()+ "]");
        }
        _taskList.setElementAt(vTask, index);
    } //-- void setTask(int, dk.xml2domain.castor.xi.Task) 

    /**
     * Method setTask
     * 
     * 
     * 
     * @param taskArray
     */
    public void setTask(dk.xml2domain.castor.xi.Task[] taskArray)
    {
        //-- copy array
        _taskList.removeAllElements();
        for (int i = 0; i < taskArray.length; i++) {
            _taskList.addElement(taskArray[i]);
        }
    } //-- void setTask(dk.xml2domain.castor.xi.Task) 

}
