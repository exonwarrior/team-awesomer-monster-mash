
<% if (null == session.getAttribute("user")) {%>
<!--User is not logged in. -->
<ul>
    <li><a href="login.jsp">Login</a></li>
    <li><a href="register.jsp">Register</a></li>
</ul>
<%} else {%>
<ul>
    <!--User is logged in -->
    <li><a href="myMonsters.jsp">My Monsters</a></li>
    <li><a href="monsterFights.jsp">Fight a monster</a></li>
    <li><a href="friends.jsp">Friends</a></li>
    <div id="logoutButton" style="float:right">
        <form method="post" action="login" id="login" class="logoutbutton">
        <input type="hidden" id="logout" name="logout" />
        <li><input style="font-size: 14px; margin-bottom: 2px;" type="button" onClick="logOut();" value="logout" /></li>
    </form>
    </div>
</ul>

<% }
%>