package bank.transactions.mapper;


import bank.transactions.domain.*;
import bank.transactions.request.*;

public class TransactionMapper {

    public Transaction toTransaction(TransactionRequest transactionRequest) {
        return new Transaction(
                transactionRequest.getId(),
                transactionRequest.getEncodedKey(),
                transactionRequest.getCreationDate(),
                transactionRequest.getValueDate(),
                transactionRequest.getParentAccountKey(),
                transactionRequest.getType(),
                transactionRequest.getAmount(),
                transactionRequest.getCurrencyCode(),
                this.toAffectedAmounts(transactionRequest.getAffectedAmounts()),
                new Taxes(),
                this.toAccountBalances(transactionRequest.getAccountBalances()),
                null,
                transactionRequest.getBranchKey(),
                this.toTerms(),
                new TransactionDetails(),
                this.toTransferDetails(transactionRequest.getTransferDetails()),
                transactionRequest.getFees()
                );
    }

    private AffectedAmounts toAffectedAmounts(AffectedAmountsRequest affectedAmountsRequest) {
        return new AffectedAmounts(
                affectedAmountsRequest.getFeesAmount(),
                affectedAmountsRequest.getFundsAmount(),
                affectedAmountsRequest.getFractionAmount(),
                affectedAmountsRequest.getInterestAmount(),
                affectedAmountsRequest.getOverdraftFeesAmount(),
                affectedAmountsRequest.getOverdraftAmount(),
                affectedAmountsRequest.getOverdraftInterestAmount(),
                affectedAmountsRequest.getTechnicalOverdraftAmount(),
                affectedAmountsRequest.getTechnicalOverdraftInterestAmount()
        );
    }

    private AccountBalances toAccountBalances(AccountBalancesRequest accountBalanceRequest) {
        return new AccountBalances(
                accountBalanceRequest.getTotalBalance()
        );
    }

    private Terms toTerms(){
        return new Terms(
                new InterestSettings(),
                new OverdraftInterestSettings(),
                new OverdraftSettings()
        );
    }

    private TransferDetails toTransferDetails(TransferDetailsRequest transferDetailsRequest){
        return new TransferDetails(
                transferDetailsRequest.getLinkedDepositTransactionKey()
        );
    }

}
