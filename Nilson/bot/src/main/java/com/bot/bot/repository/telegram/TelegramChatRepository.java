package com.bot.bot.repository.telegram;

import com.bot.bot.models.telegram.TelegramChat;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource(collectionResourceRel = "telegram_chats", path = "chats")
public interface TelegramChatRepository extends PagingAndSortingRepository<TelegramChat, Long> {
    Optional<TelegramChat> findByUser_Id(Integer userId);

    Optional<TelegramChat> findByUser_Person_Id(Integer personId);
}
