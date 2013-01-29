/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import database.Monster;
import database.MonsterDOA;
import database.Person;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Random;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Dave
 */
public class MonsterFightServlet extends HttpServlet {
    @EJB
    private MonsterDOA monsterDOA;
    
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MonsterFightServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet MonsterFightServlet at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
             */
        } finally {            
            out.close();
        }
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
   public void fight(long myMonsterID, long friendMonsterID) {
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
        
    }
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
