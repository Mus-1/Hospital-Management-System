    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

	<h1>Login List</h1>
	<table border="2" width="70%" cellpadding="2">
	<tr><th>Id</th><th>Name</th><th>UserId</th><th>Password</th><th>Edit</th><th>Delete</th></tr>
    <c:forEach var="login" items="${list}"> 
    <tr>
    <td>${login.id}</td>
    <td>${login.name}</td>
    <td>${login.userId}</td>
    <td>${login.password}</td>
    <td><a href="editLogin/${login.id}">Edit</a></td>
    <td><a href="deleteLogin/${login.id}">Delete</a></td>
    </tr>
    </c:forEach>
    </table>
    <br/>
    <a href="loginForm">Add New Login</a>