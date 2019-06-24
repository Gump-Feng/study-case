package com.ertu.spider;

import com.alibaba.fastjson.JSONObject;
import com.ertu.spider.utils.HttpClientUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.nio.charset.Charset;
import java.time.LocalDate;
import java.util.UUID;

/**
 * @author hxf
 * @date 2019/6/8 22:04
 *
 * http-post的抓取练习
 */
public class PostDemo {

    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
//        crawl();
    }

    private static String crawl(){
        String url = "http://httpbin.org/post";
        CloseableHttpClient httpClient = HttpClientUtils.createSSLClientDefault();
        HttpPost post = new HttpPost("");

        post = new HttpPost(url);
        // 构造消息头
        post.setHeader("Content-type", "application/json; charset=utf-8");
        post.setHeader("Connection", "Close");
//        String sessionId = getSessionId();
//        post.setHeader("SessionId", sessionId);

        JSONObject jsonObj = new JSONObject();
        jsonObj.put("name", "Tom");

        // 构建消息实体
        StringEntity entity = new StringEntity(jsonObj.toString(), Charset.forName("UTF-8"));
        entity.setContentEncoding("UTF-8");
        // 发送Json格式的数据请求
        entity.setContentType("application/json");
        post.setEntity(entity);

        try {
            HttpResponse response = httpClient.execute(post);
            HttpEntity entity1 = response.getEntity();
            String s = EntityUtils.toString(entity1);
        } catch (IOException e) {
            e.printStackTrace();
        }


        return "";
    }

    // 构建唯一会话Id
    private static String getSessionId(){
        UUID uuid = UUID.randomUUID();
        String str = uuid.toString();
        return str.substring(0, 8) + str.substring(9, 13) + str.substring(14, 18) + str.substring(19, 23) + str.substring(24);
    }

}
