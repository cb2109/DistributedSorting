package user.cb2109.distributedsorting.datadistributions;

import user.cb2109.distributedsorting.SortItem;

/**
 * Author: Christopher Bates
 * Date: 16/03/2018
 */
public interface DataSegment<T extends SortItem> {
    boolean isInRange(double value);

    int getExpectedPopulationSize();

    int getPosition(int comparisonValue);
}
