package com.aor.numbers;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ListAggregatorTest {

    private ListAggregator aggregator;
    private List<Integer> list;

    private void setupList() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(2);
        list.add(5);

        aggregator = new ListAggregator(list);
    }

    @Test
    public void sum() {

        setupList();
        int sum = aggregator.sum();

        assertEquals(14, sum);
    }

    @Test
    public void max() {
        setupList();
        int max = aggregator.max();

        assertEquals(5, max);
    }

    @Test
    public void max7263() {

        List<Integer> list = new ArrayList<>();
        list.add(-1);
        list.add(-4);
        list.add(-5);

        aggregator = new ListAggregator(list);

        int max = aggregator.max();

        assertEquals(-1, max);
    }

    @Test
    public void min() {
        setupList();
        int min = aggregator.min();

        assertEquals(1, min);
    }

    @Test
    public void distinct() {
        setupList();
        int distinct = aggregator.distinct();

        assertEquals(4, distinct);
    }

    @Test
    public void distinct8726() {

        class stubDeduplicator implements IListDeduplicator {
            @Override
            public List<Integer> deduplicate() {
                List<Integer> unique = new ArrayList<>();
                unique.add(1);
                unique.add(2);
                unique.add(4);

                return unique;
            }
        }

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(2);

        aggregator = new ListAggregator(list);
        int distinct = aggregator.distinct(new stubDeduplicator());

        assertEquals(3, distinct);
    }
}