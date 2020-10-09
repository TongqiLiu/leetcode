package src.RearrangeStringkDistanceApart;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author mingqiao
 * @Date 2020/10/9
 */
public class RearrangeStringkDistanceApart {

    /**
     * 题目地址：https://leetcode-cn.com/problems/rearrange-string-k-distance-apart/
     * 先统计字符出现次数构造大顶堆，每次都贪心加入出现次数最多的字符，然后不断模拟k长度的循环节添加字符
     * 复杂度O(n * logn)，n为字符个数
     *
     * @param s
     * @param k
     * @return
     */
    public String rearrangeString(String s, int k) {
        if (s == null || s.length() == 0 || k <= 1) {
            return s;
        }

        //统计字符出现次数，并构造大顶堆
        HashMap<Character, Integer> map = new HashMap<>();
        for (Character ch : s.toCharArray()) {
            map.merge(ch, 1, (pre, one) -> pre + one);
        }

        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        maxHeap.addAll(map.entrySet());

        StringBuilder sb = new StringBuilder(s.length());
        Queue<Entry<Character, Integer>> queue = new LinkedList<>();
        while (!maxHeap.isEmpty()) {
            //取出重复次数最多的字符
            Map.Entry<Character, Integer> curEntry = maxHeap.poll();
            sb.append(curEntry.getKey());

            curEntry.setValue(curEntry.getValue() - 1);
            queue.offer(curEntry);

            //已插入了k个字符，故可以出现重复字符了
            if (queue.size() == k) {
                Map.Entry<Character, Integer> entry = queue.poll();
                if (entry.getValue() > 0) {
                    maxHeap.add(entry);
                }
            }
        }
        //长度不等则证明仍有字符挂在queue中无法满足条件
        return sb.length() == s.length() ? sb.toString() : "";
    }
}
