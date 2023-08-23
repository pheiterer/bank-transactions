package bank.transactions.service;

import bank.transactions.domain.BankUser;
import bank.transactions.repository.BankUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BankUserService {

    private final BankUserRepository bankUserRepository;

    public BankUser findUserByUsername(String username) {
        return bankUserRepository.findBankUserByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not Found"));
    }
}
