<%-- 
    Document   : friends
    Created on : Dec 9, 2012, 9:13:31 PM
    Author     : 
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="database.Person"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*, servlets.FriendsServlet"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Friends</title>
        <script type="text/javascript"><!--
            function sendreq(){       
                var email = document.getElementById('sendrequest').value;
                document.getElementById("current_action").value = "send_request";
                document.getElementById("sendFriendRequest").value = email;
                document.forms["friends form"].submit();
            }
            function acceptreq(){
                var email = document.getElementById('accept_decline').value;
                document.getElementById("current_action").value = "accept_request";
                document.getElementById("acceptFriendRequest").value = email;
                document.forms["friends form"].submit();
            } 
            function declinereq(){
                var email = document.getElementById('accept_decline').value;
                document.getElementById("current_action").value = "decline_request";
                document.getElementById("declineFriendRequest").value = email;
                document.forms["friends form"].submit();
            }
            -->
        </script>
    </head>
    <body>
        <%Person user = (Person) session.getAttribute("user"); %>
        <h1>My Friends  <%=user.getName() %></h1>
        
        <form method="post" action="myFriends" id="friends form">
        <input type="hidden" id="current_action" name="current_action" />
        <input type="hidden" id="sendFriendRequest" name="sendFriendRequest" />
        <input type="hidden" id="acceptFriendRequest" name="acceptFriendRequest" />
        <input type="hidden" id="declineFriendRequest" name="declineFriendRequest" />
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
                    <td><%=friend.getName()%></td>
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
                </tr>
                <%}
                    }%>
            </table>
            <p>Send Friend request:</p>
            Friends Email: <input type="text" id="sendrequest" name="email" />
            <input type="submit" name="reqButton" onclick="sendreq();" value="Send friend request" />
            <p>Accept/Decline Friends:</p>
            Friends Email: <input type="text" id="accept_decline" name="emailToAccOrDel" />
            <input type="submit" name="acceptFriend" onclick="acceptreq();" value="Accept friend request" />
            <input type="submit" name="declineFriend" onclick="declinereq();" value="Decline friend request" />
        </form>
    </body>		
</html>