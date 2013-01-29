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
                //document.getElementById("breed").value = id;
                //document.getElementById("sell").value = null;
                session.setAttribute("sell")  = null;
                session.setAttribute("breed") = id;
                document.forms["monster form"].submit();
                }
                
                function sell(id){
                    //document.getElementById("breed").value = null;
                    //document.getElementById("sell").value = id;
                    session.setAttribute("sell") = id;
                    session.setAttribute("breed") = null;
                    ducment.forms["monster form"].submit();
                }
                
                -->
            </script>
    </head>
    <body>
        <h1>My Monsters</h1>
        <form method="post" action="myMonsters" id="monster form">
        <table name="monster" border="1">
            <% ArrayList<Monster> monsters = (ArrayList<Monster>)session.getAttribute("monsters"); %>
            <tr>
                <th>Monster Name</th>
                <th>Health</th>
                <th>Strength</th>
                <th>Dodge</th>
                <th>Price</th> 
                
            </tr>
            <% if(monsters != null){ 
                for(Monster monster : monsters){ %>
                    <tr>
                        <td><%=monster.getName()%></td>
                        <td><%=monster.getHealth()%></td>
                        <td><%=monster.getStrength()%></td>
                        <td><%=monster.getDodge()%></td>
                        <td><%=monster.getPrice()%></td>
                        <td><input type="submit" name="breed" onclick="breed(<%=monster.getId()%>);" value="breed" /></td>
                        <td><input type="submit" name="sell"  onclick="sell(<%=monster.getId()%>);" value="sell" /></td>
                    </tr>
                <%}
              }%>
        </table>
	<textarea name="monsterList" style="height: 231px; width: 196px">
                
                      
        </textarea><input name="breedMonsters" type="button" value="Breed Monsters" />
       
        
        <input name="buyMonster" onclick="location='newMonster.html'" type="button" value="+ Buy Monsters" />
        <input name="sellMonsters" type="button" value="Sell Monsters" />
        <input name="home" onclick="location='home.html'" type="button" value="home" style="width: 66px" />
        <input type="submit" value="get" />
        </form>

    </body>
</html>
