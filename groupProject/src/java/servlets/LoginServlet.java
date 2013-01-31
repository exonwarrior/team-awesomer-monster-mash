package servlets;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import database.*;
import java.io.IOException;
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
@WebServlet(name = "Login", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {


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
     @EJB PersonDOA personDOA;
     @Override 
    protected void doPost(
        HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String tempEmail = request.getParameter("email");
        String tempPassword = request.getParameter("password");
        String formError =" ";
        
        response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
        
       
        if(this.check(tempEmail, tempPassword)){
                   
            personDOA = new PersonDOA();
            HttpSession session = request.getSession(true);
            Person p = personDOA.getPersonByEmail(tempEmail);
                
            session.setAttribute("user", p);            
            session.setAttribute("monsters", personDOA.getPersonsMonsters(p));
            session.setAttribute("friends", personDOA.getPersonsFriends(p));
            session.setAttribute("requestList", personDOA.getPersonsFriendRequests(p));
            session.setAttribute("offers", p.getFightOffers() );
            session.setAttribute("challenges", p.getFightChallenges() );
            request.getRequestDispatcher("/myMonsters.jsp").forward(request, response);
            
        }
        else{
            formError ="Incorrect email or password!";
            request.setAttribute("message", formError);
            request.getRequestDispatcher("/login.jsp").forward(request, response); 
            response.setHeader("Location", "http://localhost:8080/MonsterGame/login.jsp");
        }
        
       
    }
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
        
//        String home = "http://localhost:8080/MonsterGame/home.jsp";
//        String register = "http://localhost:8080/MonsterGame/pee.jsp";
//        request.setAttribute("check", answer );
//        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }
    
    public boolean check(String email, String password){
        boolean response = false;
        personDOA = new PersonDOA();
        if(personDOA.lookForEmail(email) && personDOA.getPersonByEmail(email).getPassword().equals(password)){
            response = true;
        }
 
        return response;
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
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
