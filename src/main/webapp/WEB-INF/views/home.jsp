<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>School Manager Home</title>
    </head>
    <body>
    	<div align="center">
	        <h1>School List</h1>
	        <h3><a href="newSchool">New School</a></h3>
	        <table border="1">
	        	<th>No</th>
	        	<th>Name</th>
	        	<th>Code</th>
	        	<th>Address</th>
	        	<th>EmailDomain</th>
	        	<th>Action</th>
	        	
				<c:forEach var="school" items="${listSchool}" varStatus="status">
	        	<tr>
	        		<td>${status.index + 1}</td>
					<td>${school.name}</td>
					<td>${school.code}</td>
					<td>${school.address}</td>
					<td>${school.emailDomain}</td>
					<td>
						<a href="editSchool?id=${school.id}">Edit</a>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="deleteSchool?id=${school.id}">Delete</a>
					</td>
							
	        	</tr>
				</c:forEach>	        	
			</table>
    	</div>
    </body>
</html>
