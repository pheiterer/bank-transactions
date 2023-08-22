package bank.transactions.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Data
public class Transaction {
    @Id
    private String id;
    private String encodedKey;
    private String creationDate;
    private String valueDate;
    private String parentAccountKey;
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
    @JoinColumn(name = "user_key", nullable=false)
    private BankUser bankUser;

    private String branchKey;

    @Embedded
    private Terms terms;

    @Embedded
    private TransactionDetails transactionDetails;

    @Embedded
    private TransferDetails transferDetails;

    @ElementCollection
    private List<Double> fees;
}



