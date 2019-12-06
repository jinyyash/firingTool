package io.applova.requestHandler;

import org.apache.http.client.methods.CloseableHttpResponse;

import java.io.IOException;

public interface RequestHandler {
    CloseableHttpResponse sendPostRequest(String url, String jsonString) throws IOException;
}
