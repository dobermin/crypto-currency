package ru.mail.dobermin.crypto.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.mail.dobermin.crypto.entity.Symbol;
import ru.mail.dobermin.crypto.repository.SymbolRepository;

@Service
@RequiredArgsConstructor
public class SymbolServiceImpl implements SymbolService {

    private final SymbolRepository symbolRepository;

    @Override
    public Symbol save(String symbol) {
        Symbol newSymbol = symbolRepository.findBySymbol(symbol);
        if (newSymbol != null) return newSymbol;
        return symbolRepository.save(new Symbol(symbol));
    }

    @Override
    public Symbol findBySymbol(String symbol) {
        return symbolRepository.findBySymbol(symbol);
    }
}
