package ru.mail.dobermin.crypto.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import ru.mail.dobermin.crypto.entity.Currency;
import ru.mail.dobermin.crypto.entity.Symbol;
import ru.mail.dobermin.crypto.service.CurrencyService;
import ru.mail.dobermin.crypto.service.SymbolService;
import ru.mail.dobermin.crypto.service.UserService;

import static java.lang.Math.abs;

@Configuration
@EnableScheduling
@RequiredArgsConstructor
@Slf4j
public class SpringConfig {

    private final CurrencyService currencyService;
    private final SymbolService symbolService;
    private final UserService userService;

    @Scheduled(fixedDelay = 60 * 1000)
    public void scheduleTask() {
        currencyService.getCryptoCurrencies().forEach(
                cryptoCurrency -> {
                    Currency currency = Response.get(cryptoCurrency.getId());
                    if (currency == null) return;

                    Symbol symbol = symbolService.findBySymbol(currency.getSymbol().getSymbol());
                    currency.setSymbol(symbol);

                    currencyService.save(currency);

                    Log(symbol, currency);
                }
        );
    }

    private void Log(Symbol symbol, Currency currency) {
        userService.findByCurrency(symbol).forEach(
                user -> {
                    double userPrice = Double.parseDouble(user.getCurrency().getPrice_usd());
                    double newPrice = Double.parseDouble(currency.getPrice_usd());
                    double percent = abs(1 - userPrice / newPrice) * 100;
                    if (percent > 1)
                        log.warn(String.format("%s %s %s%s", symbol.getSymbol(), user.getUsername(), percent, "%"));
                }
        );
    }
}
