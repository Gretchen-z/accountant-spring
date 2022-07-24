
package ru.gretchen.accountantspring.soap;

import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ru.gretchen.accountant.soap package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ru.gretchen.accountant.soap
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link User }
     * 
     */
    public User createUser() {
        return new User();
    }

    /**
     * Create an instance of {@link SetOfUser }
     * 
     */
    public SetOfUser createSetOfUser() {
        return new SetOfUser();
    }

    /**
     * Create an instance of {@link SetOfObject }
     * 
     */
    public SetOfObject createSetOfObject() {
        return new SetOfObject();
    }

    /**
     * Create an instance of {@link SetOfString }
     * 
     */
    public SetOfString createSetOfString() {
        return new SetOfString();
    }

}
