package bank.transactions.domain.transactions.subclass;

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
