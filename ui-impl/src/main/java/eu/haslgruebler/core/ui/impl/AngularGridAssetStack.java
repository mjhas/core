package eu.haslgruebler.core.ui.impl;

import eu.haslgruebler.core.ui.api.AssetStack;
import eu.haslgruebler.core.ui.api.CSSAsset;
import eu.haslgruebler.core.ui.api.CoreWebConstants;
import eu.haslgruebler.core.ui.api.JavascriptAsset;

/**
 * AngularJS Grid
 * 
 * @see <a
 *      href="http://angular-ui.github.io/ng-grid/">http://angular-ui.github.io/ng-grid/</a>
 * @author Michael Haslgrübler
 * 
 */
public class AngularGridAssetStack extends AssetStack {
    /**
     * 
     */
    public AngularGridAssetStack() {
        super(new JavascriptAsset("ng-grid", "2.0.7", "/core-resources/angular/modules/ng-grid-2.0.7.debug.js", new String[] { "jquery", "angular" }), new CSSAsset("ng-grid", "2.0.7", "/core-resources/angular/modules/ng-grid.min.css", CoreWebConstants.NO_DEPS));
    }
}
