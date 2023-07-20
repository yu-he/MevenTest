package common;

import cn.hutool.core.util.NumberUtil;

import java.math.BigDecimal;

public class DoubleTest {
    public static void main(String[] args) throws Exception {
        BigDecimal b1 = BigDecimal.valueOf(1.2);
        BigDecimal b2 = BigDecimal.valueOf(2.44);
        System.out.println(b1.add(b2));

        Double d1 = 1.2;
        Double d2 = 2.44;
        System.out.println(NumberUtil.add(d1, d2, null));

        long l = -1234;
        long l2 = -1234;
        if(l==l2){

        }

        String str = "";
        String[] arr = str.split("|");
    }
}
