/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.json.JSONException;
import org.json.JSONObject;

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

    private String monsterID;
    private String name, ownerID;
    private int birthDate, lifespan, breedOffer, saleOffer;
    private double baseStrength, currentStrength, 
            baseDefence, currentDefence, baseHealth, 
            currentHealth, price;

  
    public void setBirthDate(int birthDate) {
        this.birthDate = birthDate;
    }

    public void setName(String name) {
        this.name = name;
    }
    public int getLifeSpan(){
        return lifespan;
    }
    public void setLifeSpan(int lifespan){
        this.lifespan = lifespan;
    }

    public void setBreedOffer(int breedOffer) {
        this.breedOffer = breedOffer;
    }

    public void setSaleOffer(int saleOffer) {
        this.saleOffer = saleOffer;
    }

    public int getBreedOffer() {
        return breedOffer;
    }

    public int getSaleOffer() {
        return saleOffer;
    }
    
    public String getName() {
        return name;
    }
    
    
    public void setOwner(String email) {
        this.ownerID = email;
    }
   
    public String getOwnerID() {
        return ownerID;
    }
    public void setOwnerID(String ownerID){
        this.ownerID = ownerID;
    }
    
    public String getMonsterID() {
        return monsterID;
    }
    
    public void setMonsterID(String id){
        this.monsterID = id;
    }
    
    public Long getId() {
        return id;
    }
    
    public int getBirthDate(){
        return birthDate;
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
    // </editor-fold>

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

    public JSONObject getJSONMonster(){
        JSONObject jMonster = new JSONObject();
        try {
            jMonster.put("name", this.name);
            jMonster.put("baseStrength", this.baseStrength);
            jMonster.put("baseHealth", this.baseHealth);
            jMonster.put("baseDefence", this.baseDefence);
        } catch (JSONException ex) {
            Logger.getLogger(Monster.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return jMonster;
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
         Random random = new Random();
         //this.monsterID = this.id.toString();
         this.birthDate = (int) (System.currentTimeMillis() / 1000L);
         this.lifespan = 74300;
         this.baseStrength = random.nextDouble();
         if(this.baseStrength<0.51){
             this.baseStrength+=0.5;
         }
         this.baseDefence = random.nextDouble();
         if(this.baseDefence<0.51){
             this.baseDefence+=0.5;
         }
         this.baseHealth = random.nextDouble();
         if(this.baseHealth<0.51){
             this.baseHealth+=0.5;
         }
         this.currentStrength = this.baseStrength;
         this.currentDefence = this.baseDefence;
         this.currentHealth = this.baseHealth;
         this.price = 0;
         try {
            this.name = generateName();
         } catch (IOException ex) {
            Logger.getLogger(Monster.class.getName()).log(Level.SEVERE, null, ex);
         }
         //this.name = "" + user.getName() + "'s Monster";
         this.ownerID = user.getEmail();
         
         System.out.println(this.id+"\n"+ this.ownerID +"\n"+this.baseStrength+"\n"
                 +this.baseDefence+"\n"+this.baseHealth);
         return this;
     }
<<<<<<< HEAD
=======

    public void setOwner(String email) {
        this.ownerID = email;
    }

    private String generateName() throws IOException {
        String randomName;
        Scanner s = new Scanner(new File("examplenames.txt"));
        ArrayList<String> list = new ArrayList<String>();
        while (s.hasNext()){
            list.add(s.next());
        }   
        s.close();        
        Random random = new Random();
        int index = random.nextInt(200)+1;
        randomName = list.get(index);
        return randomName;
    }
>>>>>>> Home.jsp
    
}