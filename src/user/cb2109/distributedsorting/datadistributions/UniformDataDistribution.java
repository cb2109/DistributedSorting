package user.cb2109.distributedsorting.datadistributions;

import user.cb2109.distributedsorting.SortItem;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Author: Christopher Bates
 * Date: 16/03/2018
 *
 * Represents a set of data that has a uniform distribution.
 *
 * It is impossible to segment this type of distribution unless we have a range, as the bounds are limitless.
 */
public class UniformDataDistribution<T extends SortItem> implements DataDistribution<T> {

    private final int min;
    private final int max;
    private int expectedPopulationSize;

    public UniformDataDistribution(int min, int max) {
        this(min, max, 0);
    }

    public UniformDataDistribution(int min, int max, int expectedPopulationSize) {
        this.min = min;
        this.max = max;
        this.expectedPopulationSize = expectedPopulationSize;
    }

    @Override
    public Collection<DataSegment<T>> segmentDistribution(int numberOfSegments) {
        Collection<DataSegment<T>> segments = new ArrayList<>();

        // segment size is calculated by dividing the range of the uniform over the number of segments
        int range = max - min;
        int segmentSize = Math.floorDiv(range, numberOfSegments);
        int missingValues = range % segmentSize;

        // the number of expected data points in each segment
        int expectedDataInRange = Math.floorDiv(expectedPopulationSize, numberOfSegments);

        for (int startOfRange = min; startOfRange <= max; startOfRange += segmentSize) {
            int endOfRange = startOfRange + segmentSize;
            if (missingValues > 0) {
                endOfRange++;
                missingValues--;
            }
            segments.add(new RangeSegment<>(startOfRange, endOfRange, expectedDataInRange));
        }

        return segments;
    }




}
