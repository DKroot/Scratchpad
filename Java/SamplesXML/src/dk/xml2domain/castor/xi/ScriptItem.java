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
 * Class ScriptItem.
 * 
 * @version $Revision$ $Date$
 */
public class ScriptItem implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Internal choice value storage
     */
    private java.lang.Object _choiceValue;

    /**
     * This is a placeholder for the process script elements
     */
    private java.util.Vector _scriptList;

    /**
     * Field _setList
     */
    private java.util.Vector _setList;

    /**
     * Field _allocateList
     */
    private java.util.Vector _allocateList;

    /**
     * Field _switchList
     */
    private java.util.Vector _switchList;

    /**
     * Field _failureList
     */
    private java.util.Vector _failureList;

    /**
     * Field _invokeList
     */
    private java.util.Vector _invokeList;

    /**
     * Field _produceList
     */
    private java.util.Vector _produceList;

    /**
     * Field _waitList
     */
    private java.util.Vector _waitList;

    /**
     * Field _oneventList
     */
    private java.util.Vector _oneventList;

    /**
     * Field _exitList
     */
    private java.util.Vector _exitList;

    /**
     * Field _manyList
     */
    private java.util.Vector _manyList;

    /**
     * Field _startList
     */
    private java.util.Vector _startList;


      //----------------/
     //- Constructors -/
    //----------------/

    public ScriptItem() 
     {
        super();
        _scriptList = new Vector();
        _setList = new Vector();
        _allocateList = new Vector();
        _switchList = new Vector();
        _failureList = new Vector();
        _invokeList = new Vector();
        _produceList = new Vector();
        _waitList = new Vector();
        _oneventList = new Vector();
        _exitList = new Vector();
        _manyList = new Vector();
        _startList = new Vector();
    } //-- dk.xml2domain.castor.xi.ScriptItem()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addAllocate
     * 
     * 
     * 
     * @param vAllocate
     */
    public void addAllocate(dk.xml2domain.castor.xi.Allocate vAllocate)
        throws java.lang.IndexOutOfBoundsException
    {
        _allocateList.addElement(vAllocate);
    } //-- void addAllocate(dk.xml2domain.castor.xi.Allocate) 

    /**
     * Method addAllocate
     * 
     * 
     * 
     * @param index
     * @param vAllocate
     */
    public void addAllocate(int index, dk.xml2domain.castor.xi.Allocate vAllocate)
        throws java.lang.IndexOutOfBoundsException
    {
        _allocateList.insertElementAt(vAllocate, index);
    } //-- void addAllocate(int, dk.xml2domain.castor.xi.Allocate) 

    /**
     * Method addExit
     * 
     * 
     * 
     * @param vExit
     */
    public void addExit(dk.xml2domain.castor.xi.Exit vExit)
        throws java.lang.IndexOutOfBoundsException
    {
        _exitList.addElement(vExit);
    } //-- void addExit(dk.xml2domain.castor.xi.Exit) 

    /**
     * Method addExit
     * 
     * 
     * 
     * @param index
     * @param vExit
     */
    public void addExit(int index, dk.xml2domain.castor.xi.Exit vExit)
        throws java.lang.IndexOutOfBoundsException
    {
        _exitList.insertElementAt(vExit, index);
    } //-- void addExit(int, dk.xml2domain.castor.xi.Exit) 

    /**
     * Method addFailure
     * 
     * 
     * 
     * @param vFailure
     */
    public void addFailure(dk.xml2domain.castor.xi.Failure vFailure)
        throws java.lang.IndexOutOfBoundsException
    {
        _failureList.addElement(vFailure);
    } //-- void addFailure(dk.xml2domain.castor.xi.Failure) 

    /**
     * Method addFailure
     * 
     * 
     * 
     * @param index
     * @param vFailure
     */
    public void addFailure(int index, dk.xml2domain.castor.xi.Failure vFailure)
        throws java.lang.IndexOutOfBoundsException
    {
        _failureList.insertElementAt(vFailure, index);
    } //-- void addFailure(int, dk.xml2domain.castor.xi.Failure) 

    /**
     * Method addInvoke
     * 
     * 
     * 
     * @param vInvoke
     */
    public void addInvoke(dk.xml2domain.castor.xi.Invoke vInvoke)
        throws java.lang.IndexOutOfBoundsException
    {
        _invokeList.addElement(vInvoke);
    } //-- void addInvoke(dk.xml2domain.castor.xi.Invoke) 

    /**
     * Method addInvoke
     * 
     * 
     * 
     * @param index
     * @param vInvoke
     */
    public void addInvoke(int index, dk.xml2domain.castor.xi.Invoke vInvoke)
        throws java.lang.IndexOutOfBoundsException
    {
        _invokeList.insertElementAt(vInvoke, index);
    } //-- void addInvoke(int, dk.xml2domain.castor.xi.Invoke) 

    /**
     * Method addMany
     * 
     * 
     * 
     * @param vMany
     */
    public void addMany(dk.xml2domain.castor.xi.Many vMany)
        throws java.lang.IndexOutOfBoundsException
    {
        _manyList.addElement(vMany);
    } //-- void addMany(dk.xml2domain.castor.xi.Many) 

    /**
     * Method addMany
     * 
     * 
     * 
     * @param index
     * @param vMany
     */
    public void addMany(int index, dk.xml2domain.castor.xi.Many vMany)
        throws java.lang.IndexOutOfBoundsException
    {
        _manyList.insertElementAt(vMany, index);
    } //-- void addMany(int, dk.xml2domain.castor.xi.Many) 

    /**
     * Method addOnevent
     * 
     * 
     * 
     * @param vOnevent
     */
    public void addOnevent(dk.xml2domain.castor.xi.Onevent vOnevent)
        throws java.lang.IndexOutOfBoundsException
    {
        _oneventList.addElement(vOnevent);
    } //-- void addOnevent(dk.xml2domain.castor.xi.Onevent) 

    /**
     * Method addOnevent
     * 
     * 
     * 
     * @param index
     * @param vOnevent
     */
    public void addOnevent(int index, dk.xml2domain.castor.xi.Onevent vOnevent)
        throws java.lang.IndexOutOfBoundsException
    {
        _oneventList.insertElementAt(vOnevent, index);
    } //-- void addOnevent(int, dk.xml2domain.castor.xi.Onevent) 

    /**
     * Method addProduce
     * 
     * 
     * 
     * @param vProduce
     */
    public void addProduce(dk.xml2domain.castor.xi.Produce vProduce)
        throws java.lang.IndexOutOfBoundsException
    {
        _produceList.addElement(vProduce);
    } //-- void addProduce(dk.xml2domain.castor.xi.Produce) 

    /**
     * Method addProduce
     * 
     * 
     * 
     * @param index
     * @param vProduce
     */
    public void addProduce(int index, dk.xml2domain.castor.xi.Produce vProduce)
        throws java.lang.IndexOutOfBoundsException
    {
        _produceList.insertElementAt(vProduce, index);
    } //-- void addProduce(int, dk.xml2domain.castor.xi.Produce) 

    /**
     * Method addScript
     * 
     * 
     * 
     * @param vScript
     */
    public void addScript(dk.xml2domain.castor.xi.Script vScript)
        throws java.lang.IndexOutOfBoundsException
    {
        _scriptList.addElement(vScript);
    } //-- void addScript(dk.xml2domain.castor.xi.Script) 

    /**
     * Method addScript
     * 
     * 
     * 
     * @param index
     * @param vScript
     */
    public void addScript(int index, dk.xml2domain.castor.xi.Script vScript)
        throws java.lang.IndexOutOfBoundsException
    {
        _scriptList.insertElementAt(vScript, index);
    } //-- void addScript(int, dk.xml2domain.castor.xi.Script) 

    /**
     * Method addSet
     * 
     * 
     * 
     * @param vSet
     */
    public void addSet(dk.xml2domain.castor.xi.Set vSet)
        throws java.lang.IndexOutOfBoundsException
    {
        _setList.addElement(vSet);
    } //-- void addSet(dk.xml2domain.castor.xi.Set) 

    /**
     * Method addSet
     * 
     * 
     * 
     * @param index
     * @param vSet
     */
    public void addSet(int index, dk.xml2domain.castor.xi.Set vSet)
        throws java.lang.IndexOutOfBoundsException
    {
        _setList.insertElementAt(vSet, index);
    } //-- void addSet(int, dk.xml2domain.castor.xi.Set) 

    /**
     * Method addStart
     * 
     * 
     * 
     * @param vStart
     */
    public void addStart(dk.xml2domain.castor.xi.Start vStart)
        throws java.lang.IndexOutOfBoundsException
    {
        _startList.addElement(vStart);
    } //-- void addStart(dk.xml2domain.castor.xi.Start) 

    /**
     * Method addStart
     * 
     * 
     * 
     * @param index
     * @param vStart
     */
    public void addStart(int index, dk.xml2domain.castor.xi.Start vStart)
        throws java.lang.IndexOutOfBoundsException
    {
        _startList.insertElementAt(vStart, index);
    } //-- void addStart(int, dk.xml2domain.castor.xi.Start) 

    /**
     * Method addSwitch
     * 
     * 
     * 
     * @param vSwitch
     */
    public void addSwitch(dk.xml2domain.castor.xi.Switch vSwitch)
        throws java.lang.IndexOutOfBoundsException
    {
        _switchList.addElement(vSwitch);
    } //-- void addSwitch(dk.xml2domain.castor.xi.Switch) 

    /**
     * Method addSwitch
     * 
     * 
     * 
     * @param index
     * @param vSwitch
     */
    public void addSwitch(int index, dk.xml2domain.castor.xi.Switch vSwitch)
        throws java.lang.IndexOutOfBoundsException
    {
        _switchList.insertElementAt(vSwitch, index);
    } //-- void addSwitch(int, dk.xml2domain.castor.xi.Switch) 

    /**
     * Method addWait
     * 
     * 
     * 
     * @param vWait
     */
    public void addWait(dk.xml2domain.castor.xi.Wait vWait)
        throws java.lang.IndexOutOfBoundsException
    {
        _waitList.addElement(vWait);
    } //-- void addWait(dk.xml2domain.castor.xi.Wait) 

    /**
     * Method addWait
     * 
     * 
     * 
     * @param index
     * @param vWait
     */
    public void addWait(int index, dk.xml2domain.castor.xi.Wait vWait)
        throws java.lang.IndexOutOfBoundsException
    {
        _waitList.insertElementAt(vWait, index);
    } //-- void addWait(int, dk.xml2domain.castor.xi.Wait) 

    /**
     * Method enumerateAllocate
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateAllocate()
    {
        return _allocateList.elements();
    } //-- java.util.Enumeration enumerateAllocate() 

    /**
     * Method enumerateExit
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateExit()
    {
        return _exitList.elements();
    } //-- java.util.Enumeration enumerateExit() 

    /**
     * Method enumerateFailure
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateFailure()
    {
        return _failureList.elements();
    } //-- java.util.Enumeration enumerateFailure() 

    /**
     * Method enumerateInvoke
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateInvoke()
    {
        return _invokeList.elements();
    } //-- java.util.Enumeration enumerateInvoke() 

    /**
     * Method enumerateMany
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateMany()
    {
        return _manyList.elements();
    } //-- java.util.Enumeration enumerateMany() 

    /**
     * Method enumerateOnevent
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateOnevent()
    {
        return _oneventList.elements();
    } //-- java.util.Enumeration enumerateOnevent() 

    /**
     * Method enumerateProduce
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateProduce()
    {
        return _produceList.elements();
    } //-- java.util.Enumeration enumerateProduce() 

    /**
     * Method enumerateScript
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateScript()
    {
        return _scriptList.elements();
    } //-- java.util.Enumeration enumerateScript() 

    /**
     * Method enumerateSet
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateSet()
    {
        return _setList.elements();
    } //-- java.util.Enumeration enumerateSet() 

    /**
     * Method enumerateStart
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateStart()
    {
        return _startList.elements();
    } //-- java.util.Enumeration enumerateStart() 

    /**
     * Method enumerateSwitch
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateSwitch()
    {
        return _switchList.elements();
    } //-- java.util.Enumeration enumerateSwitch() 

    /**
     * Method enumerateWait
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateWait()
    {
        return _waitList.elements();
    } //-- java.util.Enumeration enumerateWait() 

    /**
     * Method getAllocate
     * 
     * 
     * 
     * @param index
     * @return Allocate
     */
    public dk.xml2domain.castor.xi.Allocate getAllocate(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _allocateList.size())) {
            throw new IndexOutOfBoundsException("getAllocate: Index value '"+index+"' not in range [0.."+_allocateList.size()+ "]");
        }
        
        return (dk.xml2domain.castor.xi.Allocate) _allocateList.elementAt(index);
    } //-- dk.xml2domain.castor.xi.Allocate getAllocate(int) 

    /**
     * Method getAllocate
     * 
     * 
     * 
     * @return Allocate
     */
    public dk.xml2domain.castor.xi.Allocate[] getAllocate()
    {
        int size = _allocateList.size();
        dk.xml2domain.castor.xi.Allocate[] mArray = new dk.xml2domain.castor.xi.Allocate[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (dk.xml2domain.castor.xi.Allocate) _allocateList.elementAt(index);
        }
        return mArray;
    } //-- dk.xml2domain.castor.xi.Allocate[] getAllocate() 

    /**
     * Method getAllocateCount
     * 
     * 
     * 
     * @return int
     */
    public int getAllocateCount()
    {
        return _allocateList.size();
    } //-- int getAllocateCount() 

    /**
     * Returns the value of field 'choiceValue'. The field
     * 'choiceValue' has the following description: Internal choice
     * value storage
     * 
     * @return Object
     * @return the value of field 'choiceValue'.
     */
    public java.lang.Object getChoiceValue()
    {
        return this._choiceValue;
    } //-- java.lang.Object getChoiceValue() 

    /**
     * Method getExit
     * 
     * 
     * 
     * @param index
     * @return Exit
     */
    public dk.xml2domain.castor.xi.Exit getExit(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _exitList.size())) {
            throw new IndexOutOfBoundsException("getExit: Index value '"+index+"' not in range [0.."+_exitList.size()+ "]");
        }
        
        return (dk.xml2domain.castor.xi.Exit) _exitList.elementAt(index);
    } //-- dk.xml2domain.castor.xi.Exit getExit(int) 

    /**
     * Method getExit
     * 
     * 
     * 
     * @return Exit
     */
    public dk.xml2domain.castor.xi.Exit[] getExit()
    {
        int size = _exitList.size();
        dk.xml2domain.castor.xi.Exit[] mArray = new dk.xml2domain.castor.xi.Exit[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (dk.xml2domain.castor.xi.Exit) _exitList.elementAt(index);
        }
        return mArray;
    } //-- dk.xml2domain.castor.xi.Exit[] getExit() 

    /**
     * Method getExitCount
     * 
     * 
     * 
     * @return int
     */
    public int getExitCount()
    {
        return _exitList.size();
    } //-- int getExitCount() 

    /**
     * Method getFailure
     * 
     * 
     * 
     * @param index
     * @return Failure
     */
    public dk.xml2domain.castor.xi.Failure getFailure(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _failureList.size())) {
            throw new IndexOutOfBoundsException("getFailure: Index value '"+index+"' not in range [0.."+_failureList.size()+ "]");
        }
        
        return (dk.xml2domain.castor.xi.Failure) _failureList.elementAt(index);
    } //-- dk.xml2domain.castor.xi.Failure getFailure(int) 

    /**
     * Method getFailure
     * 
     * 
     * 
     * @return Failure
     */
    public dk.xml2domain.castor.xi.Failure[] getFailure()
    {
        int size = _failureList.size();
        dk.xml2domain.castor.xi.Failure[] mArray = new dk.xml2domain.castor.xi.Failure[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (dk.xml2domain.castor.xi.Failure) _failureList.elementAt(index);
        }
        return mArray;
    } //-- dk.xml2domain.castor.xi.Failure[] getFailure() 

    /**
     * Method getFailureCount
     * 
     * 
     * 
     * @return int
     */
    public int getFailureCount()
    {
        return _failureList.size();
    } //-- int getFailureCount() 

    /**
     * Method getInvoke
     * 
     * 
     * 
     * @param index
     * @return Invoke
     */
    public dk.xml2domain.castor.xi.Invoke getInvoke(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _invokeList.size())) {
            throw new IndexOutOfBoundsException("getInvoke: Index value '"+index+"' not in range [0.."+_invokeList.size()+ "]");
        }
        
        return (dk.xml2domain.castor.xi.Invoke) _invokeList.elementAt(index);
    } //-- dk.xml2domain.castor.xi.Invoke getInvoke(int) 

    /**
     * Method getInvoke
     * 
     * 
     * 
     * @return Invoke
     */
    public dk.xml2domain.castor.xi.Invoke[] getInvoke()
    {
        int size = _invokeList.size();
        dk.xml2domain.castor.xi.Invoke[] mArray = new dk.xml2domain.castor.xi.Invoke[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (dk.xml2domain.castor.xi.Invoke) _invokeList.elementAt(index);
        }
        return mArray;
    } //-- dk.xml2domain.castor.xi.Invoke[] getInvoke() 

    /**
     * Method getInvokeCount
     * 
     * 
     * 
     * @return int
     */
    public int getInvokeCount()
    {
        return _invokeList.size();
    } //-- int getInvokeCount() 

    /**
     * Method getMany
     * 
     * 
     * 
     * @param index
     * @return Many
     */
    public dk.xml2domain.castor.xi.Many getMany(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _manyList.size())) {
            throw new IndexOutOfBoundsException("getMany: Index value '"+index+"' not in range [0.."+_manyList.size()+ "]");
        }
        
        return (dk.xml2domain.castor.xi.Many) _manyList.elementAt(index);
    } //-- dk.xml2domain.castor.xi.Many getMany(int) 

    /**
     * Method getMany
     * 
     * 
     * 
     * @return Many
     */
    public dk.xml2domain.castor.xi.Many[] getMany()
    {
        int size = _manyList.size();
        dk.xml2domain.castor.xi.Many[] mArray = new dk.xml2domain.castor.xi.Many[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (dk.xml2domain.castor.xi.Many) _manyList.elementAt(index);
        }
        return mArray;
    } //-- dk.xml2domain.castor.xi.Many[] getMany() 

    /**
     * Method getManyCount
     * 
     * 
     * 
     * @return int
     */
    public int getManyCount()
    {
        return _manyList.size();
    } //-- int getManyCount() 

    /**
     * Method getOnevent
     * 
     * 
     * 
     * @param index
     * @return Onevent
     */
    public dk.xml2domain.castor.xi.Onevent getOnevent(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _oneventList.size())) {
            throw new IndexOutOfBoundsException("getOnevent: Index value '"+index+"' not in range [0.."+_oneventList.size()+ "]");
        }
        
        return (dk.xml2domain.castor.xi.Onevent) _oneventList.elementAt(index);
    } //-- dk.xml2domain.castor.xi.Onevent getOnevent(int) 

    /**
     * Method getOnevent
     * 
     * 
     * 
     * @return Onevent
     */
    public dk.xml2domain.castor.xi.Onevent[] getOnevent()
    {
        int size = _oneventList.size();
        dk.xml2domain.castor.xi.Onevent[] mArray = new dk.xml2domain.castor.xi.Onevent[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (dk.xml2domain.castor.xi.Onevent) _oneventList.elementAt(index);
        }
        return mArray;
    } //-- dk.xml2domain.castor.xi.Onevent[] getOnevent() 

    /**
     * Method getOneventCount
     * 
     * 
     * 
     * @return int
     */
    public int getOneventCount()
    {
        return _oneventList.size();
    } //-- int getOneventCount() 

    /**
     * Method getProduce
     * 
     * 
     * 
     * @param index
     * @return Produce
     */
    public dk.xml2domain.castor.xi.Produce getProduce(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _produceList.size())) {
            throw new IndexOutOfBoundsException("getProduce: Index value '"+index+"' not in range [0.."+_produceList.size()+ "]");
        }
        
        return (dk.xml2domain.castor.xi.Produce) _produceList.elementAt(index);
    } //-- dk.xml2domain.castor.xi.Produce getProduce(int) 

    /**
     * Method getProduce
     * 
     * 
     * 
     * @return Produce
     */
    public dk.xml2domain.castor.xi.Produce[] getProduce()
    {
        int size = _produceList.size();
        dk.xml2domain.castor.xi.Produce[] mArray = new dk.xml2domain.castor.xi.Produce[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (dk.xml2domain.castor.xi.Produce) _produceList.elementAt(index);
        }
        return mArray;
    } //-- dk.xml2domain.castor.xi.Produce[] getProduce() 

    /**
     * Method getProduceCount
     * 
     * 
     * 
     * @return int
     */
    public int getProduceCount()
    {
        return _produceList.size();
    } //-- int getProduceCount() 

    /**
     * Method getScript
     * 
     * 
     * 
     * @param index
     * @return Script
     */
    public dk.xml2domain.castor.xi.Script getScript(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _scriptList.size())) {
            throw new IndexOutOfBoundsException("getScript: Index value '"+index+"' not in range [0.."+_scriptList.size()+ "]");
        }
        
        return (dk.xml2domain.castor.xi.Script) _scriptList.elementAt(index);
    } //-- dk.xml2domain.castor.xi.Script getScript(int) 

    /**
     * Method getScript
     * 
     * 
     * 
     * @return Script
     */
    public dk.xml2domain.castor.xi.Script[] getScript()
    {
        int size = _scriptList.size();
        dk.xml2domain.castor.xi.Script[] mArray = new dk.xml2domain.castor.xi.Script[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (dk.xml2domain.castor.xi.Script) _scriptList.elementAt(index);
        }
        return mArray;
    } //-- dk.xml2domain.castor.xi.Script[] getScript() 

    /**
     * Method getScriptCount
     * 
     * 
     * 
     * @return int
     */
    public int getScriptCount()
    {
        return _scriptList.size();
    } //-- int getScriptCount() 

    /**
     * Method getSet
     * 
     * 
     * 
     * @param index
     * @return Set
     */
    public dk.xml2domain.castor.xi.Set getSet(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _setList.size())) {
            throw new IndexOutOfBoundsException("getSet: Index value '"+index+"' not in range [0.."+_setList.size()+ "]");
        }
        
        return (dk.xml2domain.castor.xi.Set) _setList.elementAt(index);
    } //-- dk.xml2domain.castor.xi.Set getSet(int) 

    /**
     * Method getSet
     * 
     * 
     * 
     * @return Set
     */
    public dk.xml2domain.castor.xi.Set[] getSet()
    {
        int size = _setList.size();
        dk.xml2domain.castor.xi.Set[] mArray = new dk.xml2domain.castor.xi.Set[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (dk.xml2domain.castor.xi.Set) _setList.elementAt(index);
        }
        return mArray;
    } //-- dk.xml2domain.castor.xi.Set[] getSet() 

    /**
     * Method getSetCount
     * 
     * 
     * 
     * @return int
     */
    public int getSetCount()
    {
        return _setList.size();
    } //-- int getSetCount() 

    /**
     * Method getStart
     * 
     * 
     * 
     * @param index
     * @return Start
     */
    public dk.xml2domain.castor.xi.Start getStart(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _startList.size())) {
            throw new IndexOutOfBoundsException("getStart: Index value '"+index+"' not in range [0.."+_startList.size()+ "]");
        }
        
        return (dk.xml2domain.castor.xi.Start) _startList.elementAt(index);
    } //-- dk.xml2domain.castor.xi.Start getStart(int) 

    /**
     * Method getStart
     * 
     * 
     * 
     * @return Start
     */
    public dk.xml2domain.castor.xi.Start[] getStart()
    {
        int size = _startList.size();
        dk.xml2domain.castor.xi.Start[] mArray = new dk.xml2domain.castor.xi.Start[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (dk.xml2domain.castor.xi.Start) _startList.elementAt(index);
        }
        return mArray;
    } //-- dk.xml2domain.castor.xi.Start[] getStart() 

    /**
     * Method getStartCount
     * 
     * 
     * 
     * @return int
     */
    public int getStartCount()
    {
        return _startList.size();
    } //-- int getStartCount() 

    /**
     * Method getSwitch
     * 
     * 
     * 
     * @param index
     * @return Switch
     */
    public dk.xml2domain.castor.xi.Switch getSwitch(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _switchList.size())) {
            throw new IndexOutOfBoundsException("getSwitch: Index value '"+index+"' not in range [0.."+_switchList.size()+ "]");
        }
        
        return (dk.xml2domain.castor.xi.Switch) _switchList.elementAt(index);
    } //-- dk.xml2domain.castor.xi.Switch getSwitch(int) 

    /**
     * Method getSwitch
     * 
     * 
     * 
     * @return Switch
     */
    public dk.xml2domain.castor.xi.Switch[] getSwitch()
    {
        int size = _switchList.size();
        dk.xml2domain.castor.xi.Switch[] mArray = new dk.xml2domain.castor.xi.Switch[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (dk.xml2domain.castor.xi.Switch) _switchList.elementAt(index);
        }
        return mArray;
    } //-- dk.xml2domain.castor.xi.Switch[] getSwitch() 

    /**
     * Method getSwitchCount
     * 
     * 
     * 
     * @return int
     */
    public int getSwitchCount()
    {
        return _switchList.size();
    } //-- int getSwitchCount() 

    /**
     * Method getWait
     * 
     * 
     * 
     * @param index
     * @return Wait
     */
    public dk.xml2domain.castor.xi.Wait getWait(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _waitList.size())) {
            throw new IndexOutOfBoundsException("getWait: Index value '"+index+"' not in range [0.."+_waitList.size()+ "]");
        }
        
        return (dk.xml2domain.castor.xi.Wait) _waitList.elementAt(index);
    } //-- dk.xml2domain.castor.xi.Wait getWait(int) 

    /**
     * Method getWait
     * 
     * 
     * 
     * @return Wait
     */
    public dk.xml2domain.castor.xi.Wait[] getWait()
    {
        int size = _waitList.size();
        dk.xml2domain.castor.xi.Wait[] mArray = new dk.xml2domain.castor.xi.Wait[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (dk.xml2domain.castor.xi.Wait) _waitList.elementAt(index);
        }
        return mArray;
    } //-- dk.xml2domain.castor.xi.Wait[] getWait() 

    /**
     * Method getWaitCount
     * 
     * 
     * 
     * @return int
     */
    public int getWaitCount()
    {
        return _waitList.size();
    } //-- int getWaitCount() 

    /**
     * Method removeAllAllocate
     * 
     */
    public void removeAllAllocate()
    {
        _allocateList.removeAllElements();
    } //-- void removeAllAllocate() 

    /**
     * Method removeAllExit
     * 
     */
    public void removeAllExit()
    {
        _exitList.removeAllElements();
    } //-- void removeAllExit() 

    /**
     * Method removeAllFailure
     * 
     */
    public void removeAllFailure()
    {
        _failureList.removeAllElements();
    } //-- void removeAllFailure() 

    /**
     * Method removeAllInvoke
     * 
     */
    public void removeAllInvoke()
    {
        _invokeList.removeAllElements();
    } //-- void removeAllInvoke() 

    /**
     * Method removeAllMany
     * 
     */
    public void removeAllMany()
    {
        _manyList.removeAllElements();
    } //-- void removeAllMany() 

    /**
     * Method removeAllOnevent
     * 
     */
    public void removeAllOnevent()
    {
        _oneventList.removeAllElements();
    } //-- void removeAllOnevent() 

    /**
     * Method removeAllProduce
     * 
     */
    public void removeAllProduce()
    {
        _produceList.removeAllElements();
    } //-- void removeAllProduce() 

    /**
     * Method removeAllScript
     * 
     */
    public void removeAllScript()
    {
        _scriptList.removeAllElements();
    } //-- void removeAllScript() 

    /**
     * Method removeAllSet
     * 
     */
    public void removeAllSet()
    {
        _setList.removeAllElements();
    } //-- void removeAllSet() 

    /**
     * Method removeAllStart
     * 
     */
    public void removeAllStart()
    {
        _startList.removeAllElements();
    } //-- void removeAllStart() 

    /**
     * Method removeAllSwitch
     * 
     */
    public void removeAllSwitch()
    {
        _switchList.removeAllElements();
    } //-- void removeAllSwitch() 

    /**
     * Method removeAllWait
     * 
     */
    public void removeAllWait()
    {
        _waitList.removeAllElements();
    } //-- void removeAllWait() 

    /**
     * Method removeAllocate
     * 
     * 
     * 
     * @param index
     * @return Allocate
     */
    public dk.xml2domain.castor.xi.Allocate removeAllocate(int index)
    {
        java.lang.Object obj = _allocateList.elementAt(index);
        _allocateList.removeElementAt(index);
        return (dk.xml2domain.castor.xi.Allocate) obj;
    } //-- dk.xml2domain.castor.xi.Allocate removeAllocate(int) 

    /**
     * Method removeExit
     * 
     * 
     * 
     * @param index
     * @return Exit
     */
    public dk.xml2domain.castor.xi.Exit removeExit(int index)
    {
        java.lang.Object obj = _exitList.elementAt(index);
        _exitList.removeElementAt(index);
        return (dk.xml2domain.castor.xi.Exit) obj;
    } //-- dk.xml2domain.castor.xi.Exit removeExit(int) 

    /**
     * Method removeFailure
     * 
     * 
     * 
     * @param index
     * @return Failure
     */
    public dk.xml2domain.castor.xi.Failure removeFailure(int index)
    {
        java.lang.Object obj = _failureList.elementAt(index);
        _failureList.removeElementAt(index);
        return (dk.xml2domain.castor.xi.Failure) obj;
    } //-- dk.xml2domain.castor.xi.Failure removeFailure(int) 

    /**
     * Method removeInvoke
     * 
     * 
     * 
     * @param index
     * @return Invoke
     */
    public dk.xml2domain.castor.xi.Invoke removeInvoke(int index)
    {
        java.lang.Object obj = _invokeList.elementAt(index);
        _invokeList.removeElementAt(index);
        return (dk.xml2domain.castor.xi.Invoke) obj;
    } //-- dk.xml2domain.castor.xi.Invoke removeInvoke(int) 

    /**
     * Method removeMany
     * 
     * 
     * 
     * @param index
     * @return Many
     */
    public dk.xml2domain.castor.xi.Many removeMany(int index)
    {
        java.lang.Object obj = _manyList.elementAt(index);
        _manyList.removeElementAt(index);
        return (dk.xml2domain.castor.xi.Many) obj;
    } //-- dk.xml2domain.castor.xi.Many removeMany(int) 

    /**
     * Method removeOnevent
     * 
     * 
     * 
     * @param index
     * @return Onevent
     */
    public dk.xml2domain.castor.xi.Onevent removeOnevent(int index)
    {
        java.lang.Object obj = _oneventList.elementAt(index);
        _oneventList.removeElementAt(index);
        return (dk.xml2domain.castor.xi.Onevent) obj;
    } //-- dk.xml2domain.castor.xi.Onevent removeOnevent(int) 

    /**
     * Method removeProduce
     * 
     * 
     * 
     * @param index
     * @return Produce
     */
    public dk.xml2domain.castor.xi.Produce removeProduce(int index)
    {
        java.lang.Object obj = _produceList.elementAt(index);
        _produceList.removeElementAt(index);
        return (dk.xml2domain.castor.xi.Produce) obj;
    } //-- dk.xml2domain.castor.xi.Produce removeProduce(int) 

    /**
     * Method removeScript
     * 
     * 
     * 
     * @param index
     * @return Script
     */
    public dk.xml2domain.castor.xi.Script removeScript(int index)
    {
        java.lang.Object obj = _scriptList.elementAt(index);
        _scriptList.removeElementAt(index);
        return (dk.xml2domain.castor.xi.Script) obj;
    } //-- dk.xml2domain.castor.xi.Script removeScript(int) 

    /**
     * Method removeSet
     * 
     * 
     * 
     * @param index
     * @return Set
     */
    public dk.xml2domain.castor.xi.Set removeSet(int index)
    {
        java.lang.Object obj = _setList.elementAt(index);
        _setList.removeElementAt(index);
        return (dk.xml2domain.castor.xi.Set) obj;
    } //-- dk.xml2domain.castor.xi.Set removeSet(int) 

    /**
     * Method removeStart
     * 
     * 
     * 
     * @param index
     * @return Start
     */
    public dk.xml2domain.castor.xi.Start removeStart(int index)
    {
        java.lang.Object obj = _startList.elementAt(index);
        _startList.removeElementAt(index);
        return (dk.xml2domain.castor.xi.Start) obj;
    } //-- dk.xml2domain.castor.xi.Start removeStart(int) 

    /**
     * Method removeSwitch
     * 
     * 
     * 
     * @param index
     * @return Switch
     */
    public dk.xml2domain.castor.xi.Switch removeSwitch(int index)
    {
        java.lang.Object obj = _switchList.elementAt(index);
        _switchList.removeElementAt(index);
        return (dk.xml2domain.castor.xi.Switch) obj;
    } //-- dk.xml2domain.castor.xi.Switch removeSwitch(int) 

    /**
     * Method removeWait
     * 
     * 
     * 
     * @param index
     * @return Wait
     */
    public dk.xml2domain.castor.xi.Wait removeWait(int index)
    {
        java.lang.Object obj = _waitList.elementAt(index);
        _waitList.removeElementAt(index);
        return (dk.xml2domain.castor.xi.Wait) obj;
    } //-- dk.xml2domain.castor.xi.Wait removeWait(int) 

    /**
     * Method setAllocate
     * 
     * 
     * 
     * @param index
     * @param vAllocate
     */
    public void setAllocate(int index, dk.xml2domain.castor.xi.Allocate vAllocate)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _allocateList.size())) {
            throw new IndexOutOfBoundsException("setAllocate: Index value '"+index+"' not in range [0.."+_allocateList.size()+ "]");
        }
        _allocateList.setElementAt(vAllocate, index);
    } //-- void setAllocate(int, dk.xml2domain.castor.xi.Allocate) 

    /**
     * Method setAllocate
     * 
     * 
     * 
     * @param allocateArray
     */
    public void setAllocate(dk.xml2domain.castor.xi.Allocate[] allocateArray)
    {
        //-- copy array
        _allocateList.removeAllElements();
        for (int i = 0; i < allocateArray.length; i++) {
            _allocateList.addElement(allocateArray[i]);
        }
    } //-- void setAllocate(dk.xml2domain.castor.xi.Allocate) 

    /**
     * Method setExit
     * 
     * 
     * 
     * @param index
     * @param vExit
     */
    public void setExit(int index, dk.xml2domain.castor.xi.Exit vExit)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _exitList.size())) {
            throw new IndexOutOfBoundsException("setExit: Index value '"+index+"' not in range [0.."+_exitList.size()+ "]");
        }
        _exitList.setElementAt(vExit, index);
    } //-- void setExit(int, dk.xml2domain.castor.xi.Exit) 

    /**
     * Method setExit
     * 
     * 
     * 
     * @param exitArray
     */
    public void setExit(dk.xml2domain.castor.xi.Exit[] exitArray)
    {
        //-- copy array
        _exitList.removeAllElements();
        for (int i = 0; i < exitArray.length; i++) {
            _exitList.addElement(exitArray[i]);
        }
    } //-- void setExit(dk.xml2domain.castor.xi.Exit) 

    /**
     * Method setFailure
     * 
     * 
     * 
     * @param index
     * @param vFailure
     */
    public void setFailure(int index, dk.xml2domain.castor.xi.Failure vFailure)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _failureList.size())) {
            throw new IndexOutOfBoundsException("setFailure: Index value '"+index+"' not in range [0.."+_failureList.size()+ "]");
        }
        _failureList.setElementAt(vFailure, index);
    } //-- void setFailure(int, dk.xml2domain.castor.xi.Failure) 

    /**
     * Method setFailure
     * 
     * 
     * 
     * @param failureArray
     */
    public void setFailure(dk.xml2domain.castor.xi.Failure[] failureArray)
    {
        //-- copy array
        _failureList.removeAllElements();
        for (int i = 0; i < failureArray.length; i++) {
            _failureList.addElement(failureArray[i]);
        }
    } //-- void setFailure(dk.xml2domain.castor.xi.Failure) 

    /**
     * Method setInvoke
     * 
     * 
     * 
     * @param index
     * @param vInvoke
     */
    public void setInvoke(int index, dk.xml2domain.castor.xi.Invoke vInvoke)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _invokeList.size())) {
            throw new IndexOutOfBoundsException("setInvoke: Index value '"+index+"' not in range [0.."+_invokeList.size()+ "]");
        }
        _invokeList.setElementAt(vInvoke, index);
    } //-- void setInvoke(int, dk.xml2domain.castor.xi.Invoke) 

    /**
     * Method setInvoke
     * 
     * 
     * 
     * @param invokeArray
     */
    public void setInvoke(dk.xml2domain.castor.xi.Invoke[] invokeArray)
    {
        //-- copy array
        _invokeList.removeAllElements();
        for (int i = 0; i < invokeArray.length; i++) {
            _invokeList.addElement(invokeArray[i]);
        }
    } //-- void setInvoke(dk.xml2domain.castor.xi.Invoke) 

    /**
     * Method setMany
     * 
     * 
     * 
     * @param index
     * @param vMany
     */
    public void setMany(int index, dk.xml2domain.castor.xi.Many vMany)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _manyList.size())) {
            throw new IndexOutOfBoundsException("setMany: Index value '"+index+"' not in range [0.."+_manyList.size()+ "]");
        }
        _manyList.setElementAt(vMany, index);
    } //-- void setMany(int, dk.xml2domain.castor.xi.Many) 

    /**
     * Method setMany
     * 
     * 
     * 
     * @param manyArray
     */
    public void setMany(dk.xml2domain.castor.xi.Many[] manyArray)
    {
        //-- copy array
        _manyList.removeAllElements();
        for (int i = 0; i < manyArray.length; i++) {
            _manyList.addElement(manyArray[i]);
        }
    } //-- void setMany(dk.xml2domain.castor.xi.Many) 

    /**
     * Method setOnevent
     * 
     * 
     * 
     * @param index
     * @param vOnevent
     */
    public void setOnevent(int index, dk.xml2domain.castor.xi.Onevent vOnevent)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _oneventList.size())) {
            throw new IndexOutOfBoundsException("setOnevent: Index value '"+index+"' not in range [0.."+_oneventList.size()+ "]");
        }
        _oneventList.setElementAt(vOnevent, index);
    } //-- void setOnevent(int, dk.xml2domain.castor.xi.Onevent) 

    /**
     * Method setOnevent
     * 
     * 
     * 
     * @param oneventArray
     */
    public void setOnevent(dk.xml2domain.castor.xi.Onevent[] oneventArray)
    {
        //-- copy array
        _oneventList.removeAllElements();
        for (int i = 0; i < oneventArray.length; i++) {
            _oneventList.addElement(oneventArray[i]);
        }
    } //-- void setOnevent(dk.xml2domain.castor.xi.Onevent) 

    /**
     * Method setProduce
     * 
     * 
     * 
     * @param index
     * @param vProduce
     */
    public void setProduce(int index, dk.xml2domain.castor.xi.Produce vProduce)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _produceList.size())) {
            throw new IndexOutOfBoundsException("setProduce: Index value '"+index+"' not in range [0.."+_produceList.size()+ "]");
        }
        _produceList.setElementAt(vProduce, index);
    } //-- void setProduce(int, dk.xml2domain.castor.xi.Produce) 

    /**
     * Method setProduce
     * 
     * 
     * 
     * @param produceArray
     */
    public void setProduce(dk.xml2domain.castor.xi.Produce[] produceArray)
    {
        //-- copy array
        _produceList.removeAllElements();
        for (int i = 0; i < produceArray.length; i++) {
            _produceList.addElement(produceArray[i]);
        }
    } //-- void setProduce(dk.xml2domain.castor.xi.Produce) 

    /**
     * Method setScript
     * 
     * 
     * 
     * @param index
     * @param vScript
     */
    public void setScript(int index, dk.xml2domain.castor.xi.Script vScript)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _scriptList.size())) {
            throw new IndexOutOfBoundsException("setScript: Index value '"+index+"' not in range [0.."+_scriptList.size()+ "]");
        }
        _scriptList.setElementAt(vScript, index);
    } //-- void setScript(int, dk.xml2domain.castor.xi.Script) 

    /**
     * Method setScript
     * 
     * 
     * 
     * @param scriptArray
     */
    public void setScript(dk.xml2domain.castor.xi.Script[] scriptArray)
    {
        //-- copy array
        _scriptList.removeAllElements();
        for (int i = 0; i < scriptArray.length; i++) {
            _scriptList.addElement(scriptArray[i]);
        }
    } //-- void setScript(dk.xml2domain.castor.xi.Script) 

    /**
     * Method setSet
     * 
     * 
     * 
     * @param index
     * @param vSet
     */
    public void setSet(int index, dk.xml2domain.castor.xi.Set vSet)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _setList.size())) {
            throw new IndexOutOfBoundsException("setSet: Index value '"+index+"' not in range [0.."+_setList.size()+ "]");
        }
        _setList.setElementAt(vSet, index);
    } //-- void setSet(int, dk.xml2domain.castor.xi.Set) 

    /**
     * Method setSet
     * 
     * 
     * 
     * @param setArray
     */
    public void setSet(dk.xml2domain.castor.xi.Set[] setArray)
    {
        //-- copy array
        _setList.removeAllElements();
        for (int i = 0; i < setArray.length; i++) {
            _setList.addElement(setArray[i]);
        }
    } //-- void setSet(dk.xml2domain.castor.xi.Set) 

    /**
     * Method setStart
     * 
     * 
     * 
     * @param index
     * @param vStart
     */
    public void setStart(int index, dk.xml2domain.castor.xi.Start vStart)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _startList.size())) {
            throw new IndexOutOfBoundsException("setStart: Index value '"+index+"' not in range [0.."+_startList.size()+ "]");
        }
        _startList.setElementAt(vStart, index);
    } //-- void setStart(int, dk.xml2domain.castor.xi.Start) 

    /**
     * Method setStart
     * 
     * 
     * 
     * @param startArray
     */
    public void setStart(dk.xml2domain.castor.xi.Start[] startArray)
    {
        //-- copy array
        _startList.removeAllElements();
        for (int i = 0; i < startArray.length; i++) {
            _startList.addElement(startArray[i]);
        }
    } //-- void setStart(dk.xml2domain.castor.xi.Start) 

    /**
     * Method setSwitch
     * 
     * 
     * 
     * @param index
     * @param vSwitch
     */
    public void setSwitch(int index, dk.xml2domain.castor.xi.Switch vSwitch)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _switchList.size())) {
            throw new IndexOutOfBoundsException("setSwitch: Index value '"+index+"' not in range [0.."+_switchList.size()+ "]");
        }
        _switchList.setElementAt(vSwitch, index);
    } //-- void setSwitch(int, dk.xml2domain.castor.xi.Switch) 

    /**
     * Method setSwitch
     * 
     * 
     * 
     * @param _switchArray
     */
    public void setSwitch(dk.xml2domain.castor.xi.Switch[] _switchArray)
    {
        //-- copy array
        _switchList.removeAllElements();
        for (int i = 0; i < _switchArray.length; i++) {
            _switchList.addElement(_switchArray[i]);
        }
    } //-- void setSwitch(dk.xml2domain.castor.xi.Switch) 

    /**
     * Method setWait
     * 
     * 
     * 
     * @param index
     * @param vWait
     */
    public void setWait(int index, dk.xml2domain.castor.xi.Wait vWait)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _waitList.size())) {
            throw new IndexOutOfBoundsException("setWait: Index value '"+index+"' not in range [0.."+_waitList.size()+ "]");
        }
        _waitList.setElementAt(vWait, index);
    } //-- void setWait(int, dk.xml2domain.castor.xi.Wait) 

    /**
     * Method setWait
     * 
     * 
     * 
     * @param waitArray
     */
    public void setWait(dk.xml2domain.castor.xi.Wait[] waitArray)
    {
        //-- copy array
        _waitList.removeAllElements();
        for (int i = 0; i < waitArray.length; i++) {
            _waitList.addElement(waitArray[i]);
        }
    } //-- void setWait(dk.xml2domain.castor.xi.Wait) 

}
