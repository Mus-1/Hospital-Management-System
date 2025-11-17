    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

	<h1>Patient List</h1>
	<table border="2" width="70%" cellpadding="2">
	<tr><th>Id</th><th>Name</th><th>Age</th><th>Edit</th><th>Delete</th></tr>
    <c:forEach var="patient" items="${list}"> 
    <tr>
    <td>${patient.id}</td>
    <td>${patient.name}</td>
    <td>${patient.age}</td>
    <td><a href="editpatient/${patient.id}">Edit</a></td>
    <td><a href="deletepatient/${patient.id}">Delete</a></td>
    </tr>
    </c:forEach>
    </table>
    <br/>
    <a href="patientform">Add New Patient</a>