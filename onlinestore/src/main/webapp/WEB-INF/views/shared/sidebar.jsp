<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c1"%>
<h1 class="my-4">Shop Name</h1>
<div class="list-group">

	<c1:forEach items="${categories}" var="category">
		<a href="${contextRoot}/show/category/${category.id}/products " class="list-group-item" id="a_${category.name}">${category.name}</a>
	</c1:forEach>
</div>