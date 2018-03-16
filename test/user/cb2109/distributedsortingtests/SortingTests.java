package user.cb2109.distributedsortingtests;

import org.junit.Assert;
import org.junit.Test;
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
    public void sortIntegers() {
        Integer[] numbersToSort = new Integer[] {
                1, 6, 4, 8, 2, 4, 5, 9
        };
        Integer[] answer = Arrays.copyOfRange(numbersToSort, 0, numbersToSort.length);
        Arrays.sort(answer);

        DataDistribution d = new UniformDataDistribution(1, 9);
        SorterFactory<Integer> factory = new SorterFactory<>();
        SortManager<Integer> sortManager = factory.withDistribution(d).withChildren(1).build();

        sortManager.sort(Arrays.stream(numbersToSort));

        Stream<Integer> sorted = sortManager.getSortedList();

        Integer[] output = sorted.toArray(Integer[]::new);

        for (int i = 0; i < answer.length; i++) {
            Assert.assertEquals("Incorrect value at position " + i, answer[i], output[i]);
        }
    }


    private int[] generateUnsortedGaussianDistribution(int size, int mean, long standardDeviation) {
        int[] arr = new int[size];


        for (int i = 0; i < size; i++) {

        }

        return arr;
    }
}
