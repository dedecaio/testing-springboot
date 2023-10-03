package com.caioprogramador.business;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.*;


public class ListBDDTest {

    @Test
    void testMockingList_When_SizeIsCalled_ShouldReturn10(){
        // Given
        List<?> list = mock(List.class);
        given(list.size()).willReturn(10);

        // When & Then
        assertThat(list.size(), is(10));

    }

    @Test
    void testMockingList_When_SizeIsCalled_ShouldReturnMultipleValues(){
        // Given
        List<?> list = mock(List.class);
        given(list.size()).willReturn(10).willReturn(21).willReturn(27);

        // When & Then
        assertThat(list.size(), is(10));
        assertThat(list.size(), not(10));
        assertThat(list.size(), not(10));

    }
    @Test
    void testMockingList_When_GetIsCalled_ShouldReturnErudio(){
        // Given
        List list = mock(List.class);
        given(list.get(0)).willReturn("Erudio");

        // When & Then
        assertThat(list.get(0), is("Erudio"));
    }

    @Test
    void testMockingList_When_GetIsCalledWithArgumentMatcher_ShouldReturnErudio(){
        // Given
        List<String> list = mock(List.class);
        given(list.get(anyInt())).willReturn("Erudio");

        // When & Then
        assertThat(list.get(0), is("Erudio"));
        assertThat(list.get(123), is("Erudio"));
        assertThat(list.get(312), is("Erudio"));
        assertThat(list.get(231), is("Erudio"));
    }

    @Test
    void testMockingList_When_ThroesAnException(){
        // Given
        List<String> list = mock(List.class);
        given(list.get(anyInt())).willThrow(new RuntimeException("Foo Bar!"));

        // When & Then
        assertThat(list.get(anyInt()), is(RuntimeException.class));

    }



}
