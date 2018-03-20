package user.cb2109.distributedsorting.managers;

import user.cb2109.distributedsorting.SortItem;
import user.cb2109.distributedsorting.datadistributions.DataDistribution;
import user.cb2109.distributedsorting.datadistributions.DataSegment;
import user.cb2109.distributedsorting.sorters.ChildSorter;
import user.cb2109.distributedsorting.sorters.RangeSorter;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Author: Christopher Bates
 * Date: 16/03/2018
 */
public class DistributionSortManager<T extends SortItem> implements SortManager<T> {

    private final Collection<DataSegment<T>> segments;
    private final Map<DataSegment<T>, ChildSorter<T>> distributedSorters;

    public DistributionSortManager(DataDistribution<T> d, int numberOfChildren) {
        this.segments = d.segmentDistribution(numberOfChildren);
        this.distributedSorters = new HashMap<>(numberOfChildren);
        for (DataSegment<T> segment : segments) {
            distributedSorters.put(segment, new RangeSorter<>(segment));
        }
    }


    @Override
    public void sort(Stream<T> stream) {
        stream.forEach(this::processItem);
    }

    private void processItem(T item) {
        for (DataSegment<T> segment : this.segments) {
            if (segment.isInRange(item.getComparisonValue())) {
                distributedSorters.get(segment).send(item);
                break;
            }
        }
    }

    @Override
    public Stream<T> getSortedList() {
        Stream<T> str = Stream.<T>builder().build();
        for (DataSegment<T> segment : segments) {
            ChildSorter<T> sorter = distributedSorters.get(segment);
            str = Stream.concat(str, sorter.getSortedItems().parallelStream());
        }
        return str;
    }
}
