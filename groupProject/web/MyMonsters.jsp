<%-- 
    Document   : MyMonsters
    Created on : 08-Dec-2012, 18:27:08
    Author     : thh21
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="database.Monster"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*, servlets.MyMonsterServlet"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>My Monsters</title>
    </head>
    <body>
        <h1>My Monsters</h1>
        
        <table name="monster">
            <% ArrayList<Monster> monsters = (ArrayList<Monster>)request.getAttribute("monsters"); %>
            <tr>
                <th>Monster Name</th>
                
            </tr>
            <% if(monsters != null){ 
                for(Monster monster : monsters){ %>
                    <tr>
                        <td><%=monster.getName()%></td>
                    </tr>
                <%}
              }%>
        </table>
	<textarea name="monsterList" style="height: 231px; width: 196px">
                
                      
        </textarea><input name="breedMonsters" type="button" value="Breed Monsters" />
       
        <form method="post" action="myMonsters">
        <input name="buyMonster" onclick="location='newMonster.html'" type="button" value="+ Buy Monsters" />
        <input name="sellMonsters" type="button" value="Sell Monsters" />
        <input name="home" onclick="location='home.html'" type="button" value="home" style="width: 66px" />
        <input type="submit" value="get" />
        </form>

    </body>
</html>
