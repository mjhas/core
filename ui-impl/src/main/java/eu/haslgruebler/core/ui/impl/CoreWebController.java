package eu.haslgruebler.core.ui.impl;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import eu.haslgruebler.core.ui.api.AssetStack;
import eu.haslgruebler.core.ui.api.CSSAsset;
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

    /**
     * 
     * @param menuList .
     * @param assetStacks .
     */
    public CoreWebController(List<MenuItem> menuList, List<AssetStack> assetStacks) {
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
        return mav;
    }
}
