package io.applova.client;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClients;
import org.springframework.stereotype.Component;

@Component
public class HttpClient {
    public CloseableHttpAsyncClient getClientConnection() {
        RequestConfig requestConfig = RequestConfig.custom()
                .setSocketTimeout(1000)
                .setConnectTimeout(1000).build();
        return HttpAsyncClients.custom()
                .setDefaultRequestConfig(requestConfig)
                .build();


    }
}
