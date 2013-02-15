/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.util.ArrayList;
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
public class MonsterDOATest {
    @EJB MonsterDOA monsterDOA;
    
    /**
     * Test of getMonsterByUser method, of class MonsterDOA.
     */
    @Test
    public void testGetMonsterByUser() throws Exception {
        System.out.println("getMonsterByUser");
        Person user = new Person("thim", "123", "thom@bla.com");
        monsterDOA = new MonsterDOA();
        int expResult = 1;
        ArrayList result = monsterDOA.getMonsterByUser(user);
        assertEquals(expResult, result.size());
       
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
