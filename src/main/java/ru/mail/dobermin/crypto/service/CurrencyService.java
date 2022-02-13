package ru.mail.dobermin.crypto.service;

import ru.mail.dobermin.crypto.component.CryptoCurrency;
import ru.mail.dobermin.crypto.entity.Currency;
import ru.mail.dobermin.crypto.entity.Symbol;

import java.util.List;

public interface CurrencyService {

    List<CryptoCurrency> getCryptoCurrencies();

    Currency findBySymbol(Symbol symbol);

    Currency save(Currency currency);
}
