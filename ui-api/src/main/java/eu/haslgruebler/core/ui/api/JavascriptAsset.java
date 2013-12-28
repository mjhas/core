package eu.haslgruebler.core.ui.api;

import java.util.Arrays;

/**
 * 
 * @author Michael Haslgrübler
 * 
 */
public final class JavascriptAsset extends AbstractAsset {
    /**
     * @see AbstractAsset#AbstractAsset(String, String)
     * @param provide .
     * @param url .
     */
    public JavascriptAsset(String provide, String url) {
        super(provide, url);
    }

    /**
     * @see AbstractAsset#AbstractAsset(String, String, String)
     * @param provide .
     * @param url .
     * @param dependency .
     */
    public JavascriptAsset(String provide, String url, String dependency) {
        super(provide, url, dependency);
    }

    /**
     * @see AbstractAsset#AbstractAsset(String, String, String, String[])
     * @param provide .
     * @param version .
     * @param url .
     * @param dependencies .
     */
    public JavascriptAsset(String provide, String version, String url, String... dependencies) {
        super(provide, version, url, dependencies);
    }

    @Override
    public String toString() {
        return "JavascriptAsset [provides()=" + Arrays.toString(provides().toArray()) + "]";
    }

}
