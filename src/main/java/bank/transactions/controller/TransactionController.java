package bank.transactions.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;


@RestController
@RequestMapping(path = {"transactions", "transactions/"})
@Log4j2
public class TransactionController {

    @GetMapping("{accountId}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<String> getTransactionsJson(@PathVariable String accountId,
                                                      @AuthenticationPrincipal UserDetails userDetails) {
        log.info("find all transactions");

        try {
            File file = ResourceUtils.getFile("classpath:transactions.json");
            String content = new String(Files.readAllBytes(file.toPath()));

            return ResponseEntity.status(HttpStatus.FOUND).body(content);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error reading file");
        }
    }

}

