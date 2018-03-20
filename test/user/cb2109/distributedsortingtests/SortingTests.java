package user.cb2109.distributedsortingtests;

import org.junit.Assert;
import org.junit.Test;
import user.cb2109.distributedsorting.SortItem;
import user.cb2109.distributedsorting.SorterFactory;
import user.cb2109.distributedsorting.datadistributions.DataDistribution;
import user.cb2109.distributedsorting.datadistributions.UniformDataDistribution;
import user.cb2109.distributedsorting.managers.SortManager;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Author: Christopher Bates
 * Date: 16/03/2018
 */
public class SortingTests {

    @Test
    public void sortIntegersWithOneChild() {
        sortIntegers(1);
    }

    @Test
    public void sortIntegersWithThreeChildren() {
        sortIntegers(3);
    }

    private void sortIntegers(int numberOfChildren) {
        int[] numbersToSort = new int[] {
                1, 6, 4, 8, 2, 4, 5, 9
        };
        int[] answer = Arrays.copyOfRange(numbersToSort, 0, numbersToSort.length);
        Arrays.sort(answer);

        DataDistribution<IntegerSortItem> d = new UniformDataDistribution<>(1, 9, numbersToSort.length);
        SorterFactory<IntegerSortItem> factory = new SorterFactory<>();
        SortManager<IntegerSortItem> sortManager = factory.withDistribution(d).withChildren(numberOfChildren).build();

        sortManager.sort(Arrays.stream(numbersToSort).mapToObj(IntegerSortItem::new));

        Stream<IntegerSortItem> sorted = sortManager.getSortedList();

        IntegerSortItem[] output = sorted.toArray(IntegerSortItem[]::new);

        for (int i = 0; i < answer.length; i++) {
            Assert.assertNotNull("Null value at position " + i, output[i]);
            Assert.assertEquals("Incorrect value at position " + i, answer[i], output[i].getItem().intValue());
        }
    }

    private class IntegerSortItem extends SortItem<Integer> {
        IntegerSortItem(int i) {
            super(i);
        }


        @Override
        protected int initializeComparisonValue() {
            return getItem();
        }
    }
}
