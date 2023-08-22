package bank.transactions.request;

import lombok.Data;

@Data
public
class TransferDetailsRequest {
    private String linkedDepositTransactionKey;
}
