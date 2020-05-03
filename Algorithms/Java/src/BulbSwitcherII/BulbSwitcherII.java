package src.BulbSwitcherII;

/**
 * @author mingqiao
 * @Date 2020/3/8
 */
public class BulbSwitcherII {

    /**
     * 1.首先找出循环节发现，x与x+6状态会始终保持一致
     * 2.对m进行分析：
     * m=0时结果为1
     * m=1时当n>=3时结果始终=4
     * m=2时，枚举排列组合，发现一共7种情况少了4：
     * 1+1=0 1+2=3 1+3=2 1+4=5
     * 2+2=0 2+3=1 2+4=6
     * 3+3=0 3+4=7
     * 4+4=0
     * m>=3时，自然可以补齐4这个操作，故有8种可能性
     * n=3时已经能够
     *
     * @param n
     * @param m
     * @return
     */
    public int flipLights(int n, int m) {
        if (m == 0) {
            return 1;
        }
        if (n == 1) {
            return 2;
        } else if (n == 2) {
            return m == 1 ? 3 : 4;
        } else {
            if (m == 1) {
                return 4;
            }
            if (m == 2) {
                return 7;
            }
            return 8;
        }
    }
}
