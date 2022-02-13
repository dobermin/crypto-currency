package ru.mail.dobermin.crypto.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.mail.dobermin.crypto.entity.Currency;
import ru.mail.dobermin.crypto.entity.Symbol;
import ru.mail.dobermin.crypto.pojo.Notify;
import ru.mail.dobermin.crypto.service.CurrencyService;
import ru.mail.dobermin.crypto.service.SymbolService;
import ru.mail.dobermin.crypto.service.UserService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserController {

    private final UserService userService;
    private final CurrencyService currencyService;
    private final SymbolService symbolService;

    @PostMapping("/notify")
    public ResponseEntity<?> save(@RequestBody Notify notify) {
        try {
            Symbol symbol = symbolService.findBySymbol(notify.getSymbol());
            Currency currency = currencyService.findBySymbol(symbol);
            return ResponseEntity.ok(userService.save(notify.getUsername(), currency));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
