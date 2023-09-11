package com.caioprogramador;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class ArrayCompareTest {

    @Test
    void test(){
        int[] numbers = {25,8,21,32,3};
        int[] expected = {3,8,21,25,32};

        Arrays.sort(numbers);

        assertArrayEquals(numbers, expected);
    }

}
