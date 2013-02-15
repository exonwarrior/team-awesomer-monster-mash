
package servlets;

import database.Monster;
import database.MonsterDOA;
import database.Person;
import database.PersonDOA;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Random;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import types.Fight;

/**
 * This class contains methods which manages connection and 
 * data exchange between .jsp and java classes for monsters fight.
 * 
 */
@WebServlet(name = "MonsterFight", urlPatterns = {"/monsterFight"})
public class MonsterFightServlet extends HttpServlet {
    
    @EJB PersonDOA personDOA;
    @EJB MonsterDOA monsterDOA;
    String currentAction;
    
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
    
    protected void doPost() {
        
    }
    protected void doGet(){
        
    }
    
    /**
     * Algorithm for processing monster fights. attacks are calculated based on
     * random dice rolls and respective attributes. Critical hits are also possible.
     * At the end monster stats are updated and the dead one removed.
     * @param fight object containing information on monsters and people involved.
     */
    public HttpServletRequest fight(Fight fight,HttpServletRequest request ) {
        personDOA = new PersonDOA();
        Monster m1;
        Monster m2;
        Person challenger = personDOA.getPersonByID(fight.getChallenger());
        Person user = personDOA.getPersonByID(fight.getOpponent());
        
        m1 = monsterDOA.getMonsterById(fight.getOppMonster());
        m2 = monsterDOA.getMonsterById(fight.getChallMonster());
		
	while((m1.getCurrentHealth()>0)&&(m2.getCurrentHealth()>0)){
            Random random = new Random();
            double attack1 = random.nextDouble();
            double attack2 = random.nextDouble();
            
            if(attack1 == 1){
                m2.setCurrentHealth(m2.getCurrentHealth()-(m1.getCurrentStrength()/2));
                System.out.println("Friend monster took a critical hit! Its health is now "+m2.getCurrentHealth());
            }
            if(attack2 == 1){
                m1.setCurrentHealth(m1.getCurrentHealth()-(m2.getCurrentStrength()/2));
                System.out.println("Your monster took a critical hit! Its health is now "+m1.getCurrentHealth());
            }
            if((attack1+m1.getCurrentStrength())>m2.getCurrentDefence()){
                m2.setCurrentHealth(m2.getCurrentHealth()-(m1.getCurrentStrength()/4));
                System.out.println("Friend monster took "+(m2.getCurrentHealth()-(m1.getCurrentStrength()/4))+"damage! Its health is now "+m2.getCurrentHealth());
            }
            if((attack2+m2.getCurrentStrength())>m1.getCurrentDefence()){
                m1.setCurrentHealth(m1.getCurrentHealth()-(m2.getCurrentStrength()/4));
                System.out.println("Your monster took "+(m1.getCurrentHealth()-(m2.getCurrentStrength()/4))+" damage! Its health is now "+m1.getCurrentHealth());
            }
	}
        monsterDOA.updateMonstersInfo(m1);
        monsterDOA.updateMonstersInfo(m2);
        if(monsterDOA.getMonsterById(m2.getId()).getCurrentHealth()<0){
            monsterDOA.remove(m2);
            request.setAttribute("fight result", "You won the Fight!!!");
            user.setMoney(user.getMoney() + 100);
            
        }        
        if(monsterDOA.getMonsterById(m1.getId()).getCurrentHealth()<0){
            monsterDOA.remove(m1);
            request.setAttribute("fight result", "You lost the fight :(");
            challenger.setMoney(challenger.getMoney() + 100);
        }
        challenger.removeFightOffer(fight);
        personDOA.updatePersonsInfo(challenger);
        personDOA.deupdatPersonsInfo(challenger, fight);
        
        user.removeFightOffer(fight);
        personDOA.updatePersonsInfo(user);
        personDOA.deupdatPersonsInfo(user, fight);
        
              
        return request;
    }

   
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        personDOA = new PersonDOA();
        monsterDOA = new MonsterDOA();
        HttpSession session = request.getSession(false);
        Person user = (Person) session.getAttribute("user");
        currentAction  = request.getParameter("current action");
        Long id;    
        
        if(currentAction.equals("personStats")){
            id = Long.parseLong(request.getParameter("current person id"));
            session.setAttribute("current person", personDOA.getPersonByID(id));
        }
        else if(currentAction.equals("monsterStats")){
            id = Long.parseLong(request.getParameter("current monster id"));
            session.setAttribute("current monster", monsterDOA.getMonsterById(id));
        }
        else if(currentAction.equals("fight")){
            Long monster = Long.parseLong(request.getParameter("current monster id"));
            Long person = Long.parseLong(request.getParameter("current person id"));
            
            request = fight(user.getFightByID( person, monster), request);
            
            
        }else if(currentAction.equals("deleteFight")){
            Long monster = Long.parseLong(request.getParameter("current monster id"));
            Long person = Long.parseLong(request.getParameter("current person id"));
            
            Fight fight = user.getFightByID( person, monster);
            user.removeFightOffer(fight);
            personDOA.getPersonByID(fight.getChallenger()).removeFightOffer(fight);
            personDOA.getPersonByID(fight.getOpponent()).removeFightOffer(fight);
            
            
        }
        
        user = personDOA.getPersonByID(user.getId());
        session.setAttribute("user", user);
        session.setAttribute("offers", user.getFightOffers() );
        session.setAttribute("challenges", user.getFightChallenges() );
        
        request.getRequestDispatcher("/monsterFights.jsp").forward(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}