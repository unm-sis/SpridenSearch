<html><!-- This is a view -->
<head>
	<title>Please Enter A Student ID</title>
</head>



<body>

<g:form controller="spriden" action="listStudents">
	<div>
	Banner ID:
	<g:textField 
		name="bannerIdInForm" 
		maxlength="50">
    </g:textField>
    </div>
    
     <div>
     <p>
     OR
     <p>
     </div>
    
    <div>
	First Name:
	<g:textField 
		name="firstNameInForm" 
		maxlength="50">
    </g:textField>
    <div>
	Last Name:
	<g:textField 
		name="lastNameInForm" 
		maxlength="50">
    </g:textField>
    </div>
    <input value="Submit"  type="submit"/>
</g:form>
<p>
<p>
<g:form controller="logout" action="index">
	
    <input value="Logout"  type="submit"/>
</g:form>

</body>

</html>