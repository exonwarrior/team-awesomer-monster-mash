/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.io.Serializable;
import java.util.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Dave
 */
@Entity
public class Monster implements Serializable {
    private static final Long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name, ownerID, monsterID;
    private int birthDate, lifespan, breedOffer, saleOffer;
    private double baseStrength, currentStrength, 
            baseDefence, currentDefence, baseHealth, 
            currentHealth, price;
    
    public String getName() {
        return name;
    }
    
    public String getOwnerID() {
        return ownerID;
    }
    
    public String getMonsterID() {
        return monsterID;
    }
    
    public Long getId() {
        return id;
    }
    
    public double getBaseHealth(){
        return baseHealth;
    }
    public void setBaseHealth(double health){
        this.baseHealth = health;
    }
    public double getCurrentHealth(){
        return currentHealth;
    }
    public void setCurrentHealth(double health){
        this.currentHealth = health;
    }
    
    public double getBaseStrength(){
        return baseStrength;
    }
    public void setBaseStrength(double strength){
        this.baseStrength = strength;
    }
    public double getCurrentStrength(){
        return currentStrength;
    }
    public void setCurrentStrength(double strength){
        this.currentStrength = strength;
    }
    
    public double getBaseDefence(){
        return baseDefence;
    }
    public void setBaseDefence(double defence){
        this.baseDefence = defence;
    }
    public double getCurrentDefence(){
        return currentDefence;
    }
    public void setCurrentDefence(double defence){
        this.currentDefence = defence;
    }
    
    public double getPrice(){
        return price;
    }
    public void setPrice(double price){
        this.price = price;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }
    
    public String getStats(){
        return "Monster name: "+ this.name + "\nStrength: " + this.baseStrength 
                + "\nDefence: " + this.baseDefence + "\nHealth: " +this.baseHealth;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Monster)) {
            return false;
        }
        Monster other = (Monster) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.Monster[ id=" + id + " ]";
    }
    
    public Monster generateRandom(Person user){
         Monster m = new Monster();
         Random random = new Random();
         this.birthDate = (int) (System.currentTimeMillis() / 1000L);
         this.baseStrength = random.nextInt(100)+1;
         this.baseDefence = random.nextInt(100)+1;
         this.baseHealth = random.nextInt(100)+1;
         this.price = this.baseStrength+this.baseDefence+this.baseHealth;
         this.name = "" + user.getName() + "'s Monster";
         this.ownerID = user.getEmail();
         System.out.println(this.id+"\n"+this.baseStrength+"\n"
                 +this.baseDefence+"\n"+this.baseHealth);
         return m;
     }
    
}