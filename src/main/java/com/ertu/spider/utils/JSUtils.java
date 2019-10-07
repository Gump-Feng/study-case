package com.ertu.spider.utils;

import org.apache.commons.io.IOUtils;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.ExecutionContext;
import org.apache.http.protocol.HttpContext;
import org.springframework.core.io.ClassPathResource;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.IOException;

/**
 * java 执行 JavaScript 工具类
 * <p>
 * create by JIUN·LIU
 * create time 2019/8/14
 */
public class JSUtils {

    private static ScriptEngineManager engineManager = new ScriptEngineManager();
    private static ScriptEngine engine = engineManager.getEngineByName("JavaScript");

    /**
     * @param script js 代码
     * @param method 执行的js 方法名称
     */
    public static String excuteCode(String script, String method, Object... param) {
        String enPassword = "";
        try {
            engine.eval(script);
            Invocable invocable = (Invocable) engine;
            Object enPasswordObj = invocable.invokeFunction(method, param);
            enPassword = enPasswordObj.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return enPassword;
    }

    public static String executeFile(String path, String method, Object... params) {
        String enPassword = "";
        try {
            ClassPathResource classPathResource = new ClassPathResource(path);
            String file = IOUtils.toString(classPathResource.getInputStream(), "UTF-8");
            engine.eval(file);
            Invocable invocable = (Invocable) engine;
            Object enPasswordObj = invocable.invokeFunction(method, params);
            enPassword = enPasswordObj.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return enPassword;
    }

    public static void main(String[] args) throws IOException {
        CookieStore cookieStore = new BasicCookieStore();
        CloseableHttpClient client2 = HttpClientBuilder.create().setDefaultCookieStore(cookieStore).build();
        HttpContext httpContext = new BasicHttpContext();
        HttpGet httpRequest2 = new HttpGet("https://www.zhipin.com/job_detail/?query=%E9%98%BF%E9%87%8C&city=101010100&industry=&position=");

        httpRequest2.setHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3");
        httpRequest2.setHeader("Upgrade-Insecure-Requests", "1");
        httpRequest2.setHeader("Connection", "keep-alive");
        httpRequest2.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/76.0.3809.100 Safari/537.36");
        httpRequest2.setHeader("Referer", "https://www.zhipin.com/");
        httpRequest2.setHeader("Sec-Fetch-Site", "same-origin");
        httpRequest2.setHeader("Host", "www.zhipin.com");
        httpRequest2.setHeader("Sec-Fetch-User", "?1");
        httpRequest2.setHeader("Accept-Encoding", "gzip, deflate, br");
        httpRequest2.setHeader("Accept-Language", "zh-CN,zh;q=0.9,en;q=0.8,fr;q=0.7,ru;q=0.6,ja;q=0.5");
        httpRequest2.setHeader("Sec-Fetch-Mode", "navigate");

        CloseableHttpResponse execute2 = client2.execute(httpRequest2, httpContext);
        HttpUriRequest realRequest = (HttpUriRequest)httpContext.getAttribute(ExecutionContext.HTTP_REQUEST);
        String uri = realRequest.getURI().toString();
        System.out.println(uri);
        String seed = StringUtil.matchStr(uri, "seed=(.*?)&");
        System.out.println("seed:"+seed);
        String ts = StringUtil.matchStr(uri, "ts=(.*?)&");
        System.out.println("ts:"+ts);
        String encrypttt = JSUtils.executeFile("js/boss-20191001.js", "getCode", seed, ts);
        System.out.println(encrypttt);

    }
}