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

import org.exolab.castor.mapping.AccessMode;
import org.exolab.castor.xml.TypeValidator;
import org.exolab.castor.xml.XMLFieldDescriptor;
import org.exolab.castor.xml.validators.*;

/**
 * Class ArtifactsItemDescriptor.
 * 
 * @version $Revision$ $Date$
 */
public class ArtifactsItemDescriptor extends org.exolab.castor.xml.util.XMLClassDescriptorImpl {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field nsPrefix
     */
    private java.lang.String nsPrefix;

    /**
     * Field nsURI
     */
    private java.lang.String nsURI;

    /**
     * Field xmlName
     */
    private java.lang.String xmlName;

    /**
     * Field identity
     */
    private org.exolab.castor.xml.XMLFieldDescriptor identity;


      //----------------/
     //- Constructors -/
    //----------------/

    public ArtifactsItemDescriptor() 
     {
        super();
        nsURI = "http://functionpro.com/schema/xi";
        xmlName = "artifacts";
        
        //-- set grouping compositor
        setCompositorAsChoice();
        org.exolab.castor.xml.util.XMLFieldDescriptorImpl  desc           = null;
        org.exolab.castor.mapping.FieldHandler             handler        = null;
        org.exolab.castor.xml.FieldValidator               fieldValidator = null;
        //-- initialize attribute descriptors
        
        //-- initialize element descriptors
        
        //-- _eventList
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(dk.xml2domain.castor.xi.Event.class, "_eventList", "event", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                ArtifactsItem target = (ArtifactsItem) object;
                return target.getEvent();
            }
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    ArtifactsItem target = (ArtifactsItem) object;
                    target.addEvent( (dk.xml2domain.castor.xi.Event) value);
                }
                catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public java.lang.Object newInstance( java.lang.Object parent ) {
                return new dk.xml2domain.castor.xi.Event();
            }
        };
        desc.setHandler(handler);
        desc.setNameSpaceURI("http://functionpro.com/schema/xi");
        desc.setMultivalued(true);
        addFieldDescriptor(desc);
        
        //-- validation code for: _eventList
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        fieldValidator.setMinOccurs(0);
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _documentList
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(dk.xml2domain.castor.xi.Document.class, "_documentList", "document", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                ArtifactsItem target = (ArtifactsItem) object;
                return target.getDocument();
            }
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    ArtifactsItem target = (ArtifactsItem) object;
                    target.addDocument( (dk.xml2domain.castor.xi.Document) value);
                }
                catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public java.lang.Object newInstance( java.lang.Object parent ) {
                return new dk.xml2domain.castor.xi.Document();
            }
        };
        desc.setHandler(handler);
        desc.setNameSpaceURI("http://functionpro.com/schema/xi");
        desc.setMultivalued(true);
        addFieldDescriptor(desc);
        
        //-- validation code for: _documentList
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        fieldValidator.setMinOccurs(0);
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _variantList
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(dk.xml2domain.castor.xi.Variant.class, "_variantList", "variant", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                ArtifactsItem target = (ArtifactsItem) object;
                return target.getVariant();
            }
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    ArtifactsItem target = (ArtifactsItem) object;
                    target.addVariant( (dk.xml2domain.castor.xi.Variant) value);
                }
                catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public java.lang.Object newInstance( java.lang.Object parent ) {
                return new dk.xml2domain.castor.xi.Variant();
            }
        };
        desc.setHandler(handler);
        desc.setNameSpaceURI("http://functionpro.com/schema/xi");
        desc.setMultivalued(true);
        addFieldDescriptor(desc);
        
        //-- validation code for: _variantList
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        fieldValidator.setMinOccurs(0);
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _roleList
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(dk.xml2domain.castor.xi.Role.class, "_roleList", "role", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                ArtifactsItem target = (ArtifactsItem) object;
                return target.getRole();
            }
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    ArtifactsItem target = (ArtifactsItem) object;
                    target.addRole( (dk.xml2domain.castor.xi.Role) value);
                }
                catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public java.lang.Object newInstance( java.lang.Object parent ) {
                return new dk.xml2domain.castor.xi.Role();
            }
        };
        desc.setHandler(handler);
        desc.setNameSpaceURI("http://functionpro.com/schema/xi");
        desc.setMultivalued(true);
        addFieldDescriptor(desc);
        
        //-- validation code for: _roleList
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        fieldValidator.setMinOccurs(0);
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- _productList
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(dk.xml2domain.castor.xi.Product.class, "_productList", "product", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                ArtifactsItem target = (ArtifactsItem) object;
                return target.getProduct();
            }
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    ArtifactsItem target = (ArtifactsItem) object;
                    target.addProduct( (dk.xml2domain.castor.xi.Product) value);
                }
                catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            public java.lang.Object newInstance( java.lang.Object parent ) {
                return new dk.xml2domain.castor.xi.Product();
            }
        };
        desc.setHandler(handler);
        desc.setNameSpaceURI("http://functionpro.com/schema/xi");
        desc.setMultivalued(true);
        addFieldDescriptor(desc);
        
        //-- validation code for: _productList
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        fieldValidator.setMinOccurs(0);
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
    } //-- dk.xml2domain.castor.xi.ArtifactsItemDescriptor()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method getAccessMode
     * 
     * 
     * 
     * @return AccessMode
     */
    public org.exolab.castor.mapping.AccessMode getAccessMode()
    {
        return null;
    } //-- org.exolab.castor.mapping.AccessMode getAccessMode() 

    /**
     * Method getExtends
     * 
     * 
     * 
     * @return ClassDescriptor
     */
    public org.exolab.castor.mapping.ClassDescriptor getExtends()
    {
        return null;
    } //-- org.exolab.castor.mapping.ClassDescriptor getExtends() 

    /**
     * Method getIdentity
     * 
     * 
     * 
     * @return FieldDescriptor
     */
    public org.exolab.castor.mapping.FieldDescriptor getIdentity()
    {
        return identity;
    } //-- org.exolab.castor.mapping.FieldDescriptor getIdentity() 

    /**
     * Method getJavaClass
     * 
     * 
     * 
     * @return Class
     */
    public java.lang.Class getJavaClass()
    {
        return dk.xml2domain.castor.xi.ArtifactsItem.class;
    } //-- java.lang.Class getJavaClass() 

    /**
     * Method getNameSpacePrefix
     * 
     * 
     * 
     * @return String
     */
    public java.lang.String getNameSpacePrefix()
    {
        return nsPrefix;
    } //-- java.lang.String getNameSpacePrefix() 

    /**
     * Method getNameSpaceURI
     * 
     * 
     * 
     * @return String
     */
    public java.lang.String getNameSpaceURI()
    {
        return nsURI;
    } //-- java.lang.String getNameSpaceURI() 

    /**
     * Method getValidator
     * 
     * 
     * 
     * @return TypeValidator
     */
    public org.exolab.castor.xml.TypeValidator getValidator()
    {
        return this;
    } //-- org.exolab.castor.xml.TypeValidator getValidator() 

    /**
     * Method getXMLName
     * 
     * 
     * 
     * @return String
     */
    public java.lang.String getXMLName()
    {
        return xmlName;
    } //-- java.lang.String getXMLName() 

}
