/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package types;

import database.Monster;
import database.Person;

/**
 *
 * @author thomas
 */
public class Fight {
    private Person person;
    private Monster monster; 

    public Fight(Person person, Monster monster) {
        this.person = person;
        this.monster = monster;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Monster getMonster() {
        return monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }
    
    
}
