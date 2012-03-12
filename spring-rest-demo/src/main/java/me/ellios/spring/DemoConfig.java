package me.ellios;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * User: ellios
 * Date: 12-3-5
 */
@Configuration
@ImportResource( { "classpath*:/applicationContext.xml" } )
@ComponentScan( basePackages = "me.ellios" )
@EnableWebMvc
public class DemoConfig {

    @Bean
    public static PropertyPlaceholderConfigurer properties(){
        PropertyPlaceholderConfigurer ppc = new PropertyPlaceholderConfigurer();
        ppc.setIgnoreUnresolvablePlaceholders( true );
        return ppc;
    }
}
