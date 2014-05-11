package eu.haslgruebler.core.ui.api;

/**
 * Interface to access configuration properties
 * 
 * @author Michael Haslgrübler
 * 
 */
public interface CoreWebConfiguration {

    boolean getBool(String key);

    int getInt(String key);

    String getString(String key);
}
