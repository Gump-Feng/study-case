package com.ertu.httpdemo;

import org.apache.commons.io.FileUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Before;
import org.junit.Test;
import us.codecraft.webmagic.selector.Html;

import java.io.File;
import java.io.IOException;

/**
 * @author: HuYi.Zhang
 * @create: 2018-05-06 09:53
 **/
public class HttpTests {

    CloseableHttpClient httpClient;

    @Before
    public void init() {
        httpClient = HttpClients.createDefault();
    }

    @Test
    public void testGet() throws IOException {
        HttpGet request = new HttpGet("http://raytheon.mediaroom.com/2019-04-08-Raytheon-demos-land-based-deployable-version-of-its-ship-based-precision-landing-system");
        HttpEntity entity = httpClient.execute(request).getEntity();
        String body = EntityUtils.toString(entity);
        Document parse = Jsoup.parse(body);
        Elements select = parse.select(".news_body > p");
        Element element = select.get(select.size() - 2);

        System.out.println("content："+element.html());
    }

    @Test
    public void webMagicTest() throws IOException {
        HttpGet request = new HttpGet("http://raytheon.mediaroom.com/2019-04-08-Raytheon-demos-land-based-deployable-version-of-its-ship-based-precision-landing-system");
        HttpEntity entity = httpClient.execute(request).getEntity();
        String body = EntityUtils.toString(entity);
        Html html = new Html(body);
//        html.xpath("//div[@class=\"news_body\"]/p[last()-1]");
        String content = html.xpath("//div[@class=\"wd_news_releases-detail\"]").toString();
        Document document = new Html(content).getDocument();
        Elements select = document.select(".news_body > p");
        select.get(select.size() - 2).remove();
        FileUtils.writeStringToFile(new File("C:\\Users\\houxf\\Desktop\\test.html"),document.toString());

    }

    @Test
    public void testPost() throws IOException {
        HttpGet request = new HttpGet("http://www.oschina.net/");
        request.setHeader("User-Agent",
                "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36");
        String response = this.httpClient.execute(request, new BasicResponseHandler());
        System.out.println(response);
    }

    @Test
    public void testGetPojo() throws IOException {
        HttpGet request = new HttpGet("http://localhost/hello");
        String response = this.httpClient.execute(request, new BasicResponseHandler());
        System.out.println(response);
    }
}