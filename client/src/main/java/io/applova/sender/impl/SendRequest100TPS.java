package io.applova.sender.impl;

import io.applova.client.HttpClient;
import io.applova.sender.SendRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.*;

@Component
public class SendRequest100TPS implements SendRequest {
    @Autowired
    HttpClient httpClient;
    Logger logger= LogManager.getLogger(SendRequest100TPS.class);
    final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private int count=0;
    @Override
    public void send() {
        final Runnable task = new Runnable() {
            public void run() {
                count++;
                System.out.println("running "+count);
            }
        };
        final ScheduledFuture<?> handle =
                scheduler.scheduleAtFixedRate(task, 1, 10, MILLISECONDS);
        scheduler.schedule(new Runnable() {
            public void run() { handle.cancel(true); }
        }, 1, SECONDS);
    }
}
