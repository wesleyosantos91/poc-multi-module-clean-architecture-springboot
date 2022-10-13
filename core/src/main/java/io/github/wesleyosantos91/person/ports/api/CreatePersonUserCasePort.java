package io.github.wesleyosantos91.person.ports.api;

import io.github.wesleyosantos91.person.domain.PersonDomain;

public interface CreatePersonUserCasePort {

    PersonDomain create(PersonDomain personDomain);
}
