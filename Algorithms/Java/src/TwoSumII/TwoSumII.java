package src.TwoSumII;

/**
 * @author tongqi
 * @date 2025/11/30
 */
public class TwoSumII {

    /**
     * 在有序数组中找到两个数，使得它们的和等于目标值
     * 
     * @param numbers 有序数组（非递减顺序）
     * @param target 目标值
     * @return 两个数的索引（从1开始），如果不存在返回空数组
     */
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0) {
            return new int[0];
        }
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            if (numbers[i] + numbers[j] == target) {
                return new int[] {i + 1, j + 1};
            } else if (numbers[i] + numbers[j] < target) {
                i++;
            } else {
                j--;
            }   
        }
        return new int[0];
    }
}

