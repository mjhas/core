package eu.haslgruebler.core.ui.impl;

import eu.haslgruebler.core.ui.api.JavascriptAsset;

/**
 * @see <a href="http://jquery.com">http://jquery.com</a>
 * @author Michael Haslgrübler
 * 
 */
public class JQueryAssetStack extends eu.haslgruebler.core.ui.api.AssetStack {
    /**
     * 
     */
    public JQueryAssetStack() {
        super(new JavascriptAsset("jquery", "2.0.3", "/core-resources/jquery/jquery.min.js", (String) null));
    }

}
