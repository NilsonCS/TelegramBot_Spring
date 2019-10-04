package com.bot.bot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiException;



@SpringBootApplication
public class BotApplication {

	public static void main(String[] args) {

		SpringApplication.run(BotApplication.class, args);

		// Se inicializa el contexto de la API
		ApiContextInitializer.init();

		// Se crea un nuevo Bot API
		final TelegramBotsApi telegramBotsApi = new TelegramBotsApi();


		try {
			// Se registra el bot
			telegramBotsApi.registerBot(new GatoscBot());
		} catch (TelegramApiException e) {
			e.printStackTrace();
		}


	}

}


