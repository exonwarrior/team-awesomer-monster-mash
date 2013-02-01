/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import org.json.JSONObject;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author toffik
 */
public class MonsterTest {
    
    Monster monster = new Monster();
   
    @Before
    public void setUp() {
    }
    
    /**
     * Test of getLifeSpan method, of class Monster.
     */
    @Test
    public void testGetLifeSpan() {
        int lifespan = 1234;
        monster.setLifeSpan(lifespan);
        int newLifespan = monster.getLifeSpan();
        assertEquals(lifespan, newLifespan);
    }

    /**
     * Test of setLifeSpan method, of class Monster.
     */
    @Test
    public void testSetLifeSpan() {
        int lifespan = 1234;
        monster.setLifeSpan(lifespan);
        int newLifespan = monster.getLifeSpan();
        assertEquals(lifespan, newLifespan);
    }

    /**
     * Test of setBreedOffer method, of class Monster.
     */
    @Test
    public void testSetBreedOffer() {
        int breedOffer = 1234;
        monster.setBreedOffer(breedOffer);
        int newBreedOffer = monster.getBreedOffer();
        assertEquals(breedOffer, newBreedOffer);
    }

    /**
     * Test of setSaleOffer method, of class Monster.
     */
    @Test
    public void testSetSaleOffer() {
        int saleOffer = 1234;
        monster.setSaleOffer(saleOffer);
        int newsaleOffer = monster.getSaleOffer();
        assertEquals(saleOffer, newsaleOffer);
    }

    /**
     * Test of getBreedOffer method, of class Monster.
     */
    @Test
    public void testGetBreedOffer() {
        int breedOffer = 1234;
        monster.setBreedOffer(breedOffer);
        int newBreedOffer = monster.getBreedOffer();
        assertEquals(breedOffer, newBreedOffer);
    }

    /**
     * Test of getSaleOffer method, of class Monster.
     */
    @Test
    public void testGetSaleOffer() {
        int saleOffer = 1234;
        monster.setSaleOffer(saleOffer);
        int newsaleOffer = monster.getSaleOffer();
        assertEquals(saleOffer, newsaleOffer);
    }

    /**
     * Test of getName method, of class Monster.
     */
    @Test
    public void testGetName() {
        monster.setName("name");
        String expResult = "name";
        String result = monster.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getOwnerID method, of class Monster.
     */
    @Test
    public void testGetOwnerID() {
        monster.setOwnerID("id");
        String expResult = "id";
        String result = monster.getOwnerID();
        assertEquals(expResult, result);
    }

    /**
     * Test of setOwnerID method, of class Monster.
     */
    @Test
    public void testSetOwnerID() {
        monster.setOwnerID("id");
        String expResult = "id";
        String result = monster.getOwnerID();
        assertEquals(expResult, result);
    }

    /**
     * Test of getMonsterID method, of class Monster.
     */
    @Test
    public void testGetMonsterID() {
        monster.setMonsterID("id");
        String expResult = "id";
        String result = monster.getMonsterID();
        assertEquals(expResult, result);
    }

    /**
     * Test of setMonsterID method, of class Monster.
     */
    @Test
    public void testSetMonsterID() {
        monster.setMonsterID("id");
        String expResult = "id";
        String result = monster.getMonsterID();
        assertEquals(expResult, result);
    }

    /**
     * Test of getBirthDate method, of class Monster.
     */
    @Test
    public void testGetBirthDate() {
        System.out.println("getBirthDate");
        Monster instance = new Monster();
        int expResult = 0;
        int result = instance.getBirthDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBaseHealth method, of class Monster.
     */
    @Test
    public void testGetBaseHealth() {
        System.out.println("getBaseHealth");
        Monster instance = new Monster();
        double expResult = 0.0;
        double result = instance.getBaseHealth();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBaseHealth method, of class Monster.
     */
    @Test
    public void testSetBaseHealth() {
        System.out.println("setBaseHealth");
        double health = 0.0;
        Monster instance = new Monster();
        instance.setBaseHealth(health);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCurrentHealth method, of class Monster.
     */
    @Test
    public void testGetCurrentHealth() {
        System.out.println("getCurrentHealth");
        Monster instance = new Monster();
        double expResult = 0.0;
        double result = instance.getCurrentHealth();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCurrentHealth method, of class Monster.
     */
    @Test
    public void testSetCurrentHealth() {
        System.out.println("setCurrentHealth");
        double health = 0.0;
        Monster instance = new Monster();
        instance.setCurrentHealth(health);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBaseStrength method, of class Monster.
     */
    @Test
    public void testGetBaseStrength() {
        System.out.println("getBaseStrength");
        Monster instance = new Monster();
        double expResult = 0.0;
        double result = instance.getBaseStrength();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBaseStrength method, of class Monster.
     */
    @Test
    public void testSetBaseStrength() {
        System.out.println("setBaseStrength");
        double strength = 0.0;
        Monster instance = new Monster();
        instance.setBaseStrength(strength);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCurrentStrength method, of class Monster.
     */
    @Test
    public void testGetCurrentStrength() {
        System.out.println("getCurrentStrength");
        Monster instance = new Monster();
        double expResult = 0.0;
        double result = instance.getCurrentStrength();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCurrentStrength method, of class Monster.
     */
    @Test
    public void testSetCurrentStrength() {
        System.out.println("setCurrentStrength");
        double strength = 0.0;
        Monster instance = new Monster();
        instance.setCurrentStrength(strength);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBaseDefence method, of class Monster.
     */
    @Test
    public void testGetBaseDefence() {
        System.out.println("getBaseDefence");
        Monster instance = new Monster();
        double expResult = 0.0;
        double result = instance.getBaseDefence();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBaseDefence method, of class Monster.
     */
    @Test
    public void testSetBaseDefence() {
        System.out.println("setBaseDefence");
        double defence = 0.0;
        Monster instance = new Monster();
        instance.setBaseDefence(defence);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCurrentDefence method, of class Monster.
     */
    @Test
    public void testGetCurrentDefence() {
        System.out.println("getCurrentDefence");
        Monster instance = new Monster();
        double expResult = 0.0;
        double result = instance.getCurrentDefence();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCurrentDefence method, of class Monster.
     */
    @Test
    public void testSetCurrentDefence() {
        System.out.println("setCurrentDefence");
        double defence = 0.0;
        Monster instance = new Monster();
        instance.setCurrentDefence(defence);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPrice method, of class Monster.
     */
    @Test
    public void testGetPrice() {
        System.out.println("getPrice");
        Monster instance = new Monster();
        double expResult = 0.0;
        double result = instance.getPrice();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPrice method, of class Monster.
     */
    @Test
    public void testSetPrice() {
        System.out.println("setPrice");
        double price = 0.0;
        Monster instance = new Monster();
        instance.setPrice(price);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class Monster.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Monster instance = new Monster();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStats method, of class Monster.
     */
    @Test
    public void testGetStats() {
        System.out.println("getStats");
        Monster instance = new Monster();
        String expResult = "";
        String result = instance.getStats();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getJSONMonster method, of class Monster.
     */
    @Test
    public void testGetJSONMonster() {
        System.out.println("getJSONMonster");
        Monster instance = new Monster();
        JSONObject expResult = null;
        JSONObject result = instance.getJSONMonster();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Monster.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        Monster instance = new Monster();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Monster.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Monster instance = new Monster();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of generateRandom method, of class Monster.
     */
    @Test
    public void testGenerateRandom() {
        System.out.println("generateRandom");
        Person user = null;
        Monster instance = new Monster();
        Monster expResult = null;
        Monster result = instance.generateRandom(user);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setOwner method, of class Monster.
     */
    @Test
    public void testSetOwner() {
        System.out.println("setOwner");
        String email = "";
        Monster instance = new Monster();
        instance.setOwner(email);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
