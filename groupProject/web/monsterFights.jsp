<%@page import="database.Person"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="database.Monster"%>
<%@page import="types.Fight"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*, servlets.MonsterFightServlet"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <link rel="stylesheet" href="style.css" />
    <head>
        <meta content="en-us" http-equiv="Content-Language" />
        <meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
        <title>Home</title>
        <script type="text/javascript"><!--
            function personStats(id){
                document.getElementById("current action").value = "personStats";
                document.getElementById("current person id").value =  id; 
                document.getElementById("current monster id").value =  null;                   
                document.forms["monster fight"].submit();
            }
            function monsterStats(id){
                document.getElementById("current action").value = "monsterStats";
                document.getElementById("current monster id").value =  id;
                document.getElementById("current person id").value =  null; 
                document.forms["monster fight"].submit();
            }
            function acceptFight(person, monster){
                document.getElementById("current action").value = "fight";
                document.getElementById("current monster id").value = monster;
                document.getElementById("current person id").value = person;
                document.forms["monster fight"].submit();
            }
            function declineFight(person,monster){
                document.getElementById("current action").value = "deleteFight";
                document.getElementById("current monster id").value = monster;
                document.getElementById("current person id").value = person;
                document.forms["monster fight"].submit();
            }
            function logOut(){
                    document.getElementById("logout").value = "logout";
                    document.forms["login"].submit();
                }
            -->
        </script>
    </head>

    <body>
        <div class="container">
            <div id="navbar">
                <jsp:include page="navbar.jsp" />
            </div>
            <section id="content">
                <h2>Monster Fights</h2><br /><br /><br />
                <form method="post" action="monsterFight" id="monster fight">
                    <input type="hidden" id="current monster id" name="current monster id" />
                    <input type="hidden" id="current person id" name="current person id" />
                    <input type="hidden" id="current action" name="current action" />
                    <input type="hidden" id="current fight id" name="current fight id" />
                    <%DecimalFormat df = new DecimalFormat("#.##");%>
                    <%if (session.getAttribute("offers") != null) {%>
                    <table name="offers" border="1">
                        <% ArrayList<Fight> offers = (ArrayList<Fight>) session.getAttribute("offers");%>
                        <tr>
                            <th name="tableTitle">Challenges from other players</th>
                        </tr>
                        <tr>
                            <th>Challenger</th>
                            <th>Challenger's Monster</th>
                            <th>Your Monster</th>
                        </tr>
                        <% if (offers != null) {
                                for (Fight fight : offers) {
                        %>
                        <tr>
                               <td><input type="submit" onclick="personStats(<%=fight.getChallenger()%>);" value="<%=fight.getChallengerName()%>" /></td>
                                <td><input type="submit" onclick="monsterStats(<%=fight.getChallMonster()%>);" value="<%=fight.getChallMonsterName()%>" /></td>
                                <td><input type="submit" onclick="acceptFight(<%=fight.getChallenger()%>,<%=fight.getChallMonster()%>);" value="Accept" /></td>
                               <td><input type="submit" onclick="declineFight(<%=fight.getChallenger()%>,<%=fight.getChallMonster()%>);" value="Decline" /></td>

                        </tr>
                        <%}
                                        }%>
                    </table>
                    <%}%>
                    <%if (session.getAttribute("challenges") != null) {%>
                    <table name="challenges" border="1">
                        <% ArrayList<Fight> challenges = (ArrayList<Fight>) session.getAttribute("challenges");%>
                        <tr>
                            <th name="tableTitle">Challenges you have issued</th>
                        </tr>
                        <tr>
                            <th>Opponent</th>
                            <th>Opponent's Monster</th>
                            <th>Your Monster</th>

                        </tr>
                        <% if (challenges != null) {
                                            for (Fight fight : challenges) {%>
                        <tr>
                              <td><input type="submit" onclick="personStats(<%=fight.getOpponent()%>);" value="<%=fight.getOpponentName()%>" /></td>
                                <td><input type="submit" onclick="MonsterStats(<%=fight.getOppMonster()%>);" value="<%=fight.getOppMonsterName()%>" /></td>

                            <td><input type="submit" onclick="declineFight(<%=fight.getId()%>);" value="Cancel" /></td>
                        </tr>
                        <%}
                                        }%>
                    </table>
                    <%}%>
                    <p name="display stats"><%
                        if (session.getAttribute("current monster") != null) {
                            Monster currentMonster = (Monster) session.getAttribute("current monster");%>
                        Monster Name:   <%=currentMonster.getName()%> <br />
                        Strength:       <%=df.format(currentMonster.getCurrentStrength())%>/<%=df.format(currentMonster.getBaseStrength())%> <br />
                        Defence:        <%=df.format(currentMonster.getCurrentDefence())%>/<%=df.format(currentMonster.getBaseDefence())%> <br />
                        Health:         <%=df.format(currentMonster.getCurrentHealth())%>/<%=df.format(currentMonster.getBaseHealth())%> <br />

                        <%} if(session.getAttribute("current person") != null){
                                        Person currentPerson = (Person) session.getAttribute("current person");%>
                        Player Name:    <%=currentPerson.getName()%> <br />
                        <%}%>
                    </p>
                    <p name="fight">
                       <% if(request.getAttribute("fight result") != null){
                           Person user = (Person) session.getAttribute("user");
                           String message = (String) request.getAttribute("fight result");%>
                                 <%=message%> <br />
                                 your Money: <%user.getMoney();%> 
                        <%}%>
                    </p>
                </form>
            </section>
        </div>
    </body>
</html>
