<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*, servlets.LoginServlet"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <link rel="stylesheet" href="style.css" />

<head>
<meta content="en-us" http-equiv="Content-Language" />
<meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
<title>Home</title>



<div id="header">
<a href="./home.html">
<img alt="Monster logo" src="monsterlogo.png">
</a>
<link rel="icon" href="favicon.ico" />
</div>
</head>
<body>



<hr>
<hr>

<div class="container">
	<section id="content">
		<form method="POST" action="login">
			<h1>Login</h1>
			
				<input type="text" placeholder="Email" required=""  name="email" /> <br><br>
		
		
				<input type="password" placeholder="Password" required="" name="password" id="password" /> <br><br>

			
				<input type="submit" value="Login" />
				<a href="register.jsp">Register</a>
				<br><br><br><br>
				<p>Welcome to Monster Mash, a new, fun and exciting online game, please start by logging in, if you are not a member then click on the register
				button just above. Enjoy :)</p>
				<b><b>
				<img alt="Monsters" src="monsters.jpg">
	</div>
		</form>
		
	</section>
</div>
</body>
</html>