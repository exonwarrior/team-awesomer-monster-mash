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
import types.Fight;

/**
 *
 * @author thh21
 */
@Stateless
@LocalBean
public class PersonDOA {

    EntityManagerFactory emf;
    @PersistenceContext(unitName = "MonsterGamePU")
    EntityManager em;
    @EJB
    MonsterDOA monsterDOA;

    public PersonDOA() {
    }

    // Stores a new guest: 
    public void persist(Person person) {
        emf = Persistence.createEntityManagerFactory("$objectdb/db/person.odb");

        em = emf.createEntityManager();
        if(person.getAllMonsters().isEmpty()){
            try {
            em.getTransaction().begin();
            em.persist(person);
            giveFirstMonster(person);
            giveFirstMonster(person);
            em.getTransaction().commit();
            } finally {
                em.close();
            }
        }
        else {
            try {
                em.getTransaction().begin();
                em.persist(person);
                em.getTransaction().commit();
            } finally {
                em.close();
            }
        }
    }

    public void updatePersonsInfo(Person person) {
        emf = Persistence.createEntityManagerFactory("$objectdb/db/person.odb");

        em = emf.createEntityManager();
        Person dbPerson = em.find(Person.class, person.getId());
        try {
            em.getTransaction().begin();
            dbPerson.setFriendRequests(person.getAllFriendRequests());
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    private List<Person> getAllPeople() {
        emf = Persistence.createEntityManagerFactory("$objectdb/db/person.odb");
        em = emf.createEntityManager();
        List<Person> list;
        try {
            em.getTransaction().begin();
            TypedQuery<Person> query = em.createQuery("SELECT p FROM Person p", Person.class);
            list = query.getResultList();
            em.getTransaction().commit();
        } finally {
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
    public boolean lookForEmail(String email) {
        boolean answer = false;
        List<Person> list = this.getAllPeople();
        for (Person p : list) {
            if (p.getEmail() == null ? email == null : p.getEmail().equals(email)) {
                answer = true;
            }
        }
        return answer;
    }

    public Person getPersonByEmail(String email) {
        emf = Persistence.createEntityManagerFactory("$objectdb/db/person.odb");
        em = emf.createEntityManager();
        Person p = null;
        try {
            em.getTransaction().begin();
            TypedQuery<Person> query = em.createQuery(
                    "SELECT p FROM Person AS p WHERE p.email = :email", Person.class)
                    .setParameter("email", email);
            p = query.getSingleResult();
            em.getTransaction().commit();

        } finally {
            em.close();
        }
        return p;
        //return me;
    }

    public boolean checkFriendRequestList(Person p, String email) {
        boolean answer = false;
        if (!p.getAllFriendRequests().isEmpty()) {
            for (String person : p.getAllFriendRequests()) {
                if (person.equals(email)) {
                    answer = true;
                }
            }
        }
        return answer;
    }

    //TODO 
    public ArrayList<Person> getPersonsFriends(Person p) {
        ArrayList<Person> list = new ArrayList<Person>();
        if (!p.getAllFriends().isEmpty()) {
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

    public ArrayList<Monster> getPersonsMonsters(Person p) {
        monsterDOA = new MonsterDOA();

        return monsterDOA.getMonsterByUser(p);
    }

    public void giveFirstMonster(Person p) {
        monsterDOA = new MonsterDOA();
        Monster m = new Monster();
        m = m.generateRandom(p);
        this.monsterDOA.persist(m);
        p.addMonster(m.getMonsterID());
    }
    
    public Person getPersonByID(Long id){
        Person person = null;
        for(Person p: getAllPeople()){
            if(p.getId().equals(id)){
                person = p;
            }
        }
        return person;
    }
    
    public ArrayList<Fight> updateFights(ArrayList<Fight> fights){
        ArrayList<Fight> latestFights = new ArrayList<Fight>();
        Long opp, chall, oppM, challM;
        for(Fight fight:fights){
            
            opp = fight.getOpponent().getId();
            fight.setOpponent(getPersonByID(opp));
            
            chall = fight.getChallenger().getId();
            fight.setOpponent(getPersonByID(chall));
            
            oppM = fight.getOppMonster().getId();
            fight.setOppMonster(monsterDOA.getMonsterById(oppM));
            
            challM  = fight.getChallMonster().getId();
            fight.setChallMonster(monsterDOA.getMonsterById(challM));
            
            monsterDOA.getMonsterById(fight.getChallMonster().getId());
            
        }
        
        return latestFights;
    }
    
}
