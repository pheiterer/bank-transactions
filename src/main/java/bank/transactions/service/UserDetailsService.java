package bank.transactions.service;

import bank.transactions.repository.BankUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {
    private final BankUserRepository bankUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        return bankUserRepository.findBankUserByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

}
