package com.caioprogramador.mockito;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
public class HamcrestMatcherTest {



    @Test
    void testHamcrestMatchers(){
        // Given

        List<Integer> scores = Arrays.asList(99,100,101,105);

        // When & Then
        assertThat(scores, hasSize(4));
        assertThat(scores, hasItems(100,99));
        assertThat(scores, everyItem(greaterThan(97)));


        // Check Strings

        assertThat("", is(emptyOrNullString()));

         // Arrays

        Integer[] myArray = {1,2,3};
        assertThat(myArray, arrayWithSize(3));
    }
}
