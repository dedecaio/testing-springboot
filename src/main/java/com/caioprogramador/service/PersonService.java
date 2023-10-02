package com.caioprogramador.service;

import com.caioprogramador.Person;

import java.util.concurrent.atomic.AtomicLong;

public class PersonService implements IPersonService {
    @Override
    public Person createPerson(Person person) {
        if (person.getEmail() == null || person.getEmail().isBlank())
            throw new IllegalArgumentException("The Person Email is null or empty!");
        Long id = new AtomicLong().incrementAndGet();
        person.setId(id);
        return person;
    }
}
