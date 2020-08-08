package com.ertu.spider.dynamic_crawler;

import com.ertu.spider.utils.HttpClientUtils;
import org.apache.commons.io.FileUtils;
import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.client.CookieStore;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import us.codecraft.webmagic.selector.Html;
import us.codecraft.webmagic.selector.Selectable;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author hxf
 * @date 2019/6/17 21:10
 */
public class SouGou {
    private static Logger logger = Logger.getLogger(SouGou.class);
    private static RequestConfig config = RequestConfig.custom().setProxy(new HttpHost("127.0.0.1", 1080)).build();

    public static void main(String[] args) {
        String preUrtl = "https://weixin.sogou.com";
        CookieStore cookieStore = initCookieStore();
        String content = "高考";
        String souSuoContent = getSouSuoContent(content, cookieStore);
        Html html = new Html(souSuoContent);
        Selectable urlSelects = html.xpath("//div[@class=\"txt-box\"]/p[@class=\"tit\"]/a/@href");
        if (urlSelects != null) {
            List<String> stringList = urlSelects.all();
            for (String url : stringList
            ) {
                System.out.println("公众号链接为：" + preUrtl + url);
                getPublicContent(preUrtl + url, cookieStore);
            }
        }

    }

    private static String getPublicContent(String publicUrl, CookieStore cookieStore) {
        CloseableHttpClient sslClientDefault = HttpClientUtils.createSSLClientDefault(cookieStore);
        Header[] headers = HttpClientUtils.getHeader("https://weixin.sogou.com/weixin?type=1&s_from=input&query=%E9%AB%98%E8%80%83&ie=utf8&_sug_=y&_sug_type_=");
        HttpGet httpGet = new HttpGet(publicUrl);
        httpGet.setHeaders(headers);
        httpGet.setConfig(config);
        String body = "";
        try {
            CloseableHttpResponse execute = sslClientDefault.execute(httpGet);
            System.out.println(execute.getStatusLine().getStatusCode());
            body = EntityUtils.toString(execute.getEntity(), "utf-8");
            FileUtils.writeStringToFile(new File("C:\\Users\\houxf\\Desktop\\test.html"), body);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return body;
    }

    private static String getSouSuoContent(String content, CookieStore cookieStore) {
        CloseableHttpClient sslClientDefault = HttpClientUtils.createSSLClientDefault(cookieStore);
        String contentUrl = "https://weixin.sogou.com/weixin?type=1&query=" + content + "&ie=utf8&s_from=input&_sug_=y&_sug_type_=";

        Header[] headers = HttpClientUtils.getHeader("https://weixin.sogou.com/");
        HttpGet httpGet = new HttpGet(contentUrl);
        httpGet.setHeaders(headers);
        httpGet.setConfig(config);
        String s = "";
        try {
            CloseableHttpResponse execute = sslClientDefault.execute(httpGet);
            System.out.println(execute.getStatusLine().getStatusCode());
            s = EntityUtils.toString(execute.getEntity(), "utf-8");

        } catch (IOException e) {
            e.printStackTrace();
        }
        return s;

    }

    private static CookieStore initCookieStore() {
        CookieStore cookieStore = new BasicCookieStore();
        CloseableHttpClient sslClientDefault = HttpClientUtils.createSSLClientDefault(cookieStore);

        Header[] headers = HttpClientUtils.getHeader(null);
        String queryUrl = "https://weixin.sogou.com/";
        HttpGet httpGet = new HttpGet(queryUrl);
        httpGet.setHeaders(headers);
        httpGet.setConfig(config);

        try {
            CloseableHttpResponse execute = sslClientDefault.execute(httpGet);
            int statusCode = execute.getStatusLine().getStatusCode();
            if (statusCode == 200) {
                System.out.println("初始化cookie成功");
            } else {
                System.out.println("初始化cookie失败，原因为：" + execute.getStatusLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cookieStore;
    }

}
