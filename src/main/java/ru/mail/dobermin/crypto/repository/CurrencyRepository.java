package ru.mail.dobermin.crypto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mail.dobermin.crypto.entity.Currency;
import ru.mail.dobermin.crypto.entity.Symbol;

import java.util.Optional;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency, Long> {

    Optional<Currency> findFirstBySymbolOrderByIdDesc(Symbol symbol);
}
