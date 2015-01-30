<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<!-- delete it later or add to project -->
<script src="<c:url value="/resources/js/lib/jquery.js" />"></script>

<!-- UNDESCORE.JS -->
<script src="<c:url value="/resources/js/lib/underscore.js" />"
	type="text/javascript"></script>

<!-- BACKBONE.JS -->
<script src="<c:url value="/resources/js/lib/backbone.js" />"
	type="text/javascript"></script>

<script src="<c:url value="/resources/js/testJS.js" />"></script>

<script src="<c:url value="/resources/js/app/model/CommentModel.js" />"
	type="text/javascript"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="http://maps.googleapis.com/maps/api/js?sensor=true"></script>
<script src="<c:url value="/resources/js/map-script.js" />"></script>
<script src="<c:url value="/resources/js/issue-script.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"
	type="text/javascript"></script>
<script src="<c:url value="/resources/js/home-script.js" />"
	type="text/javascript"></script>
<script src="<c:url value="/resources/js/validation-script.js" />"
	type="text/javascript"></script>

<link href="<c:url value="/resources/css/styles2.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap.min.css" />">
<link
	href='http://fonts.googleapis.com/css?family=Jura:400,600|Averia+Sans+Libre:400,700'
	rel='stylesheet' type='text/css'>

</head>
<body>
	<div class="container" id="navbar">
		<nav class="navbar navbar-default navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">

				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar-collapse">
					<span class="sr-only"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span> <span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">Bawl</a>
			</div>

			<div class="collapse navbar-collapse" id="navbar-collapse">
				<ul class="nav navbar-nav">
					<li><a href="#">Cry out</a></li>

				</ul>

				<ul class="nav navbar-nav navbar-right">
					<li><a href="#">Login</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#">About</a></li>
				</ul>
			</div>
		</div>
		</nav>
	</div>



	<div class="grid" id="grid-right">
		<div class="col-1-3">
			<div class="tabbable">

				<div align=right>
					<button type="submit" class="btn btn-small" id="resolve_button">Resolve</button>
				</div>

				<h4>
					<label id="issue_name">Traffic light doesn't work. </label>
				</h4>

				<label id="issue_description"> Not working traffic lights at
					the intersection of Soborna-Kievskaya. </label>

				<!-- <div class="thumbnail"> -->
				<img src="http://placehold.it/130x70"> <img
					src="http://placehold.it/130x70">
				<!-- </div> -->

				<br>
				<h4>Comments</h4>
				<div class="comments">
					<label class="comments_user_name"> Alex </label><br> <label
						class="comment_name"> He always breaks. </label>
					<hr width="100%" size="2">
					<label class="comments_user_name"> Alex </label><br> <label
						class="comment_name"> He always breaks. </label>
					<hr width="100%" size="2">

				</div>
				<div class="comment" id="add-comment">
					<h4>Your comment</h4>

					<div>
						<label>Name</label> <input type="text" name="userName">
					</div>

					<div>
						<label>Email</label> <input type="text" name="email">
					</div>

					<div>
						<label>Comment</label>
						<textarea name="comment-text" rows="3"></textarea>
					</div>


				</div>




			</div>
		</div>
	</div>

</body>
</html>