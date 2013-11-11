dataSource {
    pooled = false
    driverClassName = "oracle.jdbc.OracleDriver"
	dialect = 'org.hibernate.dialect.Oracle10gDialect'
	readOnly = true
	}

hibernate {
    cache.use_second_level_cache = true
    cache.use_query_cache = false
    cache.region.factory_class = 'net.sf.ehcache.hibernate.EhCacheRegionFactory'
	connection.pool_size = 0
	temp.use_jdbc_metadata_defaults = false
	}
// environment specific settings
environments {
	development {
		dataSource {
			dbCreate = ''
			// url specified in "Local.groovy"
		}
	}
	
    test {
        dataSource {
            dbCreate = "update"
            //In memory
			//url = "jdbc:h2:mem:testDb;MVCC=TRUE;LOCK_TIMEOUT=10000"
			//Writes a file
			url = "jdbc:h2:testDb;MVCC=TRUE;LOCK_TIMEOUT=10000"
        }
    }
    production {
        dataSource {
            dbCreate = "update"
            url = "jdbc:h2:prodDb;MVCC=TRUE;LOCK_TIMEOUT=10000"
            pooled = true
            properties {
               maxActive = -1
               minEvictableIdleTimeMillis=1800000
               timeBetweenEvictionRunsMillis=1800000
               numTestsPerEvictionRun=3
               testOnBorrow=true
               testWhileIdle=true
               testOnReturn=true
               validationQuery="SELECT 1"
            }
        }
    }
   
}
