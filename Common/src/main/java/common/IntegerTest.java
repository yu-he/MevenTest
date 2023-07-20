package common;

import java.util.Objects;

public class IntegerTest {
    public static void main(String[] args) throws Exception {
        Integer a = null;
        Integer b = 133;

        System.out.println(a == b);
        System.out.println(Objects.equals(a, b));
        a.equals(b);

        String str = "";
        if (str != null) {

        }
    }
}
