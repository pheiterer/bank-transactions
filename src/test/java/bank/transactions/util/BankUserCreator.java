package bank.transactions.util;

import bank.transactions.domain.BankUser;

public class BankUserCreator {
    public static BankUser create() {
        return BankUser.builder()
                .authorities("ROLE_USER")
                .id("123")
                .password("nada")
                .build();
    }
}
