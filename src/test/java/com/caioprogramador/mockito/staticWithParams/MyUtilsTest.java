package com.caioprogramador.mockito.staticWithParams;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class MyUtilsTest {
    @Test
    void shouldMockStaticMethodWithParams(){
        try (MockedStatic<MyUtils> mockedStatic = mockStatic(MyUtils.class)){
            mockedStatic.when(() -> MyUtils.getWelcomeMessage(eq("Erudio"), anyBoolean()))
                    .thenReturn("Howdy Erudio!");

            String result = MyUtils.getWelcomeMessage("Erudio", false);
            assertThat(result, is("Howdy Erudio!"));
        }
    }
}