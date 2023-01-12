package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CuentaTest {

    @Test
    void testNombreCuenta(){
        Cuenta cuenta = new Cuenta("David", new  BigDecimal("1000.12345"));//se recomienda pasarlo en cadena
//        cuenta.setPersona("David");

        String esperado = "David";
        String real = cuenta.getPersona();
        assertNotNull(real);
        Assertions.assertEquals(esperado, real);
        Assertions.assertTrue(real.equals("David"));
    }

    @Test
    void testSaldoCuenta(){
        Cuenta cuenta = new Cuenta("David", new BigDecimal("1000.12345"));
        assertNotNull(cuenta.getSaldo());
        assertEquals(1000.12345, cuenta.getSaldo().doubleValue());
        assertFalse(cuenta.getSaldo().compareTo(BigDecimal.ZERO) < 0);//compare -1 0 1
        assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);//compare -1 0 1
    }

    @Test
    void testReferenciaCuenta() {
        Cuenta cuenta = new Cuenta("David Yallerco", new BigDecimal("8900.9997"));
        Cuenta cuenta2 = new Cuenta("David Yallerco", new BigDecimal("8900.9997"));

        //comparando por instancia  , osea por referencia
        //assertNotEquals(cuenta2, cuenta); //cuenta valor real , cuenta2 valor esperado
        assertEquals(cuenta2, cuenta);

    }

    @Test
    void testDebitoCuenta() {
        Cuenta cuenta = new Cuenta("David", new BigDecimal("1000.12345"));
        cuenta.debito(new BigDecimal(100));
        assertNotNull(cuenta.getSaldo());
        assertEquals(900, cuenta.getSaldo().intValue());
        assertEquals("900.12345", cuenta.getSaldo().toPlainString());
    }
}