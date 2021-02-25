package com.tutu.reading.httpdemo;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.Logs;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.StringJoiner;

/**
 * @author: HuYi.Zhang
 * @create: 2018-05-06 09:53
 **/
public class HttpTests {

    @Test
    public void stringTest() {
        DesiredCapabilities capability = new DesiredCapabilities();

        capability.setBrowserName("chrome");
//
//        capability.setPlatform(Platform.WINDOWS);

        try {
            WebDriver driver = new RemoteWebDriver(new URL("http://192.168.62.53:4444/wd/hub"), capability);

            driver.get("http://www.baidu.com");

            driver.quit();

        } catch (MalformedURLException e) {
            e.printStackTrace();

        }

    }

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:/Program Files (x86)/Google/Chrome/Application/chromedriver.exe");
        ChromeDriver chromeDriver = new ChromeDriver();
        chromeDriver.get("https://www.baidu.com");
        saveHttpTransferDataIfNecessary(chromeDriver);
    }

    public static void saveHttpTransferDataIfNecessary(ChromeDriver driver) {
        Logs logs = driver.manage().logs();
        Set<String> availableLogTypes = logs.getAvailableLogTypes();

        if(availableLogTypes.contains(LogType.PERFORMANCE)) {
            LogEntries logEntries = logs.get(LogType.PERFORMANCE);

            for(LogEntry entry : logEntries) {
                JSONObject jsonObj = JSON.parseObject(entry.getMessage()).getJSONObject("message");
                String method = jsonObj.getString("method");
                String params = jsonObj.getString("params");

                System.out.println(params);
            }
//            saveHttpTransferDataIfNecessary(driver, responseReceivedEvents);
        }
    }
//
//    // 保存网络请求
//    private static void saveHttpTransferDataIfNecessary(ChromeDriverProxy driver, List<ResponseReceivedEvent> responses) {
//        List<String> content = new ArrayList<>(1024);
//
//        for(ResponseReceivedEvent response : responses) {
//            String url = response.getResponse().getUrl();
//            boolean staticFiles = url.endsWith(".png")
//                    || url.endsWith(".jpg")
//                    || url.endsWith(".css")
//                    || url.endsWith(".ico")
//                    || url.endsWith(".js")
//                    || url.endsWith(".gif");
//
//            if(!staticFiles && url.startsWith("http")) {
//                content.add(url);
//                content.add(response.getResponse().getRequestHeadersText());
//                content.add(response.getResponse().getHeadersText());
//                // 使用上面开发的接口获取返回数据
//                ResponseBodyVo body = driver.getResponseBody(response.getRequestId());
//                if(body != null && body.getStatus() == 0) {
//                    content.add("base64Encoded:" + body.getValue().getBase64Encoded());
//                    content.add("body:\n" + body.getValue().getBody());
//                }
//                content.add("\n");
//            }
//        }
//        // 写文件至本地
//    }



}