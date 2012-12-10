/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import database.Person;
import database.PersonDOA;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author szs1
 */
public class FriendsServlet extends HttpServlet {
    @EJB PersonDOA personDOA;
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
        HttpSession session = request.getSession(false);
        if(session.getAttribute("user") != null){
            String userEmail = request.getParameter("useremail");
            response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
            if(this.check(userEmail)){
                personDOA.addFriendRequest((Person)session.getAttribute("user"), personDOA.getPersonByEmail(userEmail));
                request.setAttribute("message", "Friend request sent.");
                request.getRequestDispatcher("/friends.jsp").forward(request, response);
            }else{
                request.setAttribute("message", "Friend doesn't exist.");
                request.getRequestDispatcher("/friends.jsp").forward(request, response);
            }
        }else{
            request.setAttribute("message", "User not logged in.");
            request.getRequestDispatcher("/friends.jsp").forward(request, response);
        }
    }
    
    private boolean check(String userEmail){
        return !personDOA.doesExist(userEmail);
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
}
