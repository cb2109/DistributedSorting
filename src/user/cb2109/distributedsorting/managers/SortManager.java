package user.cb2109.distributedsorting.managers;

import java.util.stream.Stream;

/**
 * Author: Christopher Bates
 * Date: 16/03/2018
 */
public interface SortManager<T> {
    public void sort(Stream<T> stream);

    public Stream<T> getSortedList();
}
