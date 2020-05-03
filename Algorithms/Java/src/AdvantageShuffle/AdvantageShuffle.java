package src.AdvantageShuffle;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

import javafx.util.Pair;

/**
 * @author mingqiao
 * @Date 2020/3/17
 */
public class AdvantageShuffle {

    /**
     * 田忌赛马策略：两个数组都排序，A里数组能打赢B组一方最小的就打，打不赢就耗掉B组里最大的
     *
     * @param A
     * @param B
     * @return
     */
    public int[] advantageCount(int[] A, int[] B) {
        LinkedList<Pair<Integer, Integer>> listB = new LinkedList<>();
        for (int i = 0; i < B.length; i++) {
            listB.add(new Pair<>(i, B[i]));
        }
        Arrays.sort(A);
        listB.sort(Comparator.comparingInt(Pair::getValue));

        for (int i = 0; i < A.length; i++) {
            if (A[i] > listB.getFirst().getValue()) {
                B[listB.removeFirst().getKey()] = A[i];
            } else {
                B[listB.removeLast().getKey()] = A[i];
            }
        }
        return B;
    }
}
