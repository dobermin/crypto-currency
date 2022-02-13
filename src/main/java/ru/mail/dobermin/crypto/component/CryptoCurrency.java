package ru.mail.dobermin.crypto.component;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CryptoCurrency {

    private String id;

    private String symbol;

    public CryptoCurrency() {
    }
}
