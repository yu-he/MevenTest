package common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class regularTest {
    public static void main(String[] args) {
        String input = "=HEADER\n" +
                "RCV 2023/10/12 16:57\n" +
                "=DESTINATION\n" +
                "SHGHHZXH;SHGHFD8X;SHGHFF8X\n" +
                "=ORIGIN\n" +
                "SBUDCA8X\n" +
                "=PRIORITY\n" +
                "QN\n" +
                "=MSGID\n" +
                "W6/121\n" +
                "=SMI\n" +
                "YYY/00\r\n" +
                "=TEXT\r\n" +
                "PDM\r\n" +
                "FWB/18\n" +
                "1/W6205/12OCT/BUD\n" +
                "HGH\n" +
                "284-00181941BUDHGH/T10K4567MC10.51/CONSOL\n" +
                "LAST";

        String pattern = "YYY/00\\s*=TEXT\\s*PDM\\s*F\\w{2}/\\d{1,2}";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(input);

        // 查找匹配的字符串
        if (m.find()) {
            String group = m.group();
            System.out.println(group);
            System.out.println(group.indexOf("F"));
            String newContent = group.replaceAll("YYY/00", group.substring(group.indexOf("F"))).replaceAll("PDM\\s*", "");
            System.out.println(m.replaceAll(newContent));
        } else {
            System.out.println("未找到匹配的字符串");
        }
    }
}
