package bank.transactions.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class TransactionGetResponse {
    private String id;
    private String arrangementId;
    private String bookingDate;
    private String type;
    private String valueDate;
    private Double amount;
    private String currencyCode;
    private String currency;
    private CreditDebitIndicator creditDebitIndicator;
    private Double runningBalance;
    private String counterPartyAccountNumber;
    private String reference;
    private String typeGroup;
    private Double instructedAmount;

    public enum CreditDebitIndicator {
        CREDIT,
        DEBIT

    }
}


