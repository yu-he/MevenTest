package common;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class JsonTest {
    public static void main(String... args) throws ParseException {
        String config = "{\"routekey1\":[\"ODS_FIL*\"],\"routekey2\":[\"ODS_FEE*\",\"ODS_\"],\"123\":null}";
        JSONObject jsonConfig = new JSONObject(config);
        for (String key : jsonConfig.keySet()) {
            JSONArray array = jsonConfig.getJSONArray(key);
            if (array != null) {
                for (Object o : array) {
                    System.out.println(o);
                }
            }
        }
        System.out.println(jsonConfig.toString());
        System.out.println(jsonConfig.toJSONString(2));
    }
}
