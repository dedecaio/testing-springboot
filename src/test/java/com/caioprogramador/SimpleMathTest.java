package com.caioprogramador;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
//@DisplayName("Test Math Operations in SimpleMath Class")
class SimpleMathTest {
    SimpleMath math;
    @BeforeEach
    void beforeEachMethod(){
        math = new SimpleMath();
    }

    @Test
    @DisplayName("Test 6.2 + 2 = 8.2")
    void testSum(){
        double firstNumber = 6.2D;
        double secondNumber = 2D;

        Double result = math.sum(firstNumber, secondNumber);
        Double expected = 8.2D;
        assertEquals(expected, result,
                firstNumber+ " - " + secondNumber +" did not produce "+expected);
    }

    @Test
    @DisplayName("Test Division By Zero")
    void testDivisionByZero(){
        //given
        double firstNumber = 6.2D;
        double secondNumber = 0D;
        assertThrows(ArithmeticException.class, ()->{
            //when & then
            math.division(firstNumber, secondNumber);
        });
    }


    @Test
    @DisplayName("Test 6.2 - 2 = 4.2")
    void testSubtraction(){
        // Given
        double firstNumber = 6.2D;
        double secondNumber = 2D;
        Double expected = 4.2D;

        // When
        Double result = math.subtraction(firstNumber, secondNumber);

        // Then
        assertEquals(expected, result,
                firstNumber+ " - " + secondNumber +" did not produce "+expected);
    }

    @Test
    @DisplayName("Test 6.2 * 2 = 12.4")
    void testMultiplication(){
        double firstNumber = 6.2D;
        double secondNumber = 2D;

        Double result = math.multiplication(firstNumber, secondNumber);
        Double expected = 12.4D;
        assertEquals(expected, result,
                firstNumber+ " * " + secondNumber +" did not produce "+expected);
    }

    @Test
    @DisplayName("Test 6.2 / 2 = 3.1")
    void testDivision(){
        double firstNumber = 6.2D;
        double secondNumber = 2D;

        Double result = math.division(firstNumber, secondNumber);
        Double expected = 3.1D;
        assertEquals(expected, result,
                firstNumber+ " / " + secondNumber +" did not produce "+expected);
    }

    @Test
    @DisplayName("Test (6.2 + 2)/2 = 4.1")
    void testMean(){
        double firstNumber = 6.2D;
        double secondNumber = 2D;

        Double result = math.mean(firstNumber, secondNumber);
        Double expected = 4.1D;
        assertEquals(expected, result,
               "("+firstNumber+ " + " + secondNumber +")/2 did not produce "+expected);
    }


    @RepeatedTest(3)
    @DisplayName("Test sqrt(38.44) = 6.2")
    void testSquare(){
        double firstNumber = 38.44D;

        Double result = math.squareRoot(firstNumber);
        Double expected = 6.2D;
        assertEquals(expected, result,
                firstNumber+"² did not produce "+expected);
    }



}