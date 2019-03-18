<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url var="css" value="/resources/css" />

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 -->
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Petals - ${title}</title>

<script>
	window.menu = '${title}';

	window.contextRoot = '${contextRoot}';

	/* 		window.categoryId='${category}';
	 */
</script>

<!-- Bootstrap core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">

<!-- Bootstrap readable CSS -->
<link href="${css}/bootstrap-readable-theme.css" rel="stylesheet">

<!-- Bootstrap datatable CSS -->
<link href="${css}/dataTables.bootstrap.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${css}/myapp.css" rel="stylesheet">

<!-- FontAwesome styles for this template -->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.7.1/css/all.css"
	integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr"
	crossorigin="anonymous">


</head>

<body>
	<div class="wrapper">
		<!-- NavBar -->
		<%-- <%@include file="./shared/navbar.jsp"%> --%>

		<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
			<div class="container">
				<div class="navbar-header">

					<a class="navbar-brand" href="${contextRoot}/home">Home</a>
				</div>
			</div>

		</nav>

		<div class="content">
			<div class="container">

				<div class="row">

					<div class="col-xs-12">

						<div class="jumbotron">

							<h1>${errorTitle}</h1>
							<hr />
							<blockquote style="word-wrap:break-word">
							${errorDescription}
							</blockquote>

						</div>
					</div>

				</div>
			</div>


		</div>
		<!-- Footer -->
		<%@include file="./shared/footer.jsp"%>


	</div>
</body>

</html>
