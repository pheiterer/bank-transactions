package bank.transactions.repository;

import bank.transactions.domain.BankUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BankUserRepository extends JpaRepository<BankUser, String> {

    Optional<BankUser> findBankUserByUsername(String username);
}
