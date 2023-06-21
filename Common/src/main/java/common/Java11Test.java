package common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Java11Test {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
//        list = list.stream().filter(item -> item > 2).collect(Collectors.toList());
//        list = list.stream().filter(item -> item > 5).collect(Collectors.toList());

        List<Integer> list2 = new ArrayList<>();
        list2.add(list.get(0));
        System.out.println(list2);
    }
}
