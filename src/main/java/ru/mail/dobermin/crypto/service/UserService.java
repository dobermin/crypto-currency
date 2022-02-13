package ru.mail.dobermin.crypto.service;

import ru.mail.dobermin.crypto.entity.Currency;
import ru.mail.dobermin.crypto.entity.Symbol;
import ru.mail.dobermin.crypto.entity.User;

import java.util.List;

public interface UserService {

    User save(String username, Currency currency) throws Exception;

    List<User> findByCurrency(Symbol symbol);
}
