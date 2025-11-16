package src.MinimumNumberOfOperationsToSortaBinaryTreeByLevel;

import java.util.*;
import src.A_Common_Package.TreeNode;

/**
 * 计算每一层按严格递增顺序排序所需的最少操作数目
 * 
 * 解题思路：
 * 1. 使用BFS层序遍历获取每一层的节点值
 * 2. 对于每一层，计算将其排序成严格递增顺序所需的最少交换次数
 * 3. 最少交换次数 = 数组中环的个数，每个环需要(环大小-1)次交换
 * 
 * 时间复杂度：O(n log n)，其中n是节点数
 *   - BFS遍历：O(n)
 *   - 每层排序和找环：O(k log k)，k是每层节点数，所有层加起来是O(n log n)
 * 
 * 空间复杂度：O(n)
 *   - 队列存储节点：O(n)
 *   - 每层数组和辅助数组：O(n)
 */
public class MinimumNumberOfOperationsToSortaBinaryTreeByLevel {

    /**
     * 计算每一层排序所需的最少操作次数
     * 
     * @param root 二叉树根节点
     * @return 最少操作次数
     */
    public int minimumOperations(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int totalOperations = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        // BFS层序遍历
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> levelValues = new ArrayList<>();
            
            // 收集当前层的所有节点值
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                levelValues.add(node.val);
                
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            
            // 计算当前层排序所需的最少交换次数
            totalOperations += calculateMinSwaps(levelValues);
        }
        
        return totalOperations;
    }
    
    /**
     * 计算将数组排序成严格递增顺序所需的最少交换次数
     * 
     * 核心思路：通过找"环"来计算最少交换次数
     * 
     * 例子：数组 [7, 6, 8, 5]
     * 1. 排序后应该是 [5, 6, 7, 8]
     * 2. 建立映射：每个元素应该去哪个位置？
     *    - 位置0的值7应该去位置2（因为7是第3小的）
     *    - 位置1的值6应该去位置1（已经在正确位置）
     *    - 位置2的值8应该去位置3
     *    - 位置3的值5应该去位置0
     * 3. 找环：0→2→3→0（3个元素，需要2次交换）
     * 
     * @param arr 原始数组
     * @return 最少交换次数
     */
    private int calculateMinSwaps(List<Integer> arr) {
        int n = arr.size();
        if (n <= 1) {
            return 0;
        }
        
        // 步骤1：创建"值到排序后位置"的映射
        // 例如：值5应该去位置0，值6去位置1，值7去位置2，值8去位置3
        Map<Integer, Integer> valueToTargetPos = new HashMap<>();
        List<Integer> sortedArr = new ArrayList<>(arr);
        Collections.sort(sortedArr);
        
        for (int i = 0; i < n; i++) {
            valueToTargetPos.put(sortedArr.get(i), i);
        }
        
        // 步骤2：创建"当前位置到目标位置"的映射
        // targetPos[i] 表示：当前位置i的元素，应该去目标位置targetPos[i]
        int[] targetPos = new int[n];
        for (int i = 0; i < n; i++) {
            targetPos[i] = valueToTargetPos.get(arr.get(i));
        }
        
        // 步骤3：找所有环，计算交换次数
        boolean[] visited = new boolean[n];
        int totalSwaps = 0;
        
        for (int startPos = 0; startPos < n; startPos++) {
            // 如果已经在正确位置，跳过
            if (targetPos[startPos] == startPos || visited[startPos]) {
                continue;
            }
            
            // 追踪一个环：从startPos开始，按照targetPos追踪
            int cycleSize = 0;
            int currentPos = startPos;
            
            while (!visited[currentPos]) {
                visited[currentPos] = true;
                currentPos = targetPos[currentPos];  // 移动到下一个位置
                cycleSize++;  // 环的大小+1
            }
            
            // 一个大小为cycleSize的环，需要cycleSize-1次交换
            totalSwaps += cycleSize - 1;
        }
        
        return totalSwaps;
    }
}
