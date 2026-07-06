package net.tier1234.better_deco.util.tab_util;

/**
 * @author ItsBlackGear
 **/
@FunctionalInterface
public interface FeatureFlag {
    FeatureFlag DEFAULT = () -> true;

    boolean isEnabled();
}
