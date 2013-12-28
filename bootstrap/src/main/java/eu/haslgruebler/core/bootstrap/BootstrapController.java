package eu.haslgruebler.core.bootstrap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 
 * @author Michael Haslgrübler
 * 
 */
@Controller
public class BootstrapController {
    /**
     * register create template page
     * 
     * @return the viewName
     */
    @RequestMapping(value = "/bootstrap/angular/init.js", method = RequestMethod.GET)
    public String init() {
        return "WEB-INF/bootstrap/angular/init";
    }
}
