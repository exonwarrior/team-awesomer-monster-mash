<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <link rel="stylesheet" href="style.css" />
  <script type="text/javascript" src="scripts.js"></script>
	
<head>
<meta content="en-us" http-equiv="Content-Language" />
<meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
<title>Home</title>



<div id="header">
<a href="./home.html">
<img alt="Monster logo" src="monsterLogo.png">
</a>
<link rel="icon" href="favicon.ico" />
</div>
</head>
<body>








<ul id="list-nav">
  
<li><a href="./marketplace.jsp">Marketplace</a></li>
<li><a href="./myMonsters.jsp">My Monsters</a></li>
<li><a href="./friends.jsp">Friends</a></li>
<li><a href="./monsterFights.jsp">Monster Fights</a></li>
<li><a href="./login.jsp">Log Out</a></li>
</div>
</ul>

<hr>

<div class="container">
	<section id="content">
<h2>My Monsters</h2><br><br><br>
<form method="post">

<div id="table">
<table border="1">
<th><b>Monster Name:</th></b>
<tr>
<td><input name="monster1" type="button" value="Monster1" /><br><br>
 </td>
</tr>
<tr>
<td><input name="monster1" type="button" value="Monster1" /><br><br>
</tr>
</table> 
</form>

</div>
<div id="titles"
<p>Strength:</p>
<br>
<p>Defence:<p>
<br>
<p>Health:<p>
</div>


<form method="post"> 
<div id="buttonLayout">

	<input type="text" placeholder="Set breeding price" />
	<input name="breedMonsters" type="button" onclick="breed0()" value="Breed Monster" />
 <br>
	<input type="text" placeholder="Set price tag of monster" />
	<input name="sellMonsters" type="button" value="Sell Monsters" /><br>

	<input type="text" placeholder="Set loan price" />
	<input name="loanOut" type="button" value="Loan out monster" /><br><br>
	
	<input name="buyMonster" onclick="location='marketplace.html'" type="button" value="+ Buy Monsters"/>


	</div>
		
</form>

</body>

</html>
