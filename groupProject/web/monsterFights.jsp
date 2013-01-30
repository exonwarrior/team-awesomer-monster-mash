
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
        document.getElementById("current_action").value = "personStats";
        document.getElementById("current person id").value =  id; 
        document.getElementById("current monster id").value =  null;                   
        document.forms["monsterFights"].submit();
    }
    function monsterStats(id){
        document.getElementById("current_action").value = "monsterStats";
        document.getElementById("current monster id").value =  id;
        document.getElementById("current person id").value =  null; 
        document.forms["monsterFights"].submit();
    }
    
    
    -->
</script>



<div id="header">
<a href="./home.html">
<img alt="Monster logo" src="monsterLogo.png">
</a>

</div>
</head>
<body>



<ul id="list-nav">
  
<li><a href="./marketplace.html">Marketplace</a></li>
<li><a href="./myMonsters.html">My Monsters</a></li>
<li><a href="./friends.html">Friends</a></li>
<li><a href="./monsterFights.html">Monster Fights</a></li>
<li><a href="./login.html">Log Out</a></li>
<li><a href="./home.html">Home</a></li>

</div>
</ul>

<hr>

<div class="container">
  <section id="content">
<h2>Monster Fights</h2><br><br><br>
<form method="post" action="monsterFights" id="monsterFights" name="monsterFights">
    <%DecimalFormat df = new DecimalFormat("#.##");%>

    <table name="offers" border="1">
        <% ArrayList<Fight> offers = (ArrayList<Fight>) request.getAttribute("offers");%>
        <tr>
            <th name="tableTitle">Offers from other players</th>
        </tr>
        <tr>
            <th>Player</th>
            <th>Monster</th>
        </tr>
        <% if(offers != null){
            for(Fight fight: offers){%>
            <tr>
                <td><input type="submit" onclick="personStats(<%=fight.getPerson().getId()%>);" value="<%=fight.getPerson().getName()%>" /></td>
                <td><input type="submit" onclick="MonsterStats(<%=fight.getMonster().getId()%>);" value="<%=fight.getMonster().getName()%>" /></td>
            </tr>
            <%}
        }%>
        
    </table>
    <table name="challenges" border="1">
        <% ArrayList<Fight> challenges = (ArrayList<Fight>) request.getAttribute("challenges");%>
        <tr>
            <th name="tableTitle">Challenges to other players</th>
        </tr>
        <tr>
            <th>Player</th>
            <th>Monster</th>
        </tr>
        <% if(challenges != null){
            for(Fight fight: challenges){%>
            <tr>
                <td><input type="submit" onclick="personStats(<%=fight.getPerson().getId()%>);" value="<%=fight.getPerson().getName()%>" /></td>
                <td><input type="submit" onclick="MonsterStats(<%=fight.getMonster().getId()%>);" value="<%=fight.getMonster().getName()%>" /></td>
            </tr>
            <%}
        }%>
        
    </table>
    <p name="display stats"><%
            if(session.getAttribute("current monster") != null){
                Monster currentMonster = (Monster) session.getAttribute("current monster");%>
                Monster Name:   <%=currentMonster.getName()%> <br />
                Strength:       <%=df.format(currentMonster.getCurrentStrength())%>/<%=df.format(currentMonster.getBaseStrength())%> <br />
                Defence:        <%=df.format(currentMonster.getCurrentDefence())%>/<%=df.format(currentMonster.getBaseDefence())%> <br />
                Health:         <%=df.format(currentMonster.getCurrentHealth())%>/<%=df.format(currentMonster.getBaseHealth())%> <br />
                
            <%}
            else if(session.getAttribute("current person") != null){
                Person currentPerson  = (Person) session.getAttribute("current person");%>
                Player Name:    <%=currentPerson.getName()%> <br />
            <%}
%>
     </p>




</form>

	</div>
	
</body>
