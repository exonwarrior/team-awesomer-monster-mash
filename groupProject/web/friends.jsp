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
            -->
        </script>
    </head>
    <body>
        <h1>My Friends</h1>
        <form method="post" action="myFriends" id="friends form">
        <input type="hidden" id="current_action" name="current_action" />
        <input type="hidden" id="sendFriendRequest" name="sendFriendRequest" />
            <table name="friend" border="1">	
                <% ArrayList<Person> friends = (ArrayList<Person>) request.getAttribute("firends");%>
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
                <% ArrayList<Person> friendRequests = (ArrayList<Person>) request.getAttribute("requestList");%>
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
            Friends Email: <input type="text" id="sendrequest" name="email" />
            <input type="submit" name="sendreq" onclick="sendreq();" value="Send friend request" />
        </form>
    </body>		
</html>