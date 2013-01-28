/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * just some random comment to test 
 * GitHub and NetBeans....
 * 
 */
package database;

import java.io.Serializable;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
    private ArrayList<Long> monsters;
    
    
    public Person(){
    }

    public Person(String name, String password, String email) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.friends = new ArrayList<String>();
        this.monsters = new ArrayList<Long>();
    }
    public void addFriend(String email){
        this.friends.add(email);
    }
    public void removeFriend(String email){
        this.friends.remove(email);
    }
    public ArrayList<Long> getAllMonsters(){
        return monsters;
    }
    
    public void addMonster(Long id ){
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
