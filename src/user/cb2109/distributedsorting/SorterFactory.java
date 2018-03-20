package user.cb2109.distributedsorting;

import user.cb2109.distributedsorting.datadistributions.DataDistribution;
import user.cb2109.distributedsorting.managers.DistributionSortManager;
import user.cb2109.distributedsorting.managers.SortManager;

/**
 * Author: Christopher Bates
 * Date: 16/03/2018
 */
public class SorterFactory<T extends SortItem> {

    private DataDistribution<T> distribution = null;
    private int numberOfSorters = 0;

    public SorterFactory<T> withDistribution(DataDistribution<T> d) {
        this.distribution = d;
        return this;
    }

    public SorterFactory<T> withChildren(int numberOfSorters) {
        this.numberOfSorters = numberOfSorters;
        return this;
    }

    public SortManager<T> build() {
        if (distribution == null) {
            throw new IllegalStateException("Distribution not set before call to build");
        }
        if (numberOfSorters <= 0) {
            throw new IllegalStateException("Number of sorters not set before call to build");
        }

        SortManager<T> sm = new DistributionSortManager<>(distribution, numberOfSorters);

        // reset the distribution and numberOfSorters for the next use
        distribution = null;
        numberOfSorters = 0;
        return sm;
    }


}
