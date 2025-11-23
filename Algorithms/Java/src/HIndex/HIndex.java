package src.HIndex;

import java.util.Arrays;

/**
 * @author tongqi
 * @date 2025/11/23
 */
public class HIndex {

    /**
     * H指数计算
     * 
     * H指数的定义：至少有h篇论文被引用了至少h次的最大值h
     * 
     * 解题思路：
     * 1. 将引用次数数组排序（从小到大）
     * 2. 从后往前遍历，找到最大的h，使得至少有h篇论文被引用至少h次
     * 3. 对于排序后的数组，如果citations[i] >= (n-i)，说明从位置i到末尾至少有(n-i)篇论文
     *    且这些论文的引用次数都至少是citations[i]，而citations[i] >= (n-i)
     * 
     * 例子：citations = [3,0,6,1,5]
     * - 排序后：[0,1,3,5,6]
     * - i=4: citations[4]=6 >= (5-4)=1, h至少可以是1
     * - i=3: citations[3]=5 >= (5-3)=2, h至少可以是2
     * - i=2: citations[2]=3 >= (5-2)=3, h至少可以是3 ✓
     * - i=1: citations[1]=1 < (5-1)=4, 不满足
     * - 所以H指数是3
     * 
     * 时间复杂度：O(n log n)，主要是排序的时间复杂度
     * 空间复杂度：O(1)，如果使用原地排序；O(n)如果使用额外空间
     * 
     * @param citations 引用次数数组
     * @return H指数
     */
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
        
        int n = citations.length;

        // 对引用次数数组进行排序
        Arrays.sort(citations);

        // 从后往前遍历，找到最大的h
        // h = n - i，表示从位置i到末尾有(n-i)篇论文
        // 如果citations[i] >= (n-i)，说明这(n-i)篇论文的引用次数都至少是(n-i)
        // 注意：我们需要找到最大的h，所以一旦遇到不满足条件的，就可以停止
        int h = 0;
        for (int i = n - 1; i >= 0; i--) {
            int count = n - i;  // 从位置i到末尾的论文数量
            if (citations[i] >= count) {
                h = count;  // 更新h为当前可能的更大值
            } else {
                // 如果当前不满足，由于数组已排序，前面的更不可能满足
                // 所以可以提前退出
                break;
            }
        }
        
        return h;
    }
}

