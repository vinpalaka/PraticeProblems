package math.binary;

import java.util.LinkedList;
import java.util.List;

public class MovingAverage {

    /**
     * Calculates the moving average at most up to the period.
     * So won't calculate average of more than 3 if period was 3.
     * @param ar
     * @param period
     * @return
     */
    public List<Double> movingaverage(double[] ar, int period) {
        double sum = 0;
        List<Double> averages = new LinkedList<>();
        for(int i = 0; i < ar.length;i++) {
            if(i >= period) {
                sum = (getNewAverage(sum, ar[i], ar[i-period]));
            } else {
                sum = getNewAverage(sum, ar[i], 0);
            }
            averages.add(sum/period);

        }
        return averages;
    }

    public double getNewAverage(double sum, double newValue, double oldValue) {
        return  (sum + newValue - oldValue);
    }


}
