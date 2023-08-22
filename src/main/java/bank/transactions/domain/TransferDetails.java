package bank.transactions.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public
class TransferDetails {
    private String linkedDepositTransactionKey;
}
