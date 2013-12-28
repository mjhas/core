package eu.haslgruebler.core.ui.api;

/**
 * Assets dependent on other Asset's functionality. This functionality dependencies has a name and is
 * represented via this class.
 * 
 * @author Michael Haslgrübler
 * 
 */
public class Dependency {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     */
    private Dependency() {
        super();
    }

    /**
     * 
     * @param name .
     */
    public Dependency(String name) {
        this();
        this.name = name;
    }

    /**
     * 
     * @param name .
     * @param version .
     */
    public Dependency(String name, String version) {
        this();
        this.name = name + '-' + version;
    }
}
