package com.nuwan.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

import java.util.Locale;

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

//    You can define a locale resolver by registering a bean of type LocaleResolver in the web application context. You
//must set the bean name of the locale resolver to localeResolver for DispatcherServlet to auto-detect. Note that you
//    can register only one locale resolver per DispatcherServlet.
    @Bean
    public LocaleResolver localeResolver () {
//        Another option of resolving locales is by SessionLocaleResolver. It resolves locales by inspecting a predefined
//        attribute in a user’s session. If the session attribute doesn’t exist, this locale resolver determines the default locale
//        from the accept-language HTTP header.
//        SessionLocaleResolver localeResolver = new SessionLocaleResolver();
//        localeResolver.setDefaultLocale(new Locale("en"));
//        return localeResolver;

//        You can also use CookieLocaleResolver to resolve locales by inspecting a cookie in a user’s browser. If the cookie
//        doesn’t exist, this locale resolver determines the default locale from the accept-language HTTP header.

        CookieLocaleResolver cookieLocaleResolver = new CookieLocaleResolver();
        cookieLocaleResolver.setCookieName("language");
        cookieLocaleResolver.setCookieMaxAge(3600);
        cookieLocaleResolver.setDefaultLocale(new Locale("en"));
        return cookieLocaleResolver;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }

    //    In addition to changing a user’s locale by calling LocaleResolver.setLocale() explicitly, you can also apply
//LocaleChangeInterceptor to your handler mappings. This interceptor detects if a special parameter is present in
//    the current HTTP request. Now a user’s locale can be changed by any URLs with the language parameter.
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
        localeChangeInterceptor.setParamName("language");
        return localeChangeInterceptor;
    }

//    You can define a message source by registering a bean of type MessageSource in the web application context. You
//must set the bean name of the message source to messageSource for DispatcherServlet to auto-detect. Note that you
//    can register only one message source per DispatcherServlet.
//    The ResourceBundleMessageSource implementation resolves messages from different resource bundles for
//different locales. For example, you can register it in WebConfiguration to load resource bundles whose base name
//    is messages:
    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages");
        return messageSource;
    }


}
