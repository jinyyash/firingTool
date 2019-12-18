package io.applova;

import io.applova.sender.SendRequest;
import io.applova.sender.impl.SendRequest100TPS;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockserver.client.MockServerClient;
import org.mockserver.integration.ClientAndServer;
import org.mockserver.verify.VerificationTimes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.mockserver.integration.ClientAndServer.startClientAndServer;
import static org.mockserver.matchers.Times.exactly;
import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;

@SpringBootTest(classes = {SendRequest100TPS.class, SendRequest.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class ClientTest {
    private static ClientAndServer mockServer;
    @Autowired
    SendRequest sendRequest;

    @BeforeClass
    public static void startServer() {
        mockServer = startClientAndServer(1080);

    }


    @Test
    public void testPostRequestMockServer_thenServerReceived() {
        sendRequestToClients();
        createExpectationForRequest();
        verifyPostRequest();

    }

    private void verifyPostRequest() {
        String jsonString = "";

        new MockServerClient("127.0.0.1", 1080).verify(
                request()
                        .withMethod("POST")
                        .withHeader("User-Agent", "Apache-HttpClient/4.5.10 (Java/12.0.2)")
                        .withHeader("Connection", "Keep-Alive")
                        .withPath("/request")
                        .withBody((jsonString))
                        .withKeepAlive(true)
                        .withSecure(false),

                VerificationTimes.exactly(100)
        );
        System.out.println("te");
    }

    private void createExpectationForRequest() {
        String jsonString = "";
        mockServer.when(request().withMethod("POST")
                        .withPath("/request")
                        .withHeader("User-Agent", "Apache-HttpClient/4.5.10 (Java/12.0.2)")
                        .withHeader("Connection", "Keep-Alive")
                        .withBody((jsonString))
                        .withKeepAlive(true)
                        .withSecure(false),
                exactly(100))
                .respond(response().withStatusCode(200));

    }

    private void sendRequestToClients() {
        sendRequest.send("http://localhost:1080/request");
    }
}
