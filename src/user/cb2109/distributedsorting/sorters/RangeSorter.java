package user.cb2109.distributedsorting.sorters;

import user.cb2109.distributedsorting.SortItem;
import user.cb2109.distributedsorting.datadistributions.DataSegment;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;

/**
 * Author: Christopher Bates
 * Date: 16/03/2018
 */
public class RangeSorter<T extends SortItem> implements ChildSorter<T> {

    private final ArrayList<T> sortedPoints;
    private DataSegment<T> segment;



    public RangeSorter(DataSegment<T> segment) {
        this.segment = segment;
        this.sortedPoints = new ArrayList<>(segment.getExpectedPopulationSize());
    }

    @Override
    public void send(T item) {
        //int expectedPosition = segment.getPosition(item.getComparisonValue());
        sortedPoints.add(item);
    }

    @Override
    public Collection<T> getSortedItems() {
        //noinspection unchecked
        sortedPoints.sort(Comparator.naturalOrder());
        return sortedPoints;
    }
}
