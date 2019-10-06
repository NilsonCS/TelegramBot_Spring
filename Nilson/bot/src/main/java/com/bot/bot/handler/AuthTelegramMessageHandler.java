package com.bot.bot.handler;

import com.bot.bot.models.telegram.TelegramUpdate;
import com.bot.bot.models.telegram.TelegramUser;
import com.bot.bot.repository.PersonRepository;
import com.bot.bot.repository.telegram.TelegramUserRepository;
import com.bot.bot.service.GatoscBot;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

import java.util.Objects;
// esta clase sirve para autorizar a una persona y un usuario determinado que se conecta directamente entre usuria y pesonra en los modelos se ven los atributos
@Component
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class AuthTelegramMessageHandler implements TelegramMessageHandler {
    GatoscBot gatoscBot;
    PersonRepository personRepository;
    TelegramUserRepository telegramUserRepository;

    @Override
    public void handle(TelegramUpdate telegramUpdate) {
        if (!telegramUpdate.getMessage().getText().startsWith(GatoscBot.START_COMMAND)
                || Objects.nonNull(telegramUpdate.getMessage().getFrom().getPerson())) {
            return;
        }
        String authCode = telegramUpdate.getMessage().getText().replace(GatoscBot.START_COMMAND, "").trim();
        personRepository.findByAuthCode(authCode)
                .ifPresent(person -> {
                    TelegramUser user = telegramUpdate.getMessage().getFrom();
                    user.setPerson(person);
                    telegramUserRepository.save(user);

                    Long chatId = telegramUpdate.getMessage().getChat().getId();
                    String text = "Fuiste autorizado " + person.getName();
                    gatoscBot.sendTextMessage(chatId, text);
                });
    }
}
