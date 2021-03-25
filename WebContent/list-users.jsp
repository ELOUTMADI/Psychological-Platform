<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>
	<title>Users Listing page</title>
	
	<link type="text/css" rel="stylesheet" href="css/styletable.css">
	

</head>

<body>
	<div id="wrapper">
		<div id="header">
			<h2>Rh plateforme</h2>
		</div>	
	</div>
	
	<div id="container">
		<div id="content" class="table-wrapper">
			<input type="button" value="Show Users list"
					onclick="window.location.href='UserControllerServlet';return false;"
					class="show-users-list-button"
			/>
			<table class="fl-table">
				<tr>
					<th>Name</th>
					<th>email</th>
					<th>role</th>
					<th>Affect</th>
				</tr>	
				
				<c:forEach var="tempUser" items="${Users_List}">
					
					<c:url var ="templink" value= "FormAffectServlet">
						<c:param name="email" value="${tempUser.email}" />
					</c:url>
					<tr>
						<td>  ${tempUser.name}  </td>
						<td>  ${tempUser.email} </td>
						<td>  ${tempUser.role} </td>
						<td><a href="${templink}" >Affecter-Formulaire</a> </td>

					</tr>
				</c:forEach>
			</table>
				<a href="LogoutServlet">Log Out</a>
		</div>
	</div>
	
	
</body>



</html>