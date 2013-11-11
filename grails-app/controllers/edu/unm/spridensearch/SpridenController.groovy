package edu.unm.spridensearch

import grails.plugins.springsecurity.Secured

import org.springframework.jdbc.datasource.UserCredentialsDataSourceAdapter
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
@Secured(['IS_AUTHENTICATED_FULLY'])
class SpridenController {
	
	UserCredentialsDataSourceAdapter dataSource
	
	//We want to reroute any requests from
	//index to searchById
	def index() 
	{
		redirect (action: "searchById")
		//render "Hello World"
	}
	
	//When a user clicks on the "Submit" button on the
	//searchById.gsp the MVC framework sends us here...
	def listStudents = 
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		dataSource.setCredentialsForCurrentThread(auth.getName(), auth.getCredentials());

		//Defining our variables that are
		//coming in from the our view/form (searchById.gsp)
		def banId = params.bannerIdInForm
		def firName = params.firstNameInForm
		def lasName = params.lastNameInForm
		def results
		
		//Adding a few console comments for logging purposes...		
		println("Ban ID: " + banId)
		println("First Name: " + firName)
		println("thread:" + Thread.currentThread().getId() + " " +Thread.currentThread().getName())
		println("auth name: " + auth.getName());

		
		//If a string is used in a conditional statement
		//Groovy will return true if there are characters or
		//whitespace.  
		if (banId)
		{			
			results = Spriden.where 
			{
				id == banId
				changeIndicator == null
			}
		}
		else //If the string is empty or null, the conditional statement is false
		{
			if (firName && lasName)
			{
				//If the first name and last name
				//are available then we will query
				//by first name, last name, and change Indicator
				results = Spriden.where
				{
					firstName == firName
					lastName == lasName
					changeIndicator == null
				}
			}
			else if (firName)
			{
				//If the user only enters the first name we
				//will only query using first name and change indicator
				results = Spriden.where
				{
					firstName == firName
					changeIndicator == null
				}
			}
			else if (lasName)
			{
				//If the user enters only the last name we
				//will only query using the last name and change indicator
				results = Spriden.where
				{
					lastName == lasName
					changeIndicator == null
				}
			}
		}//End Else Statement
			
		//Our results are placed in a map
		//and handed to the view that matches
		//this controller method (listStudents.gsp)
		[oneStudent:results]
	}
	
	
	@Secured(['IS_AUTHENTICATED_FULLY'])
	def searchById = 
	{
		
	}
	
	//def scaffold = Spriden
}
