package bank.transactions.service;

import bank.transactions.domain.Transaction;
import bank.transactions.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public List<Transaction> findAllById(String id){
        return transactionRepository.findAllById(Collections.singleton(id));
    }

    public void save(Transaction transactions) {
        transactionRepository.save(transactions);
    }
}
