<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <link rel="stylesheet" href="style.css" />

<head>
<meta content="en-us" http-equiv="Content-Language" />
<meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
<title>Home</title>



<div id="header">
<a href="./home.jsp">
<img alt="Monster logo" src="monsterLogo.png">
</a>

</div>
</head>
<body>



<ul id="list-nav">
  
<li><a href="./marketplace.jsp">Marketplace</a></li>
<li><a href="./myMonsters.jsp">My Monsters</a></li>
<li><a href="./friends.jsp">Friends</a></li>
<li><a href="./monsterFights.jsp">Monster Fights</a></li>
<li><a href="./login.jsp">Log Out</a></li>
<li><a href="./home.jsp">Home</a></li>

</div>
</ul>

<hr>

<div class="container">
  <section id="content">
<h1>Friends</h1>

<br><br><br>



<form method="post">



	<input name="displayFriends" type="button" value="Display Friends List" />	<br><br>
	
	
	
	<input name="delete" type="button" value="delete friend" /><br><br>
	<input name="viewFriendWealth"  type="button" value="View Friend Wealth" /><br><br>
	
	<hr>
	<h2> Friend Requests </h2><br><br><br>
	<input name="accept" type="button" value="Accept Friend" /><br><br>
	<input name="decline" type="button" value="Decline Friend" /><br><br>
		<input name="add"  type="button" value="Add friend" /></p><br><br>

	<input name="search" type="text" placeholder="Search for friend by email address" /><br><br>

	</div>
	</form>

</body>

</html>
