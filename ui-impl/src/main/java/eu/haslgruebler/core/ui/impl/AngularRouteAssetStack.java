package eu.haslgruebler.core.ui.impl;

import eu.haslgruebler.core.ui.api.AssetStack;
import eu.haslgruebler.core.ui.api.JavascriptAsset;

/**
 * AngularJS Asset Stack
 * 
 * @see <a href="http://www.angularjs.org">http://www.angularjs.org</a>
 * @author Michael Haslgrübler
 * 
 */
public class AngularRouteAssetStack extends AssetStack {
    /**
     * 
     */
    public AngularRouteAssetStack() {
        super(new JavascriptAsset("angular-route", "1.2.7", "/core-resources/angular/angular-route.js", "angular"));
    }
}
