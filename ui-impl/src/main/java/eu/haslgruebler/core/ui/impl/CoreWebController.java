package eu.haslgruebler.core.ui.impl;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import eu.haslgruebler.core.ui.api.AssetStack;
import eu.haslgruebler.core.ui.api.CSSAsset;
import eu.haslgruebler.core.ui.api.CoreWebConfiguration;
import eu.haslgruebler.core.ui.api.CoreWebConstants;
import eu.haslgruebler.core.ui.api.JavascriptAsset;
import eu.haslgruebler.core.ui.api.MenuItem;

/**
 * 
 * @author Michael Haslgrübler
 * 
 */
@Controller
public class CoreWebController {

    private List<MenuItem> menuList;

    private TreeSet<JavascriptAsset> javaScriptStack;

    private TreeSet<CSSAsset> cssStack;

    private boolean loginLogoutSwitch;

    private boolean languageSwitch;

    private boolean navbarRight;

    private String redirect;

    /**
     * 
     * @param menuList .
     * @param assetStacks .
     */
    public CoreWebController(List<MenuItem> menuList, List<AssetStack> assetStacks, eu.haslgruebler.core.ui.api.CoreWebConfiguration configuration) {
        setLanguageSwitch(configuration.getBool(CoreWebConstants.CONFIG_MENU_LANGUAGE));
        setLoginLogoutSwitch(configuration.getBool(CoreWebConstants.CONFIG_MENU_LOGIN_LOGOUT));
        setNavbarRight(configuration.getBool(CoreWebConstants.CONFIG_MENU_NAVBAR_RIGHT));
        redirect = configuration.getString(CoreWebConstants.CONFIG_REDIRECT);
        this.menuList = new LinkedList<MenuItem>(menuList);
        this.javaScriptStack = new TreeSet<JavascriptAsset>();
        this.cssStack = new TreeSet<CSSAsset>();
        Collections.sort(this.menuList);
        for (AssetStack aStack : assetStacks) {
            javaScriptStack.addAll(aStack.getJavaScriptAssets());
            cssStack.addAll(aStack.getCssAssets());
        }
    }

    /**
     * root page of the context
     * 
     * @return {@link ModelAndView}
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView getIndex() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName(CoreWebConstants.CORE_WEB_VIEW);
        mav.addObject("jsStack", javaScriptStack);
        mav.addObject("cssStack", cssStack);
        mav.addObject("menuList", menuList);
        mav.addObject("loginLogoutSwitch", isLoginLogoutSwitch());
        mav.addObject("languageSwitch", isLanguageSwitch());
        mav.addObject("navbarRight", isNavbarRight());
        mav.addObject("redirect", redirect);
        return mav;
    }

    /**
     * main.js page of the context
     * 
     * @return {@link ModelAndView}
     */
    @RequestMapping(value = "/core/main.js", method = RequestMethod.GET)
    public ModelAndView getMainJS() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("core/main");
        mav.addObject("jsStack", javaScriptStack);
        mav.addObject("cssStack", cssStack);
        mav.addObject("menuList", menuList);
        mav.addObject("loginLogoutSwitch", isLoginLogoutSwitch());
        mav.addObject("languageSwitch", isLanguageSwitch());
        mav.addObject("isNavbarRight", isNavbarRight());
        return mav;
    }

    public boolean isLoginLogoutSwitch() {
        return loginLogoutSwitch;
    }

    public void setLoginLogoutSwitch(boolean loginLogoutSwitch) {
        this.loginLogoutSwitch = loginLogoutSwitch;
    }

    public void setLanguageSwitch(boolean languageSwitch) {
        this.languageSwitch = languageSwitch;
    }

    public void setNavbarRight(boolean navbarRight) {
        this.navbarRight = navbarRight;
    }

    public boolean isLanguageSwitch() {
        return languageSwitch;
    }

    public boolean isNavbarRight() {
        return navbarRight;
    }
}
