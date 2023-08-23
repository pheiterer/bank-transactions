package bank.transactions.repository;

import bank.transactions.domain.BankUser;
import bank.transactions.domain.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, String> {

    List<Transaction> findAllByBankUser(BankUser bankUser);
}
