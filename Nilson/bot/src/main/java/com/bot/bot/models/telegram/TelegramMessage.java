package com.bot.bot.models.telegram;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
@Data
@EqualsAndHashCode(of = {"id"})
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TelegramMessage {
    @Id
    Integer id;
    LocalDateTime creationDate;
    String text;
    @ManyToOne
    TelegramUser from;
    @ManyToOne
    TelegramChat chat;
}
