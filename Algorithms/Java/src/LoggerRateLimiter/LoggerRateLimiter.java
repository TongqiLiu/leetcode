package src.LoggerRateLimiter;

import java.util.HashMap;

/**
 * @author mingqiao
 * @Date 2020/2/15
 */
public class LoggerRateLimiter {

    private HashMap<String, Integer> map;
    private int time;

    /**
     * Initialize your data structure here.
     */
    public LoggerRateLimiter() {
        map = new HashMap<>();
    }

    /**
     * Returns true if the message should be printed in the given timestamp, otherwise returns false.
     * If this method returns false, the message will not be printed.
     * The timestamp is in seconds granularity.
     */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (map.containsKey(message)) {
            time = map.get(message);
            if (Math.abs(timestamp - time) < 10) {
                return false;
            }
        }
        map.put(message, timestamp);
        return true;
    }
}
