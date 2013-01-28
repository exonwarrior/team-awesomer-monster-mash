/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author thh21
 */
@Stateless
@LocalBean
public class PersonDOA {

    EntityManagerFactory emf;
   
    @PersistenceContext(unitName = "MonsterGamePU" )
     EntityManager em;
    
    @EJB MonsterDOA monsterDOA;
    
    public PersonDOA(){

    }
 
    // Stores a new guest: 
    public void persist(Person person) {
        emf = Persistence.createEntityManagerFactory("$objectdb/db/person.odb");
        
        em = emf.createEntityManager();
        try{
             em.getTransaction().begin();
             em.persist(person);
             giveFirstMonster(person);             
             em.getTransaction().commit();
        }
        finally{
             em.close();
        }   
    }
    
    private List<Person> getAllPeople(){
        emf = Persistence.createEntityManagerFactory("$objectdb/db/person.odb");
        em = emf.createEntityManager();
        List<Person> list;
        try{
             em.getTransaction().begin();
             TypedQuery<Person> query = em.createQuery("SELECT p FROM Person p", Person.class);
             list = query.getResultList();
             em.getTransaction().commit();
        }
        finally{
             em.close();
        }
        
        
        return list;
    }
    
    public boolean doesExit(String name){
        boolean answer = false;
        List<Person> list = this.getAllPeople();
        for(Person p: list){
            if(p.getName() == null ? name == null : p.getName().equals(name)){
                answer = true;
            }
        }
        return answer;
    }
    public boolean lookForEmail(String email){
        boolean answer = false;
        List<Person> list = this.getAllPeople();
        for(Person p: list){
            if(p.getEmail() == null ? email == null : p.getEmail().equals(email)){
                answer = true;
            }
        }
        return answer;
    }
    
    public Person getPersonByEmail(String email){
        emf = Persistence.createEntityManagerFactory("$objectdb/db/person.odb");
        em = emf.createEntityManager();
        Person p = null;
        try{
            em.getTransaction().begin();
            TypedQuery<Person> query = em.createQuery(
            "SELECT p FROM Person AS p WHERE p.email = :email", Person.class)
                    .setParameter("email", email);
            p = query.getSingleResult();
            em.getTransaction().commit();
            
        }
        finally{
            em.close();
        }
        return p;
        //return me;
    }
    
    public ArrayList<Monster> getPersonsMonsters(Person p){
        ArrayList<Monster> list = new ArrayList<Monster>();
        monsterDOA = new MonsterDOA();
        for(Long monster: p.getAllMonsters()){
           list.add(monsterDOA.getMonsterById(monster)); 
        }
        
        return list;
    }
    
    public void giveFirstMonster(Person p){
        Monster m = new Monster();
        m = m.generateRandom(p);
        this.monsterDOA.persist(m);
        p.addMonster(m.getId());
    }
     

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
}
