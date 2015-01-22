<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	<script type="text/javascript" src="http://maps.googleapis.com/maps/api/js?sensor=true"></script>
	<script src="<c:url value="/resources/js/map-script.js" />"></script>
	<script src="<c:url value="/resources/js/issue-script.js" />"></script>
	<script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />" type="text/javascript"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js" />" type="text/javascript"></script>
    <script src="<c:url value="/resources/js/home-script.js" />" type="text/javascript"></script>
    <script src="<c:url value="/resources/js/validation-script.js" />" type="text/javascript"></script>
	<link href="<c:url value="/resources/css/styles2.css" />" rel="stylesheet">
	<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
	<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css" />">
</head>
<body>

	<div class="container" id="navbar">
        <nav class="navbar navbar-default navbar-fixed-top">
            <div class="container">
                <div class="navbar-header">

                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-collapse">
                        <span class="sr-only"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">Bawl</a>
                </div>

                <div class="collapse navbar-collapse" id="navbar-collapse">
                    <ul class="nav navbar-nav">
                        <li>
                            <a href="#" id="cry-out">Cry out</a>
                        </li>

                    </ul>

                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="#">Login</a>
                        </li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="#">About</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
	</div>


	<div class="grid" id="grid-right">
        <div class="col-1-3">
            <div class="tabbable">
                <!-- Only required for left/right tabs -->
                <h4>Add issue</h4>
                <ul class="nav nav-tabs">

                    <li class="active"><a href="#tab1" data-toggle="tab">Point</a>
                    </li>

                    <li><a href="#tab2" data-toggle="tab">Description</a>
                    </li>
                    <li><a href="#tab3" data-toggle="tab">Photo</a>
                    </li>
                </ul>
                <div class="tab-content">
                    <div class="tab-pane active" id="tab1">
                        <p>Mark the place of issue on the map</p>
                        <button class="btn">Next</button>
                    </div>
                    <div class="tab-pane fade" id="tab2">
                        <p>
                            <div class="form-group">
                                <label for="exampleInputPassword1">Short issue name</label>
                                <input type="text" class="form-control" id="exampleInputPassword1" />
                            </div>
                            <div class="form-group">
                                <label for="exampleInputPassword1">Issue category</label>
                                <input type="text" class="form-control" id="exampleInputPassword1" />
                            </div>
                            <div class="form-group">
                                <label for="problem_description">Issue description</label>
                                <textarea class="form-control" rows="3" id="problem_description">
                                </textarea>
                            </div>
                            <div class="form-group">
                                <label for="propose">Resolution</label>
                                <textarea class="form-control" rows="3" id="propose">
                                </textarea>
                            </div>
                            <button class="btn">Next</button>
                    </div>

                    <div class="tab-pane fade" id="tab3">
                        <p></p>
                        <div class="form-group">
                            <label for="exampleInputFile">Click to upload file</label>
                            <input id="input-1" type="file" class="file">
                       
                        </div>
                        <button type="submit" class="btn btn-default">Add</button>

                    </div>
                </div>
            </div>
        </div>
	</div>
	
	
	<div id="map">
		<div id="map_canvas"></div>
	</div>
	
</body>
</html>