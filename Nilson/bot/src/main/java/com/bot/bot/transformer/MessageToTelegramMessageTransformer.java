package com.bot.bot.transformer;

import com.bot.bot.models.telegram.TelegramMessage;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.time.LocalDateTime;

@Component
public class MessageToTelegramMessageTransformer implements Transformer<Message, TelegramMessage> {
    @Override
    public TelegramMessage transform(Message message) {
        return TelegramMessage.builder()
                .id(message.getMessageId())
                .creationDate(LocalDateTime.now())
                .text(message.getText())
                .build();
    }
}
