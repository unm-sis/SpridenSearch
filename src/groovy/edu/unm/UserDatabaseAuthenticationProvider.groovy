package edu.unm

import java.sql.Connection
import java.sql.SQLException

import org.springframework.jdbc.datasource.UserCredentialsDataSourceAdapter
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider
import org.springframework.security.core.AuthenticationException
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.util.StringUtils


class UserDatabaseAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {
	
	 def dataSource
		 
	 @Override
	 protected void additionalAuthenticationChecks(UserDetails userDetails,
	   UsernamePasswordAuthenticationToken token) throws AuthenticationException {
	 }
	
	 @Override
	 protected UserDetails retrieveUser(String username,
	   UsernamePasswordAuthenticationToken token) throws AuthenticationException {
	
	   String password = (String) token.getCredentials();
		   
	   if (!StringUtils.hasText(password)) {
		 throw new BadCredentialsException("Please enter password");
	   }
		   
	   List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		   
	   try {
		 Connection connection = dataSource.getConnection(username, password)
		 
		 dataSource.setCredentialsForCurrentThread(username, password)
	   }catch(SQLException sql) {
		 throw new BadCredentialsException("Invalid username or password!" + sql.getMessage());
	   }
	   
	   return new org.springframework.security.core.userdetails.User(username, password,	true, true, true, true,	authorities);
	
	 }
   }
