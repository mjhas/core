package eu.haslgruebler.core.ui.api;

/**
 * Assets provide a functionality. This functionality has a name and is
 * represented via this class.
 * 
 * @author Michael Haslgrübler
 * 
 */
public class Provide {
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
    private Provide() {
        super();
    }

    /**
     * 
     * @param name .
     */
    public Provide(String name) {
        this();
        this.name = name;
    }

    /**
     * 
     * @param name .
     * @param version .
     */
    public Provide(String name, String version) {
        this();
        this.name = name + '-' + version;
    }
}
