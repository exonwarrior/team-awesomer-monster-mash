/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.util.List;
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
    EntityManager em;
    
    public PersonDOA(){

    }
 
    // Stores a new guest: 
    public void persist(Person person) {
        emf = Persistence.createEntityManagerFactory("$objectdb/db/person.odb");
        em = emf.createEntityManager();
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
        TypedQuery<Person> query = em.createQuery("SELECT p FROM Person p", Person.class);
        return query.getResultList();
    }
    
    public boolean doesExit(String name){
        boolean answer = false;
        List<Person> list = this.getAllPeople();
        for(Person p: list){
            if(p.getName() == name){
                answer = true;
            }
        }
        return answer;
    }
    
    public Person getPersonByName(String name){
        emf = Persistence.createEntityManagerFactory("$objectdb/db/person.odb");
        em = emf.createEntityManager();
        Person p = null;
        try{
            em.getTransaction().begin();
            TypedQuery<Person> query = em.createQuery(
            "SELECT p FROM Person AS p WHERE p.name = :name", Person.class)
                    .setParameter("name", name);
            p = query.getSingleResult();
            em.getTransaction().commit();
            
        }
        finally{
            em.close();
        }
        return p;
        //return me;
    }
    
     

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
}
