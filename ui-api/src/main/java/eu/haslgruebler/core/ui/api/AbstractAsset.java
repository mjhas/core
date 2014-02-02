package eu.haslgruebler.core.ui.api;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * 
 * @author Michael Haslgrübler
 * 
 */
public abstract class AbstractAsset<E> implements Asset<E> {
    private Map<String, Provide> provides;
    private Map<String, Dependency> dependencies;
    private String url;

    /**
     */
    private AbstractAsset() {
        provides = new LinkedHashMap<String, Provide>();
        dependencies = new LinkedHashMap<String, Dependency>();
    }

    /**
     * 
     * @param provide .
     * @param url .
     */
    public AbstractAsset(String provide, String url) {
        this();
        addProvide(new Provide(provide));
        this.setUrl(url);
    }

    /**
     * 
     * @param provide .
     * @param url .
     * @param dependency .
     */
    public AbstractAsset(String provide, String url, String dependency) {
        this();
        addProvide(new Provide(provide));
        addDependency(new Dependency(dependency));
        this.setUrl(url);
    }

    /**
     * 
     * @param provide .
     * @param version .
     * @param url .
     * @param dependencies null, a single dependency or a list of dependencies
     */
    public AbstractAsset(String provide, String version, String url, String[] dependencies) {
        this();
        addProvide(new Provide(provide));
        addProvide(new Provide(provide, version));
        if (dependencies != null) {
            for (String dependency : dependencies) {
                addDependency(new Dependency(dependency));
            }
        }
        this.setUrl(url);
    }
    
    @Override
    public Collection<Provide> getProvides() {
        return Collections.unmodifiableCollection(provides.values());
    }

    /**
     * 
     * @param provides .
     */
    public void setProvides(Map<String, Provide> provides) {
        this.provides.clear();
        if (provides != null) {
            this.provides.putAll(provides);
        }
    }

    /**
     * 
     * @param provide .
     */
    public void addProvide(Provide provide) {
        this.provides.put(provide.getName(), provide);
    }

    @Override
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override 
    public Collection<Dependency> getDependencies() {
        return Collections.unmodifiableCollection(dependencies.values());
    }

    /**
     * 
     * @param dependencies .
     */
    public void setDependencies(Map<String, Dependency> dependencies) {
        this.dependencies.clear();
        if (dependencies != null) {
            this.dependencies.putAll(dependencies);
        }
    }

    /**
     * 
     * @param dependency .
     */
    @SuppressWarnings("unchecked")
    public E addDependency(Dependency dependency) {
        this.dependencies.put(dependency.getName(), dependency);
        return (E) this;
    }
    /**
     * 
     * @param dependency .
     */
    public E addDependency(String name) {
        return this.addDependency(new Dependency(name));
    }


    @Override
    public Set<String> dependencies() {
        return dependencies.keySet();
    }

    @Override
    public Set<String> provides() {
        return provides.keySet();
    }

    @Override
    public int compareTo(Asset<E> o) {
        if (this.equals(o)) {
            return 0;
        }
        if (this.dependencies().size() == 0) {
            return -1;
        } else {
            for (String dep : o.dependencies()) {
                if (this.provides().contains(dep)) {
                    return -1;
                }
            }
        }
        return 1;
    }
    
    
    public String getRequireUrl(){
        return getUrl().substring(1, getUrl().length()-3);
    }
    
    @Override
    public String getProvide() {
        return getProvides().iterator().next().getName();
    }
}
