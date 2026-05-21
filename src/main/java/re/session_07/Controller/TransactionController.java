package re.session_07.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import re.session_07.services.TransactionService;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @PostMapping("/process")
    public boolean processPayment(
            @RequestParam String accountNumber,
            @RequestParam double amount) {
        return transactionService.processPayment(accountNumber, amount);
    }
}
