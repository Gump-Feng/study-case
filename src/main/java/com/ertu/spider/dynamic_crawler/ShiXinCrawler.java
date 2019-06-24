package com.ertu.spider.dynamic_crawler;

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

/**
 * @author hxf
 * @date 2019/6/20 22:38
 */
public class ShiXinCrawler {

    public static void main(String[] args) {
        CloseableHttpClient httpClient = HttpClientUtils.createHttpClient();

        String url = "http://zxgk.court.gov.cn/shixin/findDisXgl.do";
        HttpPost httpPost = new HttpPost(url);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("pName", "张三");
        jsonObject.put("pCardNum", "");
        jsonObject.put("pProvince", "0");
        // 构建消息实体
        StringEntity entity = new StringEntity(jsonObject.toString(), Charset.forName("UTF-8"));
        entity.setContentEncoding("UTF-8");
        // 发送Json格式的数据请求
        entity.setContentType("application/json");
        httpPost.setEntity(entity);

        try {
            HttpResponse response = httpClient.execute(httpPost);
            HttpEntity responseEntity = response.getEntity();
            String s = EntityUtils.toString(responseEntity);
            System.out.println(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
