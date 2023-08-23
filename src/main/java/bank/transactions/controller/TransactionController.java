package bank.transactions.controller;

import bank.transactions.domain.BankUser;
import bank.transactions.response.TransactionGetResponse;
import bank.transactions.service.BankUserService;
import bank.transactions.service.TransactionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;


@RestController
@RequestMapping(path = {"transactions", "transactions/"})
@Log4j2
@RequiredArgsConstructor
public class TransactionController {

    private final BankUserService bankUserService;
    private final TransactionService transactionService;


    @GetMapping("/{accountId}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<List<TransactionGetResponse>> getTransactionsJson(
            @PathVariable String accountId,
            @AuthenticationPrincipal UserDetails userDetails) {
        log.info("Find all transactions");

        BankUser authenticatedUserId = bankUserService.findUserByUsername(userDetails.getUsername());
        if (!Objects.equals(authenticatedUserId.getId(), accountId)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }

        List<TransactionGetResponse> transactions = transactionService.findAllByBankUser(authenticatedUserId);
        return ResponseEntity.ok(transactions);
    }


}

