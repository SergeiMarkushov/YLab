package ru.YLab.hwTwo.statsAccumulator;

public class StatsAccumulatorImpl implements StatsAccumulator {
    private int min = Integer.MAX_VALUE;
    private int max = Integer.MIN_VALUE;
    private int count;
    private int sum;


    @Override
    public void add(int value) {
        count++;
        sum += value;
        min = Integer.min(min, value);
        max = Integer.max(max, value);
    }

    @Override
    public int getMin() {
        return min;
    }

    @Override
    public int getMax() {
        return max;
    }

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public Double getAvg() {
        return (double) sum / (double) count;
    }
}
