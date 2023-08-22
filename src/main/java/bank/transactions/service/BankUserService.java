package bank.transactions.service;

import bank.transactions.domain.BankUser;
import bank.transactions.repository.BankUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BankUserService {

    private final BankUserRepository bankUserRepository;

    public BankUser findUser(String id){
        return bankUserRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not Found"));
    }

}
