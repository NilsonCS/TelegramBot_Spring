package com.bot.bot.service;


import com.bot.bot.models.telegram.TelegramChat;
import com.bot.bot.models.telegram.TelegramMessage;
import com.bot.bot.models.telegram.TelegramUpdate;
import com.bot.bot.models.telegram.TelegramUser;
import com.bot.bot.repository.telegram.TelegramChatRepository;
import com.bot.bot.repository.telegram.TelegramMessageRepository;
import com.bot.bot.repository.telegram.TelegramUpdateRepository;
import com.bot.bot.repository.telegram.TelegramUserRepository;
import com.bot.bot.transformer.Transformer;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;

@Service
@Transactional
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class TelegramUpdateService {
    Transformer<Update, TelegramUpdate> updateToTelegramUpdateTransformer;
    Transformer<Message, TelegramMessage> messageToTelegramMessageTransformer;
    Transformer<User, TelegramUser> userToTelegramUserTransformer;
    Transformer<Chat, TelegramChat> chatToTelegramChatTransformer;
    TelegramUpdateRepository telegramUpdateRepository;
    TelegramMessageRepository telegramMessageRepository;
    TelegramUserRepository telegramUserRepository;
    TelegramChatRepository telegramChatRepository;

    public TelegramUpdate save(Update update) {
        TelegramUser telegramUser = telegramUserRepository.findById(update.getMessage().getFrom().getId())
                .orElseGet(() ->
                        telegramUserRepository.save(
                                userToTelegramUserTransformer.transform(update.getMessage().getFrom())
                        )
                );

        TelegramChat telegramChat = telegramChatRepository.findById(update.getMessage().getChat().getId())
                .orElseGet(() ->
                        {
                            TelegramChat transformedChat = chatToTelegramChatTransformer.transform(update.getMessage().getChat());
                            transformedChat.setUser(telegramUser);
                            return telegramChatRepository.save(transformedChat);
                        }
                );

        TelegramMessage telegramMessage = messageToTelegramMessageTransformer.transform(update.getMessage());
        telegramMessage.setFrom(telegramUser);
        telegramMessage.setChat(telegramChat);
        TelegramMessage savedTelegramMessage = telegramMessageRepository.save(telegramMessage);

        TelegramUpdate telegramUpdate = updateToTelegramUpdateTransformer.transform(update);
        telegramUpdate.setMessage(savedTelegramMessage);
        return telegramUpdateRepository.save(telegramUpdate);
    }
}
