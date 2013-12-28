package eu.haslgruebler.core.ui.api;

import java.util.Set;

/**
 * 
 * @author Michael Haslgrübler
 * 
 */
public interface Asset extends Comparable<Asset> {
    /**
     * @return a {@link Set} of {@link Provide}'s
     */
    Set<Provide> getProvides();

    /**
     * @return a {@link Set} of {@link Dependency}'s
     */
    Set<Dependency> getDependencies();

    /**
     * @see Asset#getProvides()
     * @return a {@link Set} of Provides as {@link String}s
     */
    Set<String> provides();

    /**
     * @see Asset#getDependencies()
     * @return a {@link Set} of Dependencies as {@link String}s
     */
    Set<String> dependencies();

    /**
     * 
     * @return the context URL of the asset
     */
    String getUrl();

}
