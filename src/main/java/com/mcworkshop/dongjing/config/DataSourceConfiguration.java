package com.mcworkshop.dongjing.config;

import org.h2.server.web.WebServlet;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by markfredchen on 4/10/15.
 */
@Configuration
public class DataSourceConfiguration {
    @Bean
    public ServletRegistrationBean h2Servlet() {
        ServletRegistrationBean servletBean = new ServletRegistrationBean();
        servletBean.addUrlMappings("/h2/*");
        servletBean.setServlet(new WebServlet());
        return servletBean;
    }
}
