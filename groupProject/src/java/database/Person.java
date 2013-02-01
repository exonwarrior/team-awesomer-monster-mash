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
    private ArrayList<Fight> fights;
    //private ArrayList<String> monsters;
    private ArrayList<String> activity;
    
    public Person(){
        
    }

    public Person(String name, String password, String email) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.friends = new ArrayList<String>();
        this.friendRequests = new ArrayList<String>();
        //this.monsters = new ArrayList<String>();
        this.fights = new ArrayList<Fight>();
        this.money = 1000;
    }
    
    
    public ArrayList<Fight> getFightChallenges(){
        ArrayList<Fight> challenges = new ArrayList<Fight>();
        
        if(fights != null) {
            for(Fight fight: fights){
                if(fight.getChallenger().getId().equals(this.id)){
                    challenges.add(fight);
                }
            }
        }
        return challenges;
    }
    
    public ArrayList<Fight> getFightOffers(){
        ArrayList<Fight> offers = new ArrayList<Fight>();
        
        if(fights != null){
          for(Fight fight: fights){
            if(fight.getOpponent().getId().equals(this.id)){
                offers.add(fight);
            }
         }  
        }
        
        
        return offers;
    }
    
    public ArrayList<Fight> getAllFights(){
        return this.fights;
    }
    
    public void addFight(Fight fight){
        this.fights.add(fight);
    }
    
    public void removeFightOffer(Fight fight){
        this.fights.remove(fight);
    }
    
    public void removeFightOffer(Person opponent, Monster oppMonster){
        for(Fight fight: this.fights){
            if(fight.getOppMonster().getId().equals(oppMonster.getId()) 
                    && fight.getOpponent().getId().equals(opponent.getId())){
                this.fights.remove(fight);
            }
        }
    }
    
    public Fight getFightByID(String id){
        for(Fight fight: this.fights){
            if(fight.getId().equals(id)){
                return fight;
            }
        }
        return null;
    }

//    public ArrayList<String> setFriendRequests(ArrayList<String> updatedRequests){
//        this.friendRequests = new ArrayList<String>(updatedRequests);
//        return friendRequests;
//    }
    public ArrayList<String> getAllFriendRequests(){
        return friendRequests;
    }
    public ArrayList<String> getActivity(){
        return activity;
    }
    public void addActivity(String active){
        this.activity.add(active);
    }
    public void addFriendRequest(String email){
        this.friendRequests.add(email);
    }
    public void removeFriendRequest(String email){
        this.friendRequests.remove(email);
    }
//   public ArrayList<String> setFriends(ArrayList<String> updatedFriends){
//        this.friends = new ArrayList<String>(updatedFriends);
//        return friends;
//    }
    public ArrayList<String> getAllFriends(){
        return friends;
    }
    public void addFriend(String email){
        this.friends.add(email);
    }
    public void removeFriend(String email){
        this.friends.remove(email);
    }
    /*public ArrayList<String> getAllMonsters(){
        return monsters;
    }
    
    public void addMonster(String id ){
        this.monsters.add(id);
    }*/
    
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

    /*public void removeMonster(Monster m){
     * for(int i = 0; i < monsters.size(); i++){
     * if(m.getId() == Long.parseLong(monsters.get(i))){
     * monsters.remove(i);
     * }
     * }
     * }*/
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
