<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="http://code.jquery.com/jquery-1.11.1.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>CONTENT MANAGEMENT SYSTEM</title>
</head>
<body style="background: url('./123.jpg'); ">
	<h1 align="center">Content Management</h1>
<div id="wrapper">
<div id="leftcolumn">
<br/><br/><br/><br/><br/><br/><br/>
	<div style="text-align: center;">
		<form:form action="/CMS_M1029673/userLogin" method="get">
			<input type="submit" value="guest" id="guest" />
		</form:form>
		<form:form action="/CMS_M1029673/customLogin" method="get">
			<input type="submit" value="admin" id="admin" />
		</form:form>
	</div>
	</div>
	 
</div>
</body>
</html>
<style>
#wrapper {
     width: 1005px;
     margin: 0 auto;
}
#leftcolumn, #rightcolumn {
    border: 1px solid white;
    float: left;
    min-height: 450px;
    color: white;
}
#leftcolumn {
     width: 250px;
     background-color: #111;
}

#rightcolumn {
     width: 750px;
     background-color: #777;
}
</style>
