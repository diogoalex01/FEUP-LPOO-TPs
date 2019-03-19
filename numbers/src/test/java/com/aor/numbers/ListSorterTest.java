package com.aor.numbers;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ListSorterTest {
    private List<Integer> list;

    private List<Integer> expected;
    private ListSorter sorter;
    private List<Integer> sorted;

    private void helper() {
        List<Integer> list = new ArrayList();
        list.add(3);
        list.add(2);
        list.add(6);
        list.add(1);
        list.add(4);
        list.add(5);
        list.add(7);

        expected = new ArrayList();
        expected.add(1);
        expected.add(2);
        expected.add(3);
        expected.add(4);
        expected.add(5);
        expected.add(6);
        expected.add(7);

        sorter = new ListSorter(list);
        sorted = sorter.sort();
    }

    @Test
    public void sort() {

        helper();
        assertEquals(expected, sorted);
    }
}