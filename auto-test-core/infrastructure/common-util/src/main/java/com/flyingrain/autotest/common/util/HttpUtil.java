package com.flyingrain.autotest.common.util;

import com.flyingrain.autotest.common.util.exception.AutoTestException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HttpUtil {

    private final  static Logger logger = LoggerFactory.getLogger(HttpUtil.class);
    private static final PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();

    static {
        cm.setDefaultMaxPerRoute(10);
        cm.setMaxTotal(200);
    }

    private static final RequestConfig requestConfig = RequestConfig.custom().setConnectionRequestTimeout(2000).setConnectTimeout(2000).setSocketTimeout(2000).build();

    private static final CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(cm).setDefaultRequestConfig(requestConfig).build();


    public static String postFormUrlEncoded(String url, Map<String, String> headers, Map<String, String> params) {
        HttpPost httpPost = new HttpPost(url);
        if (headers == null) {
            headers = new HashMap<>();
        }
        headers.put("Content-Type", "application/x-www-form-urlencoded");
        initHeader(httpPost, headers);
        if (!CollectionUtils.isEmpty(params)) {
            List<NameValuePair> body = new ArrayList<>();
            params.forEach((k, v) -> {
                body.add(new BasicNameValuePair(k, v));
            });
            HttpEntity entity = new UrlEncodedFormEntity(body, StandardCharsets.UTF_8);
            httpPost.setEntity(entity);
        }
        try (CloseableHttpResponse response = httpClient.execute(httpPost, HttpClientContext.create());) {
            int statusCode = response.getStatusLine().getStatusCode();
            HttpEntity entity = response.getEntity();
            String result = EntityUtils.toString(entity, "utf-8");
            if (statusCode == HttpStatus.SC_OK) {
                return result;
            } else {
                logger.error("send http post error!return status:[{}],result:[{}]", statusCode, result);
                return result;
            }
        } catch (Exception e) {
            logger.error("send http error!", e);
            throw new AutoTestException(AutoTestResultCodeEnum.NETWORK_ERROR.getCode(), e.getMessage());
        }

    }

    private static void initHeader(HttpPost httpPost, Map<String, String> headers) {
        headers.forEach(httpPost::setHeader);
    }


}
