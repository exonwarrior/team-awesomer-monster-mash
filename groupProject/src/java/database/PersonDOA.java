/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
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
    
    public void updatePersonsInfo(Person person) {
        emf = Persistence.createEntityManagerFactory("$objectdb/db/person.odb");
        
        em = emf.createEntityManager();
        //Person toUpdate = em.find(Person.class, person.getId());
        try{
             em.getTransaction().begin();
             em.persist(person);          
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
    
//    public boolean doesExist(String email){
//        boolean answer = false;
//        List<Person> list = this.getAllPeople();
//        for(Person p: list){
//            if(p.getEmail() == null ? email == null : p.getEmail().equals(email)){
//                answer = true;
//            }
//        }
//        return answer;
//    }
   
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
    
    public ArrayList<Person> getPersonsFriends(Person p) {
        ArrayList<Person> list = new ArrayList<Person>();
        if (!p.getAllFriends().equals(null)) {
            for (Person friend : getAllPeople()) {
                for (String person : p.getAllFriends()) {
                    if (friend.getEmail().equals(person)) {
                        list.add(friend);
                    }
                }
            }
            return list;
        } else {
            return null;
        }
    }
    
    public ArrayList<Monster> getPersonsMonsters(Person p){
        monsterDOA = new MonsterDOA();
 
        return monsterDOA.getMonsterByUser(p);
    }
    
    public void giveFirstMonster(Person p){
        monsterDOA = new MonsterDOA();
        Monster m = new Monster();
        m = m.generateRandom(p);
        this.monsterDOA.persist(m);
        p.addMonster(m.getMonsterID());
    }
     

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
}
