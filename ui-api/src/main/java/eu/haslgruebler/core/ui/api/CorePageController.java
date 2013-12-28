package eu.haslgruebler.core.ui.api;

import java.util.SortedSet;
import java.util.TreeSet;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @author Michael Haslgrübler
 * 
 */
public abstract class CorePageController {
    private SortedSet<JavascriptAsset> pageJavaScriptStack;

    private SortedSet<CSSAsset> pageCssStack;

    private String pageName;

    /**
     * Default Constructor
     */
    private CorePageController() {
        pageJavaScriptStack = new TreeSet<JavascriptAsset>();
        pageCssStack = new TreeSet<CSSAsset>();
    }

    /**
     * Constructor using the page name (template url without the jsp name)
     * 
     * @param pageName .
     */
    public CorePageController(String pageName) {
        this();
        this.pageName = pageName;
    }

    /**
     * @param pageName .
     * @param pageJavaScriptStack a {@link SortedSet} of Javascript files for
     *            this page
     * @param pageCssStack a {@link SortedSet} of CSS files for this page
     */
    public CorePageController(String pageName, SortedSet<JavascriptAsset> pageJavaScriptStack, SortedSet<CSSAsset> pageCssStack) {
        this();
        this.pageName = pageName;
        if (pageJavaScriptStack != null) {
            this.pageJavaScriptStack.addAll(pageJavaScriptStack);
        }
        if (pageCssStack != null) {
            this.pageCssStack.addAll(pageCssStack);
        }
    }

    /**
     * @param pageName .
     * @param pageJavaScript {@link JavascriptAsset} for this page
     * @param pageCss {@link CSSAsset} for this page
     */
    public CorePageController(String pageName, JavascriptAsset pageJavaScript, CSSAsset pageCss) {
        this();
        this.pageName = pageName;
        if (pageJavaScript != null) {
            this.pageJavaScriptStack.add(pageJavaScript);
        }
        if (pageCss != null) {
            this.pageCssStack.add(pageCss);
        }
    }

    /**
     * register the root page
     * 
     * @return {@link ModelAndView}
     */
    @RequestMapping(value = "/")
    public ModelAndView get() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("forward:/");
        mav.addObject("pageJsStack", pageJavaScriptStack);
        mav.addObject("pageCssStack", pageCssStack);
        mav.addObject("page", pageName);
        return mav;
    }

}
