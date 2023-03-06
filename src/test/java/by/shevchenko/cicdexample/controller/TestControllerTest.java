package by.shevchenko.cicdexample.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(TestController.class)
class TestControllerTest {
    @Autowired
    private  MockMvc mockMvc;
    @Test
    void getHello() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/test"))  // Сделай запрос в метод по адресу test
                .andDo(MockMvcResultHandlers.print())                  // Печатай все, что есть -> "hello world!"
                .andExpect(MockMvcResultMatchers.status().isOk())     // Говорим, что ждем статус 200 (Ок)
                .andExpect(MockMvcResultMatchers.content().string("hello world!"));
    }
}