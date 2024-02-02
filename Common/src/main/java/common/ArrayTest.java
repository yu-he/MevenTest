package common;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ArrayTest {
    public static void main(String[] args) {
        long start = System.nanoTime();
        String string = "";
        for (int i = 0; i < 2; i++) {
            string += "测试呀434444444444444444444444444444444444444444444444444444444444444";
        }
        long end = System.nanoTime();
        System.out.println("String用时：" + (end - start));
        System.out.println(string);

        long start2 = System.nanoTime();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 2; i++) {
            stringBuilder.append("测试呀434444444444444444444444444444444444444444444444444444444444444");
        }
        long end2 = System.nanoTime();
        System.out.println("StringBuilder用时：" + (end2 - start2));
        System.out.println(string);

//        StringBuilder sb = new StringBuilder();
//        int start = (int) System.currentTimeMillis();
//        for (int i = 0; i < 2; i++) {
//            sb.append("SBs23333333333333333334444444444444444444444444444444444");
//        }
//        int end = (int) System.currentTimeMillis();
//        System.out.println("所需时间为" + (end - start) + "毫秒");
//
//        String str = new String();
//        int start2 = (int) System.currentTimeMillis();
//        for (int i = 0; i < 2; i++) {
//            str += "SBs23333333333333333334444444444444444444444444444444444";
//        }
//        int end2 = (int) System.currentTimeMillis();
//        System.out.println("所需时间为" + (end2 - start2) + "毫秒");
    }
}
