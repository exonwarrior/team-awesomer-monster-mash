<%-- 
    Document   : register
    Created on : Dec 5, 2012, 3:18:40 PM
    Author     : thomas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*, servlets.Register"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script type="text/javascript"><!--
            function validate(){
                var emailReg = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
                var passwordReg = /((?=.*\d)(?=.*[a-z])(?=.*[A-Z])[a-zA-Z0-9@#$%]{6,20})/;
                var nameReg =  /^[A-Za-z]{2,16}$/;
                var pass1 = document.getElementById("password").value;
                var pass2 = document.getElementById("confirm_password").value;
                var email = document.getElementById("email").value;
                var name = document.getElementById("name").value;
                var lastName = document.getElementById("last_name").value;
                
                if(!nameReg.test(name)){
                   alert("name must be between 2 and 16 a-z charaters");
                }
                else if(!nameReg.test(lastName)){
                    alert("name must be between 2 and 16 a-z charaters");
                }
                else if(pass1 != pass2){
                    alert("passwords do not match");     
                }
                else if(!passwordReg.test(pass1)){
                    alert("Password is not valid");
                }
                else if(!emailReg.test(email)){
                    alert("Not a valid email");
                }
                else{
                    document.forms["paymentForm"].submit();
                }
            }
            --></script>
    </head>
    <body>
        <form method="POST" name="paymentForm" id="paymentForm" action="register">
            <p name="name_text">
            First Name: <input type="text" name="first_name" id="name" size="30" /><br />
            
            Last Name: <input type="text" name="last_name" id="last_name" size="30" /><br />
            </p>
            <p name="email_text">
            Email <input type="text" name="email" id="email" size="30" /><br />
            </p>            
            <p name="password_text">
            
            password: <input type="password" name="password" id="password" size="30" /><br />

            Confirm Password: <input type="password" name="confirm_password" id="confirm_password" size="30" />
            Pass words must be between 6 and 20 characters and contain a number and an upper and lower case letter.
            Special characters are not allowed.
            </p>
            <% 
              String errorMess = (String) request.getAttribute("error");
                if(errorMess != null){%>
                <p><%=errorMess %></p><%   
                }
                %>           
            <input type="button" value="submit" onclick="validate();" />

        </form>
    </body>
</html>
