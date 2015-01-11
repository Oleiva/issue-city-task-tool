<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title> Administrator Toolpage</title>
	<link href="<c:url value="/resources/css/styles.css" />" rel="stylesheet">
	<script src="<c:url value="/resources/js/script.js" />"></script>
</head>
<body>

	<div id="background"></div>
	<div id="notification-window" class="wrapper">
		<div id="notification-message">${notMsg}</div>
	</div>
	<br />
	
	<div id="users-table">
	
		<div class="buttons">
			<button id="add" class='button'>Add new user</button>
		</div>
		
		<table id="users">
			<thead>
				<tr>
					<th>Id</th>
					<th>Name</th>
					<th>Email</th>
					<th>Login</th>
				</tr>	
			</thead>
			
			<c:forEach items="${users}" var="usr">
				<tr>
					<td id="${usr.id}"><c:out value="${usr.id}"></c:out></td><td><c:out value="${usr.name}"></c:out></td><td><c:out value="${usr.email}"></c:out></td><td><c:out value="${usr.login}"></c:out></td>
					<td>
						<div>
							<form method="POST" action="edit-user"><input name="userId" type="hidden" value="<c:out value="${usr.id}"></c:out>" /><input type="submit" name="edit" value="edit" class="button" /></form>
							<form method="POST" action="remove-user"><input name="userId" type="hidden" value="<c:out value="${usr.id}"></c:out>" /><input type="submit" name="remove" value="remove" class="button" /></form>
						</div>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	
	<br />
	
	<div class='wrapper' id="add-popup">
		<h1>Add User</h1>
		<div class='form-wrapper'>
			<form method="POST" action="add-user">
				<div class='row'>
					<div class='left'><label for "firstname"> UserName: </label></div>
					<div class='right'><input type="text" id="name" name ="name" placeholder="enter your name"></div>
					<br clear='all'>
				</div>
				<div id="name-help" class="helper"></div>
				
				<div class='row'>
					<div class='left'><label for "email"> Email: </label></div>
					<div class='right'><input type="email" id="email" name ="email" placeholder="enter your email"></div>
					<br clear='all'>
				</div>
				<div id="email-help" class="helper"></div>
				
				<div class='row'>
					<div class='left'><label for "login"> Login: </label></div>
					<div class='right'><input type="text" id="login" name ="login" placeholder="enter your login"></div>
					<br clear='all'>
				</div>
				<div id="login-help" class="helper"></div>
				
				<div class='row'>
					<div class='left'><label for "password"> UserPassword: </label></div>
					<div class='right'><input type="password" id="password" name ="password" placeholder="enter your password"></div>
					<br clear='all'>
				</div>
				<div id="password-help" class="helper"></div>
				
				<div class='row'>
					<div class='left'><label for "avatar"> Avatar: </label></div>
					<div class='right'><input type="file" value="Browse" name="avatar"></div>
					<br clear='all'>
				</div>
				
				<div class='row'>
					<div class='left'>Role: </div>
					<div class='right-radio'><input type="radio" value="1" id="admin" name ="role_id"> Admin <input type="radio" value="2" id="manager" name ="role_id"> Manager <input type="radio" value="3" id="user" name ="role_id"> User </div>
					<br clear='all'>	
				</div>
				<div id="role-help" class="helper"></div>
				
				<div class='buttons'>
					<input type="submit" id="add-user-submit" value="add user" class="button"> 
				</div>
				<div id="submit-help" class="helper"></div>
			</form>
		</div>
	</div>
	
	<div class='wrapper' id="edit-popup">
	<h1>Edit User</h1>
		<div class='form-wrapper'>
			<form method="POST" action="edit-user">
				<input type="hidden" id="edit-user-id" name="userId" />
				<div class='row'>
					<div class='left'><label for "change_firstname"> Change User Name: </label></div>
					<div class='right'><input type="text" id="change_firstname" name ="change_firstname" placeholder="enter your name" /></div>
				<br clear='all'>
				</div>
				
				<div class='row'>
					<div class='left'><label for "change_email"> Change Email: </label></div>
					<div class='right'><input type="email" id="change_email" name ="change_email" placeholder="enter your email"></div>
				<br clear='all'>
				</div>
				
				<div class='row'>
					<div class='left'><label for "change_login"> Change Login: </label></div>
					<div class='right'><input type="text" id="change_login" name ="change_login" placeholder="enter your login"></div>
				<br clear='all'>
				</div>
					
				<div class='buttons'>
					<input type="submit" id="edit-user-submit" name="update-changes" value="update changes" class="button">
				</div>
			</form>
		</div>
	</div>

</body>
</html>