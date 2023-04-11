package common;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class HmacMD5 {
    public static void main(String[] args) throws Exception {
        String bodyData = "{\n" +
                "\t\"preAirline\": \"NH\",\n" +
                "\t\"cargoNo\": \"0003\",\n" +
                "\t\"stockTypeId\": \"AWBH\",\n" +
                "\t\"shpCustomerId\": \"COD\",\n" +
                "\t\"sndr\": \"WLPT\",\n" +
                "\t\"msgtype\": \"PLT_AWB\",\n" +
                "\t\"cargoNm\": \"包装盒\",\n" +
                "\t\"sAirportId\": \"BKK\",\n" +
                "\t\"stockPre\": \"54789874154\",\n" +
                "\t\"weight\": 13.55,\n" +
                "\t\"pack\": \"4\",\n" +
                "\t\"billId\": \"AWBH54789874154CS547847840\",\n" +
                "\t\"isDgr\": \"N\",\n" +
                "\t\"domInt\": \"D\",\n" +
                "\t\"shprTel\": \"15478478920\",\n" +
                "\t\"cnsnAddress\": \"连阳区\",\n" +
                "\t\"surveyReport\": [{\n" +
                "\t\t\"effectiveYear\": 1640966400000,\n" +
                "\t\t\"entrustmentUnit\": \"cs\",\n" +
                "\t\t\"sampleDescription\": \"纸箱\",\n" +
                "\t\t\"surveyReportAccessory\": \"/hb-cargo-agent/image/surveyReport/2022/12/21/1027147497035081.jpg\",\n" +
                "\t\t\"productUnit\": \"test\",\n" +
                "\t\t\"detectionMechanism\": \"ZTYT\",\n" +
                "\t\t\"surveyReportNo\": \"854789410\",\n" +
                "\t\t\"surveyReportType\": \"1\"\n" +
                "\t}],\n" +
                "\t\"cnsnName\": \"张衡\",\n" +
                "\t\"shprAddress\": \"江汉区\",\n" +
                "\t\"expImp\": \"E\",\n" +
                "\t\"eAirportId\": \"GRU\",\n" +
                "\t\"feeWt\": 55.00,\n" +
                "\t\"vol\": 22.00,\n" +
                "\t\"specopeId\": \"ECC\",\n" +
                "\t\"preFlightDate\": 1671552000000,\n" +
                "\t\"stockNo\": \"CS547847840\",\n" +
                "\t\"pcs\": 22,\n" +
                "\t\"preFlightNo\": \"784\",\n" +
                "\t\"cnsnTel\": \"15478478620\",\n" +
                "\t\"preEAirport\": \"GRU\",\n" +
                "\t\"shprName\": \"李红\"\n" +
                "}";
        System.out.println(encryptByHMACMD5ForServer(1671604197318L,"1671604197318","ccsp001","sdfsddfsfs223423",bodyData));
    }

    public static String encryptByHMACMD5ForServer(long ts, String transNo, String openId, String openSecretKey, String bodyData) throws Exception {
        List<String> list = new ArrayList<>();
        list.add("ts=" + ts);
        list.add("transNo=" + transNo);
        list.add("openId=" + openId);
        list.add("openSecretKey=" + openSecretKey);

        if (bodyData != null && bodyData.length() > 0) {
            list.add("bodyData=" + openSecretKey);
        }
        Collections.sort(list);
        String original = String.join("&", list);

        return base64(hmacMD5(original, openSecretKey));
    }

    private static byte[] hmacMD5(String encryptText, String encryptKey) throws Exception {
        byte[] data = encryptKey.getBytes(StandardCharsets.UTF_8);
        SecretKey secretKey = new SecretKeySpec(data, "common.HmacMD5");
        Mac mac = Mac.getInstance("common.HmacMD5");
        mac.init(secretKey);
        byte[] text = encryptText.getBytes(StandardCharsets.UTF_8);
        return mac.doFinal(text);
    }

    private static String base64(byte[] source) {
        return Base64.getEncoder().encodeToString(source);
    }
}
