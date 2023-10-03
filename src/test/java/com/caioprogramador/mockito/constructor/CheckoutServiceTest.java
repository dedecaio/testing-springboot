package com.caioprogramador.mockito.constructor;

import org.junit.jupiter.api.Test;
import org.mockito.MockedConstruction;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class CheckoutServiceTest {

    @Test
    void testMockObjectConstruction(){
        try(MockedConstruction<PaymentProcessor> mockedConstruction = mockConstruction(PaymentProcessor.class,
                (mock,content) -> {
                    when(mock.chargeCustomer(anyString(),
                            any(BigDecimal.class))).thenReturn(BigDecimal.TEN);
                }))
        {
            CheckoutService service = new CheckoutService();
            BigDecimal result = service.purchaseProduct("MacBook Pro", "42");

            assertEquals(BigDecimal.TEN, result);
            assertEquals(1, mockedConstruction.constructed().size());
        }
    }


}