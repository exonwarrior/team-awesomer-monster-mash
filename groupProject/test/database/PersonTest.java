/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import types.Fight;

/**
 *
 * @author thomas
 */
public class PersonTest {
    private Person person;

    public PersonTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        String p1Name = "p1";
        String p2Name = "p2";
        String p1Password = "123";
        String p2Password = "123";
        String p1Email = "1email";
        String p2Email = "2email";
        Person p1 = new Person(p1Name, p1Password, p1Email);
        Person p2 = new Person(p2Name, p2Password, p2Email);
    }

    @Before
    public void setUp() {
        person = new Person("name", "password", "email");

    }

    /**
     * Test of getAllFriendRequests method, of class Person.
     */
    @Test
    public void testGetAllFriendRequests() {
        Person instance = new Person();
        ArrayList expResult = null;
        ArrayList result = instance.getAllFriendRequests();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getActivity method, of class Person.
     */
    @Test
    public void testGetActivity() {
        System.out.println("getActivity");
        Person instance = new Person();
        ArrayList expResult = null;
        ArrayList result = instance.getActivity();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addActivity method, of class Person.
     */
    @Test
    public void testAddActivity() {
        System.out.println("addActivity");
        String active = "";
        Person instance = new Person();
        instance.addActivity(active);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addFriendRequest method, of class Person.
     */
    @Test
    public void testAddFriendRequest() {
       
    }

    /**
     * Test of removeFriendRequest method, of class Person.
     */
    @Test
    public void testRemoveFriendRequest() {
        System.out.println("removeFriendRequest");
        String email = "";
        Person instance = new Person();
        instance.removeFriendRequest(email);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllFriends method, of class Person.
     */
    @Test
    public void testGetAllFriends() {
        System.out.println("getAllFriends");
        Person instance = new Person();
        ArrayList expResult = null;
        ArrayList result = instance.getAllFriends();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addFriend method, of class Person.
     */
    @Test
    public void testAddFriend() {
        System.out.println("addFriend");
        String email = "";
        Person instance = new Person();
        instance.addFriend(email);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeFriend method, of class Person.
     */
    @Test
    public void testRemoveFriend() {
        System.out.println("removeFriend");
        String email = "";
        Person instance = new Person();
        instance.removeFriend(email);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetAllMonsters() {
        System.out.println("getAllMonsters");
        Person instance = new Person();
        ArrayList expResult = null;
        // ArrayList result = instance.getAllMonsters();
        //   assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addMonster method, of class Person.
     */
    @Test
    public void testAddMonster() {
        System.out.println("addMonster");
        String id = "";
        Person instance = new Person();
        // instance.addMonster(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEmail method, of class Person.
     */
    @Test
    public void testSetEmail() {
        String email = "newEmail";
        person.setEmail(email);
        String newEmail = person.getEmail();
        assertEquals(email, newEmail);
    }

    /**
     * Test of setMoney method, of class Person.
     */
    @Test
    public void testSetMoney() {
        int money = 1234;
        person.setMoney(money);
        int newMoney = person.getMoney();
        assertEquals(money, newMoney);
    }

    /**
     * Test of setName method, of class Person.
     */
    @Test
    public void testSetName() {
        String name = "newName";
        person.setName(name);
        String newName = person.getName();
        assertEquals(name, newName);
    }

    /**
     * Test of setPassword method, of class Person.
     */
    @Test
    public void testSetPassword() {
        String password = "newPassword";
        person.setPassword(password);
        String newPassword = person.getPassword();
        assertEquals(password, newPassword);
    }

    /**
     * Test of getEmail method, of class Person.
     */
    @Test
    public void testGetEmail() {
        String expResult = "email";
        String result = person.getPassword();
        assertEquals(expResult, result);
    }

    /**
     * Test of getMoney method, of class Person.
     */
    @Test
    public void testGetMoney() {
        int money = 1234;
        person.setMoney(money);
        int newMoney = person.getMoney();
        assertEquals(money, newMoney);
    }

    /**
     * Test of getName method, of class Person.
     */
    @Test
    public void testGetName() {
        String expResult = "name";
        String result = person.getPassword();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPassword method, of class Person.
     */
    @Test
    public void testGetPassword() {
        String expResult = "password";
        String result = person.getPassword();
        assertEquals(expResult, result);
    }

    /**
     * Test of getId method, of class Person.
     */
    @Test
    public void testGetId() {
        Long id = new Long(1234);
        person.setId(id);
        Long newId = new Long(person.getId());
        assertEquals(id, newId);
    }

    /**
     * Test of setId method, of class Person.
     */
    @Test
    public void testSetId() {
        Long id = new Long(1234);
        person.setId(id);
        Long newId = new Long(person.getId());
        assertEquals(id, newId);
    }

    /**
     * Test of equals method, of class Person.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        Person instance = new Person();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
