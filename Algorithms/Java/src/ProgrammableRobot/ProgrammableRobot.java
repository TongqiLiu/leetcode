package src.ProgrammableRobot;

/**
 * @author mingqiao
 * @Date 2020/2/26
 */
public class ProgrammableRobot {

    /**
     * 因为走法固定，每次循环都是走x+y步，相当于无限向右上角平移，故无论终点、障碍物都可以通过计算位置差
     * 从而判定是否能平移走到
     *
     * @param command
     * @param obstacles
     * @param x
     * @param y
     * @return
     */
    public boolean robot(String command, int[][] obstacles, int x, int y) {
        int endX = count(command, 'R');
        int endY = count(command, 'U');

        //未遇到障碍物都尚且不能到达终点
        if (!canReach(command, endX, endY, x, y)) {
            return false;
        }

        //如果有障碍物在终点之前遇到
        for (int[] point : obstacles) {
            int px = point[0];
            int py = point[1];
            if (canReach(command, endX, endY, px, py) && (px < x || py < y)) {
                return false;
            }
        }
        return true;
    }

    private boolean canReach(String command, int endX, int endY, int x, int y) {
        //如果终点在一次循环操作的界外则进行平移
        while (x > endX || y > endY) {
            x -= endX;
            y -= endY;
        }

        //如果出现这种越界case证明x,y步调没法在本周期内达成一致
        if (x < 0 || y < 0) {
            return false;
        }
        String str = command.substring(0, x + y);
        return x == count(str, 'R') && y == count(str, 'U');
    }

    private static int count(String command, char c) {
        if (command == null || command.isEmpty()) {
            return 0;
        }
        return command.length() - command.replaceAll(String.valueOf(c), "").length();
    }

    public static void main(String[] args) {
        System.out.println(count("abaaaa", 'a'));
    }
}
