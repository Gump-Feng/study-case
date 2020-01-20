package com.ertu.spider.dynamic_crawler;

import com.ertu.spider.utils.HttpClientUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;

import java.io.IOException;


/**
 * @author hxf
 * @date 2019/6/27 21:14
 */
public class ZhiHu {

    public static void main(String[] args) {
        CookieStore cookieStore = preLogin();
        System.out.println(cookieStore);
    }

    private static CookieStore preLogin() {
        CookieStore cookieStore = new BasicCookieStore();
        CloseableHttpClient sslClientDefault = HttpClientUtils.createSSLClientDefault(cookieStore);

        HttpGet httpGet = new HttpGet("https://www.zhihu.com/signin?next=%2F");
        try {
            CloseableHttpResponse execute = sslClientDefault.execute(httpGet);
            HttpEntity entity = execute.getEntity();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cookieStore;

    }

}
