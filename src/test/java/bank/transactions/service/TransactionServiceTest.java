package bank.transactions.service;

import bank.transactions.domain.BankUser;
import bank.transactions.domain.Transaction;
import bank.transactions.repository.TransactionRepository;
import bank.transactions.response.TransactionGetResponse;
import bank.transactions.util.BankUserCreator;
import bank.transactions.util.TransactionsCreator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Collections;
import java.util.List;

@ExtendWith(SpringExtension.class)
class TransactionServiceTest {
    @InjectMocks
    private TransactionService transactionService;
    @Mock
    private TransactionRepository transactionRepository;

    BankUser bankUser = BankUserCreator.create();
    Transaction transaction = TransactionsCreator.createTransaction();

    @Test
    @DisplayName("findAllByBankUser() returns a List of TransactionGetResponse when Successful")
    void findAllByBankUser_ReturnsTransactionGetResponseList_WhenSuccessful() {
        BankUser user = bankUser;
        List<Transaction> transactions = List.of(transaction);

        BDDMockito.when(transactionRepository.findAllByBankUser(user))
                .thenReturn(transactions);

        List<TransactionGetResponse> allByBankUser = transactionService.findAllByBankUser(user);

        Assertions.assertThat(allByBankUser)
                .hasSize(transactions.size())
                .isNotNull();
    }

    @Test
    @DisplayName("findAllByBankUser() returns an Empty List when no BankUser")
    void findAllByBankUser_ReturnsEmptyList_WhenNoBankUser() {
        BankUser user = bankUser;
        List<Transaction> transactions = List.of(transaction);

        BDDMockito.when(transactionRepository.findAllByBankUser(user))
                .thenReturn(Collections.emptyList());

        List<TransactionGetResponse> allByBankUser = transactionService.findAllByBankUser(user);

        Assertions.assertThat(allByBankUser)
                .isNotNull()
                .isEmpty();
    }

}