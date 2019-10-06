package com.bot.bot.handler;

import com.bot.bot.models.telegram.TelegramUpdate;

public interface TelegramMessageHandler {
    void handle(TelegramUpdate telegramUpdate);
}
