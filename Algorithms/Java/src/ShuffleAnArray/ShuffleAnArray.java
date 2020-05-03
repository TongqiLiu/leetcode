package src.ShuffleAnArray;

import java.util.Random;

/**
 * @author mingqiao
 * @Date 2020/3/15
 */
public class ShuffleAnArray {

    private int[] array;
    private int[] original;
    private Random rand = new Random();

    private int randRange(int min, int max) {
        return rand.nextInt(max - min) + min;
    }

    private void swap(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /**
     * 地址：https://leetcode-cn.com/problems/shuffle-an-array/
     * 洗牌算法：
     * 在每次迭代中，生成一个范围在当前下标到数组末尾元素下标之间的随机整数。
     * 将当前元素和随机选出的下标所指的元素互相交换，其中选取下标范围的依据在于每个被摸出的元素都不可能再被摸出来了
     *
     * @param nums
     */
    public ShuffleAnArray(int[] nums) {
        array = nums;
        original = nums.clone();
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        array = original;
        //因为original的地址被赋给了array，但在shuffle方法里面被修改了
        original = original.clone();
        return original;
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        for (int i = 0; i < array.length; i++) {
            swap(i, randRange(i, array.length));
        }
        return array;
    }
}
