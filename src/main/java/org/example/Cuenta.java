package org.example;

import java.math.BigDecimal;

public class Cuenta {
    private String pesona;
    private BigDecimal saldo;

    public Cuenta(String pesona, BigDecimal saldo) {
        this.pesona = pesona;
        this.saldo = saldo;
    }

    public String getPesona() {
        return pesona;
    }

    public void setPesona(String pesona) {
        this.pesona = pesona;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }
}
