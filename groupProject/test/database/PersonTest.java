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
    
    public PersonTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        String p1Name = "p1";
        String p2Name = "p2";
        String p1Password = "123";
        String p2Password  = "123";
        String p1Email = "1email";
        String p2Email = "2email";
        Person p1 = new Person(p1Name,p1Password,p1Email);
        Person p2 = new Person(p2Name, p2Password, p2Email);
    }

    private Person person;

    @Before
    public void setUp() {
        person = new Person("name", "password", "email");
    }

    /**
     * Test of getFightChallenges method, of class Person.
     */
    @Test
    public void testGetFightChallenges() {
        System.out.println("getFightChallenges");
        Person instance = new Person();
        ArrayList expResult = null;
        ArrayList result = instance.getFightChallenges();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFightOffers method, of class Person.
     */
    @Test
    public void testGetFightOffers() {
        System.out.println("getFightOffers");
        Person instance = new Person();
        ArrayList expResult = null;
        ArrayList result = instance.getFightOffers();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllFights method, of class Person.
     */
    @Test
    public void testGetAllFights() {
        System.out.println("getAllFights");
        Person instance = new Person();
        ArrayList expResult = null;
        ArrayList result = instance.getAllFights();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addFightOffer method, of class Person.
     */
    @Test
    public void testAddFightOffer() {
        System.out.println("addFightOffer");
        Person opponent = null;
        Monster oppMonster = null;
        Monster challMonster = null;
        Person instance = new Person();
        instance.addFightOffer(opponent, oppMonster, challMonster);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeFightOffer method, of class Person.
     */
    @Test
    public void testRemoveFightOffer_Fight() {
        System.out.println("removeFightOffer");
        Fight fight = null;
        Person instance = new Person();
        instance.removeFightOffer(fight);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeFightOffer method, of class Person.
     */
    @Test
    public void testRemoveFightOffer_Person_Monster() {
        System.out.println("removeFightOffer");
        Person opponent = null;
        Monster oppMonster = null;
        Person instance = new Person();
        instance.removeFightOffer(opponent, oppMonster);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFightByID method, of class Person.
     */
    @Test
    public void testGetFightByID() {
        System.out.println("getFightByID");
        String id = "";
        Person instance = new Person();
        Fight expResult = null;
        Fight result = instance.getFightByID(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllFriendRequests method, of class Person.
     */
    @Test
    public void testGetAllFriendRequests() {
        System.out.println("getAllFriendRequests");
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
        System.out.println("addFriendRequest");
        String email = "";
        Person instance = new Person();
        instance.addFriendRequest(email);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
        System.out.println("getMoney");
        Person instance = new Person();
        int expResult = 0;
        int result = instance.getMoney();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
        System.out.println("getId");
        Person instance = new Person();
        Long expResult = null;
        Long result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class Person.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        Long id = null;
        Person instance = new Person();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class Person.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Person instance = new Person();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
