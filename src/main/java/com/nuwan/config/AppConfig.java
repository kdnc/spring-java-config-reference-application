package com.nuwan.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

@Configuration
//@ComponentScan(basePackages = {“”}), this is the same as <context:component-scan base-package=””/>
@ComponentScan( basePackages = "com.nuwan.stockticker" )
//@EnableWebMVC, this is the same as <mvc:annotation-driven/>
//In the case of REST, @EnableWebMVC detect the existence of Jackson and JAXB 2 on the classpath
// and automatically creates and registers default JSON and XML converters. When more complex configuration is
// needed, remove the @EnableWebMVC annotation and extend WebMvcConfigurationSupport directly.
@EnableWebMvc
public class AppConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        Declare our static resources. Same as following xml config.
//        <mvc:resources mapping="/resources/**" location="/resources/" />
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }

    @Bean
    public ViewResolver getViewResolver(){
//         Add bean for InternalResourceViewResolver. Same as following xml config.
//                 <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
//              <property name="prefix" value="/WEB-INF/" />
//              <property name="suffix" value=".jsp" />
//         </bean>
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/security/basic-securing-web/home").setViewName("security/basic-securing-web/home");
        registry.addViewController("/security/basic-securing-web/").setViewName("security/basic-securing-web/home");
        registry.addViewController("/security/basic-securing-web/admin").setViewName("security/basic-securing-web/admin");
        registry.addViewController("/security/basic-securing-web/login").setViewName("security/basic-securing-web/login");
    }

}
