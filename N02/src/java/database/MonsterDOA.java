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
 * Class for handling the interaction between Monster objects and the databse
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
 
    /**
     * Method for saving monster objects to database.
     * @param monster - monster object to be saved.
     */
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
    /**
     * Method for retrieving list of monsters in the database, regardless of owner.
     * @return - list of Monsters.
     */
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
    /**
     * Method for verifying a monster with the name provided exists in list.
     * @param name - name of monster to be found
     * @return true/false.
     */
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
    /**
     * Retrieve monster from database, based on its name.
     * @param name - name that is being searched for.
     * @return - the found monster.
     */
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
    }
    /**
     * Retrieve monster from database, based on its id.
     * @param id - id that is being searched for.
     * @return - the found monster.
     */
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
    /**
     * Method for updating monster info.
     * @param monster - monster that is to be updated.
     */
    public void updateMonstersInfo(Monster monster){
        emf = Persistence.createEntityManagerFactory("$objectdb/db/monster.odb"); 
        em = emf.createEntityManager();
        
        Monster dbMonster = em.find(Monster.class, monster.getId());
        
        try{
             em.getTransaction().begin();
             dbMonster.setBreedOffer(monster.getBreedOffer());
             dbMonster.setSaleOffer(monster.getSaleOffer());
             dbMonster.setCurrentHealth(monster.getCurrentHealth());
             dbMonster.setOwner(monster.getOwnerID());
             em.getTransaction().commit();
        }
        finally{
             em.close();
        } 
    }
    /**
     * Method that retrieves a list of monsters belonging to a single user.
     * @param user - user that's list of monsters is needed.
     * @return - resultant list.
     */
    public ArrayList<Monster> getMonsterByUser(Person user){
        ArrayList<Monster> list = new ArrayList<Monster>();
        for(Monster monster : getAllMonsters()){
            if(monster.getOwnerID().equals(user.getEmail())){
                list.add(monster);
            }
        }
        return list;
    }
    /**
     * Method for breeding two monsters. Using a series of random dice rolls,
     * stats to be inherited or randomized are chosen, with a healthy dose of
     * random mutation.
     * @param monster - known as the stud.
     * @param monster2 - known as the bitch. 
     * @return - resulting baby monster.
     */
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
        baby.setLifeSpan(73400);
        baby.setName("Little baby " + baby.getMonsterID());
        baby.setBirthDate((int) (System.currentTimeMillis() / 1000L));
        System.out.println("NOW RETURN THE BABY");
        return baby;
    }
    /**
     * Method for checking remaining lifespan on Monster. If lifespan is reduced
     * to zero or below, monster is removed from database.
     * @param m - monster that's life is to be checked.
     */
    public void checkLife(Monster m){
        m.setLifeSpan((int)(m.getLifeSpan()-((System.currentTimeMillis() / 1000L)-m.getBirthDate())));
        if(m.getLifeSpan()<0){
            remove(m);
        }
    }
    /**
     * Method to simply remove a monster from a player's monster list.
     * @param m - monster to be deleted.
     */
    public void remove(Monster m){
        emf = Persistence.createEntityManagerFactory("$objectdb/db/monster.odb"); 
        em = emf.createEntityManager();
        m = em.find(Monster.class, m.getId());
        em.getTransaction().begin();
        em.remove(m);
        em.getTransaction().commit();
    }
}
