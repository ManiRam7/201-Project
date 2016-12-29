<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="http://code.jquery.com/jquery-1.11.1.js"></script>
<title>Insert title here</title>
</head>
<body>
<h1 align="center">Content Management System</h1>
	<div id="wrapper">
		<div id="leftcolumn">
			<br /> <br /> <br /> <br /> <br /> <br /> <br />
			<div style="text-align: center;">
				<a href="/secure/home"> <input type="button" value="Add Blog"
					id="guest" />
				</a></br></br>
				<a href="/viewBlogForAdmin?guestUserName=admin&blogId=1">
					<input type="button" value="View Blog" id="admin" />
				</a></br></br>
				<form action="/appLogout" method="POST">
					<input type="submit" value="Logout" /> <input type="hidden"
						name="${_csrf.parameterName}" value="${_csrf.token}" />
				</form>
			</div>
		</div>
		<div id="rightcolumn" >
			<div style='text-align: center'>
				<form:form commandName="blogFo" action="saveBlog" id="add-form" style='text-align: center'
					method="POST" enctype="multipart/form-data">
			
						<h1 style="color: green">
							<c:if test="${msg!=null}">
                  ${msg}
                 </c:if>
						</h1>
					<div style='text-align: center'>
						<table >
							<tr>
								<td><label for="title">Title: </label></td>
								<td><form:input id="title" path="title" /></td><td style="color: red;"> <form:errors
										path="title" cssClass="error" /></td>
							</tr>
							<tr>
								<td><label for="description">Description: </label> </td>
								<td><form:textarea rows="10" cols="40" 
										id="description" path="description" /> </td><td style="color: red;"><form:errors
										path="description" cssClass="error" /></td>
							</tr>
							<tr>
								<td><label for="image">Blog: </label></td>
								<td><input type="file" name="file" id="photo" />(Upload JPEG/PNG File)</td>
								<td style="color: red;"><c:if test="${nofile!=null}">
                 					 ${nofile}
                 					</c:if></td>
							</tr>
							<tr><td>
								<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<input id="reset" type="reset" tabindex="4"> <input
									id="submit" type="submit" tabindex="5" value="Add"></td>
							</tr>
						</table>
					</div>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>
<style>
body {
	background-color: #444;
	margin: 0;
}

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

