package io.curiositycore.curiousclasses.archetypes.archetype.interfaces;

/**
 * Class that represents the generalisation of a builder within the plugin. Utilises generics to ensure that
 * this interface is applicable to any object within the plugin.
 * @param <C> The generic parameter type that represents what requires constructing within the builder.
 */
public interface Builder<C> {
    void build(C classToBuild);
}
