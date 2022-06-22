package com.mariana.base64project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.net.SocketFactory;
import java.net.Socket;

@SpringBootApplication
public class Base64ProjectApplication {

    public static void main (String [] args) throws Exception{
    SpringApplication.run(Base64ProjectApplication.class, args);
    }
}
