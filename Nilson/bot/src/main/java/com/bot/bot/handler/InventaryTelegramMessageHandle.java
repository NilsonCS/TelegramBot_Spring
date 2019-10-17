package com.bot.bot.handler;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

public class InventaryTelegramMessageHandle extends TelegramLongPollingBot {
    @Override
    public void onUpdateReceived(Update update) {

        System.out.println(update.getMessage().getFrom().getFirstName()+ ": " +update.getMessage().getText());
        

    }

    @Override
    public String getBotUsername() {
        return null;
    }

    @Override
    public String getBotToken() {
        return null;
    }
}
