package com.example.springbootrestfuldemo.common.config;

import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * @author sh on 2019/3/24 20:23
 * @version ideaIU-2018.2.3.win_home
 */
@Configuration
public class RestTemplateConfig {

    @Bean
    public RestTemplate getRestTemplate(@Qualifier("httpRequestFactory") ClientHttpRequestFactory httpRequestFactory) {
        RestTemplate restTemplate = new RestTemplate(httpRequestFactory);

        return restTemplate;

    }

    /**
     * 工厂
     * @param httpClient http客户端
     * @return
     */
    @Bean("httpRequestFactory")
    public ClientHttpRequestFactory httpRequestFactory(@Qualifier("httpClient") HttpClient httpClient) {
        return new HttpComponentsClientHttpRequestFactory(httpClient);
    }
    @Bean("httpClient")
    public HttpClient getHttpClient(@Qualifier("poolingHttpClientConnectionManager") PoolingHttpClientConnectionManager connectionManager ,
                                 @Qualifier("requestConfig") RequestConfig requestConfig) {



        return HttpClientBuilder.create()
                // 请求配置
                .setDefaultRequestConfig(requestConfig)
                // 设置连接管理
                .setConnectionManager(connectionManager)
                .build();
    }

    /**
     * 连接池管理
     * @return 连接池
     */
    @Bean(name="poolingHttpClientConnectionManager")
    public PoolingHttpClientConnectionManager getConnectionManager() {
        Registry<ConnectionSocketFactory> registry = RegistryBuilder.<ConnectionSocketFactory>create()
                .register("http", PlainConnectionSocketFactory.getSocketFactory())
                .register("https", SSLConnectionSocketFactory.getSocketFactory())
                .build();
        return new PoolingHttpClientConnectionManager(registry);
        // 此处可设置连接池属性，此处保持默认

    }
    @Bean("requestConfig")
    public RequestConfig getRequestConfig() {
        return RequestConfig.custom()
                //连接上服务器(握手成功)的时间，超出(10秒)抛出connect timeout
                .setConnectTimeout(10000)
                //服务器返回数据(response)的时间，超过(20秒)抛出read timeout
                .setSocketTimeout(20000)
                //从连接池中获取连接的超时时间，超时间未拿到可用连接，会抛出org.apache.http.conn.ConnectionPoolTimeoutException: Timeout waiting for connection from pool
                .setConnectionRequestTimeout(100)
                .build();
    }

}
