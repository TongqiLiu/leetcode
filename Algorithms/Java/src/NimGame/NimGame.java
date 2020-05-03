package src.NimGame;

/**
 * @author mingqiao
 * @Date 2020/3/10
 */
public class NimGame {

    /**
     * 巴什博弈，n % (m + 1) != 0时，先手一定赢
     *
     * @param n
     * @return
     */
    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }
}
