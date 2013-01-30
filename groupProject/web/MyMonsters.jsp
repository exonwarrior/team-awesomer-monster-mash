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
        <script type="text/javascript"><!--
                function breed(id){
                
                document.getElementById("current_action").value = "breed";
                document.getElementById("breed").value = id;
                document.forms["monster form"].submit();
                }
                
                function sell(id){
                    
                    document.getElementById("sell").value= id;
                    document.getElementById("current_action").value = "sell";
                    document.forms["monster form"].submit();
                }
                function changeMonster(monsterID){
                    document.getElementById("current_action").value = "changeMonster";
                    document.getElementById("current monster id").value =  monsterID;                   
                    document.forms["monster form"].submit();
                }
                
                -->
            </script>
    </head>
    <body>
        <h1>My Monsters</h1>
        <form method="post" action="myMonsters" id="change_monster">
        <input type="hidden" id="current monster id" name="current monster id" />
        <input type="hidden" id="current_action" name="current_action" />
        <table name="monster" border="1">
            <% ArrayList<Monster> monsters = (ArrayList<Monster>)session.getAttribute("monsters"); %>
            <tr>
                <th>Monster Name</th>
                
            </tr>
            <% if(monsters != null){ 
                for(Monster monster : monsters){ %>
                    <tr>
                        <td>
                            <input type="submit" onclick="changeMonster(<%=monster.getMonsterID()%>);" value="<%=monster.getName()%>"  />                           
                        </td>

                    </tr>
                <%}
              }%>
        </table>
       
        <p name="display monster"><%
            if(session.getAttribute("current monster") != null){
                Monster currentMonster = (Monster) session.getAttribute("current monster");%>
                Monster Name:   <%=currentMonster.getName()%> <br />
                Strength:       <%=currentMonster.getCurrentStrength()%>/<%=currentMonster.getBaseStrength()%> <br />
                Defence:        <%=currentMonster.getCurrentDefence()%>/<%=currentMonster.getBaseDefence()%> <br />
                Health:         <%=currentMonster.getCurrentHealth()%>/<%=currentMonster.getBaseHealth()%> <br />
                
                
                <input type="text" placeholder="breeding price" name="breed price" />
                <input type="submit" name="breed" onclick="breed(<%=currentMonster.getMonsterID()%>);" value="breed" />
                <input type="text" placeholder="selling price" name="sell price" />
                <input type="submit" name="sell"  onclick="sell(<%=currentMonster.getMonsterID()%>);" value="sell" />

            <%}%>
        </p>
        
        <input name="buyMonster" onclick="location='newMonster.html'" type="button" value="+ Buy Monsters" />
        <input name="sellMonsters" type="button" value="Sell Monsters" />
        <input name="home" onclick="location='home.jsp'" type="button" value="home" style="width: 66px" />
         </form>

    </body>
</html>
