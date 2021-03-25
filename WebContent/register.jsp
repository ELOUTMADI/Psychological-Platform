<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Register Account</title>

<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="cadre">
		<div class="regbox box">
			<img class="icon" src="img/fqs.png">
			<h1>Register Account</h1>
			<form action="RegisterServlet" method="post">
				<p>Username</p>
				<input type="text" placeholder="Username" name="name" required>
				<p>Useremail</p>
				<input type="text" placeholder="Useremail" name="email" required>
				<p>Password</p>
				<input type="password" placeholder="Password" name="password"
					required> 
				<p>Choisir ton rôle :</p>
				
		  <label for="psychologue">Psychologue</label>
 			 <input type="radio" name="role" id="Psychologue" value="Psychologue"><br>
 			 <label for="RH">RH</label>
 			 <input type="radio" name="role" id="RH" value="RH"><br>
  			<label for="Utilisateur">Utilisateur</label>
  			<input type="radio" name="role" id="Utilisateur" value="Utilisateur"><br><br>
					
					<input type="submit" value="Register">
				<br> <a href="Home.jsp">Already have Account?</a>
			</form>
		</div>
	</div>
</body>
</html>
