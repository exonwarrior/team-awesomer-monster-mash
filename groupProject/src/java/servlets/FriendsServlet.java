/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import database.Person;
import database.PersonDOA;
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
 * @author szs1
 */

@WebServlet(name = "friends", urlPatterns = {"/myFriends"})
public class FriendsServlet extends HttpServlet {
    @EJB PersonDOA personDOA;
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
       
        processRequest(request, response);
        HttpSession session = request.getSession(false);
        Person user = (Person) session.getAttribute("user");
        currentAction = request.getParameter("current_action");
        
        if(currentAction.equals("send_request")){
            request = this.sendRequest(request, user);
            
        }else if(currentAction.equals("accept_request")){
            request = this.acceptRequest(request, user);
            
        }else if(currentAction.equals("decline_request")){
            request = this.declineRequest(request, user);
            
        }else if(currentAction.equals("get_monster")){
            String friendsEmail = request.getParameter("requestEmail");
            Person friend = personDOA.getPersonByEmail(friendsEmail);
 
            session.setAttribute("friendsMonsters", personDOA.getPersonsMonsters(friend));
            
        }else if(currentAction.equals("challenge_monster")){
            Long friendsMonsterID = Long.parseLong(request.getParameter("friendsMonsterID"));
            this.challengeMonster(session, friendsMonsterID);
            }
        
        user = personDOA.getPersonByID(user.getId());
        session.setAttribute("user", user);

        session.setAttribute("requestList", personDOA.getPersonsFriendRequests(user));
        session.setAttribute("friends", personDOA.getPersonsFriends(user) );

        request.getRequestDispatcher("/friends.jsp").forward(request, response);
    }
    
                //  response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
          /*  if(this.check(userEmail)){
                //personDOA.addFriendRequest((Person)session.getAttribute("user"), personDOA.getPersonByEmail(userEmail));
                request.setAttribute("message", "Friend request sent.");
                request.getRequestDispatcher("/friends.jsp").forward(request, response);
            }else{
                request.setAttribute("message", "Friend doesn't exist.");
                request.getRequestDispatcher("/friends.jsp").forward(request, response);
            }*/
    
    private boolean checkIfExist(String userEmail){
        return personDOA.lookForEmail(userEmail);
    }

    private HttpServletRequest sendRequest(HttpServletRequest request, Person user ){
        String friendsEmail = request.getParameter("requestEmail");
            if(checkIfExist(friendsEmail) && !(user.getEmail().equalsIgnoreCase(friendsEmail))){
                
                Person friend = personDOA.getPersonByEmail(friendsEmail);
                
                friend.addFriendRequest(user.getEmail());

                personDOA.addFriendRequest(friend, user.getEmail());
         
            
            }else{
                request.setAttribute("message", "Friend doesn't exist.");               
            }
            
            return request;
    }
    
    private HttpServletRequest acceptRequest(HttpServletRequest request, Person user ){
        String friendsEmail = request.getParameter("requestEmail");
            
            
            user = personDOA.getPersonByEmail(user.getEmail());
            
            if(personDOA.checkFriendRequestList(user, friendsEmail)){
                Person friend = personDOA.getPersonByEmail(friendsEmail);
                personDOA.addFriend(user, friendsEmail);
                personDOA.deleteFriendRequest(user, friendsEmail);
                personDOA.addFriend(friend, user.getEmail());
            }else{
                request.setAttribute("message", "Friend doesn't exist.");               
            }
            return request;
    }
    
     private HttpServletRequest declineRequest(HttpServletRequest request, Person user ){
         
         String friendsEmail = request.getParameter("requestEmail");
            user = personDOA.getPersonByEmail(user.getEmail());
            if(personDOA.checkFriendRequestList(user, friendsEmail)){
                
                personDOA.deleteFriendRequest(user, friendsEmail);
            
            }else{
                request.setAttribute("message", "Friend doesn't exist.");  
            }
         
         return request;
     }
     
     private void challengeMonster(HttpSession session, Long id){
         //Make me workz!!1!
     }
     
     private void breedMonster(HttpServletRequest request, Person user){
         
     }
     
     private void buyMonster(HttpServletRequest request, Person user){
         
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
