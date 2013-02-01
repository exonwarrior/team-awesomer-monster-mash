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
import java.util.ArrayList;
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
    String currentAction;
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
        Long monsterID;
        currentAction = request.getParameter("current_action");
       
        /*
         * Update the breed price
         */
        if(currentAction.equals("breed")){
            setBreedOffer(session, request);
            //request.setParameter("current monster id", )
        }
        /*
         * update the selling price
         */
        else if(currentAction.equals("sale")){
            
            setSaleOffer(session, request);
            
        }else if(currentAction.equals("breed_with_monster")){
            
            request = breedMonster(request, user);
        }
        /*
         * Update the current monster
         */
        if(currentAction.equals("changeMonster")){ 
            monsterID = Long.parseLong(request.getParameter("current monster id"));
            
            setCurrentMonster(session, monsterID );
        }
        
        session.setAttribute("monsters", personDOA.getPersonsMonsters(user) );
        ArrayList<Monster> monsters = (ArrayList<Monster>)session.getAttribute("monsters");
        if(monsters != null){ 
                for(Monster monster : monsters){                     
                    monsterDOA.checkLife(monster);
                }
        }
        request.getRequestDispatcher("/myMonsters.jsp").forward(request, response);
    
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
    
    public void setBreedOffer(HttpSession session, HttpServletRequest request){
        monsterDOA = new MonsterDOA();
        Long monsterID = Long.parseLong(request.getParameter("breed id"));
        Monster monster = monsterDOA.getMonsterById(monsterID);
        int price = Integer.parseInt(request.getParameter("breed price"));
        monster.setBreedOffer(price);
        monsterDOA.updateMonstersInfo(monster);
        currentAction = "changeMonster";
    }
    
    public void setSaleOffer(HttpSession session, HttpServletRequest request){
        monsterDOA = new MonsterDOA();
        Long monsterID = Long.parseLong(request.getParameter("sale id"));
        Monster monster = monsterDOA.getMonsterById(monsterID);
        int price = Integer.parseInt(request.getParameter("sale price"));
        monster.setSaleOffer(price);
        monsterDOA.updateMonstersInfo(monster);
        currentAction = "changeMonster";
    }
    
    public void setCurrentMonster(HttpSession session, Long id){
        monsterDOA = new MonsterDOA();
        session.setAttribute("current monster", monsterDOA.getMonsterById(id));        
    }
    
    private HttpServletRequest breedMonster(HttpServletRequest request, Person user){
         HttpSession session = request.getSession(false);
        
         Long friendsMonsterID = Long.parseLong(session.getAttribute("friendsMonsterID").toString());
         Long currentMonsterID = Long.parseLong(request.getParameter("current monster id"));
         
         Monster stud = monsterDOA.getMonsterById(friendsMonsterID);
         Monster bitch = monsterDOA.getMonsterById(currentMonsterID);
         
         Person seller = personDOA.getPersonByEmail(stud.getOwnerID());
         seller.setMoney(seller.getMoney()+stud.getBreedOffer());
         user.setMoney(user.getMoney() - stud.getBreedOffer());
         
         Monster baby = monsterDOA.breedMonsters(stud, bitch);
         
         baby.setOwner(user.getEmail());
         monsterDOA.persist(baby);
         
         personDOA.updatePersonsInfo(seller);
         personDOA.updatePersonsInfo(user);
         
         session.setAttribute("current_action", "done breeding");

         return request;
     }
}