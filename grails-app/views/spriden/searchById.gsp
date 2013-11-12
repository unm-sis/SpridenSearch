<html><!-- This is a view -->
<g:render template="/layouts/header" />
<head>
<meta name='layout' content='main'/>
	<title>Please Enter A Student ID</title>
</head>



<body>
<div id = 'overall'>
<g:form controller="spriden" action="listStudents">
	
		Banner ID:
		<g:textField 
			name="bannerIdInForm" 
			maxlength="50">
	    </g:textField>
    
    
         <br>
	     <br>
	     OR
	     <br>
         <br>
    
        
		First Name:
		<g:textField 
			name="firstNameInForm" 
			maxlength="50">
	    </g:textField>
	    <br>
	    <br>
		Last Name:
		<g:textField 
			name="lastNameInForm" 
			maxlength="50">
	    </g:textField>
    <br>
    <br>
    <input value="Submit"  type="submit"/>
    
    
	</g:form>
</div>	
<p>
<p>
<div id = 'logout'>
<g:form controller="logout" action="index">
	
    <input value="Logout"  type="submit"/>
</g:form>
</div>
</body>

</html>