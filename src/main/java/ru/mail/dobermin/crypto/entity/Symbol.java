package ru.mail.dobermin.crypto.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@JsonIgnoreProperties
@Table(name = "symbols", uniqueConstraints = {@UniqueConstraint(columnNames = {"symbol"})})
public class Symbol {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "symbol", nullable = false)
    private String symbol;

    @OneToMany(mappedBy = "symbol")
    @ToString.Exclude
    private List<Currency> currencies;

    public Symbol() {
    }

    public Symbol(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Symbol currency = (Symbol) o;
        return id != null && Objects.equals(id, currency.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
