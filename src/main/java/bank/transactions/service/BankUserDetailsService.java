package bank.transactions.service;

import bank.transactions.repository.BankUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BankUserDetailsService implements UserDetailsService {
    private final BankUserRepository bankUserRepository;
    @Override
    public UserDetails loadUserByUsername(String username){
        return Optional.ofNullable(bankUserRepository.findByUsername(username))
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

}
