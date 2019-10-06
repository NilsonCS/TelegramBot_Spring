package com.bot.bot.handler;


import com.bot.bot.models.telegram.TelegramUpdate;
import com.bot.bot.models.telegram.TelegramUser;
import com.bot.bot.service.GatoscBot;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

import java.util.Objects;
// manejamos el boton de ayuda para diferenciar entre los registrados y los que no
@Component
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class HelpTelegramMessageHandler implements TelegramMessageHandler {
    GatoscBot gatoscBot;

    @Override
    public void handle(TelegramUpdate telegramUpdate) {
        if (!telegramUpdate.getMessage().getText().startsWith(gatoscBot.HELP_BUTTON)) {
            return;
        }
        Long chatId = telegramUpdate.getMessage().getChat().getId();  // aca se maneja el boto de ayuda
        String text;
        if (Objects.isNull(telegramUpdate.getMessage().getFrom().getPerson())) {
            text = "La ayuda es solo para usuarios registrados";
        } else {
            text = "Le ayudaremos";
        }
        TelegramUser user = telegramUpdate.getMessage().getFrom();
        gatoscBot.sendTextMessage(chatId, text);
    }
}
