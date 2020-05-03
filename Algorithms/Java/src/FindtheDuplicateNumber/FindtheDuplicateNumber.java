package src.FindtheDuplicateNumber;

/**
 * @author mingqiao
 * @Date 2020/2/12
 */
public class FindtheDuplicateNumber {

    /**
     * 排序和HashSet的解法暂时不表，这里使用下标索引及快慢指针法找到重复元素，
     * 比如[1,3,4,2,2]，我们认为nums[i]值即为下一次索引到的数组位置，那么这就变成了
     * 0->1->3->2->4->2-4->2这样的循环节，故而就变成了求环的所在位置元素，
     * 因为抽屉原理：N+1个苹果放在N个抽屉，一定有个抽屉放了俩苹果，带到本题即一定有两个元素
     * 组成循环节即环的存在
     *
     * @param nums
     * @return
     */
    public static int findDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int slow = 0;
        int fast = 0;
        slow = nums[slow];
        fast = nums[nums[fast]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        //slow和fast只能确保环内相遇，找具体值还是要再遍历一遍
        int p1 = 0;
        int p2 = slow;
        while (p1 != p2) {
            p1 = nums[p1];
            p2 = nums[p2];
        }
        return p1;
    }

    public static void main(String[] args) {
        findDuplicate(new int[] {1, 3, 4, 2, 2});
    }
}
