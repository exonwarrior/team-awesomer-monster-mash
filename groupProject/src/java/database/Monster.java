/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.swing.JOptionPane;

/**
 *
 * @author Dave
 */
@Entity
public class Monster implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name, owner, birthday;
    private float health, strength, dodge, price, fertility;
    private boolean gender;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    
    public String getOwner(){
        return owner;
    }
    public void setOwner(String owner){
        this.owner = owner;
    }
    
    public float getHealth(){
        return health;
    }
    public void setHealth(float health){
        this.health = health;
    }
    
    public float getStrength(){
        return strength;
    }
    public void setStrength(float strength){
        this.strength = strength;
    }
    
    public float getDodge(){
        return dodge;
    }
    public void setDodge(float dodge){
        this.dodge = dodge;
    }
    
    public float getPrice(){
        return price;
    }
    public void setPrice(float price){
        this.price = price;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }
    
    public String getStats(){
        return this.name + this.health + this.strength + this.dodge;
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
         DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
         Date date = new Date();
         this.birthday = dateFormat.format(date);
         m.setStrength(random.nextFloat());
         m.setDodge(random.nextFloat());
         m.setHealth(1);
         this.fertility = (random.nextFloat());
         gender = random.nextBoolean();
         m.setPrice(m.getStrength()+m.getDodge()+m.getHealth());
         //String s = JOptionPane.showInputDialog("How would you like to name your monster?");
         //m.setName(s);
         m.setOwner(user.getName());
         System.out.println(this.id+"\n"+this.birthday+"\n"+this.strength+"\n"+this.dodge+"\n"+this.health+"\n"+this.fertility+"\n"+this.gender);
         return m;
     }

    
}