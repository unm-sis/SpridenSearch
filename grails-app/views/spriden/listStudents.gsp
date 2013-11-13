<html><!-- This is a view -->
<head>
<meta name='layout' content='main'/>
	<title>Student Information</title>
</head>

<body>
<div id = 'overall'>
<table border="1">
	
	<thead>
	<tr>
		<th>First Name</th>
		<th>Last Name</th>
		<th>Banner ID</th>
		<th>PIDM</th>
	</tr>
	</thead>
	<tbody>
	<g:each in="${oneStudent}" status="i" var="thisStudent">
		<tr>
			<td>${thisStudent.firstName}</td>
			<td>${thisStudent.lastName}</td>
			<td>${thisStudent.id}</td>
			<td>${thisStudent.pidm}</td>
		</tr>
	
	</g:each>
	</tbody>

</table>
<g:form controller="spriden" action="searchById">
	
    <input value="Search Again"  type="submit"/>
</g:form>
</div>
<div id = 'logout'>
	<g:form controller="logout" action="index">
		
	    <input value="Logout"  type="submit"/>
</g:form>
</div>

</body>

</html>