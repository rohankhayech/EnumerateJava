/**
 * Copyright (C) Rohan Khayech 2022
 */

package com.rohankhayech.utils;

/**
 * The Enumerate class provides a generic method to iterate over an iterable
 * collection, providing access to each element and
 * it's index within the collection.
 * 
 * It allows enumeration over a collection similar to the {@code enumerate()}
 * function in Python.
 * 
 * The following pseudo control structure is introduced to enumerate over a
 * collection with minimal complexity when compared to
 * a regular for-each loop:
 * 
 * {@code Enumerate.over(list, (item, i) -> { ... }); }
 * 
 * The above example uses a lambda expession to define the task to be run each iteration.
 * This also allows for the {@code item} and {@code i} parameters to be renamed as required.
 * 
 * @author Rohan Khayech
 * 
 * @implNote The static function provided simply iterates over the collection
 *           using a for-each loop, keeping track of the
 *           iteration index with an integer variable. This, combined with the
 *           Iteration object passed is the only overhead when
 *           compared to a regular for-each loop.
 */
public class Enumerate {

    /**
     * Iterates over the specified collection and performs the specified task for each element.
     * Provides access to the element and it's index within the collection.
     * 
     * @param <T> The type of element contained in the collection.
     * @param iterable The collection to iterate over.
     * @param task The task to be performed every iteration (for each element in the collection). 
     *                  This argument accepts a lamda expression with two parameters passed:
     *                  {@code item} - the current element in the iteration, and
     *                  {@code i} - the index of the current element in the iteration.
     *                  These parameters may be renamed as required.
     */
    public static <T> void over(Iterable<T> iterable, Iteration<T> task) {
        int i = 0;
        for (T item : iterable) {
                task.iteration(item, i);
                i++;
        }
    }

    /**
     * Iterates over the specified array and performs the specified task for
     * each element.
     * Provides access to the element and it's index within the array.
     * 
     * @param <T>      The type of element contained in the array.
     * @param iterable The array to iterate over.
     * @param task     The task to be performed every iteration (for each element in
     *                 the array).
     *                 This argument accepts a lamda function with two parameters
     *                 passed:
     *                 {@code item} - the current element in the iteration, and
     *                 {@code i} - the index of the current element in the
     *                 iteration.
     */
    public static <T> void over(T[] array, Iteration<T> task) {
        int i = 0;
        for (T item : array) {
            task.iteration(item, i);
            i++;
        }
    }

    /**
     * The Iteration interface defines a task to be performed for each iteration in an enumeration.
     * The may be used as an anonymous class or lamda expression to simplify enumeration of the elements in a collection.
     */
    public interface Iteration<T> {
        /**
         * The task to be performed for each iteration/item in the list.
         * @param item The current element in the iteration.
         * @param i The index of the current element in the iteration.
         */
        public void iteration(T item, int i);
    }
}