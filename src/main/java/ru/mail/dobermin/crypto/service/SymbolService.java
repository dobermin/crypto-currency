package ru.mail.dobermin.crypto.service;

import ru.mail.dobermin.crypto.entity.Symbol;

public interface SymbolService {

    Symbol save(String symbol);

    Symbol findBySymbol(String symbol);
}
