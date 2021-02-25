package com.tutu.reading.spider;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import us.codecraft.webmagic.selector.Html;
import us.codecraft.xsoup.Xsoup;

import java.io.IOException;

/**
 * @author hxf
 * @date 2019/5/6 23:28
 */
public class SpiderTest {

    public static void main(String[] args) {
        HttpGet httpGet = new HttpGet("http://zhuanlan.sina.com.cn/");
        HttpClient httpClient = HttpClients.createDefault();
        try {
            HttpResponse execute = httpClient.execute(httpGet);
            HttpEntity entity = execute.getEntity();
            String body = EntityUtils.toString(entity);
            Html html = new Html(body);
            Document document = Jsoup.parse(body);
            String result = Xsoup.compile("//a/@href").evaluate(document).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
