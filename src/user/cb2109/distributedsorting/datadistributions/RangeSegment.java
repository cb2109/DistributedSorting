package user.cb2109.distributedsorting.datadistributions;

import user.cb2109.distributedsorting.SortItem;

/**
 * Author: Christopher Bates
 * Date: 16/03/2018
 */
class RangeSegment<T extends SortItem> implements DataSegment<T> {
    private final int min;
    private final int max;
    private final int expectedPopulationSize;

    RangeSegment(int min, int max, int expectedPopulationSize) {
        this.min = min;
        this.max = max;
        this.expectedPopulationSize = expectedPopulationSize;
    }


    @Override
    public boolean isInRange(double value) {
        return min <= value && value < max;
    }


    @Override
    public int getExpectedPopulationSize() {
        return this.expectedPopulationSize;
    }

    @Override
    public int getPosition(int comparisonValue) {
        return comparisonValue - min;
    }
}
