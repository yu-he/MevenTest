package common;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Encryption {
    public static void main(String[] args) throws Exception {
        EncryptionData();
    }

    private static void EncryptionData() throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {
        String content = "shopNo01,orderNo01,100.00,20170706, 91310000631494692T";
        byte[] key = "12345678".getBytes(StandardCharsets.UTF_8);
        SecretKeySpec keySpec = new SecretKeySpec(key, "DES");
        Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");//"算法/模式/补码方式"
        cipher.init(Cipher.ENCRYPT_MODE, keySpec);
        byte[] encrypted = cipher.doFinal(content.getBytes(StandardCharsets.UTF_8));
        String base64 = Base64.getEncoder().encodeToString(encrypted);
        //++IwcENeIT/Ciadh9FcpYAzUTPTtvVnwQcz4BocCQSbhq39i+wxLuKekZIYT/M30vhtwLMfiwFs=
        String urlEncode = URLEncoder.encode(base64, "UTF-8");
        //%2B%2BIwcENeIT%2FCiadh9FcpYAzUTPTtvVnwQcz4BocCQSbhq39i%2BwxLuKekZIYT%2FM30vhtwLMfiwFs%3D
        System.out.println(urlEncode);

//        String requestUrl = "http://testwx.fapiao.com/fpt-wechat/wxscan/wxkp.do?t=v";
//        String requestData = "";
//        String rsData = RequestUtils.getHttpConnectResult(requestData, requestUrl);
    }
}
