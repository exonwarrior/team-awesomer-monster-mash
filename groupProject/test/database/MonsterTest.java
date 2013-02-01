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
 * @author toffik
 */
public class MonsterTest {
    
    Monster monster = new Monster();
    Person person;
    
    @Before
    public void setUp() {
        person = new Person("name", "password", "email");
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
        monster.setBirthDate(1);
        int expResult = 1;
        int result = monster.getBirthDate();
        assertEquals(expResult, result);
    }

    /**
     * Test of getBaseHealth method, of class Monster.
     */
    @Test
    public void testGetBaseHealth() {
        monster.setBaseHealth(1.0);
        double expResult = 1.0;
        double result = monster.getBaseHealth();
        assertEquals(expResult, result, 0.01);
    }

    /**
     * Test of setBaseHealth method, of class Monster.
     */
    @Test
    public void testSetBaseHealth() {
        monster.setBaseHealth(1.0);
        double expResult = 1.0;
        double result = monster.getBaseHealth();
        assertEquals(expResult, result, 0.01);
    }

    /**
     * Test of getCurrentHealth method, of class Monster.
     */
    @Test
    public void testGetCurrentHealth() {
        monster.setCurrentHealth(1.0);
        double expResult = 1.0;
        double result = monster.getCurrentHealth();
        assertEquals(expResult, result, 0.01);
    }

    /**
     * Test of setCurrentHealth method, of class Monster.
     */
    @Test
    public void testSetCurrentHealth() {
        monster.setCurrentHealth(1.0);
        double expResult = 1.0;
        double result = monster.getCurrentHealth();
        assertEquals(expResult, result, 0.01);
    }

    /**
     * Test of getBaseStrength method, of class Monster.
     */
    @Test
    public void testGetBaseStrength() {
        monster.setBaseStrength(1.0);
        double expResult = 1.0;
        double result = monster.getBaseStrength();
        assertEquals(expResult, result, 0.01);
    }

    /**
     * Test of setBaseStrength method, of class Monster.
     */
    @Test
    public void testSetBaseStrength() {
        monster.setBaseStrength(1.0);
        double expResult = 1.0;
        double result = monster.getBaseStrength();
        assertEquals(expResult, result, 0.01);
    }

    /**
     * Test of getCurrentStrength method, of class Monster.
     */
    @Test
    public void testGetCurrentStrength() {
       monster.setBaseStrength(1.0);
        double expResult = 1.0;
        double result = monster.getBaseStrength();
        assertEquals(expResult, result, 0.01);
    }

    /**
     * Test of setCurrentStrength method, of class Monster.
     */
    @Test
    public void testSetCurrentStrength() {
        monster.setBaseStrength(1.0);
        double expResult = 1.0;
        double result = monster.getBaseStrength();
        assertEquals(expResult, result, 0.01);
    }

    /**
     * Test of getBaseDefence method, of class Monster.
     */
    @Test
    public void testGetBaseDefence() {
        monster.setBaseDefence(1.0);
        double expResult = 1.0;
        double result = monster.getBaseDefence();
        assertEquals(expResult, result, 0.01);
    }

    /**
     * Test of setBaseDefence method, of class Monster.
     */
    @Test
    public void testSetBaseDefence() {
        monster.setBaseDefence(1.0);
        double expResult = 1.0;
        double result = monster.getBaseDefence();
        assertEquals(expResult, result, 0.01);
    }

    /**
     * Test of getCurrentDefence method, of class Monster.
     */
    @Test
    public void testGetCurrentDefence() {
        monster.setCurrentDefence(1.0);
        double expResult = 1.0;
        double result = monster.getCurrentDefence();
        assertEquals(expResult, result, 0.01);
    }

    /**
     * Test of setCurrentDefence method, of class Monster.
     */
    @Test
    public void testSetCurrentDefence() {
        monster.setCurrentDefence(1.0);
        double expResult = 1.0;
        double result = monster.getCurrentDefence();
        assertEquals(expResult, result, 0.01);
    }

    /**
     * Test of getPrice method, of class Monster.
     */
    @Test
    public void testGetPrice() {
        monster.setPrice(1.0);
        double expResult = 1.0;
        double result = monster.getPrice();
        assertEquals(expResult, result, 0.01);
    }

    /**
     * Test of setPrice method, of class Monster.
     */
    @Test
    public void testSetPrice() {
        monster.setPrice(1.0);
        double expResult = 1.0;
        double result = monster.getPrice();
        assertEquals(expResult, result, 0.01);
    }

    /**
     * Test of generateRandom method, of class Monster.
     */
    @Test
    public void testGenerateRandomNotNull() {
       Monster temp = monster.generateRandom(person);
        assertNotNull(temp);
    }

    @Test
    public void testGenerateRandomStrengthMax() {
       Monster temp = monster.generateRandom(person);
       assertTrue(temp.getBaseStrength()<= 1.0);
    }
    
    @Test
    public void testGenerateRandomStrengthMin() {
       Monster temp = monster.generateRandom(person);
       assertTrue(temp.getBaseStrength()>= 0.0);
    }
    
    @Test
    public void testGenerateRandomDefenceMax() {
       Monster temp = monster.generateRandom(person);
       assertTrue(temp.getBaseDefence()<= 1.0);
    }
    
    @Test
    public void testGenerateRandomDefenceMin() {
       Monster temp = monster.generateRandom(person);
       assertTrue(temp.getBaseDefence()>= 0.0);
    }
    
    @Test
    public void testGenerateRandomHealthMax() {
       Monster temp = monster.generateRandom(person);
       assertTrue(temp.getBaseHealth()<= 1.0);
    }
    
    @Test
    public void testGenerateRandomHealthMin() {
       Monster temp = monster.generateRandom(person);
       assertTrue(temp.getBaseHealth()>= 0.0);
    }
    
    /**
     * Test of setOwner method, of class Monster.
     */
    @Test
    public void testSetOwner() {
        monster.setOwner("name");
        String expResult = "name";
        String result = monster.getOwnerID();
        assertEquals(expResult, result);
    }
}
