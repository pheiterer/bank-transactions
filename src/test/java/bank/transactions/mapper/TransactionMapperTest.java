package bank.transactions.mapper;

import bank.transactions.domain.Transaction;
import bank.transactions.response.TransactionGetResponse;
import bank.transactions.util.TransactionsCreator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
class TransactionMapperTest {

    @InjectMocks
    private TransactionMapper transactionMapper;

    Transaction transaction = TransactionsCreator.createTransaction();

    TransactionGetResponse transactionGetResponse = TransactionsCreator.createTransactionGetResponse();

    @Test
    @DisplayName("toTransactionGetResponse() returns a TransactionGetResponse")
    void toTransactionGetResponse_ReturnsTransactionGetResponse_WhenSuccessful() {
        TransactionGetResponse transactionGetResponse = transactionMapper.toTransactionGetResponse(transaction);
        Assertions.assertThat(transactionGetResponse)
                .isEqualTo(this.transactionGetResponse);
    }

    @Test
    @DisplayName("toTransactionGetResponses() returns a List of TransactionGetResponse")
    void toTransactionGetResponses_ReturnsTransactionGetResponseList_WhenSuccessful() {
        List<TransactionGetResponse> transactionGetResponse = transactionMapper.toTransactionGetResponses(List.of(transaction));
        Assertions.assertThat(transactionGetResponse)
                .hasSize(1)
                .contains(this.transactionGetResponse);
    }

}