package eu.haslgruebler.core.ui.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import eu.haslgruebler.core.ui.api.MenuItem;

/**
 * 
 * @author Michael Haslgrübler
 * 
 */
@EnableWebMvc
@Configuration
public class CoreWebConfiguration extends WebMvcConfigurerAdapter {

    private List<MenuItem> menuItemList;

    /**
     * 
     * @return {@link LocaleChangeInterceptor}
     */
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
        localeChangeInterceptor.setParamName("lang");
        return localeChangeInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }

    /**
     * 
     * @return {@link LocaleResolver}
     */
    @Bean(name = "localeResolver")
    public LocaleResolver localeResolver() {
        return new SessionLocaleResolver();
    }

    /**
     * 
     * @return {@link ViewResolver}
     */
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Autowired(required = false)
    public void setMenuItemList(List<MenuItem> menuItemList) {
        this.menuItemList = menuItemList;
    }

    /**
     * 
     * @return {@link List} of {@link MenuItem}s
     */
    public List<MenuItem> getMenuItemList() {
        if (menuItemList == null) {
            return Collections.emptyList();
        }
        return menuItemList;
    }

    /**
     * 
     * @return {@link CoreWebController}
     */
    @Bean
    public CoreWebController coreWebController() {
        return new CoreWebController(getMenuItemList());
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/core-javascript/**").addResourceLocations("classpath:/core/");
    }

}
