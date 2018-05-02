package com.project.demo.profileConfig;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("prod")
public class ProdCustomizer {
	@Bean
	public ConfigurableServletWebServerFactory webServerFactory() {

		TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
		factory.setContextPath("/spring-boot-prod");
		factory.addConnectorCustomizers(connector -> connector.setPort(8585));
		return factory;
	}
}
