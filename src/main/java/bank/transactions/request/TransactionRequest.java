package bank.transactions.request;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class TransactionRequest {
    @Id
    private String id;
    private String encodedKey;
    private String creationDate;
    private String valueDate;
    private String parentAccountKey;
    private String type;
    private Double amount;
    private String currencyCode;
    private String userKey;
    private String branchKey;

    private AffectedAmountsRequest affectedAmounts;
    
    private TaxesRequest taxes;
    
    private AccountBalancesRequest accountBalances;

    private TermsRequest terms;

    private TransactionDetailsRequest transactionDetails;

    private TransferDetailsRequest transferDetails;

    @ElementCollection
    private List<Double> fees;
}

@Data
class TaxesRequest {
}

class InterestSettingsRequest {
}

class OverdraftInterestSettingsRequest {
}

class OverdraftSettingsRequest {
}

@Data
class TransactionDetailsRequest {
}



