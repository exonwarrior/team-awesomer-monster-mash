
package servlets;

import database.Monster;
import database.MonsterDOA;
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
 * This class contains methods which manages connection and 
 * data exchange between friends.jsp and database.
 */
@WebServlet(name = "friends", urlPatterns = {"/myFriends"})
public class FriendsServlet extends HttpServlet {
    @EJB PersonDOA personDOA;
    @EJB MonsterDOA monsterDOA;
    String currentAction;
    String forwardUrl = "/friends.jsp";
   
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
        monsterDOA = new MonsterDOA();
       
        processRequest(request, response);
        HttpSession session = request.getSession(false);
        Person user = (Person) session.getAttribute("user");
        currentAction = request.getParameter("current_action");
        forwardUrl = "/friends.jsp";
        
        //method which sends friend requests
        if(currentAction.equals("send_request")){
            request = this.sendRequest(request, user);
        
        //method which accepts received friend requests   
        }else if(currentAction.equals("accept_request")){
            request = this.acceptRequest(request, user);
          
         //method that declines reveived friend requests   
        }else if(currentAction.equals("decline_request")){
            request = this.declineRequest(request, user);
         
         //method that allows user displaying users monsters   
        }else if(currentAction.equals("get_monster")){
            String friendsEmail = request.getParameter("requestEmail");
            Person friend = personDOA.getPersonByEmail(friendsEmail);
 
            session.setAttribute("friendsMonsters", personDOA.getPersonsMonsters(friend));
         
         //method that allows user fight with friends monster   
        }else if(currentAction.equals("challenge_monster")){
            this.forwardUrl = "/myMonsters.jsp";
            session.setAttribute("friendsMonsterID", request.getParameter("friendsMonsterID"));
            session.setAttribute("current_action", "fight");
         
          //method that allows user to buy friends monster
        } else if(currentAction.equals("purchase")){   
            request = buyMonster(request, user);
            
          //method that allows user to breed with friends monster 
        } else if(currentAction.equals("breed")){
            this.forwardUrl = "/myMonsters.jsp";
            session.setAttribute("friendsMonsterID", request.getParameter("friendsMonsterID"));
            session.setAttribute("current_action", "breed");
        }
        
        user = personDOA.getPersonByID(user.getId());
        session.setAttribute("user", user);

        session.setAttribute("requestList", personDOA.getPersonsFriendRequests(user));
        session.setAttribute("friends", personDOA.getPersonsFriends(user) );

        request.getRequestDispatcher(this.forwardUrl).forward(request, response);
    }
    
    /**
     * Checks if user email already exists in the database
     * @param userEmail , takes users email as a param  
     * @return , returns true if found
     */
    private boolean checkIfExist(String userEmail){
        return personDOA.lookForEmail(userEmail);
    }

    /**
     * Method that takes user input adds users friend request 
     * to the list and updates the database
     * @param request , HTTP request
     * @param user , Object Person 
     * @return , request
     */
    private HttpServletRequest sendRequest(HttpServletRequest request, Person user ){
        String friendsEmail = request.getParameter("requestEmail");
            if(checkIfExist(friendsEmail) && !(user.getEmail().equalsIgnoreCase(friendsEmail))){
                Person friend = personDOA.getPersonByEmail(friendsEmail);
                friend.addFriendRequest(user.getEmail());
                personDOA.addFriendRequest(friend, user.getEmail());
                request.setAttribute("message", "Friend Request has been successfully sent.");
                
            }else{
                request.setAttribute("message", "Friend doesn't exist.");               
            }
            return request;
    }
    
    /**
     * Method that takes user input adds users friend request 
     * to the list and updates the database
     * @param request , HTTP request
     * @param user , Object Person
     * @return , request
     */
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
    
    /**
     * Method that takes user input deletes users friend request 
     * from the list and updates the database
     * @param request , HTTTP request
     * @param user , Object Person
     * @return , request
     */
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
     
     /**
      * Method that takes user input sends fight request 
      * and updates the database
      * @param request , HTTP request   
      * @param user , Obejct Person 
      * @return , request
      */
     private HttpServletRequest challengeMonster(HttpServletRequest request, Person user){
         HttpSession session = request.getSession(false);
         Long friendsMonsterID = Long.parseLong(request.getParameter("friendsMonsterID"));
         Monster challenged = monsterDOA.getMonsterById(friendsMonsterID);
         Person challengedFriend = personDOA.getPersonByEmail(challenged.getOwnerID());
         
         return request;
     }
     
     /**
      * Method that takes user input sends breed request to the friend 
      * and updates the database
      * @param request , HTTPrequest    
      * @param user , Object Person
      * @return , request
      */
     private HttpServletRequest breedMonster(HttpServletRequest request, Person user){
         HttpSession session = request.getSession(false);
         Long friendsMonsterID = Long.parseLong(request.getParameter("friendsMonsterID"));
         Monster stud = monsterDOA.getMonsterById(friendsMonsterID);
         Person seller = personDOA.getPersonByEmail(stud.getOwnerID());
         
         if(user.getMoney()<stud.getBreedOffer()){
             request.setAttribute("error", "Not enough funds! >:(");
             
         }else{
            seller.setMoney(seller.getMoney()+stud.getBreedOffer());
            Monster baby;
         }
         return request;
     }
     
     /**
      * Method that takes user input sends buy request to the friend 
      * and updates the database
      * @param request , HTTP request   
      * @param user , Object Person
      * @return , request
      */
     private HttpServletRequest buyMonster(HttpServletRequest request, Person user){
         HttpSession session = request.getSession(false);
         Long friendsMonsterID = Long.parseLong(request.getParameter("friendsMonsterID"));
         Monster m = monsterDOA.getMonsterById(friendsMonsterID);
         Person seller;
         seller = personDOA.getPersonByEmail(m.getOwnerID());
         if(user.getMoney()<m.getSaleOffer()){
             request.setAttribute("error", "Not enough funds! >:(");
         }
         else {
            seller.setMoney(seller.getMoney()+m.getSaleOffer());
            m.setOwner(user.getEmail());
            user.setMoney(user.getMoney() - m.getSaleOffer());
            m.setSaleOffer(0);
            monsterDOA.updateMonstersInfo(m);
            personDOA.updatePersonsInfo(seller);
            personDOA.updatePersonsInfo(user);
            session.setAttribute("friendsMonsters", personDOA.getPersonsMonsters(seller));
         }
         
         return request;
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
