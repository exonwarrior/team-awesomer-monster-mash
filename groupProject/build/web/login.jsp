<%-- 
    Document   : login
    Created on : 25-Nov-2012, 18:25:32
    Author     : thh21
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*, login.LoginServlet"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="POST" action="login">
            Name: <input type="text" name="email" />
            PassWord: <input type="password" name="password" />
                      <input type="submit" value="Add" />  
        </form>
        <a href="register.jsp"> Register </a>
        <h1>Hello World!</h1>
    </body>
</html>
