package com.caioprogramador.business;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class ListTest {

    @Test
    void testMockingList_When_SizeIsCalled_ShouldReturn10(){
        // Given
        List<?> list = mock(List.class);
        when(list.size()).thenReturn(10);

        // When & Then
        assertEquals(10, list.size());

    }

    @Test
    void testMockingList_When_SizeIsCalled_ShouldReturnMultipleValues(){
        // Given
        List<?> list = mock(List.class);
        when(list.size()).thenReturn(10).thenReturn(21).thenReturn(27);

        // When & Then
        assertEquals(10, list.size());

        assertEquals(21, list.size());

        assertEquals(27, list.size());

    }
    @Test
    void testMockingList_When_GetIsCalled_ShouldReturnErudio(){
        // Given
        List<String> list = mock(List.class);
        when(list.get(0)).thenReturn("Erudio");

        // When & Then
        assertEquals("Erudio", list.get(0));
    }

    @Test
    void testMockingList_When_GetIsCalledWithArgumentMatcher_ShouldReturnErudio(){
        // Given
        List<String> list = mock(List.class);
        when(list.get(anyInt())).thenReturn("Erudio");

        // When & Then
        assertEquals("Erudio", list.get(0));
        assertEquals("Erudio", list.get(344));
        assertEquals("Erudio", list.get(23));
        assertEquals("Erudio", list.get(21));
    }

    @Test
    void testMockingList_When_ThroesAnException(){
        // Given
        List<String> list = mock(List.class);
        when(list.get(anyInt())).thenThrow(new RuntimeException("Foo Bar!"));

        // When & Then
        assertThrows(RuntimeException.class, () -> {
            list.get(anyInt());
        }, () -> "Should have throw an RuntimeException");

    }



}
