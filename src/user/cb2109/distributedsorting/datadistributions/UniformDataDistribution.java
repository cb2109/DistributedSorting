package user.cb2109.distributedsorting.datadistributions;

/**
 * Author: Christopher Bates
 * Date: 16/03/2018
 */
public class UniformDataDistribution implements DataDistribution {

    private final double min;
    private final double max;

    public UniformDataDistribution(double min, double max) {
        this.min = min;
        this.max = max;
    }



}
