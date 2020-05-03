package src.LinkedListRandomNode;

import java.util.Random;

import src.A_Common_Package.ListNode;

/**
 * @author mingqiao
 * @Date 2020/2/1
 */
public class LinkedListRandomNode {

    private ListNode head;
    private Random random;

    /**
     * 蓄水池抽奖算法，到第i位时就用1/i的概率替换之前选中的数，nextInt(cnt) == 0的概率刚好是1/i
     * @param head
     */
    public void Solution(ListNode head) {
        this.head = head;
        this.random = new Random();
    }

    public int getRandom() {
        int ans = 0;
        ListNode p = head;
        //nextInt(cnt)产生0-cnt随机数，其中等于0的概率正好为1/cnt
        for (int cnt = 1; p != null; cnt++, p = p.next) {
            if (random.nextInt(cnt) == 0) {
                ans = p.val;
            }
        }
        return ans;
    }
}
