<%-- 
    Document   : friends
    Created on : Dec 9, 2012, 9:13:31 PM
    Author     : 
--%>

<%@page import="java.text.DecimalFormat"%>
<%@page import="database.Monster"%>
<%@page import="java.util.ArrayList"%>
<%@page import="database.Person"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*, servlets.FriendsServlet"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <link rel="stylesheet" href="style.css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Friends</title>
        <script type="text/javascript"><!--
            function sendreq(){       
                var email = document.getElementById('sendrequest').value;
                document.getElementById("current_action").value = "send_request";
                document.getElementById("requestEmail").value = email;
                document.forms["friends form"].submit();
            }
            function acceptreq(email){               
                document.getElementById("current_action").value = "accept_request";
                document.getElementById("requestEmail").value = email;
                document.forms["friends form"].submit();
            } 
            function declinereq(email){               
                document.getElementById("current_action").value = "decline_request";
                document.getElementById("requestEmail").value = email;
                document.forms["friends form"].submit();
            }
            function challengeMonster(id){
                document.getElementById("current_action").value = "challenge_monster";
                document.getElementById("friendsMonsterID").value = id;
                document.forms["friends form"].submit();
            }
            function getFriendsMonsters(email){
                document.getElementById("current_action").value  = "get_monster"
                document.getElementById("requestEmail").value = email;
                document.forms["friends form"].submit();
            }
            -->
        </script>
        <div id="header">
            <a href="./home.jsp">
            <img alt="Monster logo" src="monsterlogo.png">
            </a>
        </div>
    </head>
    <body>
        <ul id="list-nav">            
            <li><a href="./MyMonsters.jsp">My Monsters</a></li>
            <li><a href="./monsterFights.jsp">Monster Fights</a></li>
            <li><a href="./login.jsp">Log Out</a></li>
        </ul>
        <%Person user = (Person) session.getAttribute("user"); %>
        <h1>My Friends  <%=user.getName() %></h1>
        
        <form method="post" action="myFriends" id="friends form">
        <input type="hidden" id="current_action" name="current_action" />
        <input type="hidden" id="requestEmail" name="requestEmail" />
        <input type="hidden" id="friendsMosnterID" name="friendsMonsterID" />
            <table name="friend" border="1">	
                <% ArrayList<Person> friends = (ArrayList<Person>) session.getAttribute("friends");%>
                <tr>
                    <th>Your Friends </th>                  
                </tr>
                
                <tr>
                    <th>Friend Name</th>
                    <th>Email</th>
                </tr>
                <% if (friends != null) {
                        for (Person friend : friends) {%>
                            <tr>
                                <td><input type="submit" name="friend" onclick="getFriendsMonsters('<%=friend.getEmail()%>');" value="<%=friend.getName()%>" /></td>
                                <td><%=friend.getEmail()%></td>                             
                            </tr>
                <%}
                    }%>
            </table>
            <table name="friendRequestList" border="1">	
                <% ArrayList<Person> friendRequests = (ArrayList<Person>) session.getAttribute("requestList");%>
                <tr>
                    <th>Friend Requests</th>
                </tr>
                <tr>
                    <th>Friend Name</th>
                    <th>Email</th>
                </tr>
                <% if (friendRequests != null) {
                        for (Person req : friendRequests) {%>
                <tr>
                    <td><%=req.getName()%></td>
                    <td><%=req.getEmail()%></td>
                    <td><input type="submit" name="acceptFriend" onclick="acceptreq('<%=req.getEmail()%>');" value="Accept friend request" /></td>
                    <td><input type="submit" name="declineFriend" onclick="declinereq('<%=req.getEmail()%>');" value="Decline friend request" /></td>
                </tr>
                <%}
                    }%>
            </table>
            <p>Send Friend request:</p>
            Friends Email: <input type="text" id="sendrequest" name="email" />
            <input type="submit" name="reqButton" onclick="sendreq();" value="Send friend request" />
            
            <%ArrayList<Monster> friendsMonsters  =(ArrayList<Monster>) session.getAttribute("friendsMonsters");%>
            <%DecimalFormat df = new DecimalFormat("#.##");%>
            
            <%if(friendsMonsters != null){
                for(Monster currentMonster: friendsMonsters){%>
                <p name="monsterStats" >
                    Monster Name:   <%=currentMonster.getName()%> <br />
                    Strength:       <%=df.format(currentMonster.getCurrentStrength())%>/<%=df.format(currentMonster.getBaseStrength())%> <br />
                    Defence:        <%=df.format(currentMonster.getCurrentDefence())%>/<%=df.format(currentMonster.getBaseDefence())%> <br />
                    Health:         <%=df.format(currentMonster.getCurrentHealth())%>/<%=df.format(currentMonster.getBaseHealth())%> <br />
                
                    <% if(currentMonster.getSaleOffer() <= 0){%>
                       <input type="submit" name="challengeMonster" onclick="challengeMonster(<%=currentMonster.getId()%>);" value="Challenge" />
                    <%}%>
                    <% if(currentMonster.getSaleOffer() > 0) { %>
                        <input type="submit" name="buyMonster" onclick="challengeMonster(<%=currentMonster.getId()%>);" value="Purchase" />
                    <% } %>
                </p><% }
            }%>
            
        </form>
    </body>		
</html>