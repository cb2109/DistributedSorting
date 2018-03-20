package user.cb2109.distributedsortingtests;

import org.junit.Assert;
import org.junit.Test;
import user.cb2109.distributedsorting.SortItem;
import user.cb2109.distributedsorting.SorterFactory;
import user.cb2109.distributedsorting.datadistributions.DataDistribution;
import user.cb2109.distributedsorting.datadistributions.DataSegment;
import user.cb2109.distributedsorting.managers.SortManager;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Author: Christopher Bates
 * Date: 16/03/2018
 */
public class SorterFactoryTests {

    @Test
    public void testCreation() {
        SorterFactory<TestEnumerable> factory = new SorterFactory<>();

        factory.withDistribution(new TestDataDistribution<>()).withChildren(1);
        SortManager<TestEnumerable> sm = factory.build();
        Assert.assertNotNull(sm);
    }

    @Test(expected = IllegalStateException.class)
    public void testNotSetDistribution() {
        SorterFactory<TestEnumerable> factory = new SorterFactory<>();

        factory.withChildren(1);
        SortManager<TestEnumerable> sm = factory.build();
    }

    @Test(expected = IllegalStateException.class)
    public void testZeroSorters() {
        SorterFactory<TestEnumerable> factory = new SorterFactory<>();

        factory.withDistribution(new TestDataDistribution<>()).withChildren(0);
        SortManager<TestEnumerable> sm = factory.build();
    }

    @Test(expected = IllegalStateException.class)
    public void testNegativeSorters() {
        SorterFactory<TestEnumerable> factory = new SorterFactory<>();

        factory.withDistribution(new TestDataDistribution<>()).withChildren(-1);
        SortManager<TestEnumerable> sm = factory.build();
    }

    private class TestEnumerable extends SortItem<Integer> {

        public TestEnumerable(Integer item) {
            super(item);
        }

        @Override
        protected int initializeComparisonValue() {
            return 0;
        }
    }
    private class TestDataDistribution<T extends SortItem> implements DataDistribution<T> {

        @Override
        public Collection<DataSegment<T>> segmentDistribution(int numberOfSegments) {
            return new ArrayList<>();
        }
    }
}
