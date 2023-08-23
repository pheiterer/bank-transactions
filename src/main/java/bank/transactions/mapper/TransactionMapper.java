package bank.transactions.mapper;


import bank.transactions.domain.Transaction;
import bank.transactions.response.TransactionGetResponse;

import java.util.ArrayList;
import java.util.List;

import static bank.transactions.response.TransactionGetResponse.CreditDebitIndicator.CREDIT;
import static bank.transactions.response.TransactionGetResponse.CreditDebitIndicator.DEBIT;

public class TransactionMapper {

    public TransactionGetResponse toTransactionGetResponse(Transaction transaction) {
        return new TransactionGetResponse(
                transaction.getEncodedKey(),
                transaction.getParentAccountKey(),
                transaction.getCreationDate(),
                transaction.getType(),
                transaction.getValueDate(),
                transaction.getAmount(),
                transaction.getCurrencyCode(),
                transaction.getCurrencyCode(),
                transaction.getAmount() < 0 ? DEBIT : CREDIT,
                transaction.getAccountBalances().getTotalBalance(),
                transaction.getId(),
                transaction.getParentAccountKey(),
                transaction.getType(),
                transaction.getAmount()
        );
    }

    public List<TransactionGetResponse> toTransactionGetResponses(List<Transaction> transactions) {

        List<TransactionGetResponse> list = new ArrayList<>(transactions.size());
        for (Transaction transaction : transactions) {
            list.add(toTransactionGetResponse(transaction));
        }

        return list;
    }
}
