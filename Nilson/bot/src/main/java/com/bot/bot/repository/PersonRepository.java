package com.bot.bot.repository;

import com.bot.bot.models.Person;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource(collectionResourceRel = "persons", path = "persons")
public interface PersonRepository extends PagingAndSortingRepository<Person, Integer> {
    Optional<Person> findByAuthCode(String authCode);
}
