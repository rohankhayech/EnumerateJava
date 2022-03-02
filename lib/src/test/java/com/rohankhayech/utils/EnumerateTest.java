/**
 * Copyright (C) Rohan Khayech 2022
 */

package com.rohankhayech.utils;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test harness for the {@code Enumerate} class.
 * 
 * @author Rohan Khayech
 */
public class EnumerateTest {

    // Result variables
    List<Integer> indexResults;
    List<String> itemResults;

    @Before
    public void setUp() {
        indexResults = new ArrayList<>();
        itemResults = new ArrayList<>();
    }

    @Test
    public void testListEnumeration() {
        List<String> list = new ArrayList<>();
        list.add("First");
        list.add("Second");

        Enumerate.over(list, (item, i) -> {
            indexResults.add(i);
            itemResults.add(item);
        });

        assertEquals("Index 0 should be returned on first iteration.",0,indexResults.get(0).intValue());
        assertEquals("Item 'First' should be returned on first iteration.", "First", itemResults.get(0));
        assertEquals("Index 1 should be returned on second iteration.", 1, indexResults.get(1).intValue());
        assertEquals("Item 'Second' should be returned on second iteration.", "Second", itemResults.get(1));
    }

    @Test
    public void testArrayEnumeration() {
        String[] array = new String[2];
        array[0] = "First";
        array[1] = "Second";

        Enumerate.over(array, (item, i) -> {
            indexResults.add(i);
            itemResults.add(item);
        });

        assertEquals("Index 0 should be returned on first iteration.",0,indexResults.get(0).intValue());
        assertEquals("Item 'First' should be returned on first iteration.", "First", itemResults.get(0));
        assertEquals("Index 1 should be returned on second iteration.", 1, indexResults.get(1).intValue());
        assertEquals("Item 'Second' should be returned on second iteration.", "Second", itemResults.get(1));
    }
}
