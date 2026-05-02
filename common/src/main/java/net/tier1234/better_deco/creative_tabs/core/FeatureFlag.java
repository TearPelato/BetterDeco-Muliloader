package net.tier1234.better_deco.creative_tabs.core;

/**
 * @author ItsBlackGear: This class will be moved on DecoLIB*/
@Deprecated(since = "1.21.1", forRemoval = true)
@FunctionalInterface
public interface FeatureFlag {
    FeatureFlag DEFAULT = () -> true;

    boolean isEnabled();
}
