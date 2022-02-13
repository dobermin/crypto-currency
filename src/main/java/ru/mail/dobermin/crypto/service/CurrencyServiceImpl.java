package ru.mail.dobermin.crypto.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.mail.dobermin.crypto.component.CryptoCurrencies;
import ru.mail.dobermin.crypto.component.CryptoCurrency;
import ru.mail.dobermin.crypto.entity.Currency;
import ru.mail.dobermin.crypto.entity.Symbol;
import ru.mail.dobermin.crypto.repository.CurrencyRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CurrencyServiceImpl implements CurrencyService {

    private final CryptoCurrencies cryptoCurrencies;
    private final CurrencyRepository currencyRepository;

    @Override
    public List<CryptoCurrency> getCryptoCurrencies() {
        return cryptoCurrencies.getCryptoCurrencies();
    }

    @Override
    public Currency findBySymbol(Symbol symbol) {
        return currencyRepository.findFirstBySymbolOrderByIdDesc(symbol).orElseThrow();
    }

    @Override
    public Currency save(Currency currency) {
        return currencyRepository.save(currency);
    }
}
