package io.github.wesleyosantos91.person.ports.spi;

import io.github.wesleyosantos91.person.domain.PersonDomain;

public interface PersonDatabasePort {

    PersonDomain create(PersonDomain personDomain);
}
