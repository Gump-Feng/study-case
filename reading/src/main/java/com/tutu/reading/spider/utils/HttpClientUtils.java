package com.tutu.reading.spider.utils;

import org.apache.http.Header;
import org.apache.http.client.CookieStore;
import org.apache.http.config.SocketConfig;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.ssl.SSLContextBuilder;

import javax.net.ssl.SSLContext;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;

/**
 * @author hxf
 * @date 2019/3/20 13:34
 */
public class HttpClientUtils {
    /**
     * 跳过web验证
     *
     * @return CloseableHttpClient
     */
    public static CloseableHttpClient createSSLClientWithHandShakeProtocol() {
        try {
            SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, (chain, authType) -> true).build();
            SSLConnectionSocketFactory sslConnectionSocketFactory;
            sslConnectionSocketFactory = new SSLConnectionSocketFactory(
                    sslContext,
                    new String[]{"TLSv1", "TLSv1.1", "TLSv1.2", "SSLv3"},
                    new String[]{"TLS_RSA_WITH_AES_128_CBC_SHA256"},
                    SSLConnectionSocketFactory.getDefaultHostnameVerifier());

            SocketConfig socketConfig = SocketConfig.custom().setSoKeepAlive(false).setSoReuseAddress(true)
                    .setSoTimeout(10000).setTcpNoDelay(true).build();

            return HttpClients.custom().setSSLSocketFactory(sslConnectionSocketFactory).setDefaultSocketConfig(socketConfig).build();
        } catch (KeyManagementException | NoSuchAlgorithmException | KeyStoreException e) {
            e.printStackTrace();
        }
        return HttpClients.createDefault();
    }


    public static CloseableHttpClient createHttpClient() {
        return HttpClientBuilder.create().build();
    }

    public static CloseableHttpClient createSSLClientDefault() {
        try {
            //信任所有
            SSLContext sslContext;
            sslContext = new SSLContextBuilder().loadTrustMaterial(null, (chain, authType) -> true).build();
            SSLConnectionSocketFactory ssl = new SSLConnectionSocketFactory(sslContext);
            return HttpClients.custom().setSSLSocketFactory(ssl).build();
        } catch (KeyManagementException | NoSuchAlgorithmException | KeyStoreException e) {
            e.printStackTrace();
        }
        return HttpClients.createDefault();
    }

    public static void main(String[] args) {

    }

    public static CloseableHttpClient createSSLClientDefault(CookieStore cookieStore) {
        try {
            //信任所有
            SSLContext sslContext;
            sslContext = new SSLContextBuilder().loadTrustMaterial(null, (chain, authType) -> true).build();
            SSLConnectionSocketFactory ssl = new SSLConnectionSocketFactory(sslContext);
            return HttpClients.custom().setDefaultCookieStore(cookieStore).setSSLSocketFactory(ssl).build();
        } catch (KeyManagementException | NoSuchAlgorithmException | KeyStoreException e) {
            e.printStackTrace();
        }
        return HttpClients.createDefault();
    }

    public static Header[] getHeader(String refererVaslue) {
        Header header = new BasicHeader("Host", "weixin.sogou.com");
        Header uaHeader = new BasicHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.169 Safari/537.36");
        Header accept = new BasicHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3");
        Header encoding = new BasicHeader("Accept-Encoding", "gzip, deflate, br");
        Header upgrade = new BasicHeader("Upgrade-Insecure-Requests", "1");
        Header connection = new BasicHeader("Connection", "keep-alive");
        Header referer = new BasicHeader("Referer", refererVaslue);

        if (refererVaslue != null) {
            return new Header[]{header, uaHeader, accept, encoding, upgrade, connection, referer};

        } else {
            return new Header[]{header, uaHeader, accept, encoding, upgrade, connection};

        }
    }

}
