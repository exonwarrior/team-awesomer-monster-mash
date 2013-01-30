/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import types.Fight;

/**
 *
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
    private ArrayList<Fight> fightOffers;

    public ArrayList<Fight> getFightOffers() {
        return fightOffers;
    }
    
    public void addFightOffer(Person person, Monster monster){
        this.fightOffers.add(new Fight(person, monster));
    }
    
    public void removeFightOffer(Fight fight){
        this.fightOffers.remove(fight);
    }
    
    public void removeFightOffer(Person person, Monster monster){
        for(Fight fight: this.fightOffers){
            if(fight.getMonster().getId().equals(monster.getId()) 
                    && fight.getPerson().getId().equals(person.getId())){
                this.fightOffers.remove(fight);
            }
        }
    }
    
    private ArrayList<String> monsters;
    
    
    public Person(){
    }

    public Person(String name, String password, String email) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.friends = new ArrayList<String>();
        this.friendRequests = new ArrayList<String>();
        this.monsters = new ArrayList<String>();
    }
    
    
    public ArrayList<String> setFriendRequests(ArrayList<String> updatedRequests){
        this.friendRequests = new ArrayList<String>(updatedRequests);
        return friendRequests;
    }
    public ArrayList<String> getAllFriendRequests(){
        return friendRequests;
    }
    public void addFriendRequest(String email){
        this.friendRequests.add(email);
    }
    public void removeFriendRequest(String email){
        this.friendRequests.remove(email);
    }
   public ArrayList<String> setFriends(ArrayList<String> updatedFriends){
        this.friends = new ArrayList<String>(updatedFriends);
        return friends;
    }
    public ArrayList<String> getAllFriends(){
        return friends;
    }
    public void addFriend(String email){
        this.friends.add(email);
    }
    public void removeFriend(String email){
        this.friends.remove(email);
    }
    public ArrayList<String> getAllMonsters(){
        return monsters;
    }
    
    public void addMonster(String id ){
        this.monsters.add(id);
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public int getMoney() {
        return money;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

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
    

    @Override
    public String toString() {
        return "login.Person[ id=" + id + " ]";
    }
    
}
