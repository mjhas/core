package eu.haslgruebler.core.ui.impl;

import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.util.StringUtils;
import org.springframework.util.StringValueResolver;

import eu.haslgruebler.core.ui.api.CoreWebConfiguration;

public class CoreWebConfigurer implements CoreWebConfiguration, EmbeddedValueResolverAware {
    private StringValueResolver resolver;
    public static final String PLACEHOLDER_PREFIX = "core.web${";

    @Override
    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        this.resolver = resolver;
    }

    @Override
    public boolean getBool(String key) {
        return Boolean.valueOf(getString(key));
    }

    @Override
    public int getInt(String key) {
        return Integer.parseInt(getString(key));
    }

    @Override
    public String getString(String key) {
        if (StringUtils.isEmpty(key)) {
            throw new IllegalArgumentException("propertyKey may not be null or empty");
        }
        String resolved = resolver.resolveStringValue(PLACEHOLDER_PREFIX + key + "}");
        if (resolved.equals(PLACEHOLDER_PREFIX + key + "}")) {
            return null;
        }
        return resolved;
    }

}
