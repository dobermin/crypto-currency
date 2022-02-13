package ru.mail.dobermin.crypto.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.mail.dobermin.crypto.entity.Symbol;
import ru.mail.dobermin.crypto.service.CurrencyService;
import ru.mail.dobermin.crypto.service.SymbolService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class CurrencyController {

    private final CurrencyService currencyService;
    private final SymbolService symbolService;

    @GetMapping("/currencies")
    public ResponseEntity<?> getCurrencies() {
        try {
            return ResponseEntity.ok(currencyService.getCryptoCurrencies());
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/currency/{symbol}")
    public ResponseEntity<?> getCurrency(@PathVariable String symbol) {
        try {
            Symbol s = symbolService.findBySymbol(symbol);
            return ResponseEntity.ok(currencyService.findBySymbol(s).getPrice_usd());
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
