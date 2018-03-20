package user.cb2109.distributedsorting.sorters;

import user.cb2109.distributedsorting.SortItem;

import java.util.Collection;

/**
 * Author: Christopher Bates
 * Date: 16/03/2018
 */
public interface ChildSorter<T extends SortItem> {
    void send(T item);
    Collection<T> getSortedItems();
}
