package user.cb2109.distributedsortingtests;

import org.junit.Assert;
import org.junit.Test;
import user.cb2109.distributedsorting.SorterFactory;
import user.cb2109.distributedsorting.datadistributions.DataDistribution;
import user.cb2109.distributedsorting.managers.SortManager;

/**
 * Author: Christopher Bates
 * Date: 16/03/2018
 */
public class SorterFactoryTests {

    @Test
    public void testCreation() {
        SorterFactory<Integer> factory = new SorterFactory<>();

        factory.withDistribution(new TestDataDistribution()).withChildren(1);
        SortManager<Integer> sm = factory.build();
        Assert.assertNotNull(sm);
    }

    @Test(expected = IllegalStateException.class)
    public void testNotSetDistribution() {
        SorterFactory<Integer> factory = new SorterFactory<>();

        factory.withChildren(1);
        SortManager<Integer> sm = factory.build();
    }

    @Test(expected = IllegalStateException.class)
    public void testZeroSorters() {
        SorterFactory<Integer> factory = new SorterFactory<>();

        factory.withDistribution(new TestDataDistribution()).withChildren(0);
        SortManager<Integer> sm = factory.build();
    }

    @Test(expected = IllegalStateException.class)
    public void testNegativeSorters() {
        SorterFactory<Integer> factory = new SorterFactory<>();

        factory.withDistribution(new TestDataDistribution()).withChildren(-1);
        SortManager<Integer> sm = factory.build();
    }


    private class TestDataDistribution implements DataDistribution {

    }
}
