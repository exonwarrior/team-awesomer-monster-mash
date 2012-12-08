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
 * @author Dave
 */
@Stateless
@LocalBean
public class MonsterDOA {
    
    EntityManagerFactory emf;
   
    @PersistenceContext(unitName = "MonsterGamePU" )
     EntityManager em;
    
    public MonsterDOA(){

    }
 
    // Stores a new guest: 
    public void persist(Monster monster) {
        emf = Persistence.createEntityManagerFactory("$objectdb/db/monster.odb");
        
        em = emf.createEntityManager();
        try{
             em.getTransaction().begin();
             em.persist(monster);
             em.getTransaction().commit();
        }
        finally{
             em.close();
        }   
    }
    
    private List<Monster> getAllMonsters(){
        emf = Persistence.createEntityManagerFactory("$objectdb/db/monster.odb");
        em = emf.createEntityManager();
        List<Monster> list;
        try{
             em.getTransaction().begin();
             TypedQuery<Monster> query = em.createQuery("SELECT m FROM Monster", Monster.class);
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
        List<Monster> list = this.getAllMonsters();
        for(Monster m: list){
            if(m.getName() == null ? name == null : m.getName().equals(name)){
                answer = true;
            }
        }
        return answer;
    }
    
    public Monster getMonsterByName(String name){
        emf = Persistence.createEntityManagerFactory("$objectdb/db/monster.odb");
        em = emf.createEntityManager();
        Monster m = null;
        try{
            em.getTransaction().begin();
            TypedQuery<Monster> query = em.createQuery(
            "SELECT m FROM Monster AS m WHERE m.name = :name", Monster.class)
                    .setParameter("name", name);
            m = query.getSingleResult();
            em.getTransaction().commit();
            
        }
        finally{
            em.close();
        }
        return m;
        //return me;
    }
    public Monster getMonsterById(Long id){
        emf = Persistence.createEntityManagerFactory("$objectdb/db/monster.odb");
        em = emf.createEntityManager();
        Monster m = null;
        try{
            em.getTransaction().begin();
            TypedQuery<Monster> query = em.createQuery(
            "SELECT m FROM Monster AS m WHERE m.id = :id", Monster.class)
                    .setParameter("id", id);
            m = query.getSingleResult();
            em.getTransaction().commit();
            
        }
        finally{
            em.close();
        }
        return m;
        //return me;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
}
