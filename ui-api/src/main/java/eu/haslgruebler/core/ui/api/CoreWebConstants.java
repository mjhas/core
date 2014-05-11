package eu.haslgruebler.core.ui.api;

/**
 * 
 * @author Michael Haslgrübler
 * 
 */
public final class CoreWebConstants {
    /**
     * 
     */
    private CoreWebConstants() {
    }

    /**
     * view name for the core web
     */
    public static final String CORE_WEB_VIEW = "core/root";
    /**
     * no dependencies placeholder
     */
    public static final String[] NO_DEPS = new String[0];
    /**
     * config for toggling the right menu bar
     */
    public final static String CONFIG_MENU_NAVBAR_RIGHT = "menu.navbar.right";
    /**
     * config for toggling the language menu
     */
    public final static String CONFIG_MENU_LANGUAGE = "menu.language";
    /**
     * config for toggling the login/logout menu
     */
    public final static String CONFIG_MENU_LOGIN_LOGOUT = "menu.loginLogout";
    /**
     * config for redirect if no page name is given
     */
    public final static String CONFIG_REDIRECT = "redirect";
}
