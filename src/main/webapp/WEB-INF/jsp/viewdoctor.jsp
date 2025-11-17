    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

	<h1>Doctors List</h1>
	<table border="2" width="70%" cellpadding="2">
	<tr><th>Id</th><th>Name</th><th>Salary</th><th>Designation</th><th>Edit</th><th>Delete</th></tr>
    <c:forEach var="doctor" items="${list}"> 
    <tr>
    <td>${doctor.id}</td>
    <td>${doctor.name}</td>
    <td>${doctor.salary}</td>
    <td>${doctor.designation}</td>
    <td><a href="editdoctor/${doctor.id}">Edit</a></td>
    <td><a href="deletedoctor/${doctor.id}">Delete</a></td>
    </tr>
    </c:forEach>
    </table>
    <br/>
    <a href="doctorform">Add New Doctor</a>