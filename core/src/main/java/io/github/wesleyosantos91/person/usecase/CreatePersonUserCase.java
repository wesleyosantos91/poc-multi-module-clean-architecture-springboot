package io.github.wesleyosantos91.person.usecase;

import io.github.wesleyosantos91.person.domain.PersonDomain;
import io.github.wesleyosantos91.person.ports.api.CreatePersonUserCasePort;
import io.github.wesleyosantos91.person.ports.spi.PersonDatabasePort;

public class CreatePersonUserCase implements CreatePersonUserCasePort {

    private final PersonDatabasePort personDatabasePort;

    public CreatePersonUserCase(PersonDatabasePort personDatabasePort) {
        this.personDatabasePort = personDatabasePort;
    }

    public PersonDomain create(PersonDomain personDomain) {
        return personDatabasePort.create(personDomain);
    }
}
