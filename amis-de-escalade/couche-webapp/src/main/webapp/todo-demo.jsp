<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; UTF-8"
	pageEncoding="UTF-8"%>

<html>

<body>

<!-- Step 1: Create HTML form -->
<form action="Tododemo" method="post">
	Add new item: <input type="text" name="theItem" />
	
	<input type="submit" value="Submit" />
</form>


<!-- Step 3: Display all "To Do" item from session -->
<hr>
<b>To List Items:</b> <br/>

<ol>
<c:forEach var="tempSite" items="${myToDoList}">

<li>${tempSite}</li>
	
</c:forEach>
</ol>

</body>

</html>








