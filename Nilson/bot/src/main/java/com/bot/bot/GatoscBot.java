package com.bot.bot;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;



public class GatoscBot extends TelegramLongPollingBot {

    @Override
    public void onUpdateReceived(final Update update) {
        // Esta función se invocará cuando nuestro bot reciba un mensaje

        // Se obtiene el mensaje escrito por el usuario
        final String messageTextReceived = update.getMessage().getText();

        // Se obtiene el id de chat del usuario
        final long chatId = update.getMessage().getChatId();

        // Se crea un objeto mensaje
        SendMessage message = new SendMessage().setChatId(chatId).setText(messageTextReceived);

        try {
            // Se envía el mensaje
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }


}