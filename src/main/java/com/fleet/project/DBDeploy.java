package com.fleet.project;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class DBDeploy {

	@Value("${SPRING_DATASOURCE_URL}")
	private String dbUrl;

	@Bean
	public DataSource dataSource() {
		HikariConfig config = new HikariConfig();
		config.setJdbcUrl(dbUrl);
		return new HikariDataSource(config);
	}

}
