package xyz.fanchw.pool;

import java.util.LinkedList;

public class DataSourcesPool {
    private LinkedList<Integer> linkedList = new LinkedList<>();

    {
        for (int i = 1; i <= 10; i++) {
            linkedList.add(i);
        }
    }

    public Integer getFormPool() {
        final Integer integer = linkedList.removeFirst();
        System.out.println("还有----"+linkedList.size());
        return integer;
    }

    public void backToPool(Integer integer){
        linkedList.add(integer);
        System.out.println("还有----"+linkedList.size());
    }
}
