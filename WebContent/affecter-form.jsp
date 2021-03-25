<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>
	<title>Formulaire affectation page</title>
	
	<link type="text/css" rel="stylesheet" href="css/styletable.css">

</head>

<body>
	<div id="wrapper">
		<div id="header">
			<h2>Liste des formulaires</h2>
		</div>	
	</div>
	
	<div id="container">
		<div id="content" class="table-wrapper">
			<table class="fl-table">
				<tr>
					<th>id</th>
					<th>Title</th>
					<th>Question1</th>
					<th>Question2</th>
					<th>Question3</th>
					<th>Question4</th>
					<th>Question5</th>
					<th>Question6</th>
					<th>Question7</th>
					<th>Question8</th>
					<th>Question9</th>
					<th>Question10</th>
					<th>Affectation</th>
					
				</tr>	
				<c:forEach var="tempitem" items="${Forms_List}">
					<c:url var ="templink" value= "AffectfinalServlet">
						<c:param name="email" value="${param.email}" />
						<c:param name="id" value="${tempitem.id}" />
						<c:param name="command" value="chosen"/>
					</c:url>
					<tr>
						<td>  ${tempitem.id}  </td>
						<td>  ${tempitem.title} </td>
						<td>  ${tempitem.question1} </td>
						<td>  ${tempitem.question2} </td>
						<td>  ${tempitem.question3} </td>
						<td>  ${tempitem.question4} </td>
						<td>  ${tempitem.question5} </td>
						<td>  ${tempitem.question6} </td>
						<td>  ${tempitem.question7} </td>
						<td>  ${tempitem.question8} </td>
						<td>  ${tempitem.question9} </td>
						<td>  ${tempitem.question10} </td>
						<td><a href="${templink}" >Affectation</a> </td>
					</tr>
				</c:forEach>
			</table>
			<c:url var ="templink1" value= "AffectfinalServlet">
						<c:param name="email" value="${param.email}" />
						<c:param name="command" value="random" />
					</c:url>
		<a href="${templink1}" >Random affectation</a>
			
		<a href="LogoutServlet">Log Out</a>
		</div>
	</div>
	
	
</body>



</html>