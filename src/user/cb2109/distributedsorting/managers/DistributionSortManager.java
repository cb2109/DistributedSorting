package user.cb2109.distributedsorting.managers;

import user.cb2109.distributedsorting.datadistributions.DataDistribution;

import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * Author: Christopher Bates
 * Date: 16/03/2018
 */
public class DistributionSortManager<T> implements SortManager<T> {

    private final DataDistribution dataDistribution;
    private final int numberOfChildren;

    public DistributionSortManager(DataDistribution d, int numberOfChildren) {
        this.dataDistribution = d;
        this.numberOfChildren = numberOfChildren;
    }


    @Override
    public void sort(Stream<T> stream) {

    }

    @Override
    public Stream<T> getSortedList() {
        return Stream.generate(new Supplier<T>() {
            @Override
            public T get() {
                return null;
            }
        }).limit(10);
    }
}
