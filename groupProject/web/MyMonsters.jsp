<%-- 
    Document   : MyMonsters
    Created on : 08-Dec-2012, 18:27:08
    Author     : thh21
--%>

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
        <form method="post" action="myMonsters">
	<textarea name="TextArea1" style="height: 231px; width: 196px">
            <%= request.getAttribute("monsters") %>
        </textarea><input name="breedMonsters" type="button" value="Breed Monsters" />
        <input name="buyMonster" onclick="location='newMonster.html'" type="button" value="+ Buy Monsters" />
        <input name="sellMonsters" type="button" value="Sell Monsters" />
        <input name="home" onclick="location='home.html'" type="button" value="home" style="width: 66px" />
        </form>

    </body>
</html>
