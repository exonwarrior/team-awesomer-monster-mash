/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import types.Fight;

/**
 * Class for Person objects, these are the players in the game.
 * @author thh21
 */
@Entity
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name, password;
    private String email;
    private int money;
    private ArrayList<String> friends;
    private ArrayList<String> friendRequests;
    @Embedded
    private ArrayList<Fight> fights;
    private ArrayList<String> activity;
    
    public Person() {
    }
    /**
     * 
     * @param name
     * @param password
     * @param email 
     */
    public Person(String name, String password, String email) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.friends = new ArrayList<String>();
        this.friendRequests = new ArrayList<String>();
        this.fights = new ArrayList<Fight>();
        this.money = 1000;
    }
    /**
     * Method that searches through all the fight challenges that a user has,
     * then returns the resulting ArrayList listing them all.
     * @return -ArrayList of fight challenges
     */
    public ArrayList<Fight> getFightChallenges() {
        ArrayList<Fight> challenges = new ArrayList<Fight>();

        if (fights != null) {
            for (Fight fight : fights) {
                if (fight.getChallenger().equals(this.id)) {
                    challenges.add(fight);
                }
            }
        }
        return challenges;
    }
    /**
     * Method that searches through all the fight offers that a user has from
     * other players, then returns the resulting ArrayList listing them all.
     * @return -ArrayList of fight offers.
     */
    public ArrayList<Fight> getFightOffers() {
        ArrayList<Fight> offers = new ArrayList<Fight>();

        if (fights != null) {
            for (Fight fight : fights) {
                if (fight.getOpponent().equals(this.id)) {
                    offers.add(fight);
                }
            }
        }


        return offers;
    }
    /**
     * 
     * @return 
     */
    public ArrayList<Fight> getAllFights() {
        return this.fights;
    }
    /**
     * Method for adding a single fight to the existing list.
     * @param fight - fight to be added.
     */
    public void addFight(Fight fight) {
        this.fights.add(fight);
    }
    /**
     * 
     * @param fight 
     */
    public void removeFightOffer(Fight fight) {
        
        this.fights.remove(getFightByID(fight.getChallenger(),fight.getChallMonster()));
    }
    /**
     * 
     * @param opponent
     * @param oppMonster 
     */
    public void removeFightOffer(Person opponent, Monster oppMonster) {
        for (Fight fight : this.fights) {
            if (fight.getOppMonster().equals(oppMonster.getId())
                    && fight.getOpponent().equals(opponent.getId())) {
                this.fights.remove(fight);
            }
        }
    }
    /**
     * 
     * @param person
     * @param monster
     * @return 
     */
    public Fight getFightByID(Long person, Long monster){
        for(Fight fight: this.fights){
            if(fight.getChallenger().equals(person) && fight.getChallMonster().equals(monster)){
                return fight;
            }
        }
        return null;
    }
    /**
     * 
     * @return 
     */
    public ArrayList<String> getActivity() {
        return activity;
    }
    /**
     * 
     * @param active 
     */
    public void addActivity(String active) {
        this.activity.add(active);
    }
    /**
     * 
     * @return 
     */
    public ArrayList<String> getAllFriendRequests() {
        return friendRequests;
    }
    /**
     * 
     * @param email 
     */
    public void addFriendRequest(String email) {
        this.friendRequests.add(email);
    }
    /**
     * 
     * @param email 
     */
    public void removeFriendRequest(String email) {
        this.friendRequests.remove(email);
    }
    /**
     * 
     * @return 
     */
    public ArrayList<String> getAllFriends() {
        return friends;
    }
    /**
     * 
     * @param email 
     */
    public void addFriend(String email) {
        this.friends.add(email);
    }
    /**
     * 
     * @param email 
     */
    public void removeFriend(String email) {
        this.friends.remove(email);
    }
    /**
     * 
     * @param email 
     */
    public void setEmail(String email) {
        this.email = email;
    }
    /**
     * 
     * @param money 
     */
    public void setMoney(int money) {
        this.money = money;
    }
    /**
     * 
     * @param name 
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * 
     * @param password 
     */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
     * 
     * @return 
     */
    public String getEmail() {
        return email;
    }
    /**
     * 
     * @return 
     */
    public int getMoney() {
        return money;
    }
    /**
     * 
     * @return 
     */
    public String getName() {
        return name;
    }
    /**
     * 
     * @return 
     */
    public String getPassword() {
        return password;
    }
    /**
     * 
     * @return 
     */
    public Long getId() {
        return id;
    }
    /**
     * 
     * @param id 
     */
    public void setId(Long id) {
        this.id = id;
    }
    /**
     * 
     * @return 
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }
    /**
     * 
     * @param object
     * @return 
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Person)) {
            return false;
        }
        Person other = (Person) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    /**
     * 
     * @return 
     */
    @Override
    public String toString() {
        return "login.Person[ id=" + id + " ]";
    }
}
