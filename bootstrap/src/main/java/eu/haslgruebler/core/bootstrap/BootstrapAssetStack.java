package eu.haslgruebler.core.bootstrap;

import java.util.Arrays;
import java.util.Collections;

import eu.haslgruebler.core.ui.api.AssetStack;
import eu.haslgruebler.core.ui.api.CSSAsset;
import eu.haslgruebler.core.ui.api.JavascriptAsset;

/**
 * CSS and Javascript Assets for Bootstrap with Angular
 * 
 * @author Michael Haslgrübler
 * 
 */
/**
 * @see <a href="http://getbootstrap.com">http://getbootstrap.com</a>
 * @see <a
 *      href="http://angular-ui.github.io/bootstrap/">http://angular-ui.github.io/bootstrap/</a>
 * @author Michael Haslgrübler
 * 
 */
public class BootstrapAssetStack extends AssetStack {
    /**
     * 
     */
    public BootstrapAssetStack() {
        // super(new JavascriptAsset("bootstrap", "3.0.3",
        // "/bootstrap/js/bootstrap.min.js", "jquery"), new
        // CSSAsset("bootstrap", "3.0.3", "/bootstrap/css/bootstrap.min.css",
        // null));
        super(Arrays.asList(new JavascriptAsset("bootstrap", "3.0.3", "/bootstrap/angular/bootstrap.js", new String[] { "bootstrap-accordion", "bootstrap-alert", "bootstrap-bindHtml", "bootstrap-buttons", "bootstrap-carousel", "bootstrap-collapse", "bootstrap-datepicker",
                "bootstrap-dropdownToggle", "bootstrap-modal", "bootstrap-pagination", "bootstrap-popover", "bootstrap-position", "bootstrap-progressbar", "bootstrap-rating", "bootstrap-tabs", "bootstrap-timepicker", "bootstrap-tooltip", "bootstrap-transition", "bootstrap-typeahead" }),
                new JavascriptAsset("bootstrap-accordion", "3.0.3", "/bootstrap/angular/accordion.js", "bootstrap-init"), new JavascriptAsset("bootstrap-alert", "3.0.3", "/bootstrap/angular/alert.js", "bootstrap-init"), new JavascriptAsset("bootstrap-bindHtml", "3.0.3",
                        "/bootstrap/angular/bindHtml.js", "bootstrap-init"), new JavascriptAsset("bootstrap-buttons", "3.0.3", "/bootstrap/angular/buttons.js", "bootstrap-init"), new JavascriptAsset("bootstrap-carousel", "3.0.3", "/bootstrap/angular/carousel.js", "bootstrap-init"),
                new JavascriptAsset("bootstrap-collapse", "3.0.3", "/bootstrap/angular/collapse.js", "bootstrap-init"), new JavascriptAsset("bootstrap-datepicker", "3.0.3", "/bootstrap/angular/datepicker.js", "bootstrap-init"), new JavascriptAsset("bootstrap-dropdownToggle", "3.0.3",
                        "/bootstrap/angular/dropdownToggle.js", "bootstrap-init"), new JavascriptAsset("bootstrap-modal", "3.0.3", "/bootstrap/angular/modal.js", "bootstrap-init"), new JavascriptAsset("bootstrap-pagination", "3.0.3", "/bootstrap/angular/pagination.js", "bootstrap-init"),
                new JavascriptAsset("bootstrap-popover", "3.0.3", "/bootstrap/angular/popover.js", "bootstrap-init"), new JavascriptAsset("bootstrap-position", "3.0.3", "/bootstrap/angular/position.js", "bootstrap-init"), new JavascriptAsset("bootstrap-progressbar", "3.0.3",
                        "/bootstrap/angular/progressbar.js", "bootstrap-init"), new JavascriptAsset("bootstrap-rating", "3.0.3", "/bootstrap/angular/rating.js", "bootstrap-init"), new JavascriptAsset("bootstrap-tabs", "3.0.3", "/bootstrap/angular/tabs.js", "bootstrap-init"), new JavascriptAsset(
                        "bootstrap-timepicker", "3.0.3", "/bootstrap/angular/timepicker.js", "bootstrap-init"), new JavascriptAsset("bootstrap-tooltip", "3.0.3", "/bootstrap/angular/tooltip.js", "bootstrap-init"), new JavascriptAsset("bootstrap-transition", "3.0.3",
                        "/bootstrap/angular/transition.js", "bootstrap-init"), new JavascriptAsset("bootstrap-typeahead", "3.0.3", "/bootstrap/angular/typeahead.js", "bootstrap-init"), new JavascriptAsset("bootstrap-init", "3.0.3", "/bootstrap/angular/init.js", "angular")

        ), Collections.singleton(new CSSAsset("bootstrap", "3.0.3", "/bootstrap/css/bootstrap.min.css", (String) null)));

    }
}
