/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package types;

import database.Monster;
import database.MonsterDOA;
import database.Person;
import database.PersonDOA;
import java.io.Serializable;
import java.util.UUID;
import javax.ejb.EJB;
import javax.persistence.Embeddable;

/**
 *
 * @author thomas
 */
@Embeddable
public class Fight implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id = UUID.randomUUID().toString();
    private Long challenger;
    private Long opponent;
    private Long challMonster;
    private Long oppMonster;
    private String challengerName, opponentName, challMonsterName, oppMonsterName;

    public String getChallMonsterName() {
        return challMonsterName;
    }

    public String getOppMonsterName() {
        return oppMonsterName;
    }

    public String getChallengerName() {
        return challengerName;
    }

    public String getOpponentName() {
        return opponentName;
    }

    public Fight() {
    }

    public Fight(Person challenger, Person opponent, Monster challMonster, Monster OppMonster) {
        this.challenger = challenger.getId();
        this.challengerName = challenger.getName();
        this.challMonster = challMonster.getId();
        this.challMonsterName = challMonster.getName();
        this.opponent = opponent.getId();
        this.opponentName = opponent.getName();
        this.oppMonster = OppMonster.getId();
        this.oppMonsterName = OppMonster.getName();
        
    }

    public String getId() {
        return id;
    }

    public Long getChallenger() {
        return challenger;
    }

    public void setChallenger(Person challenger) {
        this.challenger = challenger.getId();
        this.challengerName = challenger.getName();
    }

    public Long getChallMonster() {
        return challMonster;
    }
    
    public void setChallMonster(Monster challMonster) {
        this.challMonster = challMonster.getId();
        this.challMonsterName = challMonster.getName();
    }

    public Long getOpponent() {
        return opponent;
    }

    public void setOpponent(Person person) {
        this.opponent = person.getId();
        this.opponentName = person.getName();
    }

    public Long getOppMonster() {
        return oppMonster;
    }

    public void setOppMonster(Monster monster) {
        this.oppMonster = monster.getId();
        this.oppMonsterName = monster.getName();
    }

    
}
