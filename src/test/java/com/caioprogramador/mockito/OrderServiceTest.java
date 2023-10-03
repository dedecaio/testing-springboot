package com.caioprogramador.mockito;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import static org.mockito.Mockito.*;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {

    OrderService service = new OrderService();

    UUID defaultUuid = UUID.fromString("8d8b30e3-de52-4f1c-a71c-9905a8043dac");

    LocalDateTime defaultLocalDateTime = LocalDateTime.of(2023,7,4,15,30);

    @DisplayName("Should Include Random OrderId When No OrderId Exists")
    @Test
    void testShouldIncludeRandomOrderId_When_NoOrderIdExists(){
        // Given
        try (MockedStatic<UUID> mockedUuid = mockStatic(UUID.class)) {
            mockedUuid.when(UUID::randomUUID).thenReturn(defaultUuid);

            Order result = service.createOrder("MacBook Pro", 2L, null);

            assertEquals(defaultUuid.toString(), result.getId());

        }
    }

    @DisplayName("Should Include Current Time When Create a New Order")
    @Test
    void testShouldIncludeCurrentTime_When_CreateANewOrder(){
        // Given
        try (MockedStatic<LocalDateTime> mockedUuid = mockStatic(LocalDateTime.class)) {
            mockedUuid.when(LocalDateTime::now).thenReturn(defaultLocalDateTime);

            Order result = service.createOrder("MacBook Pro", 2L, null);

            assertEquals(defaultLocalDateTime, result.getCreationDate());

        }



    }
}