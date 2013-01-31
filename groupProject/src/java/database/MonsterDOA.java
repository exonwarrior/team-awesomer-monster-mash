/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
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
             TypedQuery<Monster> query = em.createQuery("SELECT m FROM Monster m", Monster.class);
             list = query.getResultList();
             em.getTransaction().commit();
        }
        finally{
             em.close();
        }
        
        
        return list;
    }
    
    public boolean doesExist(String name){
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
        
    }
    
    public void updateMonstersInfo(Monster monster){
        emf = Persistence.createEntityManagerFactory("$objectdb/db/monster.odb"); 
        em = emf.createEntityManager();
        
        Monster dbMonster = em.find(Monster.class, monster.getId());
        
        try{
             em.getTransaction().begin();
             dbMonster.setBreedOffer(monster.getBreedOffer());
             dbMonster.setSaleOffer(monster.getSaleOffer());
             dbMonster.setCurrentHealth(monster.getBaseHealth());
             dbMonster.setOwner(monster.getOwnerID());
             em.getTransaction().commit();
        }
        finally{
             em.close();
        } 
    }
 
    public ArrayList<Monster> getMonsterByUser(Person user){
        ArrayList<Monster> list = new ArrayList<Monster>();
        for(Monster monster : getAllMonsters()){
            if(monster.getOwnerID().equals(user.getEmail())){
                list.add(monster);
            }
        }
        return list;
    }
    
    public Monster breedMonsters(Monster monster, Monster monster2){
        Monster baby = new Monster();
        Random random = new Random();
        int r = random.nextInt(3);
        if(2 == 0){
            baby.setBaseStrength(monster.getBaseStrength());
            baby.setCurrentStrength(baby.getBaseStrength());
            baby.setBaseDefence(monster2.getBaseDefence());
            baby.setCurrentDefence(baby.getBaseDefence());
            baby.setBaseHealth((monster.getBaseHealth()+
                    +monster2.getBaseHealth())/2);
            baby.setCurrentHealth(baby.getBaseHealth());
        } else if(r == 1){
            baby.setBaseDefence(monster.getBaseDefence());
            baby.setCurrentDefence(baby.getBaseDefence());
            baby.setBaseHealth(monster2.getBaseHealth());
            baby.setCurrentHealth(baby.getBaseHealth());
            baby.setBaseStrength((monster.getBaseStrength()+
                    +monster2.getBaseStrength())/2);
            baby.setCurrentStrength(baby.getBaseStrength());
        } else {
            baby.setBaseHealth(monster.getBaseHealth());
            baby.setCurrentHealth(baby.getBaseHealth());
            baby.setBaseStrength(monster2.getBaseStrength());
            baby.setCurrentStrength(baby.getBaseStrength());
            baby.setBaseDefence((monster.getBaseDefence()+
                    +monster2.getBaseDefence())/2);
            baby.setCurrentDefence(baby.getBaseDefence());
        }
        int m = random.nextInt(20)+1;
        if(m==1){
            int w = random.nextInt(3);
            if(w==0){
                baby.setBaseStrength(baby.getBaseStrength()+(baby.getBaseStrength()/4));
            } else if (w==1){
                baby.setBaseDefence(baby.getBaseDefence()+(baby.getBaseDefence()/4));
            } else {
                baby.setBaseHealth(baby.getBaseDefence()+(baby.getBaseDefence()/4));
            }
        }
        System.out.println("NOW RETURN THE BABY");
        return baby;
    }
    
    public void checkLife(Monster m){
        m.setLifeSpan((int)(m.getLifeSpan()-((System.currentTimeMillis() / 1000L)-m.getBirthDate())));
        if(m.getLifeSpan()<0){
            remove(m);
        }
    }
    
    public void remove(Monster m){
        emf = Persistence.createEntityManagerFactory("$objectdb/db/monster.odb"); 
        em = emf.createEntityManager();
        m = em.find(Monster.class, m.getId());
        em.getTransaction().begin();
        em.remove(m);
        em.getTransaction().commit();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
}
