package com.aor.numbers;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ListDeduplicatorTest {

    private ListDeduplicator deduplicator;
    private List<Integer> expected;

    private void setupList() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(2);
        list.add(5);

        expected = new ArrayList<>();
        expected.add(1);
        expected.add(2);
        expected.add(4);
        expected.add(5);

        deduplicator = new ListDeduplicator(list);
    }

    @Test
    public void deduplicate() {

        setupList();
        List<Integer> distinct = deduplicator.deduplicate();

        assertEquals(expected, distinct);
    }

    @Test
    public void deduplicateBug() {

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(2);

        expected = new ArrayList<>();
        expected.add(1);
        expected.add(2);
        expected.add(4);

        deduplicator = new ListDeduplicator(list);
        List<Integer> distinct = deduplicator.deduplicate();

        assertEquals(expected, distinct);
    }
}