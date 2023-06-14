package com.iemr.common.identity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.iemr.common.identity.utils.IEMRApplBeans;

@SpringBootApplication
@EnableJpaRepositories
@EnableTransactionManagement
public class IdentityApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(applicationClass, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(applicationClass);
	}

	private static Class<IdentityApplication> applicationClass = IdentityApplication.class;
	
	@Bean
	public IEMRApplBeans instantiateBeans(){
		
		return new IEMRApplBeans();
	}
}

