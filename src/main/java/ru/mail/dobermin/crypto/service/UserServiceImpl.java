package ru.mail.dobermin.crypto.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.mail.dobermin.crypto.entity.Currency;
import ru.mail.dobermin.crypto.entity.Symbol;
import ru.mail.dobermin.crypto.entity.User;
import ru.mail.dobermin.crypto.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User save(String username, Currency currency) throws Exception {
        if (username.isEmpty() || username == null) throw new Exception();
        User user = new User();
        user.setUsername(username);
        user.setCurrency(currency);
        System.out.println(user);
        return userRepository.save(user);
    }

    @Override
    public List<User> findByCurrency(Symbol symbol) {
        return userRepository.findAllBySymbol(symbol);
    }
}
