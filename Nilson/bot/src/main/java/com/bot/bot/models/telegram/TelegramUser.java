package com.bot.bot.models.telegram;

import lombok.*;
import lombok.experimental.FieldDefaults;

import com.bot.bot.models.Person;
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
public class TelegramUser {
    @Id
    Integer id;
    LocalDateTime creationDate;
    String userName;
    Boolean bot;
    String lastName;
    String firstName;
    String languageCode;

    @ManyToOne
    Person person;
}
