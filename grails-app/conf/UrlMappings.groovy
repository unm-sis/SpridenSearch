
class UrlMappings {
	
		static mappings = {
			"/$controller/$action?/$id?"{ constraints { // apply constraints here
				} }
	
			//"/"(view:"/index")
			"/"(controller:"spriden")
			"500"(view:'/error')
						
			//2013-11-11 SCC: We were having strangeness with WebLogic
			//and the following solved our problem:
			"/index.gsp"(controller:"spriden")
		}
	}


