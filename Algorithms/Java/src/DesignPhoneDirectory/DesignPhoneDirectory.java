package src.DesignPhoneDirectory;

import java.util.Arrays;

/**
 * @author mingqiao
 * @Date 2020/2/18
 */
public class DesignPhoneDirectory {

    private boolean[] vis;
    private int size = 0;

    /**
     * Initialize your data structure here
     *
     * @param maxNumbers - The maximum numbers that can be stored in the phone
     *                   directory.
     */
    public DesignPhoneDirectory(int maxNumbers) {
        size = maxNumbers;
        vis = new boolean[size];
        Arrays.fill(vis, true);
    }

    /**
     * Provide a number which is not assigned to anyone.
     *
     * @return - Return an available number. Return -1 if none is available.
     */
    public int get() {
        for (int i = 0; i < size; i++) {
            if (vis[i]) {
                vis[i] = false;
                return i;
            }
        }
        return -1;
    }

    /**
     * Check if a number is available or not.
     */
    public boolean check(int number) {
        return vis[number];
    }

    /**
     * Recycle or release a number.
     */
    public void release(int number) {
        vis[number] = true;
    }
}
