package io.applova.sender.impl;

import io.applova.requestHandler.RequestHandler;
import io.applova.sender.SendRequest;
import org.apache.http.HttpResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.SECONDS;

@Component
public class SendRequest100TPS implements SendRequest {
    private Logger logger = LogManager.getLogger(SendRequest100TPS.class);
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private ExecutorService executor = Executors.newFixedThreadPool(1);
    private RequestHandler requestHandler;
    private int count = 0;
    private List<Future<HttpResponse>> httpResponseFuture = new ArrayList<>();

    @Autowired
    public SendRequest100TPS(RequestHandler requestHandler) {
        this.requestHandler = requestHandler;
    }

    @Override
    public void send(String url) {
        final Runnable send100Requests = () -> {
            count++;
            Future resFuture = executor.submit(() -> {
                try {
                    requestHandler.sendPostRequest(url, "");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            System.out.println("running " + count);
            httpResponseFuture.add(resFuture);

        };
        final ScheduledFuture<?> handleIn1Second =
                scheduler.scheduleAtFixedRate(send100Requests, 1, 10, MILLISECONDS);
        scheduler.schedule(new Runnable() {
            public void run() {
                handleIn1Second.cancel(false);
                logger.info("complete");

            }
        }, 1, SECONDS);
    }
}
