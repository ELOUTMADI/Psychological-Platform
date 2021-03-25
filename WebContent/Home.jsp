<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>Join Us</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="cadre">
		<div class="box">
			<img class="icon" src="img/xq.jpg">
			<h1>Login Account</h1>
			<form action="LoginServlet" method="post">
				<p>User's Email</p>
				<input type="text" placeholder="Email" name="email" required>
				<p>Password</p>
				<input type="password" placeholder="Password" name="password"
					required> 
				<p>Ton rôle : </p>
				
				 <label for="psychologue">Psychologue</label>
 			 <input type="radio" name="role" id="Psychologue" value="Psychologue"><br>
 			 <label for="RH">RH</label>
 			 <input type="radio" name="role" id="RH" value="RH"><br>
  			<label for="Utilisateur">Utilisateur</label>
  			<input type="radio" name="role" id="Utilisateur" value="Utilisateur"><br><br>
					
					<input type="submit" value="Login"><br> <a href="register.jsp">Create
					New Account</a>
			</form>
		</div>
	</div>
</body>
</html>
