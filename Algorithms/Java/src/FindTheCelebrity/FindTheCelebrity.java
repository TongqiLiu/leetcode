package src.FindTheCelebrity;

/**
 * @author mingqiao
 * @Date 2020/3/3
 */
public class FindTheCelebrity {

    private boolean knows(int a, int b) {
        return true;
    }

    /**
     * 乍一看像是toposort，但其实按照题目名人的行医，根据know(i,j)=true可以排除i，know(i,j)=false可以排除j，
     * 故扫一遍就可以找出名人是谁，另外考虑没有名人的情况，需要对res进行校验
     *
     * @param n
     * @return
     */
    public int findCelebrity(int n) {
        int res = 0;
        for (int i = 1; i < n; ++i) {
            if (knows(res, i)) {
                res = i;
            }
        }
        for (int i = 0; i < n; ++i) {
            if (res == i) {
                continue;
            }
            //res认识别人或者有人不认识res
            if (knows(res, i) || !knows(i, res)) {
                return -1;
            }
        }
        return res;
    }
}
