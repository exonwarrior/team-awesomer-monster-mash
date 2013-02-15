/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import javax.ejb.EJB;
import javax.ejb.embeddable.EJBContainer;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author thomas
 */
public class PersonDOATest {
    
    @EJB PersonDOA poa;
    
    public PersonDOATest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getPersonByName method, of class PersonDOA.
     */
    @Test
    public void testGetPersonByName() throws Exception {
        System.out.println("getPersonByName");
        poa = new PersonDOA();
        //Person p = new Person("tom", "123", "email");
        //poa.persist(p);
        
        Person p = poa.getPersonByEmail("thom@bla.com");
  //      System.out.print(p.getAllMonsters().get(0).toString());
    }

}
