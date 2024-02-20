package org.generation.italy.webtv.servlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServletConfig {

    @Autowired
    private UtenteVideoServlet utenteVideoServlet;
    
  
    @Bean
    ServletRegistrationBean<UtenteVideoServlet> UtenteVideoServletRegistration() {
        ServletRegistrationBean<UtenteVideoServlet> registrationBean =
                new ServletRegistrationBean<>(utenteVideoServlet, "/utenteVideo/*");

        return registrationBean;
    }
  
}