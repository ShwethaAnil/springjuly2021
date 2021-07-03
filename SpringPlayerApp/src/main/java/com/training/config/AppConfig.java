package com.training.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.training.dao.PlayerDao;
import com.training.daoimpl.PlayerDaoImpl;

@Configuration
@ComponentScan(basePackages = "com.training")
public class AppConfig {
	
//	@Bean
//	public PlayerDao getPlayerDao() {
//		return new PlayerDaoImpl();
//	}

}
