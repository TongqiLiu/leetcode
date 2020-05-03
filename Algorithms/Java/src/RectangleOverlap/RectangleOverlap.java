package src.RectangleOverlap;

/**
 * @author mingqiao
 * @Date 2020/3/18
 */
public class RectangleOverlap {

    /**
     * 卡死几种不相交的case
     *
     * @param rec1
     * @param rec2
     * @return
     */
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        if (rec2[1] >= rec1[3] || rec1[1] >= rec2[3]) {
            return false;
        }
        if (rec1[0] >= rec2[2] || rec2[0] >= rec1[2]) {
            return false;
        }
        return true;
    }
}
