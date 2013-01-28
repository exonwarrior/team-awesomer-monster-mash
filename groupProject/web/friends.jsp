<%-- 
    Document   : friends
    Created on : Dec 9, 2012, 9:13:31 PM
    Author     : szymus <3
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="database.Person"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Friends</title>
    </head>
    <body>
        <form action="FriendsServlet" method="post">
            <p>Enter user email:</p>
            <p><input type="text" name="useremail" /></p>
            <p><input type="submit" name="friendrequest" value="Submit" /></p>
            <p><%= request.getAttribute("message")%></p>
        </form>
        <form action="FriendsServelet" method="post">
            <p>Friends request list:</p>
            <textarea name="monsterList" style="height: 231px; width: 196px"><ol>
                    <% ArrayList<String> friendsreq = (ArrayList<String>) request.getAttribute("firendsreq");
                        for (String s : friendsreq) {%>
                            <li><%  %></li>
                    <% }%>
            </ol> 
            </textarea>
        </form>
    </body>
</html>
