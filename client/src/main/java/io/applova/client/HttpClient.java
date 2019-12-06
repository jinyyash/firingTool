package io.applova.client;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HttpClient {
    public CloseableHttpClient getClientConnection() {
        return HttpClientBuilder.create().disableContentCompression().build();

    }
}
