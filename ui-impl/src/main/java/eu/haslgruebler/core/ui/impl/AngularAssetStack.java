package eu.haslgruebler.core.ui.impl;

import eu.haslgruebler.core.ui.api.AssetStack;
import eu.haslgruebler.core.ui.api.CoreWebConstants;
import eu.haslgruebler.core.ui.api.JavascriptAsset;

/**
 * AngularJS Asset Stack
 * 
 *  @see <a
 *      href="http://www.angularjs.org">http://www.angularjs.org</a>
 * @author Michael Haslgrübler
 * 
 */
public class AngularAssetStack extends AssetStack {
    /**
     * 
     */
    public AngularAssetStack() {
        super(new JavascriptAsset("angular", "1.2.6", "/core-resources/angular/angular.min.js", CoreWebConstants.NO_DEPS));
    }

}
