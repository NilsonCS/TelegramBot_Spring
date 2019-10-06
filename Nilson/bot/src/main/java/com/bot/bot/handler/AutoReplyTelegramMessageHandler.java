package com.bot.bot.handler;

import com.bot.bot.models.telegram.TelegramUpdate;
import com.bot.bot.models.telegram.TelegramUser;
import com.bot.bot.service.GatoscBot;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;
// aca manejamos como cada vez que se envie un mensaje el bot respondera lo q se envio
@Component
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class AutoReplyTelegramMessageHandler implements TelegramMessageHandler {
    GatoscBot gatoscBot;

    @Override
    public void handle(TelegramUpdate telegramUpdate) {
        if (telegramUpdate.getMessage().getText().startsWith(GatoscBot.START_COMMAND)
                || telegramUpdate.getMessage().getText().startsWith(GatoscBot.HELP_BUTTON)
                || telegramUpdate.getMessage().getText().startsWith(GatoscBot.HELLO_BUTTON)) {
            return;
        }
        Long chatId = telegramUpdate.getMessage().getChat().getId();  // en estas lineas se extrae el mensaje para luego ser reenviado al usuario
        TelegramUser user = telegramUpdate.getMessage().getFrom();
        String text = Stream.of(user.getLastName(), user.getFirstName(), "said:", telegramUpdate.getMessage().getText())
                .filter(Objects::nonNull)
                .collect(Collectors.joining(" "));
        gatoscBot.sendTextMessage(chatId, text);
    }
}
