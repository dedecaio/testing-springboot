package com.caioprogramador;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SimpleMathTestS4 {
    SimpleMath math;
    @BeforeEach
    void beforeEachMethod(){
        math = new SimpleMath();
    }

    @DisplayName("Test 6.2 / 2 = 3.1")
    @ParameterizedTest
    @MethodSource("testDivisionInputParameters")
    void testDivision(double firstNumber, double secondNumber, double expected){

        Double result = math.division(firstNumber, secondNumber);
        assertEquals(expected, result, 2D,
                firstNumber+ " / " + secondNumber +" did not produce "+expected);
    }

    public static Stream<Arguments> testDivisionInputParameters(){
        return Stream.of(
                Arguments.of(6.2D,2D,3.1D),
                Arguments.of(59D,2D,29.5D),
                Arguments.of(10D,3D,3.33D)
        );
    }


}