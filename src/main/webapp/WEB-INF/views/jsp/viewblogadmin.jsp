<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<script src="http://code.jquery.com/jquery-1.11.1.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
		<div id="rightcolumn" style="position: relative; overflow-y: scroll;">
		<a class="prev" id="prev">&#10094;</a> 
			<div style="text-align: center;">
					<c:choose>
					<c:when test="${not empty blogFo}">
						<h3 style="color: #0bb1d8;">Title:${blogFo.title}</h3>
						<h3 style="color: #0bb1d8;">
							Description: ${blogFo.description}<br />
						</h3>
						<h3 style="color: #0bb1d8;">
							<b>Image:</b>
						</h3>
						<img src="data:image/jpg;base64,${blogFo.imageSrc}"
							class="mySlides" alt="No image" width="250" height="250">
					</c:when>
					 <c:otherwise>
					 <br/><br/><br/><br/><br/><br/><br/><br/>
					<h1 style="color: red"> NO Record Found</h1>
					 </c:otherwise>
					</c:choose>
				</div>
				<a class="next" id="next">&#10095;</a>
				<div style="text-align: center;" id="refershtheData">
					<c:if test="${not empty blogFo.blogCommentsFo}">
						<h3>User Comments</h3>
						<c:forEach items="${blogFo.blogCommentsFo}" var="blogComment">
							<div style="text-align: center;">
								<b style="font-size: large; color: #0bb1d8;">${blogComment.userName}:</b>
								${blogComment.comment} <br /></br>
							</div>
						</c:forEach>
					</c:if>
				</div>
		
		</div>
	</div>

</body>
</html>
<script>
	jQuery(document).ready(
			function($) {
				var slideIndex = '${blogId}';
				if (slideIndex == 1) {
					$("#prev").hide();
				}
				if ('${blogFo.count}' <= 1) {
					$("#prev").hide();
					$("#next").hide();
				}
				if ('${blogFo.count}' == slideIndex) {
					$("#next").hide();
				}
				$("#next")
						.click(
								function() {
									var blogId = parseInt('${blogId}') + 1;
									window.location
											.replace("/viewBlogForAdmin?guestUserName="
													+ '${guestUserName}'
													+ "&blogId=" + blogId);

								});
				$("#prev")
						.click(
								function() {
									var blogId = parseInt('${blogId}') - 1;
									window.location
											.replace("/viewBlogForAdmin?guestUserName="
													+ '${guestUserName}'
													+ "&blogId=" + blogId);

								});
			});
</script>
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
	height: 500px
}

#rightcolumn {
	width: 750px;
	background-color: #777;
	height: 500px
}
/* Next & previous buttons */
.prev, .next {
  cursor: pointer;
  position: absolute;
  top: 50%;
  width: auto;
  margin-top: -22px;
  padding: 16px;
  color: white;
  font-weight: bold;
  font-size: 18px;
  transition: 0.6s ease;
  border-radius: 0 3px 3px 0;
}
/* Position the "next button" to the right */
.next {
  right: 0;
  border-radius: 3px 0 0 3px;
}

/* On hover, add a black background color with a little bit see-through */
.prev:hover, .next:hover {
  background-color: rgba(0,0,0,0.8);
}

</style>

