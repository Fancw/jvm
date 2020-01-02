package xyz.fanchw.se;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class Sort {
    Integer[] arr = {12, 52, 6, 5, 23, 35, 61, 42, 53};
    List<Integer> numList = new ArrayList<Integer>(Arrays.asList(arr));
    List<Integer> sortedList = new ArrayList<>();
    Integer[] sortedArr = new Integer[arr.length];

    @Test
    public void basicStream() {
        List<Integer> collect = Arrays.stream(arr).filter(m -> m % 2 == 0).map(m -> m + 200).collect(Collectors.toList());
        System.out.println(collect);
    }

    @Test
    public void quick() {
        List<Integer> afterFilter = numList.stream().filter(m -> m > 10).collect(Collectors.toList());
        System.out.println(numList);
        System.out.println(afterFilter);
    }

    @Test
    public void streamSort() {
        //降序排序 从大到小
        List<Integer> sorted = Arrays.stream(arr).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        List<Integer> sorted2 = Arrays.stream(arr).sorted(Comparator.comparing(Integer::intValue).reversed()).collect(Collectors.toList());
        System.out.println("before sorted = " + numList);
        System.out.println("sorted = " + sorted);
    }

    @Test
    public void bubble() {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    Integer temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        System.out.println("Sort By Bubble----->" + new ArrayList<Integer>(Arrays.asList(arr)));
    }

    @Test
    public void choose() {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    Integer temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println("Sort By Choose----->" + new ArrayList<Integer>(Arrays.asList(arr)));
    }
}
