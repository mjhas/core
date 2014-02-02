package eu.haslgruebler.core.ui.impl;

import eu.haslgruebler.core.ui.api.AssetStack;
import eu.haslgruebler.core.ui.api.JavascriptAsset;

/**
 * 
 * @author Michael Haslgrübler
 * 
 */
public class CoreAssetStack extends AssetStack {
    /**
     * 
     */
    public CoreAssetStack() {
        super();
        JavascriptAsset coreMenu = new JavascriptAsset("core-menu", "0.3", "/core-resources/core/menu.js", "angular", "angular-route", "bootstrap-dropdownToggle");
        coreMenu.setAngularModuleName("core.menu");
        addJavaScriptAssets(coreMenu);
    }

}
