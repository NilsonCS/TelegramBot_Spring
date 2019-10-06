package com.bot.bot.repository.telegram;

import com.bot.bot.models.telegram.TelegramUpdate;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "telegram_updates", path = "updates")
public interface TelegramUpdateRepository extends PagingAndSortingRepository<TelegramUpdate, Integer> {
}
