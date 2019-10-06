package com.bot.bot.repository.telegram;



import com.bot.bot.models.telegram.TelegramMessage;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "telegram_messages", path = "messages")
public interface TelegramMessageRepository extends PagingAndSortingRepository<TelegramMessage, Integer> {
}
