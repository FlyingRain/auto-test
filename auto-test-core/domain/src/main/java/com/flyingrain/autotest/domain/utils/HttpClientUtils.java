package com.flyingrain.autotest.domain.utils;

import com.flyingrain.autotest.common.util.AutoTestResultCodeEnum;
import com.flyingrain.autotest.common.util.RequestBodyTypeEnum;
import com.flyingrain.autotest.common.util.exception.AutoTestException;
import com.flyingrain.autotest.domain.core.executor.HttpEntityModel;
import com.flyingrain.autotest.domain.core.executor.HttpRequestBody;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

/**
 * @author wally
 * @date 2021-12-16
 */
public class HttpClientUtils {

    private static final Logger logger = LoggerFactory.getLogger(HttpClientUtils.class);

    private static final PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();

    static {
        cm.setDefaultMaxPerRoute(10);
        cm.setMaxTotal(200);
    }

    private static final RequestConfig requestConfig = RequestConfig.custom().setConnectionRequestTimeout(2000).setConnectTimeout(2000).setSocketTimeout(2000).build();

    private static final CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(cm).setDefaultRequestConfig(requestConfig).build();


    public static String post(String url, HttpRequestBody data,
                              Map<String, String> headerMap) {
        HttpPost httppost = new HttpPost(url);
        initPost(data, headerMap, httppost);
        try (CloseableHttpResponse response = httpClient.execute(httppost, HttpClientContext.create());) {
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

    private static void initPost(HttpRequestBody data, Map<String, String> headerMap, HttpPost httppost) {
        RequestBodyTypeEnum bodyTypeEnum = data.getRequestBodyTypeEnum();
        if (bodyTypeEnum == null) {
            bodyTypeEnum = RequestBodyTypeEnum.TEXT;
        }
        if (headerMap != null) {
            for (Map.Entry<String, String> entry : headerMap.entrySet()) {
                httppost.setHeader(entry.getKey(), entry.getValue());
            }
        }
        switch (bodyTypeEnum) {
            case FORM:
                MultipartEntityBuilder multipartEntityBuilder = MultipartEntityBuilder.create();
                List<HttpEntityModel> httpEntityModels = data.getEntities();
                for (HttpEntityModel httpModel : httpEntityModels) {

                }
                break;
            case TEXT:
                if (null != data.getContent() && !"".equals(data.getContent())) {
                    httppost.setEntity(new StringEntity(data.getContent(), StandardCharsets.UTF_8));
                }
                break;
            default:
                throw new AutoTestException(AutoTestResultCodeEnum.NOT_SUPPORT_DATA_TYPE);
        }

    }


    public static String get(String url, Map<String, String> head) {
        HttpGet httpget = new HttpGet(url);
        if (head != null) {
            for (Map.Entry<String, String> entry : head.entrySet()) {
                httpget.setHeader(entry.getKey(), entry.getValue());
            }
        }
        try (CloseableHttpResponse response = httpClient.execute(httpget,
                HttpClientContext.create());) {
            int statusCode = response.getStatusLine().getStatusCode();
            HttpEntity entity = response.getEntity();
            String result = EntityUtils.toString(entity, "utf-8");
            EntityUtils.consume(entity);
            if (statusCode == HttpStatus.SC_OK) {
                return result;
            } else {
                logger.error("http send status error!statusCode:[{}],result:[{}]", statusCode, result);
                return result;
            }
        } catch (IOException e) {
            logger.error("send http get error!", e);
            throw new AutoTestException(AutoTestResultCodeEnum.NETWORK_ERROR.getCode(), e.getMessage());
        }
    }

}
