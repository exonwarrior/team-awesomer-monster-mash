package database;

import java.io.IOException;
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
 * Class for Monster objects, which are controlled by the players (bred,
 * fights arranged for, etc)
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

  /**
   * Sets the monster's birth date to the parameter provided.
   * @param birthDate - given birth date.
   */
    public void setBirthDate(int birthDate) {
        this.birthDate = birthDate;
    }
    /**
     * Sets the monster's name to the parameter provided.
     * @param name - name provided for monster
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Method for returning the remaining lifespan of a monster.
     * @return lifespan remaining as an int.
     */
    public int getLifeSpan(){
        return lifespan;
    }
    /**
     * Sets the lifespan for the monster. Used in monster creation and periodic
     * checks to update remaining lifespan.
     * @param lifespan - time left to live.
     */
    public void setLifeSpan(int lifespan){
        this.lifespan = lifespan;
    }
    /**
     * Used to set breeding price of monster, based on parameter provided.
     * @param breedOffer 
     */
    public void setBreedOffer(int breedOffer) {
        this.breedOffer = breedOffer;
    }
    /**
     * Used to set selling price of monster, based on parameter provided.
     * @param saleOffer 
     */
    public void setSaleOffer(int saleOffer) {
        this.saleOffer = saleOffer;
    }
    /**
     * Method for returning the monster's breed offer.
     * @return - breedOffer as int.
     */
    public int getBreedOffer() {
        return breedOffer;
    }
    /**
     * Method for returning the monster's sale offer.
     * @return - saleOffer as int.
     */
    public int getSaleOffer() {
        return saleOffer;
    }
    /**
     * Method for returning the monster's name.
     * @return name of monster.
     */
    public String getName() {
        return name;
    }
    /**
     * Sets the ownerID (i.e., email) based on parameter provided.
     * @param email 
     */
    public void setOwner(String email) {
        this.ownerID = email;
    }
    /**
     * Method for returning the monster's ownerID.
     * @return ID of monster owner.
     */
    public String getOwnerID() {
        return ownerID;
    }
    /**
     * Sets the ownerID based on parameter provided.
     * @param ownerID - identifier of the owner.
     */
    public void setOwnerID(String ownerID){
        this.ownerID = ownerID;
    }
    /**
     * Method for retrieving monster's identifier.
     * @return monsterID as String
     */
    public String getMonsterID() {
        return monsterID;
    }
    /**
     * Sets the monsterID based on parameter provided.
     * @param id new monster ID.
     */
    public void setMonsterID(String id){
        this.monsterID = id;
    }
    /**
     * Method for retrieving ID of monster.
     * @return monster ID as long
     */
    public Long getId() {
        return id;
    }
    /**
     * Method for retrieving monster's birthday. Maybe you want to give him a cake.
     * @return birthday as int.
     */
    public int getBirthDate(){
        return birthDate;
    }
    /**
     * Method for retrieving the monster's base or beginning health.
     * @return 
     */
    public double getBaseHealth(){
        return baseHealth;
    }
    /**
     * 
     * @param health 
     */
    public void setBaseHealth(double health){
        this.baseHealth = health;
    }
    /**
     * 
     * @return 
     */
    public double getCurrentHealth(){
        return currentHealth;
    }
    /**
     * 
     * @param health 
     */
    public void setCurrentHealth(double health){
        this.currentHealth = health;
    }
    /**
     * 
     * @return 
     */
    public double getBaseStrength(){
        return baseStrength;
    }
    /**
     * 
     * @param strength 
     */
    public void setBaseStrength(double strength){
        this.baseStrength = strength;
    }
    /**
     * 
     * @return 
     */
    public double getCurrentStrength(){
        return currentStrength;
    }
    /**
     * 
     * @param strength 
     */
    public void setCurrentStrength(double strength){
        this.currentStrength = strength;
    }
    /**
     * 
     * @return 
     */
    public double getBaseDefence(){
        return baseDefence;
    }
    /**
     * 
     * @param defence 
     */
    public void setBaseDefence(double defence){
        this.baseDefence = defence;
    }
    /**
     * 
     * @return 
     */
    public double getCurrentDefence(){
        return currentDefence;
    }
    /**
     * 
     * @param defence 
     */
    public void setCurrentDefence(double defence){
        this.currentDefence = defence;
    }
    /**
     * 
     * @return 
     */
    public double getPrice(){
        return price;
    }
    /**
     * 
     * @param price 
     */
    public void setPrice(double price){
        this.price = price;
    }
    // </editor-fold>
    
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
     * Method for creating and then returning a String comprised of the monster's
     * basic stats.
     * @return stats of monster as one String, used in display.
     */
    public String getStats(){
        return "Monster name: "+ this.name + "\nStrength: " + this.baseStrength 
                + "\nDefence: " + this.baseDefence + "\nHealth: " +this.baseHealth;
    }
    /**
     * Method for returning monster stats in the form of a JSON object.
     * @return 
     */
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
    /**
     * Method for checking if two monsters are equal.
     * @param object - a monster
     * @return true/false, depending on whether they match.
     */
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Monster)) {
            return false;
        }
        Monster other = (Monster) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    /**
     * Custom toString() method. 
     * @return the completed String.
     */
    @Override
    public String toString() {
        return "database.Monster[ id=" + id + " ]";
    }
    /**
     * Generating a random Monster, mostly for newly registered users.
     * Many variables are randomly assigned.
     * @param user for whom a monster is to be created.
     * @return monster that was generated/ 
     */
    public Monster generateRandom(Person user){
         Random random = new Random();

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
         this.ownerID = user.getEmail();
         
         System.out.println(this.id+"\n"+ this.ownerID +"\n"+this.baseStrength+"\n"
                 +this.baseDefence+"\n"+this.baseHealth);
         return this;
     }
    /**
     * Method for choosing a random name for newly created monsters based on a 
     * hard-coded array of 10 names.
     * @return randomName, String with chosen name
     * @throws IOException 
     */
    private String generateName() throws IOException {
        String randomName;
        String[] array = {"Tana Eris", "Rolim Ironfist", "Rurruka Knesos", "Misou Long", "Teel Brangwin", "Jospi Ulluto", "Robe Dremine", "Woro Irokini", "Lynorri Seki", "Kyle Rayley", "Jarvis Parlayy"};
        Random random = new Random();
        int index = random.nextInt(10);
        randomName = array[index];
        return randomName;
    }
    
}