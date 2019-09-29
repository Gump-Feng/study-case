package com.ertu.spider.dynamic_crawler;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.CookieStore;
import org.apache.http.client.entity.EntityBuilder;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author hxf
 * @date 2019/9/28 17:10
 */
public class QiMingPian {


    public static void main(String[] args) throws IOException {

        CookieStore cookieStore = new BasicCookieStore();
        CloseableHttpClient client1 = HttpClientBuilder.create().setDefaultCookieStore(cookieStore).build();
        HttpPost httpRequest1 = new HttpPost("https://vipapi.qimingpian.com/login/sendVerifyCode");

        List<NameValuePair> nameValuePairs1 = new ArrayList<>();
        nameValuePairs1.add(new BasicNameValuePair("unionid", ""));
        nameValuePairs1.add(new BasicNameValuePair("mobile", "18335440228"));
        HttpEntity entity1 = EntityBuilder.create().setParameters(nameValuePairs1).build();
        httpRequest1.setEntity(entity1);

        httpRequest1.setHeader("Origin", "https://www.qimingpian.cn");
        httpRequest1.setHeader("Accept", "application/json, text/plain, */*");
        httpRequest1.setHeader("Connection", "keep-alive");
        httpRequest1.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/77.0.3865.90 Safari/537.36");
        httpRequest1.setHeader("Sec-Fetch-Site", "cross-site");
        httpRequest1.setHeader("Host", "vipapi.qimingpian.com");
        httpRequest1.setHeader("Accept-Encoding", "gzip, deflate, br");
        httpRequest1.setHeader("Accept-Language", "zh-CN,zh;q=0.9,en;q=0.8,fr;q=0.7,ru;q=0.6,ja;q=0.5");
        httpRequest1.setHeader("Sec-Fetch-Mode", "cors");
        httpRequest1.setHeader("Content-Type", "application/x-www-form-urlencoded");

        CloseableHttpResponse execute1 = client1.execute(httpRequest1);
        String body1 = EntityUtils.toString(execute1.getEntity());
    }
}
