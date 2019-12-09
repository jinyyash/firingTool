package io.applova.requestHandler;

import org.apache.http.HttpResponse;

import java.io.IOException;
import java.util.concurrent.Future;

public interface RequestHandler {
   Future<HttpResponse> sendPostRequest(String url, String jsonString) throws IOException;
}
