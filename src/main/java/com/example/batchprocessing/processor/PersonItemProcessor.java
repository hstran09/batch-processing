package com.example.batchprocessing.processor;

import com.example.batchprocessing.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

public class PersonItemProcessor implements ItemProcessor<Person, Person> {

    private static final Logger log = LoggerFactory.getLogger(PersonItemProcessor.class);

    public Person process(Person item) {

        if (item == null) {
            return null;
        }

        final Person transformedPerson = new Person(item.getFirstNameOrNull().toUpperCase(), item.getLastNameOrNull().toUpperCase());

        log.info("Converting from {} to {})", item, transformedPerson);

        return transformedPerson;
    }
}
