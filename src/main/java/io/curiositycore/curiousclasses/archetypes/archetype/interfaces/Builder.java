package io.curiositycore.curiousclasses.archetypes.archetype.interfaces;

import java.lang.reflect.InvocationTargetException;

/**
 * Class that represents the generalisation of a builder within the plugin. Utilises generics to ensure that
 * this interface is applicable to any object within the plugin.
 * @param <C> The generic parameter type that represents what requires constructing within the builder.
 */
public interface Builder<T> {
    /**
     * Build the builder's object.
     *
     * @param classToBuild Object to build.
     * @return
     */
    void build(T typeToBuild) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException;
}
