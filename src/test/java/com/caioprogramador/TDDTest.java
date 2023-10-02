package com.caioprogramador;

import com.caioprogramador.service.IPersonService;
import com.caioprogramador.service.PersonService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TDDTest {


    IPersonService service;
    Person person;
    @BeforeEach
    void setup(){
        person = new Person(
                "Neymar",
                "Jr",
                "neymar@gmail.com",
                "Paris - FR",
                "Male"
        );
        service = new PersonService();
    }

    @DisplayName("When Create a Person with Success Should Return a Person Object")
    @Test
    void testCreatePerson_WhenSuccess_ShouldReturnPersonObject(){

        // Given


        // When
        Person actualPerson = service.createPerson(person);


        // Then
        assertNotNull(actualPerson, () -> "The createPerson should not have returned null!");

    }

    @DisplayName("When Create a Person with Success Should Contains Valid Fields in Returned Person Object")
    @Test
    void testCreatePerson_WhenSuccess_ShouldContainValidFieldsInReturnedPersonObject(){

        // Given


        // When
        Person actualPerson = service.createPerson(person);


        // Then
        assertEquals(person.getFirstName(),actualPerson.getFirstName(), () -> "The name of 'actualPerson' is different of 'person'!");
        assertNotEquals("Blumenau - BR", actualPerson.getAddress(), () -> "The address should not be equals to 'Blumenau - BR'");
        assertNotNull(person.getId(), () -> "The id should not be null!");
    }


    @DisplayName("When Create a Person With a Null Email Should Throw an Illegal Argument Exception")
    @Test
    void testCreatePerson_WithNullEmail_ShouldThrowIllegalArgumentException(){
        // Given
        person.setEmail(null);

        String expectedMessage = "The Person Email is null or empty!";

        // When
        // Then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> service.createPerson(person),
                () -> "Empty Email should have cause an IllegalArgumentException!");

        assertEquals(expectedMessage, exception.getMessage(), () -> "Invalid Exception message");
    }

}
