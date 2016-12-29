<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CMS</title>
</head>
<body background="/images/cms_BackGround.jpg">
	<h1 align="center">Content Management</h1>
	<div id="wrapper">
		<div id="leftcolumn">
			<br /> <br /> <br /> <br /> <br /> <br /> <br />
			<div style="text-align: center;">
				<form:form action="/userLogin" method="get">
					<input type="submit" value="guest" id="guest" />
				</form:form>
				<form:form action="/customLogin" method="get">
					<input type="submit" value="admin" id="admin" />
				</form:form>
			</div>
		</div>


		<div id="rightcolumn">
			<br /> <br /> <br /> <br /> <br /> <br /> <br />
			<div id="msg" style="text-align: center;">
				<font color="red"> ${SPRING_SECURITY_LAST_EXCEPTION.message}
				</font>
			</div>
			</br>
			<form action="/appLogin" method="POST"
				style="text-align: center;">
				<div id="adminview">
					Enter UserName : <input type="text" name="app_username" /><br /></br>
					Enter Password &nbsp;: &nbsp;<input type="password"
						name="app_password" />

				</div>
				<div id="formsubmit">
					<br />
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input
						type="submit" value="Login" id="submit" /> <input type="hidden"
						name="${_csrf.parameterName}" value="${_csrf.token}" />
				</div>

			</form>
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
