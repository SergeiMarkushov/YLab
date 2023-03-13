package ru.YLab.hwTwo.rateLimitedPrinter;

public class RateLimitedPrinter {
    private long lastPrintTime = 0;
    private final long interval;

    public RateLimitedPrinter(long interval) {
        this.interval = interval;
    }

    public void print(String message) {
        long currentTime = System.currentTimeMillis();
        if (currentTime - lastPrintTime >= interval) {
            System.out.println(message);
            lastPrintTime = currentTime;
        }
    }
}
