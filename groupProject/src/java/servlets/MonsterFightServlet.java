/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author Dave
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
    
    public void sendFightRequest(Person friend) {
        
    }
    public void acceptFight(Person friend) {
        
    }
    public void declineFight(Person friend) {
        
    }
   /*public void fight(long myMonsterID, long friendMonsterID) {
        Monster m1;
        Monster m2;
        m1 = monsterDOA.getMonsterById(myMonsterID);
        m2 = monsterDOA.getMonsterById(friendMonsterID);
		
	while((m1.getCurrentHealth()!=0)&&(m2.getCurrentHealth()!=0)){
            Random random = new Random();
            int attack1 = random.nextInt(20)+1;
            int attack2 = random.nextInt(20)+1;
            
            if(attack1 == 20){
                m2.setCurrentHealth(m2.getCurrentHealth()-(m1.getCurrentStrength()/2));
                System.out.println("Friend monster took a critical hit! Its health is now "+m2.getCurrentHealth());
            }
            if(attack2 == 20){
                m1.setCurrentHealth(m1.getCurrentHealth()-(m2.getCurrentStrength()/2));
                System.out.println("Your monster took a critical hit! Its health is now "+m1.getCurrentHealth());
            }
            if((attack1+m1.getCurrentStrength())>m2.getCurrentDefence()){
                m2.setCurrentHealth(m2.getCurrentHealth()-(m1.getCurrentStrength()/4));
                System.out.println("Friend monster took a damage! Its health is now "+m2.getCurrentHealth());
            }
            if((attack2+m2.getCurrentStrength())>m1.getCurrentDefence()){
                m1.setCurrentHealth(m1.getCurrentHealth()-(m2.getCurrentStrength()/4));
                System.out.println("Your monster took a damage! Its health is now "+m1.getCurrentHealth());
            }
	}
        
    }*/
    public List<Monster> getMonsterList(Person friend) {
        List<Monster> list = null;
        
        return list;
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
        
        request.setAttribute("offers", user.getFightOffers() );
        request.setAttribute("challenges", personDOA.getPersonsFightChallenges(user) );
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
