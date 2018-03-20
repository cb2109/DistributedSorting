package user.cb2109.distributedsorting.managers;

import user.cb2109.distributedsorting.SortItem;

import java.util.stream.Stream;

/**
 * Author: Christopher Bates
 * Date: 16/03/2018
 */
public interface SortManager<T extends SortItem> {

    void sort(Stream<T> stream);

    Stream<T> getSortedList();
}
