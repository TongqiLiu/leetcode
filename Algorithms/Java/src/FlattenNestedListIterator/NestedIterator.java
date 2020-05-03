package src.FlattenNestedListIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import src.A_Common_Package.NestedInteger;

/**
 * @author mingqiao
 * @Date 2020/3/18
 */
public class NestedIterator implements Iterator<Integer> {

    private int index;
    private List<Integer> list = new ArrayList<>();

    private void dfs(List<NestedInteger> nestedList) {
        for (NestedInteger nestedInteger : nestedList) {
            if (nestedInteger.isInteger()) {
                list.add(nestedInteger.getInteger());
            } else {
                dfs(nestedInteger.getList());
            }
        }
    }

    public NestedIterator(List<NestedInteger> nestedList) {
        dfs(nestedList);
    }

    @Override
    public Integer next() {
        return list.get(index++);
    }

    @Override
    public boolean hasNext() {
        return index < list.size();
    }
}
