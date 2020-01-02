package xyz.fanchw.stream;

import org.junit.Test;
import xyz.fanchw.enumm.MyStatus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {
    Integer[] arr = {12, 52, 6, 5, 23, 35, 61, 42, 53};
    int[] intArray = {12, 52, 6, 5, 23, 35, 61, 42, 53};
    List<Integer> numList = new ArrayList<>(Arrays.asList(arr));

    @Test
    public void streamFilter() {
        //Stream.of(arr).findFirst().ifPresent(System.out::println);
        Arrays.stream(intArray).sorted().forEach(System.out::println);
        Stream.of(arr).mapToInt(Integer::intValue).mapToObj(m -> m + "  stream").forEach(System.out::println);
        List<Integer> collect = numList.stream().filter(m -> m > 10).map(m -> m + 100).collect(Collectors.toList());
        System.out.println(collect);
    }

    @Test
    public void enumStream() {
        //接收到的状态编号
        String statusNum = "4";
        MyStatus[] values = MyStatus.values();
        //根据状态编号获取枚举类
        MyStatus myStatus = Stream.of(values)
                .filter(v -> v.getStatusNumber().equals(statusNum)).findFirst()
                .orElseThrow(() -> new RuntimeException("不存在该状态！"));
        System.out.println(myStatus + "---" + myStatus.getStatusName() + "---" + myStatus.getStatusNumber());
    }
}
