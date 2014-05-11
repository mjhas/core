package eu.haslgruebler.core.ui.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
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

import eu.haslgruebler.core.ui.api.AssetStack;
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

    private List<AssetStack> assetStack;

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

    /**
     * A {@link PropertyPlaceholderConfigurer} for "core.web${my.property}"
     * properties
     * 
     * @return {@link PropertyPlaceholderConfigurer}
     */
    @Bean
    public static PropertyPlaceholderConfigurer coreWebPropertyPlaceholderConfigurer() {
        PropertyPlaceholderConfigurer ppc = new PropertyPlaceholderConfigurer();
        ppc.setPlaceholderPrefix(CoreWebConfigurer.PLACEHOLDER_PREFIX);
        Resource[] resources;
        ClassPathResource cpr = new ClassPathResource("core.web.properties");
        if (System.getProperty("core.web.propertiesFile") == null) {
            resources = new Resource[] { cpr };
        } else {
            resources = new Resource[] { cpr, new FileSystemResource(System.getProperty("core.web.propertiesFile")) };
        }
        ppc.setLocations(resources);
        ppc.setIgnoreUnresolvablePlaceholders(true);
        return ppc;
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

    /**
     * 
     * @return {@link AngularAssetStack}
     */
    @Bean
    public AngularAssetStack angularAssetStack() {
        return new AngularAssetStack();
    }

    /**
     * 
     * @return {@link JQueryAssetStack}
     */
    @Bean
    public JQueryAssetStack jQueryAssetStack() {
        return new JQueryAssetStack();
    }

    /**
     * 
     * @return {@link AngularRouteAssetStack}
     */
    @Bean
    public AngularRouteAssetStack angularRouteAssetStack() {
        return new AngularRouteAssetStack();
    }

    /**
     * 
     * @return {@link AngularRouteAssetStack}
     */
    @Bean
    public CoreAssetStack coreAssetStack() {
        return new CoreAssetStack();
    }

    /**
     * 
     * @return {@link AngularGridAssetStack}
     */
    @Bean
    public AngularGridAssetStack angularGridAssetStack() {
        return new AngularGridAssetStack();
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
        return new CoreWebController(getMenuItemList(), getAssetStack(), coreWebConfigurer());
    }

    /**
     * @return {@link eu.haslgruebler.core.ui.api.CoreWebConfiguration}
     */
    @Bean
    public eu.haslgruebler.core.ui.api.CoreWebConfiguration coreWebConfigurer() {
        return new CoreWebConfigurer();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/core-resources/**").addResourceLocations("classpath:/core/");
    }

    /**
     * @return .
     */
    public List<AssetStack> getAssetStack() {
        if (assetStack == null) {
            return Collections.emptyList();
        }
        return assetStack;
    }

    @Autowired(required = false)
    public void setAssetStack(List<AssetStack> assetStack) {
        this.assetStack = assetStack;
    }

    /**
     * register a MessageSource for internationalisation
     * 
     * @return {@link MessageSource} for i18n
     */
    @Bean
    public MessageSource messageSource() {
        final ReloadableResourceBundleMessageSource ret = new ReloadableResourceBundleMessageSource();
        ret.setBasename("classpath:core.messages");
        ret.setDefaultEncoding("UTF-8");
        return ret;
    }

}
