package common;

public class StringTest {
    public static void main(String... agrs){
        String str = "ODS_*";
        str = str.replaceAll("[*]","");
        System.out.println(str);
    }
}
