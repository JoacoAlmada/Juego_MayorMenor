package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CartaTest {

    @Test
    void testConstructorYGetters() {
        Carta carta = new Carta(Palo.ESPADA, 7);
        assertEquals(Palo.ESPADA, carta.getPalo());
        assertEquals(7, carta.getValor());
    }
    @Test
    void testToString() {
        Carta carta = new Carta(Palo.ORO, 12);
        assertEquals("12 de ORO", carta.toString());
    }
    @Test
    void testCartaValorMinimoYMaximo() {
        Carta cartaMin = new Carta(Palo.BASTO, 1);
        Carta cartaMax = new Carta(Palo.COPA, 12);
        assertEquals(1, cartaMin.getValor());
        assertEquals(12, cartaMax.getValor());
    }


}