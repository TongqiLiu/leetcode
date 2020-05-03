package src.FindInMountainArray;

import java.util.Arrays;

/**
 * @author mingqiao
 * @Date 2020/5/3
 */
public class FindInMountainArray {

    /**
     * 先找出峰顶，然后将数组分为升序，降序两块分别进行二分查找
     *
     * @param target
     * @param mountainArr
     * @return
     */
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int l = 0, r = mountainArr.length() - 1, pos = -1;
        while (l + 1 < r) {
            int mid = l + (r - l) / 2;
            int midVal = mountainArr.get(mid);

            if (midVal > mountainArr.get(mid - 1) && midVal > mountainArr.get(mid + 1)) {
                pos = mid;
                break;
            } else if (midVal > mountainArr.get(mid - 1)) {
                l = mid;
            } else if (midVal > mountainArr.get(mid + 1)) {
                r = mid;
            }
        }
        int high = pos != -1 ? pos : (mountainArr.get(l) > mountainArr.get(r) ? l : r);

        int idx = search(mountainArr, 0, high, target, true);
        return idx != -1 ? idx : search(mountainArr, high + 1, mountainArr.length() - 1, target, false);
    }

    private int search(MountainArray mountainArr, int l, int r, int target, boolean asc) {
        while (l + 1 < r) {
            int mid = l + (r - l) / 2;
            int midVal = mountainArr.get(mid);

            if (midVal == target) {
                return mid;
            }
            if (midVal <= target) {
                l = asc ? mid : l;
                r = asc ? r : mid;
            } else {
                r = asc ? mid : r;
                l = asc ? l : mid;
            }
        }
        return mountainArr.get(l) == target ? l : (mountainArr.get(r) == target ? r : -1);
    }

    private class MountainArray {
        public MountainArray() {
        }

        public int get(int index) {
            return 0;
        }

        public int length() {
            return 0;
        }
    }
}
