package com.bot.bot.transformer;

import com.bot.bot.models.telegram.TelegramUser;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.User;

import java.time.LocalDateTime;

@Component
public class UserToTelegramUserTransformer implements Transformer<User, TelegramUser> {
    @Override
    public TelegramUser transform(User user) {
        return TelegramUser.builder()
                .id(user.getId())
                .creationDate(LocalDateTime.now())
                .userName(user.getUserName())
                .bot(user.getBot())
                .lastName(user.getLastName())
                .firstName(user.getFirstName())
                .languageCode(user.getLanguageCode())
                .build();
    }
}
