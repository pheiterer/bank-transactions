package bank.transactions.service;

import bank.transactions.domain.BankUser;
import bank.transactions.repository.BankUserRepository;
import bank.transactions.util.BankUserCreator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;


@ExtendWith(SpringExtension.class)
class BankUserServiceTest {

    @InjectMocks
    private BankUserService bankUserService;

    @Mock
    private BankUserRepository bankUserRepository;

    BankUser bankUser = BankUserCreator.create();

    @Test
    @DisplayName("findUserByUsername() returns a BankUser when successful")
    void findUserByUsername_ReturnsBankUser_WhenSuccessful() {
        BankUser user = this.bankUser;

        BDDMockito.when(bankUserRepository.findBankUserByUsername(user.getUsername()))
                .thenReturn(Optional.of(user));

        BankUser bankUserOptional = bankUserService.findUserByUsername(user.getUsername());

        Assertions.assertThat(bankUserOptional)
                .isNotNull()
                .isEqualTo(this.bankUser);
    }

    @Test
    @DisplayName("findUserByUsername() throw a RuntimeException when username not exist")
    void findUserByUsername_ThrowRuntimeException_WhenUsernameNotExist() {
        BankUser user = this.bankUser;

        BDDMockito.when(bankUserRepository.findBankUserByUsername(user.getUsername()))
                .thenReturn(Optional.of(user));

        BankUser bankUserOptional = bankUserService.findUserByUsername(user.getUsername());

        Assertions.assertThat(bankUserOptional)
                .isNotNull()
                .isEqualTo(this.bankUser);
    }
}