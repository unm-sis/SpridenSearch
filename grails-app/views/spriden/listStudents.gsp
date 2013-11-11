<html><!-- This is a view -->
<head>
	<title>Student Information</title>
</head>

<body>
<table border="3">
	<tr>
		<td>First Name</td>
		<td>Last Name</td>
		<td>Banner ID</td>
		<td>PIDM</td>
	</tr>
	<g:each in="${oneStudent}" status="i" var="thisStudent">
		<tr>
			<td>${thisStudent.firstName}</td>
			<td>${thisStudent.lastName}</td>
			<td>${thisStudent.id}</td>
			<td>${thisStudent.pidm}</td>
		</tr>
	
	</g:each>

</table>
<g:form controller="spriden" action="searchById">
	
    <input value="Search Again"  type="submit"/>
</g:form>
<g:form controller="logout" action="index">
	
    <input value="Logout"  type="submit"/>
</g:form>

</body>

</html>