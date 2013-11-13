import org.springframework.jdbc.datasource.UserCredentialsDataSourceAdapter
import org.springframework.jdbc.support.lob.OracleLobHandler
import org.springframework.jdbc.support.nativejdbc.CommonsDbcpNativeJdbcExtractor

import edu.unm.UserDatabaseAuthenticationProvider
//SCC 2013-11-01: Added the following from Jason's code
//This allowed for the application to start but I still got an error:
//| Error 2013-11-01 15:06:38,845 [localhost-startStop-1] ERROR spring.GrailsRuntimeConfigurator  - [RuntimeConfiguration] Unable to load beans from resources.groovy
//Message: No such property: UserDatabaseAuthenticationProvider for class: resources
//SCC 2013-11-01: Be sure to add the UserDatabaseAuthenticationProvider.groovy  
//that is in /src/groovy/edu/unm/
beans = {
	lobHandlerDetector(OracleLobHandler) { nativeJdbcExtractor = new CommonsDbcpNativeJdbcExtractor() }

	dataSource(UserCredentialsDataSourceAdapter){ targetDataSource= ref("dataSourceUnproxied") }

	dbAuthenticationProvider(UserDatabaseAuthenticationProvider){ dataSource = ref("dataSource") }

}

