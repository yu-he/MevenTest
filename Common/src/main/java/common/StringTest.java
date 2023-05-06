package common;

import java.beans.PropertyEditor;

public class StringTest {
    public static void main(String... args){
        String str = "ODS_*";
        str = str.replaceAll("[*]","");
        System.out.println(str);
    }
}
