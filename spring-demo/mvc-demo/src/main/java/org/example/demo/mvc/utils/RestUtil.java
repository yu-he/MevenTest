package org.example.demo.mvc.utils;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RestUtil {
    public static String post(String url, HashMap<String, String> header, HttpEntity entity) throws IOException {
        CloseableHttpClient httpClient = HttpClients.custom().build();

        HttpPost post = new HttpPost(url);
        post.setEntity(entity);
        header.forEach(post::addHeader);
        HttpResponse response = httpClient.execute(post);
        if (null == response || response.getStatusLine() == null) {
            return "返回为空";
        } else if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
            return response.getStatusLine().getStatusCode() + response.getStatusLine().getReasonPhrase();
        }
        return EntityUtils.toString(response.getEntity(), "utf-8");
    }

    public static void requestParamTest() throws IOException {
        HashMap<String, String> header = new HashMap<>();
        header.put("Content-Type", "application/x-www-form-urlencoded");

        //StringEntity entity = new StringEntity(content);

        List<NameValuePair> nvpList = new ArrayList<>();
        nvpList.add(new BasicNameValuePair("name", "name123"));
        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(nvpList);

        System.out.println(RestUtil.post("http://localhost:8801/requestParamTest", header, entity));
    }

    public static void main(String[] args) throws IOException {
        requestParamTest();
    }
}
