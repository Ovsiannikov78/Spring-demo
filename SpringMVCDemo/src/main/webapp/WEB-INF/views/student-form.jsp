<%--
  Created by IntelliJ IDEA.
  User: sergiiovsiannikov
  Date: 10.10.20
  Time: 17:22
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>

<html>

<head>
    <title>Student Registration Form</title>
</head>

<body>

<form:form action="processForm" modelAttribute="student">

    First name: <form:input path="firstName"/>

    <br><br>

    Last name: <form:input path="lastName"/>

    <br><br>

    Country:
    <form:select path="country">
        <form:options items="${student.countryOptions}"/>

    </form:select>

    <br><br>

    <input type="submit" value="Submit"/>

</form:form>

</body>

</html>
