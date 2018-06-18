package math.binary;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MovingAverageTest {

    @Test
    public void movingaverage() {
        MovingAverage average = new MovingAverage();
        double[] input_data = { 1, 3, 5, 6, 8,
                12, 18, 21, 22, 25 };
        average.movingaverage(input_data, 3).forEach(System.out::println);
        double d = (double)1/3;
        System.out.println(d);
    }
}