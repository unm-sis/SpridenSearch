package edu.unm.spridensearch

class Spriden {

    String pidm
	String id
	String lastName
	String firstName
	String changeIndicator
	
	
	//This also determines the field order
	static constraints = {
		pidm()
		id()
		lastName()
		firstName()
		
    }
	
	static mapping = {
		table name: 'SPRIDEN', schema: 'SATURN'
		
		
		version false
		pidm column: 'SPRIDEN_PIDM'
		id column: 'SPRIDEN_ID'
		lastName column: 'SPRIDEN_LAST_NAME'
		firstName column: 'SPRIDEN_FIRST_NAME'
		changeIndicator column: 'SPRIDEN_CHANGE_IND'
		//id generator: 'sequence', params:[sequence:'SZBGAPR_SEQ', schema: 'UNM']
    }
	
}