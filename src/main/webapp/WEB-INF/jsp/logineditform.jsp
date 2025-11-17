<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

		<h1>Edit Login</h1>
       <form:form method="POST" action="/SpringMVCCRUDSimple/EditSaveLogin">  
      	<table >  
      	<tr>
      	<td></td>  
         <td><form:hidden  path="id" /></td>
         </tr> 
         <tr>  
          <td>Name : </td> 
          <td><form:input path="name"  /></td>
         </tr>  
         <tr>  
          <td>UserId :</td>  
          <td><form:input path="userId" /></td>
         </tr> 
         <tr>  
          <td>Password :</td>  
          <td><form:input path="password" /></td>
         </tr> 
         <tr>  
          <td> </td>  
          <td><input type="submit" value="EditSave" /></td>  
         </tr>  
        </table>  
       </form:form>  
