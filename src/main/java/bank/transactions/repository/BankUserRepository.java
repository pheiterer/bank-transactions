package bank.transactions.repository;

import bank.transactions.domain.BankUser;
import bank.transactions.domain.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankUserRepository extends JpaRepository<BankUser, String> {

    BankUser findByUsername(String username);
}
