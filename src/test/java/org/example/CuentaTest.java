package org.example;

import org.example.exceptions.DineroInsuficienteException;
import org.example.models.Banco;
import org.example.models.Cuenta;
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

    @Test
    void testCreditoCuenta() {
        Cuenta cuenta = new Cuenta("David", new BigDecimal("1000.12345"));
        cuenta.credito(new BigDecimal(100));
        assertNotNull(cuenta.getSaldo());
        assertEquals(1100, cuenta.getSaldo().intValue());
        assertEquals("1100.12345", cuenta.getSaldo().toPlainString());
    }

    @Test
    void testDineroInsuficienteException() {
        Cuenta cuenta = new Cuenta("David", new BigDecimal("1000.12345"));
        Exception exception = assertThrows(DineroInsuficienteException.class, ()-> {
            cuenta.debito(new BigDecimal(1500));
        });
        String actual = exception.getMessage();
        String esperado = "Dinero Insuficiente";
        assertEquals(esperado, actual);
    }

    @Test
    void transferirDineroCuentas() {
        Cuenta cuenta1 = new Cuenta("Ezer", new BigDecimal("2500"));
        Cuenta cuenta2 = new Cuenta("David", new BigDecimal("1500.8989"));

        Banco banco = new Banco();
        banco.setNombre("banco de estado");
        banco.transferir(cuenta2, cuenta1, new BigDecimal(500));
        assertEquals("1000.8989", cuenta2.getSaldo().toPlainString());
        assertEquals("3000", cuenta1.getSaldo().toPlainString());


    }
}