package eu.haslgruebler.core.bootstrap;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Registers Bootstrap resource files.
 * 
 * @author Michael Haslgrübler
 * 
 */
@EnableWebMvc
@Configuration
public class BootstrapConfiguration extends WebMvcConfigurerAdapter {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/bootstrap/**").addResourceLocations("classpath:/bootstrap/");
    }
}
