package bank.transactions.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@WebMvcTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TransactionControllerTest {
    private static final String URL = "/transactions";

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("getTransactionsJson() returns transactions.json")
    @Order(1)
    void getTransactionsJson_ReturnTransactions_WhenSuccessuful() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(URL))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isFound());
    }
}