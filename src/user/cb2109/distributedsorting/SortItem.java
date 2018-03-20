package user.cb2109.distributedsorting;

/**
 * Author: Christopher Bates
 * Date: 16/03/2018
 */
public abstract class SortItem<T> implements Comparable<SortItem<T>> {

    private final int comparisonValue;
    private T item;

    public SortItem(T item) {
        this.item = item;
        this.comparisonValue = this.initializeComparisonValue();
    }

    protected abstract int initializeComparisonValue();

    public T getItem() {
        return item;
    }

    public int getComparisonValue() {
        return comparisonValue;
    }

    @Override
    public int compareTo(SortItem<T> o) {
        return Integer.compare(this.comparisonValue, o.comparisonValue);
    }
}
