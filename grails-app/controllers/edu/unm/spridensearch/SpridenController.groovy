package edu.unm.spridensearch

import grails.plugins.springsecurity.Secured

import org.springframework.jdbc.datasource.UserCredentialsDataSourceAdapter
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
@Secured(['IS_AUTHENTICATED_FULLY'])
class SpridenController {
	
	UserCredentialsDataSourceAdapter dataSource
	
	def index() {
		
		//println(dataSource)
		redirect (action: "searchById")
		//render "Hello World"
	}
	
	def listStudents = {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		dataSource.setCredentialsForCurrentThread(auth.getName(), auth.getCredentials());

		def banId = params.bannerIdInForm
		def firName = params.firstNameInForm
		def results
				
		println("Ban ID: " + banId)
		println("First Name: " + firName)
		
		println("thread:" + Thread.currentThread().getId() + " " +Thread.currentThread().getName())
		
		println("auth name" + auth.getName());

		
		
		if (banId != "")
		{
			
			results = Spriden.where 
			{
				id == banId
				changeIndicator == null
			}
		}
		else
		{
			results = Spriden.where
			{
				firstName == firName
				changeIndicator == null
			}
			
		}
			
		//def oneStudent = Spriden.list()
		[oneStudent:results]
	}
	
//	def listStudents = {
//		def allStudents = Spriden.list()
//		[allStudents:allStudents]
//	}
	
	def listOneStudent = {
		
		def banId = params.bannerIdInForm
		
		println(banId)
		
//		def fname = "St%"
//		def lname = "Cro%"
		
		//def results = Spriden.findAllByFirstName(fname)
		//def results = Spriden.findAllByFirstNameAndChangeIndicatorIsNull(fname)
		//def results = Spriden.findAllByLastNameIlikeAndChangeIndicatorIsNull(lname)
		//def  results = Spriden.findAllByFirstNameIlikeAndChangeIndicatorIsNull(fname)
		
		def results = Spriden.where {
			id == banId
			changeIndicator == null
			
		}
		
		
			
		
			
		//def oneStudent = Spriden.list()
		[oneStudent:results]
		
		//println(results)
	}
	
	@Secured(['IS_AUTHENTICATED_FULLY'])
	def searchById = {
		
	}
	
	//def scaffold = Spriden
}
