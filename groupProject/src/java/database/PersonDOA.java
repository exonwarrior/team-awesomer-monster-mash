/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.util.ArrayList;
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

    public void addFriendRequest(Person person, String email) {
        emf = Persistence.createEntityManagerFactory("$objectdb/db/person.odb");

        em = emf.createEntityManager();
        Person dbPerson = em.find(Person.class, person.getId());
        try {
            em.getTransaction().begin();
            dbPerson.addFriendRequest(email);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
    
    public void deleteFriendRequest(Person person, String email) {
        emf = Persistence.createEntityManagerFactory("$objectdb/db/person.odb");

        em = emf.createEntityManager();
        Person dbPerson = em.find(Person.class, person.getId());
        try {
            em.getTransaction().begin();
            dbPerson.removeFriendRequest(email);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
    
    public void addFriend(Person person, String email) {
        emf = Persistence.createEntityManagerFactory("$objectdb/db/person.odb");

        em = emf.createEntityManager();
        Person dbPerson = em.find(Person.class, person.getId());
        try {
            em.getTransaction().begin();
            dbPerson.addFriend(email);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
    
    public void deleteFriend(Person person, String email) {
        emf = Persistence.createEntityManagerFactory("$objectdb/db/person.odb");

        em = emf.createEntityManager();
        Person dbPerson = em.find(Person.class, person.getId());
        try {
            em.getTransaction().begin();
            dbPerson.removeFriend(email);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
    
    private ArrayList<Person> getAllPeople() {
        emf = Persistence.createEntityManagerFactory("$objectdb/db/person.odb");
        em = emf.createEntityManager();
        ArrayList<Person> list = new ArrayList<Person>();
        try {
            em.getTransaction().begin();
            TypedQuery<Person> query = em.createQuery("SELECT p FROM Person p", Person.class);
            list.addAll(query.getResultList()) ;
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        list = getPeoplesArrays(list);
        return list;
    }
    
    public ArrayList<Person> getPeoplesArrays(ArrayList<Person> people){
        ArrayList<Person> list = new ArrayList<Person>();
        for(Person p : people){
            p = getPersonsArrays(p);
            list.add(p);
        }
        return list;
    }
    
    public Person getPersonsArrays(Person p){
        emf = Persistence.createEntityManagerFactory("$objectdb/db/person.odb");
        em = emf.createEntityManager();
        Person dbPerson = em.find(Person.class, p.getId());
        return dbPerson;
    }

    public boolean lookForEmail(String email) {
        boolean answer = false;
        ArrayList<Person> list = this.getAllPeople();
        for (Person p : list) {
            if (p.getEmail() == null ? email == null : p.getEmail().equals(email)) {
                answer = true;
            }
        }
        return answer;
    }

    public Person getPersonByEmail(String email) {
        ArrayList<Person> people = getAllPeople();
        Person p = null;
        for(Person person: people){
            if(person.getEmail().equalsIgnoreCase(email)){
                p = person;
            }
        }
        return p;
        
    }
    
    public boolean checkFriendRequestList(Person p, String email) {
        emf = Persistence.createEntityManagerFactory("$objectdb/db/person.odb");
        em = emf.createEntityManager();
        
        boolean answer = false;      
        Person dbPerson = em.find(Person.class, p.getId());
        if (!(dbPerson.getAllFriendRequests().isEmpty())) {
            for (String person : dbPerson.getAllFriendRequests()) {
                if (person.equals(email)) {
                    answer = true;
                }
            }
        }
        em.close();
        return answer;
    }

    //TODO 
    public ArrayList<Person> getPersonsFriends(Person p) {
        ArrayList<Person> list = new ArrayList<Person>();
        if (!(p.getAllFriends().isEmpty())) {
            for (Person friend : getAllPeople()) {
                for (String person : p.getAllFriends()) {
                    if (friend.getEmail().equals(person)) {
                        list.add(friend);
                    }
                }
            }

        }
        return list;
    }

    public ArrayList<Person> getPersonsFriendRequests(Person p) {
        ArrayList<Person> list = new ArrayList<Person>();
        if (!(p.getAllFriendRequests().isEmpty())) {
            for (Person friend : getAllPeople()) {
                for (String person : p.getAllFriendRequests()) {
                    if (friend.getEmail().equals(person)) {
                        list.add(friend);
                    }
                }
            }

        }
        return list;
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
        //p.addMonster(m.getMonsterID());
        
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
    
    public Person updateFights(Person person){
        Long opp, chall, oppM, challM;
        
        for(Fight fight:person.getAllFights()){
            
            opp = fight.getOpponent();
            fight.setOpponent(getPersonByID(opp));
            
            chall = fight.getChallenger();
            fight.setOpponent(getPersonByID(chall));
            
            oppM = fight.getOppMonster();
            fight.setOppMonster(monsterDOA.getMonsterById(oppM));
            
            challM  = fight.getChallMonster();
            fight.setChallMonster(monsterDOA.getMonsterById(challM));   
        }
        
        return person;
    }
    
    public void updatePersonsInfo(Person person){
        emf = Persistence.createEntityManagerFactory("$objectdb/db/person.odb"); 
        em = emf.createEntityManager();
        
        Person dbPerson = em.find(Person.class, person.getId());
        
        try{
             em.getTransaction().begin();
             dbPerson.setMoney(person.getMoney());
             em.getTransaction().commit();
        }
        finally{
             em.close();
        } 
    }
    
    /**
     *
     * @param person
     * @param fight
     */
    public void updatePersonsInfo(Person person,Fight fight){
        emf = Persistence.createEntityManagerFactory("$objectdb/db/person.odb"); 
        em = emf.createEntityManager();
        
        Person dbPerson = em.find(Person.class, person.getId());
        
        try{
             em.getTransaction().begin();
             
             dbPerson.addFight(fight);

             em.getTransaction().commit();
        }
        finally{
             em.close();
        } 
    }
    
}
