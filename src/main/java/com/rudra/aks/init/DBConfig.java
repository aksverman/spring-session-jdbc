package com.rudra.aks.init;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.session.jdbc.config.annotation.web.http.EnableJdbcHttpSession;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableJdbcHttpSession
public class DBConfig {
	
	/*
	@Bean
	public EmbeddedDatabase dataSource() {
		return new EmbeddedDatabaseBuilder() // <2>
				.setType(EmbeddedDatabaseType.H2)
				.addScript("org/springframework/session/jdbc/schema-h2.sql").build();
	}*/
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://10.98.8.100:3306/security_dev?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
		dataSource.setUsername("devuser");
		dataSource.setPassword("leo$123");
		return dataSource;
	}

	/*@Bean 
	public DataSourceInitializer dataSourceInitializer() {
	    DataSourceInitializer initializer = new DataSourceInitializer();
	    initializer.setDataSource(dataSource());
	    initializer.setDatabasePopulator(databasePopulator());
	    initializer.afterPropertiesSet();
	    return initializer;
	} 
	 
	private DatabasePopulator databasePopulator() {
	    ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
	    populator.addScript(new ClassPathResource("org/springframework/session/jdbc/schema-mysql.sql"));
	    return populator;
	} 	*/
	
	@Bean(name = "txManager")
	public PlatformTransactionManager	txManager() {
		return new DataSourceTransactionManager(dataSource());
	}
}
