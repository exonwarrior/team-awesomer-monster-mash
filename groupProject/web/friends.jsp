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
    </head>
    <body>
        <h1>My Friends</h1>
        <form method="post" action="myFriends" id="friends form">
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
    </body>		
</html>