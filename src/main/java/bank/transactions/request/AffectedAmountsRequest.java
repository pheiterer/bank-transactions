package bank.transactions.request;

import lombok.Data;

@Data
public
class AffectedAmountsRequest {
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
