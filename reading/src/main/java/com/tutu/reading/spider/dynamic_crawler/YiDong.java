package com.tutu.reading.spider.dynamic_crawler;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.CookieStore;
import org.apache.http.client.entity.EntityBuilder;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author ：hxf
 * @date ：Created in 2019/9/24 12:55
 * @description: boss招聘的公司职位抓取
 */
@Service
public class YiDong {

    private static Logger logger = LoggerFactory.getLogger(YiDong.class);

    public static void main(String[] args) throws Exception {
        String phone = "18335440228";
        CookieStore cookieStore = new BasicCookieStore();

        CloseableHttpClient client8 = HttpClientBuilder.create().setDefaultCookieStore(cookieStore).build();
        HttpGet httpRequest8 = new HttpGet("https://login.10086.cn/loadSendflag.htm?timestamp=");

        httpRequest8.setHeader("Accept", "image/webp,image/apng,image/*,*/*;q=0.8");
        httpRequest8.setHeader("Connection", "keep-alive");
        httpRequest8.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/76.0.3809.100 Safari/537.36");
        httpRequest8.setHeader("Referer", "https://login.10086.cn/login.html");
        httpRequest8.setHeader("Sec-Fetch-Site", "same-origin");
        httpRequest8.setHeader("Host", "login.10086.cn");
        httpRequest8.setHeader("Accept-Encoding", "gzip, deflate, br");
        httpRequest8.setHeader("Accept-Language", "zh-CN,zh;q=0.9,en;q=0.8,fr;q=0.7,ru;q=0.6,ja;q=0.5");
        httpRequest8.setHeader("Sec-Fetch-Mode", "no-cors");

        CloseableHttpResponse execute8 = client8.execute(httpRequest8);
        String body8 = EntityUtils.toString(execute8.getEntity());

        //补充：添加图片链接的请求
        CloseableHttpClient client7 = HttpClientBuilder.create().setDefaultCookieStore(cookieStore).build();
        HttpGet httpRequest7 = new HttpGet("https://login.10086.cn/captchazh.htm?type=12");

        httpRequest7.setHeader("Accept", "image/webp,image/apng,image/*,*/*;q=0.8");
        httpRequest7.setHeader("Connection", "keep-alive");
        httpRequest7.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/76.0.3809.100 Safari/537.36");
        httpRequest7.setHeader("Referer", "https://login.10086.cn/login.html");
        httpRequest7.setHeader("Sec-Fetch-Site", "same-origin");
        httpRequest7.setHeader("Host", "login.10086.cn");
        httpRequest7.setHeader("Accept-Encoding", "gzip, deflate, br");
        httpRequest7.setHeader("Accept-Language", "zh-CN,zh;q=0.9,en;q=0.8,fr;q=0.7,ru;q=0.6,ja;q=0.5");
        httpRequest7.setHeader("Sec-Fetch-Mode", "no-cors");

        CloseableHttpResponse execute7 = client7.execute(httpRequest7);
        String body7 = EntityUtils.toString(execute7.getEntity());

        //
        CloseableHttpClient client9 = HttpClientBuilder.create().setDefaultCookieStore(cookieStore).build();
        HttpGet httpRequest9 = new HttpGet("https://login.10086.cn/genqr.htm");

        httpRequest9.setHeader("Accept", "image/webp,image/apng,image/*,*/*;q=0.8");
        httpRequest9.setHeader("Connection", "keep-alive");
        httpRequest9.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/76.0.3809.100 Safari/537.36");
        httpRequest9.setHeader("Referer", "https://login.10086.cn/login.html");
        httpRequest9.setHeader("Sec-Fetch-Site", "same-origin");
        httpRequest9.setHeader("Host", "login.10086.cn");
        httpRequest9.setHeader("Accept-Encoding", "gzip, deflate, br");
        httpRequest9.setHeader("Accept-Language", "zh-CN,zh;q=0.9,en;q=0.8,fr;q=0.7,ru;q=0.6,ja;q=0.5");
        httpRequest9.setHeader("Sec-Fetch-Mode", "no-cors");

        CloseableHttpResponse execute9 = client9.execute(httpRequest9);
        String body9 = EntityUtils.toString(execute9.getEntity());

        //
        CloseableHttpClient client10 = HttpClientBuilder.create().setDefaultCookieStore(cookieStore).build();
        HttpPost httpRequest10 = new HttpPost("https://login.10086.cn/checkUidAvailable.action");

        httpRequest10.setHeader("Origin", "https://login.10086.cn");
        httpRequest10.setHeader("Accept", "application/json, text/javascript, */*; q=0.01");
        httpRequest10.setHeader("X-Requested-With", "XMLHttpRequest");
        httpRequest10.setHeader("Connection", "keep-alive");
        httpRequest10.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/76.0.3809.100 Safari/537.36");
        httpRequest10.setHeader("Referer", "https://login.10086.cn/login.html");
        httpRequest10.setHeader("Sec-Fetch-Site", "same-origin");
        httpRequest10.setHeader("Host", "login.10086.cn");
        httpRequest10.setHeader("Accept-Encoding", "gzip, deflate, br");
        httpRequest10.setHeader("Accept-Language", "zh-CN,zh;q=0.9,en;q=0.8,fr;q=0.7,ru;q=0.6,ja;q=0.5");
        httpRequest10.setHeader("Sec-Fetch-Mode", "cors");

        CloseableHttpResponse execute10 = client10.execute(httpRequest10);
        String body10 = EntityUtils.toString(execute10.getEntity());

        //1、验证验证码的链接
        CloseableHttpClient client1 = HttpClientBuilder.create().setDefaultCookieStore(cookieStore).build();
        HttpGet httpRequest1 = new HttpGet("https://login.10086.cn/needVerifyCode.htm?" +
                "accountType=01&" +
                "account=" + phone + "&" +
                "timestamp=" + System.currentTimeMillis());

        httpRequest1.setHeader("Accept", "application/json, text/javascript, */*; q=0.01");
        httpRequest1.setHeader("X-Requested-With", "XMLHttpRequest");
        httpRequest1.setHeader("Connection", "keep-alive");
        httpRequest1.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/76.0.3809.100 Safari/537.36");
        httpRequest1.setHeader("Referer", "https://login.10086.cn/login.html");
        httpRequest1.setHeader("Sec-Fetch-Site", "same-origin");
        httpRequest1.setHeader("Host", "login.10086.cn");
        httpRequest1.setHeader("Accept-Encoding", "gzip, deflate, br");
        httpRequest1.setHeader("Accept-Language", "zh-CN,zh;q=0.9,en;q=0.8,fr;q=0.7,ru;q=0.6,ja;q=0.5");
        httpRequest1.setHeader("Sec-Fetch-Mode", "cors");

        CloseableHttpResponse execute1 = client1.execute(httpRequest1);
        String body1 = EntityUtils.toString(execute1.getEntity());

        //2、依次请求三个链接获取验证码
        CloseableHttpClient client2 = HttpClientBuilder.create().setDefaultCookieStore(cookieStore).build();
        HttpPost httpRequest2 = new HttpPost("https://login.10086.cn/chkNumberAction.action");

        List<NameValuePair> nameValuePairs2 = new ArrayList<>();
        nameValuePairs2.add(new BasicNameValuePair("userName", phone));
        nameValuePairs2.add(new BasicNameValuePair("loginMode", "01"));
        nameValuePairs2.add(new BasicNameValuePair("channelID", "10000"));
        HttpEntity entity2 = EntityBuilder.create().setParameters(nameValuePairs2).build();
        httpRequest2.setEntity(entity2);

        httpRequest2.setHeader("Origin", "https://login.10086.cn");
        httpRequest2.setHeader("Accept", "application/json, text/javascript, */*; q=0.01");
        httpRequest2.setHeader("X-Requested-With", "XMLHttpRequest");
        httpRequest2.setHeader("Connection", "keep-alive");
        httpRequest2.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/76.0.3809.100 Safari/537.36");
        httpRequest2.setHeader("Referer", "https://login.10086.cn/login.html");
        httpRequest2.setHeader("Sec-Fetch-Site", "same-origin");
        httpRequest2.setHeader("Host", "login.10086.cn");
        httpRequest2.setHeader("Accept-Encoding", "gzip, deflate, br");
        httpRequest2.setHeader("Sec-Fetch-Mode", "cors");
        httpRequest2.setHeader("Accept-Language", "zh-CN,zh;q=0.9,en;q=0.8,fr;q=0.7,ru;q=0.6,ja;q=0.5");
        httpRequest2.setHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");

        CloseableHttpResponse execute2 = client2.execute(httpRequest2);
        String body2 = EntityUtils.toString(execute2.getEntity());

        if ("true".equals(body2)) {
            logger.info("check成功");
        } else {
            logger.error("check失败");
        }

        CloseableHttpClient client3 = HttpClientBuilder.create().setDefaultCookieStore(cookieStore).build();
        HttpPost httpRequest3 = new HttpPost("https://login.10086.cn/loadToken.action");

        List<NameValuePair> nameValuePairs3 = new ArrayList<>();
        nameValuePairs3.add(new BasicNameValuePair("userName", phone));
        HttpEntity entity3 = EntityBuilder.create().setParameters(nameValuePairs3).build();
        httpRequest3.setEntity(entity3);

        httpRequest3.setHeader("Origin", "https://login.10086.cn");
        httpRequest3.setHeader("Accept", "application/json, text/javascript, */*; q=0.01");
        httpRequest3.setHeader("X-Requested-With", "XMLHttpRequest");
        httpRequest3.setHeader("Connection", "keep-alive");
        httpRequest3.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/76.0.3809.100 Safari/537.36");
        httpRequest3.setHeader("Referer", "https://login.10086.cn/login.html");
        httpRequest3.setHeader("Sec-Fetch-Site", "same-origin");
        httpRequest3.setHeader("Host", "login.10086.cn");
        httpRequest3.setHeader("Accept-Encoding", "gzip, deflate, br");
        httpRequest3.setHeader("Sec-Fetch-Mode", "cors");
        httpRequest3.setHeader("Accept-Language", "zh-CN,zh;q=0.9,en;q=0.8,fr;q=0.7,ru;q=0.6,ja;q=0.5");
        httpRequest3.setHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");

        CloseableHttpResponse execute3 = client3.execute(httpRequest3);
        String body3 = EntityUtils.toString(execute3.getEntity());
        JSONObject parseObject = JSONObject.parseObject(body3);
        String token = parseObject.getString("result");

        if (body3.contains("0000")) {
            logger.info("loadToken成功");
        } else {
            logger.error("loadToken失败");
        }

        CloseableHttpClient client4 = HttpClientBuilder.create().setDefaultCookieStore(cookieStore).build();
        HttpPost httpRequest4 = new HttpPost("https://login.10086.cn/sendRandomCodeAction.action");

        List<NameValuePair> nameValuePairs4 = new ArrayList<>();
        nameValuePairs4.add(new BasicNameValuePair("userName", phone));
        nameValuePairs4.add(new BasicNameValuePair("type", "01"));
        nameValuePairs4.add(new BasicNameValuePair("channelID", "12003"));
        HttpEntity entity4 = EntityBuilder.create().setParameters(nameValuePairs4).build();
        httpRequest4.setEntity(entity4);

        httpRequest4.setHeader("Origin", "https://login.10086.cn");
        httpRequest4.setHeader("Accept", "application/json, text/javascript, */*; q=0.01");
        httpRequest4.setHeader("X-Requested-With", "XMLHttpRequest");
        httpRequest4.setHeader("Connection", "keep-alive");
        httpRequest4.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/76.0.3809.100 Safari/537.36");
        httpRequest4.setHeader("Referer", "https://login.10086.cn/login.html");
        httpRequest4.setHeader("Xa-before", token);
        httpRequest4.setHeader("Sec-Fetch-Site", "same-origin");
        httpRequest4.setHeader("Host", "login.10086.cn");
        httpRequest4.setHeader("Accept-Encoding", "gzip, deflate, br");
        httpRequest4.setHeader("Sec-Fetch-Mode", "cors");
        httpRequest4.setHeader("Accept-Language", "zh-CN,zh;q=0.9,en;q=0.8,fr;q=0.7,ru;q=0.6,ja;q=0.5");
        httpRequest4.setHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");

        CloseableHttpResponse execute4 = client4.execute(httpRequest4);
        String body4 = EntityUtils.toString(execute4.getEntity());
        logger.info("cookie信息为：{}", cookieStore.getCookies().toArray());
        if ("0".equals(body4)) {
            logger.info("验证码发送成功");
        } else {
            logger.error("验证码发送失败");
        }

        //3、过度链接
        CloseableHttpClient client5 = HttpClientBuilder.create().setDefaultCookieStore(cookieStore).build();
        HttpGet httpRequest5 = new HttpGet("https://login.10086.cn/sendflag.htm?" +
                "timestamp=" + System.currentTimeMillis());

        httpRequest5.setHeader("Accept", "image/webp,image/apng,image/*,*/*;q=0.8");
        httpRequest5.setHeader("Connection", "keep-alive");
        httpRequest5.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/76.0.3809.100 Safari/537.36");
        httpRequest5.setHeader("Referer", "https://login.10086.cn/login.html");
        httpRequest5.setHeader("Sec-Fetch-Site", "same-origin");
        httpRequest5.setHeader("Host", "login.10086.cn");
        httpRequest5.setHeader("Accept-Encoding", "gzip, deflate, br");
        httpRequest5.setHeader("Accept-Language", "zh-CN,zh;q=0.9,en;q=0.8,fr;q=0.7,ru;q=0.6,ja;q=0.5");
        httpRequest5.setHeader("Sec-Fetch-Mode", "no-cors");

        CloseableHttpResponse execute5 = client5.execute(httpRequest5);
        String body5 = EntityUtils.toString(execute5.getEntity());

        String randCode = new Scanner(System.in).next();
        //4、账号验证
        CloseableHttpClient client6 = HttpClientBuilder.create().setDefaultCookieStore(cookieStore).build();
        HttpGet httpRequest6 = new HttpGet("https://login.10086.cn/login.htm?" +
                "accountType=01&" +
                "account=" + phone + "&" +
                "password=cRIbD%2BIccQvTxMaNYcuNHhCrHdaz6beTREVK9WfJHPv%2FC5u%2BfwYfnGrcjHfpTb3PHET0uvWErxtovYw8vWS2seIusRJ8g1%2B43QHs4E7EOtBIpD1T%2BNayPhHssP5b8o6SXM%2ByAPAU6NP5Y9pIrJugi9AHHW2cfH6zkQY9pa%2B09uw1ApiNAAZlc28%2FQOYr%2BeQGpZisa3x8Y8ZsNn%2FFgTIaikv%2FYshckqeFf%2BuAn4GI6k22HYMWebrTujygBSvphMieqK8IoRW4%2BI0Km7LlEzPLJxcHFI37Uo%2FHLhiyv37pytGmn4%2FkrmnclANrFv4H3%2Fx5rRhoQ%2FqCJJP37Ux41k9tjA%3D%3D&" +
                "pwdType=01&" +
                "smsPwd=" + randCode + "&" +
                "inputCode=&" +
                "backUrl=https%3A%2F%2Fshop.10086.cn%2Fi%2F&" +
                "rememberMe=0&" +
                "channelID=12003&" +
                "loginMode=01&" +
                "protocol=https%3A&" +
                "timestamp=");

        httpRequest6.setHeader("Accept", "application/json, text/javascript, */*; q=0.01");
        httpRequest6.setHeader("X-Requested-With", "XMLHttpRequest");
        httpRequest6.setHeader("Connection", "keep-alive");
        httpRequest6.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/76.0.3809.100 Safari/537.36");
        httpRequest6.setHeader("Referer", "https://login.10086.cn/login.html");
        httpRequest6.setHeader("Sec-Fetch-Site", "same-origin");
        httpRequest6.setHeader("Host", "login.10086.cn");
        httpRequest6.setHeader("Accept-Encoding", "gzip, deflate, br");
        httpRequest6.setHeader("Accept-Language", "zh-CN,zh;q=0.9,en;q=0.8,fr;q=0.7,ru;q=0.6,ja;q=0.5");
        httpRequest6.setHeader("Sec-Fetch-Mode", "cors");

        CloseableHttpResponse execute6 = client6.execute(httpRequest6);
        String body6 = EntityUtils.toString(execute6.getEntity(), "utf-8");
        JSONObject jsonObject = JSONObject.parseObject(body6);
        String desc = jsonObject.getString("desc");
        String artifact = jsonObject.getString("artifact");
        if ("认证成功".equals(desc)) {
            logger.info("认证成功：{}", phone);
        } else {
            logger.error("认证失败");
        }

        CloseableHttpClient client13 = HttpClientBuilder.create().setDefaultCookieStore(cookieStore).build();
        HttpGet httpRequest13 = new HttpGet("https://shop.10086.cn/i/v1/auth/getArtifact?" +
                "backUrl=https%3A%2F%2Fshop.10086.cn%2Fi%2F&" +
                "artifact=" + artifact + "&" +
                "type=00");

        httpRequest13.setHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3");
        httpRequest13.setHeader("Upgrade-Insecure-Requests", "1");
        httpRequest13.setHeader("Connection", "keep-alive");
        httpRequest13.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/76.0.3809.100 Safari/537.36");
        httpRequest13.setHeader("Referer", "https://login.10086.cn/login.html");
        httpRequest13.setHeader("Sec-Fetch-Site", "same-site");
        httpRequest13.setHeader("Host", "shop.10086.cn");
        httpRequest13.setHeader("Sec-Fetch-User", "?1");
        httpRequest13.setHeader("Accept-Encoding", "gzip, deflate, br");
        httpRequest13.setHeader("Accept-Language", "zh-CN,zh;q=0.9,en;q=0.8,fr;q=0.7,ru;q=0.6,ja;q=0.5");
        httpRequest13.setHeader("Sec-Fetch-Mode", "navigate");

        CloseableHttpResponse execute13 = client13.execute(httpRequest13);
        logger.info(execute13.getStatusLine().getStatusCode() + "");
        String body13 = EntityUtils.toString(execute13.getEntity(), "utf-8");

        CloseableHttpClient client11 = HttpClientBuilder.create().setDefaultCookieStore(cookieStore).build();
        HttpGet httpRequest11 = new HttpGet("https://shop.10086.cn/i/v1/cust/mergecust/" +
                phone + "?" +
                "_=" + System.currentTimeMillis());

        httpRequest11.setHeader("expires", "0");
        httpRequest11.setHeader("Accept", "application/json, text/javascript, */*; q=0.01");
        httpRequest11.setHeader("X-Requested-With", "XMLHttpRequest");
        httpRequest11.setHeader("Connection", "keep-alive");
        httpRequest11.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/76.0.3809.100 Safari/537.36");
        httpRequest11.setHeader("Referer", "https://shop.10086.cn/i/?f=home&welcome=" + System.currentTimeMillis());
        httpRequest11.setHeader("Sec-Fetch-Site", "same-origin");
        httpRequest11.setHeader("Host", "shop.10086.cn");
        httpRequest11.setHeader("Accept-Encoding", "gzip, deflate, br");
        httpRequest11.setHeader("pragma", "no-cache");
        httpRequest11.setHeader("Sec-Fetch-Mode", "cors");
        httpRequest11.setHeader("Cache-Control", "no-store, must-revalidate");
        httpRequest11.setHeader("If-Modified-Since", "0");
        httpRequest11.setHeader("Accept-Language", "zh-CN,zh;q=0.9,en;q=0.8,fr;q=0.7,ru;q=0.6,ja;q=0.5");
        httpRequest11.setHeader("Content-Type", "*");

        CloseableHttpResponse execute11 = client11.execute(httpRequest11);
        String body11 = EntityUtils.toString(execute11.getEntity());
        logger.info(body11);
    }

}
