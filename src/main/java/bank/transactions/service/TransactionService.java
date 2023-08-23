package bank.transactions.service;

import bank.transactions.domain.BankUser;
import bank.transactions.domain.Transaction;
import bank.transactions.mapper.TransactionMapper;
import bank.transactions.repository.TransactionRepository;
import bank.transactions.response.TransactionGetResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionService {

    TransactionMapper mapper = new TransactionMapper();
    private final TransactionRepository transactionRepository;

    public List<TransactionGetResponse> findAllByBankUser(BankUser bankUser) {
        List<Transaction> transactions = transactionRepository.findAllByBankUser(bankUser);
        return mapper.toTransactionGetResponses(transactions);
    }

}
