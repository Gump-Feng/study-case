package com.ertu.spider.dynamic_crawler;

import com.ertu.spider.utils.StringUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
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

        // 1、根据手机号获取验证码
        CookieStore cookieStore = new BasicCookieStore();
        CloseableHttpClient client = HttpClientBuilder.create().setDefaultCookieStore(cookieStore).build();
        long epochDay = LocalDate.now().toEpochDay();
        HttpGet httpRequest = new HttpGet("https://uac.10010.com/portal/Service/SendMSG?callback=jQuery17206571463072632691_1568901836495" +
                "&req_time=" + epochDay +
                "&mobile=" + phone +
                "&_=" + epochDay);
        setHeaders(httpRequest);

        CloseableHttpResponse execute = client.execute(httpRequest);
        String body = EntityUtils.toString(execute.getEntity());
        String result = StringUtil.getResultByReg(body, "{.*?}");
        String resultByReg = StringUtil.getResultByReg(result, "resultCode:\".*?\"");
        if (!StringUtils.isEmpty(resultByReg) || !StringUtils.equals(resultByReg, "0000")) {
            logger.error("发送验证码出现错误，返回信息为：{}", result);
        } else {
            logger.info("获取验证码成功，进行登录");
            // 2、根据验证码进行登录
            //根据发送的验证码输入
            Scanner in = new Scanner(System.in);
            String yzm = in.next();//输入一个整数

            long epochDay1 = LocalDate.now().toEpochDay();
//            CloseableHttpClient client2 = HttpClientBuilder.create().setDefaultCookieStore(cookieStore).build();
            HttpGet httpRequest2 = new HttpGet("https://uac.10010.com/portal/Service/MallLogin?callback=jQuery17206571463072632691_1568901836496" +
                    "&req_time=" + epochDay1 +
                    "&redirectURL=http%3A%2F%2Fwww.10010.com" +
                    "&userName=" + phone +
                    "&password=" + yzm +
                    "&pwdType=02" +
                    "&productType=01" +
                    "&redirectType=01" +
                    "&rememberMe=1" +
                    "&_=" + epochDay1);
            setHeaders(httpRequest2);


            CloseableHttpResponse execute2 = client.execute(httpRequest2);
            String body2 = EntityUtils.toString(execute2.getEntity());
            String result2 = StringUtil.getResultByReg(body2, "resultCode:\".*?\"");
            if (!StringUtils.isEmpty(result2) || !StringUtils.equals(result2, "0000")) {
                logger.error("根据验证码登录出现错误，返回信息为：{}", result);
            } else {
                String redirectUrl = StringUtil.getResultByReg(body2, "redirectURL:\".*?\"");
                logger.info("登陆验证成功，访问跳转页面:{}", redirectUrl);
//                CloseableHttpClient client3 = HttpClientBuilder.create().setDefaultCookieStore(cookieStore).build();
                HttpGet httpRequest3 = new HttpGet("https://uac.10010.com/portal/Service/SendMSG?callback=jQuery17206571463072632691_1568901836495&req_time=1568901871047&mobile=17610757597&_=1568901871047");

                setHeaders(httpRequest3);

                CloseableHttpResponse execute3 = client.execute(httpRequest3);
                String body3 = EntityUtils.toString(execute3.getEntity());

            }
            // 3、解析2步骤产生的相关链接并进行相关的处理解析
            // 4、根据最终的页面获取所需的详单链接进而获取数据
        }


    }

    private static void setHeaders(HttpGet httpRequest) {
        httpRequest.setHeader("Accept", "text/javascript, application/javascript, application/ecmascript, application/x-ecmascript, */*; q=0.01");
        httpRequest.setHeader("X-Requested-With", "XMLHttpRequest");
        httpRequest.setHeader("Connection", "keep-alive");
        httpRequest.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/76.0.3809.132 Safari/537.36");
        httpRequest.setHeader("Referer", "https://uac.10010.com/portal/homeLoginNew");
        httpRequest.setHeader("Sec-Fetch-Site", "same-origin");
        httpRequest.setHeader("Host", "uac.10010.com");
        httpRequest.setHeader("Accept-Encoding", "gzip, deflate, br");
        httpRequest.setHeader("Accept-Language", "zh-CN,zh;q=0.9,en;q=0.8,fr;q=0.7,ru;q=0.6,ja;q=0.5");
        httpRequest.setHeader("Sec-Fetch-Mode", "cors");
    }


}
