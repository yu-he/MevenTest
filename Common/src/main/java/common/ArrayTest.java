package common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayTest {
    public static void main(String[] args){
        List<String> list1 = new ArrayList<>();
        list1.add("aaa");
        list1.add("bbb");
        list1.add("ccc");
        List<String> list2 = new ArrayList<>();
        list2.add("aaa");
        list2.add("bbb");
        list2.add("ccc");
        boolean result = list1.retainAll(list2);
        System.out.println(result);
        System.out.println(list1);
    }
}
