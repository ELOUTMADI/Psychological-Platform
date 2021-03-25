<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
        <meta charset="utf-8" />
        <title>${ logUser.name }</title>
        <link href="table.css" rel="stylesheet" />
</head>
<body>
<form action="envoiereponse" method="post">
	<div id="wrapper">
		<div id="header">
			<h2>Liste des formulaires</h2>
		</div>	
	</div>
	
	<div id="container">
		<div id="content" class="table-wrapper">
			<table class="steelBlueCols">
			<thead>
			<tr>
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
			</tr>
			</thead>
			<tbody>
			<c:forEach var="tempitem" items="${Questions}">
			<tr>		
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
			</tr>
			<tr>
						<td><select name="reponse"  class="dropbtn">
									<option value="${tempitem.title}"></option>
							</select></td>						
						
						<td><select name="reponse"  class="dropbtn">
									<option value="oui">Oui</option>
									<option value="non">Non</option>
							</select></td>
						<td><select name="reponse"  class="dropbtn">
									<option value="oui">Oui</option>
									<option value="non">Non</option>
							</select></td>
						<td><select name="reponse"  class="dropbtn">
									<option value="oui">Oui</option>
									<option value="non">Non</option>
							</select></td>
						<td><select name="reponse"  class="dropbtn">
									<option value="oui">Oui</option>
									<option value="non">Non</option>
							</select></td>
						<td><select name="reponse"  class="dropbtn">
									<option value="oui">Oui</option>
									<option value="non">Non</option>
							</select></td>
						<td><select name="reponse"  class="dropbtn">
									<option value="oui">Oui</option>
									<option value="non">Non</option>
							</select></td>
						<td><select name="reponse"  class="dropbtn">
									<option value="oui">Oui</option>
									<option value="non">Non</option>
							</select></td>
						<td><select name="reponse"  class="dropbtn">
									<option value="oui">Oui</option>
									<option value="non">Non</option>
							</select></td>
						<td><select name="reponse"  class="dropbtn">
									<option value="oui">Oui</option>
									<option value="non">Non</option>
							</select></td>
						<td><select name="reponse"  class="dropbtn">
									<option value="oui">Oui</option>
									<option value="non">Non</option>
							</select></td>
					</tr>
				</c:forEach>
				</tbody>
				</table>
			<h2><button type="submit">Envoyer mes reponses</button></h2>			
		</div>
	</div>
	
	</form>	
<div class="row">
  <div class="profile-nav">
          <div class="user-heading">
              <a href="#">
                  <img src="img/vv.png" alt="">
              </a>
              <h1>Votre profil</h1>
          </div>
          </div>
          <div class="body bio-graph-info">
              <div class="row">
                  <div class="bio-row">
                  <p>Nom : ${ logUser.name }</p>
                  </div>
                  <div class="bio-row">
                  <p>Occupation : ${ logUser.role }</p>
                  </div>
                  <div class="bio-row">                  
                  <p>Email : ${ logUser.email }</p>
                  </div>
              </div>
          </div>
      </div>       
<div class="button">
<a href="LogoutServlet" class=button >Log Out</a>
</div>
</body>
</html>