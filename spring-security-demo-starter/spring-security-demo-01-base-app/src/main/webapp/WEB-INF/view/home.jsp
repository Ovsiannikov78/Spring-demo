<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>

<head>
    <title>My Company Home Page</title>
</head>

<body>
<h2>My Company Home Page</h2>
<hr>
<p>
    Welcome to the my company home page
</p>

<%-- Add a logout button --%>
<form:form action="${pageContext.request.contextPath}/logout" method="post">

    <input type="submit" value="Logout"/>

</form:form>

</body>

</html>
