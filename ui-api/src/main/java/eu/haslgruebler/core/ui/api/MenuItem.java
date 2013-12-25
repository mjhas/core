package eu.haslgruebler.core.ui.api;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Represent a menu item
 * 
 * @author Michael Haslgrübler
 * 
 */
public class MenuItem implements Comparable<MenuItem> {
    private int order;
    private String key;
    private String url;
    private List<MenuItem> subMenu;

    /**
     * 
     * @param key the i18n messageKey
     * @param url the page url
     */
    public MenuItem(String key, String url) {
        super();
        this.setKey(key);
        this.url = url;
        this.subMenu = new LinkedList<MenuItem>();
    }

    /**
     * 
     * @param key the i18n messageKey
     * @param url the page url
     * @param subMenu a list of sub menu items
     */
    public MenuItem(String key, String url, List<MenuItem> subMenu) {
        this(key, url);
        setSubMenu(subMenu);
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<MenuItem> getSubMenu() {
        return Collections.unmodifiableList(subMenu);
    }

    /**
     * 
     * @param subMenuItem to add
     */
    public void addSubMenuItem(MenuItem subMenuItem) {
        this.subMenu.add(subMenuItem);
    }

    /**
     * 
     * @param subMenu .
     */
    public void setSubMenu(List<MenuItem> subMenu) {
        this.subMenu.clear();
        if (subMenu != null) {
            this.subMenu.addAll(subMenu);
        }
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public int compareTo(MenuItem other) {
        if (getOrder() > other.getOrder()) {
            return -1;
        }
        if (getOrder() == other.getOrder()) {
            return 0;
        }
        return 1;
    }
}
