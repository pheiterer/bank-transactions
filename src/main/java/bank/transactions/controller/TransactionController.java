package bank.transactions.controller;

import bank.transactions.domain.BankUser;
import bank.transactions.domain.Transaction;
import bank.transactions.mapper.TransactionMapper;
import bank.transactions.request.TransactionRequest;
import bank.transactions.service.BankUserService;
import bank.transactions.service.TransactionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;


@RestController
@RequestMapping(path = {"transactions", "transactions/"})
@Log4j2
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;
    private final BankUserService bankUserService;


    @GetMapping("{accountId}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<String> getTransactionsJson(@PathVariable String accountId,
                                                      @AuthenticationPrincipal UserDetails userDetails) {
        log.info("find all transactions");

//        if((findUserId(userDetails.getUsername()) != accountId) {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized");
//        }

            try {
            File file = ResourceUtils.getFile("classpath:transactions.json");
            String content = new String(Files.readAllBytes(file.toPath()));

            return ResponseEntity.status(HttpStatus.FOUND).body(content);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error reading file");
        }
    }

    @PostMapping("post")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<List<TransactionRequest>> addTransactionsJson(@RequestBody List<TransactionRequest> requests) {
        log.info("post all transactions");
        TransactionMapper mapper = new TransactionMapper();
        for (TransactionRequest transaction:requests) {
            Transaction transactionToBeSaved = mapper.toTransaction(transaction);
            BankUser bankUser = this.bankUserService.findUser(transaction.getUserKey());
            transactionToBeSaved.setBankUser(bankUser);
            transactionService.save(transactionToBeSaved);
        }
        return new ResponseEntity<>(requests, HttpStatus.CREATED);

    }

}

