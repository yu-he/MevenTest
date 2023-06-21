package common;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class StringTest {
    public static void main(String... args) throws UnsupportedEncodingException {
        String url = "";

        int lastIndex = url.lastIndexOf("/");
        int dotIndex = url.lastIndexOf(".");
        String fileBaseUrl = url.substring(0, lastIndex + 1);
        String fileName = url.substring(lastIndex + 1, dotIndex);
        String extName = url.substring(dotIndex);
        String encodeFileName = fileBaseUrl + URLEncoder.encode(fileName, "UTF-8") + extName;
        System.out.println(encodeFileName);
    }
}
