package com.example.simpleWebApplication.config;

import org.h2.server.web.JakartaWebServlet;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class H2ConsoleConfiguration {

	@Bean
	public ServletRegistrationBean<JakartaWebServlet> h2ConsoleServletRegistration(
			@Value("${spring.h2.console.path:/h2-console}") String h2ConsolePath) {
		ServletRegistrationBean<JakartaWebServlet> registrationBean = new ServletRegistrationBean<>(
				new JakartaWebServlet(), h2ConsolePath, h2ConsolePath + "/*");
		registrationBean.setLoadOnStartup(1);
		return registrationBean;
	}
}