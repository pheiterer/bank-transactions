package bank.transactions.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public
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
