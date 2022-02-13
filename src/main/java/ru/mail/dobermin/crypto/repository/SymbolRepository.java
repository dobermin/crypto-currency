package ru.mail.dobermin.crypto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mail.dobermin.crypto.entity.Symbol;

@Repository
public interface SymbolRepository extends JpaRepository<Symbol, Long> {

    Symbol findBySymbol(String symbol);
}
