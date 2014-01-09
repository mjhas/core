package eu.haslgruebler.core.ui.api;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

/**
 * 
 * @author Michael Haslgrübler
 * 
 */
public class AssetStack {

    private Collection<JavascriptAsset> javaScriptAssets;
    private Collection<CSSAsset> cssAssets;

    /**
     * 
     */
    protected AssetStack() {
        javaScriptAssets = new LinkedList<JavascriptAsset>();
        cssAssets = new LinkedList<CSSAsset>();
    }

    /**
     * 
     * @param javaScriptAssets .
     * @param cssAssets .
     */
    public AssetStack(Collection<JavascriptAsset> javaScriptAssets, Collection<CSSAsset> cssAssets) {
        this();
        setJavaScriptAssets(javaScriptAssets);
        setCssAssets(cssAssets);
    }

    /**
     * @param javaScriptAssets .
     * @param cssAssets .
     */
    public AssetStack(JavascriptAsset javaScriptAssets, CSSAsset cssAssets) {
        this();
        setJavaScriptAssets(Collections.singleton(javaScriptAssets));
        setCssAssets(Collections.singleton(cssAssets));
    }

    /**
     * 
     * @param cssAssets .
     */
    public AssetStack(CSSAsset cssAssets) {
        this();
        setCssAssets(Collections.singleton(cssAssets));
    }

    /**
     * @param javaScriptAssets .
     */
    public AssetStack(JavascriptAsset javaScriptAssets) {
        this();
        setJavaScriptAssets(Collections.singleton(javaScriptAssets));
    }

    public Collection<JavascriptAsset> getJavaScriptAssets() {
        return Collections.unmodifiableCollection(javaScriptAssets);
    }

    /**
     * @param javaScriptAssets .
     */
    public void setJavaScriptAssets(Collection<JavascriptAsset> javaScriptAssets) {
        this.javaScriptAssets.clear();
        if (javaScriptAssets != null) {
            this.javaScriptAssets.addAll(javaScriptAssets);
        }
    }
    
    /**
     * @param javaScriptAsset .
     */
    public void addJavaScriptAssets(JavascriptAsset javaScriptAsset) {
        if (javaScriptAssets != null) {
            this.javaScriptAssets.add(javaScriptAsset);
        }
    }

    public Collection<CSSAsset> getCssAssets() {
        return Collections.unmodifiableCollection(cssAssets);
    }

    /**
     * @param cssAssets .
     */
    public void setCssAssets(Collection<CSSAsset> cssAssets) {
        this.cssAssets.clear();
        if (cssAssets != null) {
            this.cssAssets.addAll(cssAssets);
        }
    }

}
