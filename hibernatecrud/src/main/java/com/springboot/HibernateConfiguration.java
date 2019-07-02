package com.springboot;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@PropertySource(value = { "classpath:application.properties" })
public class HibernateConfiguration {

	@Value("${db.driver}")
	private String DB_DRIVER;
	@Value("${db.password}")
	private String DB_PASSWORD;
	@Value("${db.username}")
	private String DB_USERNAME;
	@Value("${db.url}")
	private String DB_URL;
	@Value("${hibernate.dialect}")
	private String HIBERNATE_DIALECT;

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource(DB_URL, DB_USERNAME, DB_PASSWORD);
		dataSource.setDriverClassName(DB_DRIVER);
		return dataSource;
	}

	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan(new String[] { "com.springboot.model" });
		sessionFactory.setHibernateProperties(properties());
		return sessionFactory;
	}

	private Properties properties() {
		Properties hibernateProperties = new Properties();
		hibernateProperties.putIfAbsent("hibernate.hbm2ddl.auto", "update");
		hibernateProperties.putIfAbsent("hibernate.dailect", HIBERNATE_DIALECT);
		hibernateProperties.putIfAbsent("hibernate.show_sql", "true");
		hibernateProperties.putIfAbsent("hibernate.format_sql", "true");
		return hibernateProperties;
	}

	@Bean
	public HibernateTransactionManager hibernateTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();
		hibernateTransactionManager.setSessionFactory(sessionFactory);
		return hibernateTransactionManager;

	}

}
