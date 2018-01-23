<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@taglib prefix="j" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<%@page session="true"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>People Management Screen</title>
</head>
<body>
<div align="center">
    <h1>People List</h1>
    <h3>
        <a href="newPeople">New People</a>
    </h3>
    <table border="1">

        <th>Name</th>
        <th>Email</th>
        <th>Address</th>
        <th>Telephone</th>
        <th>Action</th>

        <c:forEach var="people" items="${listPeople}">
            <tr>
                <td>${people.name}</td>
                <td>${people.email}</td>
                <td>${people.address}</td>
                <td>${people.telephone}</td>
                <td><a href="editPeople?id=${people.id}">Edit</a>
                    <a
                            href="deletePeople?id=${people.id}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>

    <br/>
    <br/>
    <h1>Name : ${name}</h1>
    <h1>Description : ${description}</h1>

    <j:if test="${pageContext.request.userPrincipal.name != null}">
        <h2>
            Welcome : ${user} | <a
                href="<j:url value="/j_spring_security_logout" />"> Logout</a>
        </h2>
    </j:if>


</div>
</body>
</html>
