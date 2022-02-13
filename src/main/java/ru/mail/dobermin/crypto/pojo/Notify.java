package ru.mail.dobermin.crypto.pojo;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class Notify {

    @NotEmpty
    @NotNull
    private String username;

    @NotEmpty
    @NotNull
    private String symbol;
}
