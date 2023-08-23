package bank.transactions.util;

import bank.transactions.domain.BankUser;
import bank.transactions.domain.Transaction;
import bank.transactions.domain.transactions.subclass.AccountBalances;
import bank.transactions.domain.transactions.subclass.AffectedAmounts;
import bank.transactions.domain.transactions.subclass.Taxes;
import bank.transactions.response.TransactionGetResponse;

public class TransactionsCreator {
    public static Transaction createTransaction() {
        return Transaction.builder()
                .id("123")
                .creationDate("")
                .accountBalances(new AccountBalances(0.0))
                .affectedAmounts(new AffectedAmounts(
                        0.0,
                        0.0,
                        0.0,
                        0.0,
                        0.0,
                        0.0,
                        0.0,
                        0.0,
                        0.0))
                .amount(0.0)
                .bankUser(new BankUser("123", null, null, null, null))
                .branchKey("")
                .currencyCode("")
                .encodedKey("")
                .fees(null)
                .parentAccountKey("")
                .taxes(new Taxes())
                .terms(null)
                .transactionDetails(null)
                .transferDetails(null)
                .type("")
                .valueDate("")
                .build();
    }

    public static TransactionGetResponse createTransactionGetResponse() {
        return TransactionGetResponse.builder()
                .id("")
                .arrangementId("")
                .bookingDate("")
                .type("")
                .valueDate("")
                .amount(0.0)
                .currencyCode("")
                .currency("")
                .creditDebitIndicator(TransactionGetResponse.CreditDebitIndicator.CREDIT)
                .runningBalance(0.0)
                .counterPartyAccountNumber("123")
                .reference("")
                .typeGroup("")
                .instructedAmount(0.0)
                .build();
    }


}
