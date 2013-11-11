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
            dbCreate = ""
        }
    }
    production {
        dataSource {
            dbCreate = ""
        }
    }
   
}
