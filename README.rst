Distributed Statistical Sorting
===============================

The idea of this project is to explore how knowledge of different metadata allows us to sort data more efficiently.
A standard sorting algorithm's efficiency is reduced by having to consider each data point in the sort as anywhere on the
number line on which it is being sorted. However, if we have more knowledge of the data set as a whole before hand we
can sort much faster as we can quickly eliminate many comparisons and distribute the work out into sets.

Uniform Distribution Sorting
----------------------------
The most basic metadata we may have on a data set is the range. If we have no other knowledge the best we can assume
is that the data is approximately evenly spread and hence follows a uniform distribution. Just having a range allows
us to very easily segment the data into bins, like a histogram, and safely distribute the dataset across multiple threads
or machines.

Although sorting these bins would have the same Big-O complexity as sorting the whole data set, we can optimise inside
that bin. Since we know the range inside each bin we can use the same logic again to approximately place each data point
as it comes in. By doing this a final bubble sort allows us to have a very small sort complexity
(n * the maximum order error).

This sorting method is referred to as a bucket sort.

Gaussian Distributed Sorting
----------------------------
In this scenario the data coming in has some sort of Gaussian/normal distribution with a known mean and standard deviation.
Similarly to  the above, the idea is to end up with sets of evenly sized bins with the data in roughly the correct order
for when we do a final pass. To make this work however we need to be able to correctly divide up a given gaussian
distribution into segments based on the amount of data we expect to fall into each bracket. This same calculation
needs to be performed at each sub-bucket as ideally the data needs to be as sorted as possible so our final sort
is as fast as possible

Sorting From Examples
---------------------
The idea in this sort would be that we were given a representative sample of the population of the data and based on
that we could predict where the sizes of each bin AND how we order the data within those bins. The efficiency of this
method is highly dependant on the quality of the sample data. There is a possibility to extend this by using some
basic feedback to adjust the parameters as the data comes in, which could be good in scenarios where we are getting
a continuous stream of data to sort.