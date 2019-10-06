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
 // este manejador sirve para devolver al usuario  el saludo con su nombre  solo en caso de que el usuario escriba "hello"
@Component
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class HelloTelegramMessageHandler implements TelegramMessageHandler {
    GatoscBot gatoscBot;

    @Override
    public void handle(TelegramUpdate telegramUpdate) {
        if (!telegramUpdate.getMessage().getText().startsWith(GatoscBot.START_COMMAND)
                && !telegramUpdate.getMessage().getText().equals(GatoscBot.HELLO_BUTTON)) {
            return;
        }
        Long chatId = telegramUpdate.getMessage().getChat().getId();
        TelegramUser user = telegramUpdate.getMessage().getFrom();
        String text = Stream.of("Hola,", user.getLastName(), user.getFirstName())
                .filter(Objects::nonNull)
                .collect(Collectors.joining(" "));
        gatoscBot.sendTextMessage(chatId, text);
    }
}
