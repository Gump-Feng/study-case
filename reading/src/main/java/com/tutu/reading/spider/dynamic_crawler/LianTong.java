package com.tutu.reading.spider.dynamic_crawler;

import com.tutu.reading.spider.utils.StringUtil;
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

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author hxf
 * @date 2019/9/22 17:32
 * <p>
 * 联通登录的破解，获取用户的通话记录和短信记录
 */
public class LianTong {
    private static Logger logger = LoggerFactory.getLogger(LianTong.class);

    public static void main(String[] args) throws Exception {
        String phone = "17610757597";
//        String phone = "13111211599";
//        String phone = "18610811230";

        //第一步添加验证手机号是否需要验证的链接
        CookieStore cookieStore = new BasicCookieStore();
        CloseableHttpClient client0 = HttpClientBuilder.create().setDefaultCookieStore(cookieStore).build();
        HttpGet httpRequest0 = new HttpGet("https://uac.10010.com/portal/Service/CheckNeedVerify?callback=jQuery17201798238041080349_" +
                System.currentTimeMillis() + "&" +
                "userName=" + phone + "&" +
                "pwdType=02&" +
                "_=" + System.currentTimeMillis());

        setHeaders(httpRequest0);

        CloseableHttpResponse execute0 = client0.execute(httpRequest0);
        String body0 = EntityUtils.toString(execute0.getEntity());

        // 1、根据手机号获取验证码
        CloseableHttpClient client = HttpClientBuilder.create().setDefaultCookieStore(cookieStore).build();
        long epochDay = LocalDate.now().toEpochDay();
        HttpGet httpRequest = new HttpGet("https://uac.10010.com/portal/Service/SendMSG?" +
                "callback=jQuery17206571463072632691_" + System.currentTimeMillis() +
                "&req_time=" + System.currentTimeMillis() +
                "&mobile=" + phone +
                "&_=" + System.currentTimeMillis());
        setHeaders(httpRequest);

        CloseableHttpResponse execute = client.execute(httpRequest);
        String body = EntityUtils.toString(execute.getEntity());
//        String result = StringUtil.getResultByReg(body, "{.*?}");
        String resultByReg = StringUtil.getResultByReg(body, "resultCode:\"(.*?)\"");
        if (!"0000".equals(resultByReg)) {
            logger.error("发送验证码出现错误，返回信息为：{}", body);
        } else {
            logger.info("获取验证码成功，进行登录");
            // 2、根据验证码进行登录
            //根据发送的验证码输入
            Scanner in = new Scanner(System.in);
            String yzm = in.next();//输入一个整数

            CloseableHttpClient client2 = HttpClientBuilder.create().setDefaultCookieStore(cookieStore).build();
            HttpGet httpRequest2 = new HttpGet("https://uac.10010.com/portal/Service/MallLogin?" +
                    "callback=jQuery17206571463072632691_" + System.currentTimeMillis() +
                    "&req_time=" + System.currentTimeMillis() +
                    "&redirectURL=http%3A%2F%2Fwww.10010.com" +
                    "&userName=" + phone +
                    "&password=" + yzm +
                    "&pwdType=02" +
                    "&productType=01" +
                    "&redirectType=01" +
                    "&rememberMe=1" +
                    "&_=" + System.currentTimeMillis());
            httpRequest2.setHeader("Accept", "text/javascript, application/javascript, application/ecmascript, application/x-ecmascript, */*; q=0.01");
            httpRequest2.setHeader("X-Requested-With", "XMLHttpRequest");
            httpRequest2.setHeader("Connection", "keep-alive");
            httpRequest2.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/76.0.3809.132 Safari/537.36");
            httpRequest2.setHeader("Referer", "https://uac.10010.com/portal/homeLoginNew");
            httpRequest2.setHeader("Sec-Fetch-Site", "same-origin");
            httpRequest2.setHeader("Host", "uac.10010.com");
            httpRequest2.setHeader("Accept-Encoding", "gzip, deflate, br");
            httpRequest2.setHeader("Accept-Language", "zh-CN,zh;q=0.9,en;q=0.8,fr;q=0.7,ru;q=0.6,ja;q=0.5");
            httpRequest2.setHeader("Sec-Fetch-Mode", "cors");


            CloseableHttpResponse execute2 = client2.execute(httpRequest2);
            String body2 = EntityUtils.toString(execute2.getEntity());
            System.out.println(body2);
            String result2 = StringUtil.getResultByReg(body2, "resultCode:\"(.*?)\"");
            if (!"0000".equals(result2)) {
                logger.error("根据验证码登录出现错误，返回信息为：{}", result2);
            } else {
                String redirectUrl = StringUtil.getResultByReg(body2, "redirectURL:\"(.*?)\"");
                logger.info("登陆验证成功，访问跳转页面:{}", redirectUrl);
//                CloseableHttpClient client3 = HttpClientBuilder.create().setDefaultCookieStore(cookieStore).build();
                CloseableHttpClient client3 = HttpClientBuilder.create().setDefaultCookieStore(cookieStore).build();
                HttpGet httpRequest3 = new HttpGet("http://www.10010.com/");

                httpRequest3.setHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3");
                httpRequest3.setHeader("Upgrade-Insecure-Requests", "1");
                httpRequest3.setHeader("Connection", "keep-alive");
                httpRequest3.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/76.0.3809.132 Safari/537.36");
                httpRequest3.setHeader("Host", "www.10010.com");
                httpRequest3.setHeader("Accept-Encoding", "gzip, deflate");
                httpRequest3.setHeader("Accept-Language", "zh-CN,zh;q=0.9,en;q=0.8,fr;q=0.7,ru;q=0.6,ja;q=0.5");

                CloseableHttpResponse execute3 = client3.execute(httpRequest3);
                String body3 = EntityUtils.toString(execute3.getEntity());
                logger.info(body3);

            }
            // 3、解析2步骤产生的相关链接并进行相关的处理解析
            CloseableHttpClient client4 = HttpClientBuilder.create().setDefaultCookieStore(cookieStore).build();
            HttpGet httpRequest4 = new HttpGet("http://www.10010.com/net5/011/");

            httpRequest4.setHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3");
            httpRequest4.setHeader("Upgrade-Insecure-Requests", "1");
            httpRequest4.setHeader("Connection", "keep-alive");
            httpRequest4.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/76.0.3809.132 Safari/537.36");
            httpRequest4.setHeader("Host", "www.10010.com");
            httpRequest4.setHeader("Accept-Encoding", "gzip, deflate");
            httpRequest4.setHeader("Accept-Language", "zh-CN,zh;q=0.9,en;q=0.8,fr;q=0.7,ru;q=0.6,ja;q=0.5");

            CloseableHttpResponse execute4 = client4.execute(httpRequest4);
            String body4 = EntityUtils.toString(execute4.getEntity());
            logger.info(body4);

            // 4、根据最终的页面获取所需的详单链接进而获取数据
            CloseableHttpClient client5 = HttpClientBuilder.create().setDefaultCookieStore(cookieStore).build();
            HttpPost httpRequest5 = new HttpPost("http://www.10010.com/mall/service//ipAddress/getAreaByIp/?_=1569248478871");

            httpRequest.setHeader("Origin", "http://www.10010.com");
            httpRequest.setHeader("Accept", "application/json, text/javascript, */*; q=0.01");
            httpRequest.setHeader("X-Requested-With", "XMLHttpRequest");
            httpRequest.setHeader("Connection", "keep-alive");
            httpRequest.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/76.0.3809.132 Safari/537.36");
            httpRequest.setHeader("Referer", "http://www.10010.com/net5/");
            httpRequest.setHeader("Host", "www.10010.com");
            httpRequest.setHeader("Accept-Encoding", "gzip, deflate");
            httpRequest.setHeader("Accept-Language", "zh-CN,zh;q=0.9,en;q=0.8,fr;q=0.7,ru;q=0.6,ja;q=0.5");

            CloseableHttpResponse execute5 = client5.execute(httpRequest5);
            String body5 = EntityUtils.toString(execute5.getEntity());

            CloseableHttpClient client6 = HttpClientBuilder.create().setDefaultCookieStore(cookieStore).build();
            HttpPost httpRequest6 = new HttpPost("http://www.10010.com/mall/service/check/checklogin/?_=1569248480163");

            List<NameValuePair> nameValuePairs = new ArrayList<>();
            nameValuePairs.add(new BasicNameValuePair("_uop_id", "405349ac3be1ede9bbf071966230dea9"));
            nameValuePairs.add(new BasicNameValuePair("jutThird", "1fuL0eJp6sPgRhg0/ZqGqyLZPKehFeTN+DnMZAcBYwLyco2qhnVJ+s5Z/v8MrVy0zxuEwYnskT/eU/F9du+Ma5CJSD6c0ybrWNTWlrNouZDiaHrRel08+AynDWKfOHcoyuKC9etP9JQ5FQu+npIgha+HkUKTuQ0ZqZn9mu2WzUTuEceOh6N2p61qTghskYYmns3JGfpWqfwjqpbd4WhUHa5nvdLEVcSPK6kbKMKGVHlZGkpIdlW32+fSRHrE4dBVN4TChpbqgdA/KzzqDReJwEgLDr/x4EqiRVhZ5eSUMb5GaI12np8R6cogHcuBKQqhbbvzp73JYnx2TjjvMAde1DI8yzQUjYLsiHWy4msx4VuYIEMtovTci3614ZiUXFUOZwbWtYhAhUJksQ3efwM1VycQDqlS2y2d1cW1de3C+OqjqrugIe2QsS5n3096kcxAlws8rh1/dIKd0k06Yllc3m9dbjEJbkkF5hK6Q8+S4DQ2gp8CyJNL4RLkdKq28FdXKoWZojpp478ec7XGKQnimtMaaAv54JHp5ZnfWCo+zS1ycbDowmb1GUf6XKuZwjVF05zXPaCiQC0"));
            HttpEntity entity = EntityBuilder.create().setParameters(nameValuePairs).build();
            httpRequest6.setEntity(entity);

            httpRequest6.setHeader("Origin", "http://www.10010.com");
            httpRequest6.setHeader("Accept", "application/json, text/javascript, */*; q=0.01");
            httpRequest6.setHeader("X-Requested-With", "XMLHttpRequest");
            httpRequest6.setHeader("Connection", "keep-alive");
            httpRequest6.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/76.0.3809.132 Safari/537.36");
            httpRequest6.setHeader("Referer", "http://www.10010.com/net5/011/");
            httpRequest6.setHeader("Host", "www.10010.com");
            httpRequest6.setHeader("Accept-Encoding", "gzip, deflate");
            httpRequest6.setHeader("Accept-Language", "zh-CN,zh;q=0.9,en;q=0.8,fr;q=0.7,ru;q=0.6,ja;q=0.5");
            httpRequest6.setHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");

            CloseableHttpResponse execute6 = client6.execute(httpRequest6);
            String body6 = EntityUtils.toString(execute6.getEntity());
            logger.info(body6);
        }


    }

    private static void setHeaders(HttpGet httpRequest) {
        httpRequest.setHeader("Accept", "text/javascript, application/javascript, application/ecmascript, application/x-ecmascript, */*; q=0.01");
        httpRequest.setHeader("X-Requested-With", "XMLHttpRequest");
        httpRequest.setHeader("Connection", "keep-alive");
        httpRequest.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/76.0.3809.132 Safari/537.36");
        httpRequest.setHeader("Sec-Fetch-Site", "same-origin");
        httpRequest.setHeader("Host", "uac.10010.com");
        httpRequest.setHeader("Accept-Encoding", "gzip, deflate, br");
        httpRequest.setHeader("Accept-Language", "zh-CN,zh;q=0.9,en;q=0.8,fr;q=0.7,ru;q=0.6,ja;q=0.5");
        httpRequest.setHeader("Sec-Fetch-Mode", "cors");
    }


}
