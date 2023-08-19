package bank.transactions.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Array;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Transaction {
    @Id
    private Long id;
    private Long encodedKey;
    private LocalDateTime creationDate;
    private LocalDateTime valueDate;
    private Long parentAccountKey;
    private String type;
    private Double amount;
    private String currencyCode;

    @Embedded
    private AffectedAmounts affectedAmounts;

    @Embedded
    private Taxes taxes;

    @Embedded
    private AccountBalances accountBalances;

    @ManyToOne
    @JoinColumn(name = "userKey", referencedColumnName = "id")
    private User user;

    private Long branchKey;

    @Embedded
    private Terms terms;

    private String transactionDetails;

    @Embedded
    private TransferDetails transferDetails;

    @ElementCollection
    private List<Double> fees;
}

@Data
class AffectedAmounts {
    private Double fundsAmount;
    private Double interestAmount;
    private Double feesAmount;
    private Double overdraftAmount;
    private Double overdraftFeesAmount;
    private Double overdraftInterestAmount;
    private Double technicalOverdraftAmount;
    private Double technicalOverdraftInterestAmount;
    private Double fractionAmount;
}

@Data
class Taxes {}

@Data
class AccountBalances{
    private Double totalBalance;
}

@Data
class Terms{
    private String interestSettings;
    private String overdraftInterestSettings;
    private String overdraftSettings;
}

@Data
class TransferDetails{
    private String linkedDepositTransactionKey;
}



