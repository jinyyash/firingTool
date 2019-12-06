package io.applova.requestHandler.impl;

import io.applova.client.HttpClient;
import io.applova.requestHandler.RequestHandler;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.BasicHttpEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
@Component
public class RequestHandlerImpl implements RequestHandler {
    private HttpClient httpClient;

    @Autowired
    public RequestHandlerImpl(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public CloseableHttpResponse sendPostRequest(String url, String jsonString) throws IOException {
        HttpPost post = new HttpPost(url);
        InputStream inputStream = new ByteArrayInputStream(jsonString.getBytes(StandardCharsets.UTF_8));
        BasicHttpEntity requestEntity = new BasicHttpEntity();
        requestEntity.setContent(inputStream);
        post.setEntity(requestEntity);
        return httpClient.getClientConnection().execute(post);
    }
}
