package com.caioprogramador;

import org.junit.jupiter.api.*;

//@TestMethodOrder(MethodOrderer.Random.class) Aleatório Por padrão ordena por nome
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class) // Você mesmo ordena com o @Order
@TestInstance(TestInstance.Lifecycle.PER_CLASS) // Para testes de integração - Ele roda todos os testes na mesma instância
public class FooBarTest {


    StringBuilder stringBuilder = new StringBuilder("");

    @AfterEach
    void afterEach(){
        System.out.println("The actual value is: "+stringBuilder);
    }

    @Test
//    @Order(3) // Esse funciona em classes de test tbm
    void testA(){
        stringBuilder.append("1");
        System.out.println("EAI");
    }
//    @Order(1)
    @Test
    void testB(){
        stringBuilder.append("2");
        System.out.println("EAI");
    }
//    @Order(2)
    @Test
    void testC(){
        stringBuilder.append("3");
        System.out.println("EAI");
    }
//    @Order(4)
    @Test
    void testD(){
        stringBuilder.append("4");
        System.out.println("EAI");
    }




}
