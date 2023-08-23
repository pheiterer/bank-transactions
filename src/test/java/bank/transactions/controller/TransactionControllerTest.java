package bank.transactions.controller;

import bank.transactions.domain.BankUser;
import bank.transactions.service.BankUserService;
import bank.transactions.service.TransactionService;
import bank.transactions.util.BankUserCreator;
import bank.transactions.util.TransactionsCreator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;


@WebMvcTest(TransactionController.class)
class TransactionControllerTest {
    private static final String URL = "/transactions";

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BankUserService bankUserService;

    @MockBean
    private TransactionService transactionService;


    BankUser user = BankUserCreator.create();

    @Test
    @DisplayName("getTransactionsJson() returns a list with the user transaction when successful")
    @WithMockUser(roles = "USER", username = "user")
    void getTransactionsJson_ReturnTransactions_WhenSuccessful() throws Exception {
        BDDMockito.when(bankUserService.findUserByUsername("user"))
                .thenReturn(user);
        BDDMockito.when(transactionService.findAllByBankUser(user))
                .thenReturn(List.of(TransactionsCreator.createTransactionGetResponse()));

        mockMvc.perform(MockMvcRequestBuilders.get(URL + "/123"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @DisplayName("getTransactionsJson() returns forbidden when userId not match")
    @WithMockUser(roles = "USER", username = "user")
    void getTransactionsJson_ReturnForbidden_WhenUserIdNotMatch() throws Exception {
        BDDMockito.when(bankUserService.findUserByUsername("user"))
                .thenReturn(user);
        BDDMockito.when(transactionService.findAllByBankUser(user))
                .thenReturn(List.of(TransactionsCreator.createTransactionGetResponse()));

        mockMvc.perform(MockMvcRequestBuilders.get(URL + "/1"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isForbidden());
    }

    @Test
    @DisplayName("getTransactionsJson() returns Unauthorized when user not logged")
    void getTransactionsJson_ReturnUnauthorized_WhenUserNotLogged() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(URL + "/1"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isUnauthorized());
    }


}

