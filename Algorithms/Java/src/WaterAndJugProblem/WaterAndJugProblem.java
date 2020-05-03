package src.WaterAndJugProblem;

import java.util.Arrays;

/**
 * @author mingqiao
 * @Date 2020/2/16
 */
public class WaterAndJugProblem {

    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    /**
     * 这题dfs会爆内存，可以用bfs来写，每次出队列后模拟6种入新队列的状态
     * 这里使用数据裴蜀定理来解：ax + by = z满足{x,y}有整数解的前提是z是gcd(a,b)的倍数
     *
     * @param x
     * @param y
     * @param z
     * @return
     */
    public static boolean canMeasureWater(int x, int y, int z) {
        if (z == 0 || x == z || y == z || x + y == z) {
            return true;
        }
        if (x + y < z) {
            return false;
        }
        return z % gcd(x, y) == 0;
    }

    public static void main(String[] args) {
        canMeasureWater(3, 5, 4);
    }
}
