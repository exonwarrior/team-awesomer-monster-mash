/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package types;

import database.Monster;
import database.Person;
import java.util.UUID;

/**
 *
 * @author thomas
 */
public class Fight {
    private Person challenger, opponent;
    private Monster challMonster, OppMonster;
    private String id;

    public Fight(Person challenger, Person opponent, Monster challMonster, Monster OppMonster) {
        this.challenger = challenger;
        this.opponent = opponent;
        this.challMonster = challMonster;
        this.OppMonster = OppMonster;
        id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public Person getChallenger() {
        return challenger;
    }

    public void setChallenger(Person challenger) {
        this.challenger = challenger;
    }

    public Monster getChallMonster() {
        return challMonster;
    }
    
    public void setChallMonster(Monster challMonster) {
        this.challMonster = challMonster;
    }

    public Person getOpponent() {
        return opponent;
    }

    public void setOpponent(Person person) {
        this.opponent = person;
    }

    public Monster getOppMonster() {
        return OppMonster;
    }

    public void setOppMonster(Monster monster) {
        this.OppMonster = monster;
    }
    
    
}
