package ru.mail.dobermin.crypto.config;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import ru.mail.dobermin.crypto.entity.Currency;

import java.util.List;

import static org.springframework.http.HttpMethod.GET;

public class Response {

    public static Currency get(String id) {
        try {
            RestTemplate restTemplate = new RestTemplate();

            ResponseEntity<List<Currency>> responseEntity =
                    restTemplate.exchange(
                            "https://api.coinlore.net/api/ticker/?id=" + id,
                            GET,
                            null,
                            new ParameterizedTypeReference<>() {
                            }
                    );
            if (responseEntity.getBody() == null) return null;
            return responseEntity.getBody().get(0);
        } catch (Exception e) {
            return null;
        }
    }
}
