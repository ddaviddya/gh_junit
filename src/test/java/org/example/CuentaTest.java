package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CuentaTest {

    @Test
    void testNombreCuenta(){
        Cuenta cuenta = new Cuenta("David", new  BigDecimal("1000.12345"));
//        cuenta.setPesona("David");

        String esperado = "David";
        String real = cuenta.getPesona();
        Assertions.assertEquals(esperado, real);
        Assertions.assertTrue(real.equals("David"));
    }
    @Test
    void testSaldoCuenta(){
        Cuenta cuenta = new Cuenta("David", new BigDecimal("1000.12345"));
        assertEquals(1000.12345, cuenta.getSaldo().doubleValue());
    }
}