package common;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class StringTest {
    public static void main(String... args) throws UnsupportedEncodingException {
        //http://172.22.70.85:8216/hghtest/cfps-api/upload/files/20230531/%E4%B8%AD%E6%96%87%E5%9B%BE%E7%89%87%E8%B7%AF%E5%BE%84%E6%B5%8B%E8%AF%95.png
        //http://172.22.70.85:8216/hghtest/cfps-api/upload/files/20230531/中文图片路径测试.png
        String url = "http://172.22.70.85:8216/hghtest/cfps-api/upload/files/20230531/中文图片路径测试.png";

        int lastIndex = url.lastIndexOf("/");
        int dotIndex = url.lastIndexOf(".");
        String fileBaseUrl = url.substring(0, lastIndex + 1);
        String fileName = url.substring(lastIndex + 1, dotIndex);
        String extName = url.substring(dotIndex);
        String encodeFileName = fileBaseUrl + URLEncoder.encode(fileName, "UTF-8") + extName;
        System.out.println(encodeFileName);
    }
}
