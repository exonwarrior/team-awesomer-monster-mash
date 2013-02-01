/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author thomas
 */
public class PersonTest {

    private Person person;

    @Before
    public void setUp() {
        person = new Person("name", "password", "email");

    }

    /**
     * Test of addActivity method, of class Person.
     */
    @Test
    public void testAddActivity() {
        for (int i = 0; i < 3; i++) {
            person.addActivity("" + 1);
        }
        assertEquals(person.getActivity().size(), 3);
        assertEquals(person.getActivity().get(0), "1");
    }

    /**
     * Test of addFriendRequest method, of class Person.
     */
    @Test
    public void testAddFriendRequest() {
        for (int i = 0; i < 3; i++) {
            person.addFriendRequest("" + 1);
        }
        assertEquals(person.getAllFriendRequests().size(), 3);
        assertEquals(person.getAllFriendRequests().get(0), "1");
    }

    /**
     * Test of removeFriendRequest method, of class Person.
     */
    @Test
    public void testRemoveFriendRequest() {
        for (int i = 0; i < 3; i++) {
            person.addFriendRequest("" + 1);
        }
        person.removeFriendRequest("1");
        assertEquals(person.getAllFriendRequests().size(), 2);
    }

    /**
     * Test of addFriend method, of class Person.
     */
    @Test
    public void testAddFriend() {
        for (int i = 0; i < 3; i++) {
            person.addFriend("" + 1);
        }
        assertEquals(person.getAllFriends().size(), 3);
        assertEquals(person.getAllFriends().get(0), "1");
    }

    /**
     * Test of removeFriend method, of class Person.
     */
    @Test
    public void testRemoveFriend() {
        for (int i = 0; i < 3; i++) {
            person.addFriend("" + 1);
        }
        person.removeFriend("1");
        assertEquals(person.getAllFriends().size(), 2);
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
        String result = person.getEmail();
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
        String result = person.getName();
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
}
