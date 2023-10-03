package com.caioprogramador.mockito;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class SpyTest {

    @Test
    void test(){
        // Given
        List<String> mockArrayList = mock(ArrayList.class);

        // When & Then
        assertEquals(0, mockArrayList.size());

        when(mockArrayList.size()).thenReturn(5);

        mockArrayList.add("Foo-Bar");

        assertEquals(5, mockArrayList.size()) ;
    }


    @Test
    void testTwo(){
        // Given
        List<String> spyArrayList = spy(ArrayList.class);

        // When & Then
        assertEquals(0, spyArrayList.size());
        spyArrayList.add("Foo-Bar");

        assertEquals(1, spyArrayList.size());

        spyArrayList.remove("Foo-Bar");
        assertEquals(0, spyArrayList.size());
    }

    @Test
    void testThree(){
        List<String> spyArrayList = spy(ArrayList.class);

        assertEquals(0, spyArrayList.size());
        when(spyArrayList.size()).thenReturn(5);
        assertEquals(5, spyArrayList.size());
    }

    @Test
    void testFour(){
        List<String> spyArrayList = spy(ArrayList.class);
        spyArrayList.add("Foo-Bar");
        verify(spyArrayList).add("Foo-Bar");
        verify(spyArrayList, never()).remove(anyString());
        verify(spyArrayList, never()).clear();
    }
}
