package src.PourWater;

/**
 * @author mingqiao
 * @Date 2020/8/13
 */
public class PourWater {

    /**
     * 题目链接：https://leetcode-cn.com/problems/pour-water/
     * 模拟题，复杂度O(V * N)，注意如果是平坦的情况，则水滴靠在离K近的位置
     *
     * @param heights
     * @param V
     * @param K
     * @return
     */
    public static int[] pourWater(int[] heights, int V, int K) {
        int[] res = new int[heights.length];

        while (V-- > 0) {
            int pos;

            int l = K - 1;
            while (l >= 0 && heights[l] + res[l] <= heights[l + 1] + res[l + 1]) {
                l--;
            }
            if (heights[l + 1] + res[l + 1] < heights[K] + res[K]) {
                pos = l + 1;
                //找到离K近的位置
                while (heights[pos] + res[pos] == heights[pos + 1] + res[pos + 1]
                    && pos + 1 < heights.length) {
                    pos++;
                }
                res[pos]++;
                continue;
            }

            int r = K + 1;
            while (r < heights.length && heights[r] + res[r] <= heights[r - 1] + res[r - 1]) {
                r++;
            }
            if (heights[r - 1] + res[r - 1] < heights[K] + res[K]) {
                pos = r - 1;
                //找到离K近的位置
                while (heights[pos] + res[pos] == heights[pos - 1] + res[pos - 1]
                    && pos + 1 >= 0) {
                    pos--;
                }
                res[pos]++;
                continue;
            }

            pos = K;
            res[pos]++;
        }

        print(heights, res);

        for (int i = 0; i < heights.length; i++) {
            heights[i] += res[i];
        }
        return heights;
    }

    private static void print(int[] heights, int[] res) {
        int maxHeight = 0;
        int n = heights.length;
        for (int i = 0; i < n; i++) {
            maxHeight = Math.max(maxHeight, heights[i] + res[i]);
        }

        for (int height = maxHeight; height >= 0; height--) {
            for (int i = 0; i < n; i++) {
                if (height <= heights[i]) {
                    System.out.print("+");
                } else if (height > heights[i] && height <= heights[i] + res[i]) {
                    System.out.print("W");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        pourWater(new int[] {1, 2, 3, 4}, 2, 2);
    }
}
