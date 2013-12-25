package eu.haslgruebler.core.ui.impl;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import eu.haslgruebler.core.ui.api.CoreWebConstants;
import eu.haslgruebler.core.ui.api.MenuItem;

/**
 * 
 * @author Michael Haslgrübler
 * 
 */
@Controller
public class CoreWebController {

    private List<MenuItem> menuList;

    /**
     * 
     * @param menuList .
     */
    public CoreWebController(List<MenuItem> menuList) {
        this.menuList = new LinkedList<MenuItem>(menuList);
        Collections.sort(this.menuList);
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
        mav.addObject("menuList", menuList);
        return mav;
    }
}
