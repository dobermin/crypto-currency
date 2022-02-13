package ru.mail.dobermin.crypto.component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import ru.mail.dobermin.crypto.service.SymbolService;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class CryptoCurrencies {

    private final SymbolService symbolService;

    @Bean
    public List<CryptoCurrency> getCryptoCurrencies() {
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<CryptoCurrency>> typeReference = new TypeReference<>() {
        };
        try {
            List<CryptoCurrency> cryptoCurrencies = mapper.readValue(new File("src/main/resources/currencies.json"), typeReference);
            cryptoCurrencies.forEach(
                    cryptoCurrency -> symbolService.save(cryptoCurrency.getSymbol())
            );
            return cryptoCurrencies;
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }
}
