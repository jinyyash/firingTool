package io.applova.boot;

import io.applova.sender.SendRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.tanukisoftware.wrapper.WrapperListener;
import org.tanukisoftware.wrapper.WrapperManager;

import java.util.concurrent.Executors;


@SpringBootApplication
@ComponentScan("io.applova")
/*public class Boot implements WrapperListener
{
    public static void main( String[] args )
    {
        WrapperManager.start(new Boot() , args);
    }

    @Override
    public Integer start(String[] strings) {
        Executors.newSingleThreadExecutor().execute(() -> SpringApplication.run(Boot.class, strings));
        return null;
    }

    @Override
    public int stop(int i) {
        return 0;
    }

    @Override
    public void controlEvent(int i) {

    }
}*/
public class Boot implements CommandLineRunner {
    @Autowired
    SendRequest sendRequest;
    public static void main( String[] args )
    {
        SpringApplication.run(Boot.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        sendRequest.send();
    }
}
