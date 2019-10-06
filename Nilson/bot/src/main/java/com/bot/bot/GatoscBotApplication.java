package com.bot.bot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.ApiContextInitializer;


@SpringBootApplication
public class GatoscBotApplication {

    public static void main(String[] args) {
        ApiContextInitializer.init();
        SpringApplication.run(GatoscBotApplication.class, args);
    }

}
