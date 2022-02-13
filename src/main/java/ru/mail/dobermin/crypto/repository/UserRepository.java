package ru.mail.dobermin.crypto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.mail.dobermin.crypto.entity.Symbol;
import ru.mail.dobermin.crypto.entity.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.currency IN (SELECT c FROM Currency c WHERE c.symbol = ?1)")
    List<User> findAllBySymbol(Symbol symbol);
}
