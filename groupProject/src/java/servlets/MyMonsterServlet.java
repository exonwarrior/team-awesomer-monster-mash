/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import database.MonsterDOA;
import database.Person;
import database.PersonDOA;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author thh21
 */
@WebServlet(name = "MyMonsters", urlPatterns = {"/myMonsters"})
public class MyMonsterServlet extends HttpServlet {
    
    @EJB PersonDOA personDOA;
    @EJB MonsterDOA monsterDOA;
    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
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
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        personDOA = new PersonDOA();
        monsterDOA = new MonsterDOA();
        
        processRequest(request, response);
        HttpSession session = request.getSession(false);
        Person user = (Person) session.getAttribute("user");
        String monsterID;
       
        if(request.getParameter("current_action").equals("changeMonster")){ 
            monsterID = request.getParameter("current monster id");
            
            setCurrentMonster(session, monsterID );
        }
        else if(request.getParameter("current_action").equals("breed")){
            monsterID = request.getParameter("breed");
            setBreedMonster(session, monsterID);
        }
        else if(request.getParameter("current_action").equals("sell")){
            monsterID = request.getParameter("sell");
            sellMonster(session, monsterID);
        }
        
        session.setAttribute("monsters", personDOA.getPersonsMonsters(user) );
        request.getRequestDispatcher("/MyMonsters.jsp").forward(request, response);
    
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
    public void setBreedMonster(HttpSession session, String id){
        monsterDOA = new MonsterDOA();
        monsterDOA.getMonsterById(id).setPrice(9000);
    }
    
    public void sellMonster(HttpSession session, String ID){
        
    }
    
    public void setCurrentMonster(HttpSession session, String id){
        monsterDOA = new MonsterDOA();
        session.setAttribute("current monster", monsterDOA.getMonsterById(id));
    }
}
