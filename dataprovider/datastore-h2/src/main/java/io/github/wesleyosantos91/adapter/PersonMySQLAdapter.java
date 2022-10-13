package io.github.wesleyosantos91.adapter;

import io.github.wesleyosantos91.person.domain.PersonDomain;
import io.github.wesleyosantos91.person.ports.spi.PersonDatabasePort;
import io.github.wesleyosantos91.respository.PersonRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import static io.github.wesleyosantos91.mapper.PersonMapper.INSTANCE;

@Component
@Primary
public class PersonMySQLAdapter implements PersonDatabasePort {

    private final PersonRepository repository;

    public PersonMySQLAdapter(PersonRepository repository) {
        this.repository = repository;
    }

    @Override
    public PersonDomain create(PersonDomain personDomain) {
         return INSTANCE.toDomain(repository.save(INSTANCE.toEntity(personDomain)));
    }
}
