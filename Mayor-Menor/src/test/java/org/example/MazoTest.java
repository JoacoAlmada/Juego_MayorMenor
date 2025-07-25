package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MazoTest {

    @Test
    void testCantidadInicialCartas() {
        Mazo mazo = new Mazo();
        assertEquals(40, mazo.cartaRestante(), "El mazo debe tener 40 cartas al inicio.");
    }
    @Test
    void testEliminarCartaReduceTamaño() {
        Mazo mazo = new Mazo();
        int antes = mazo.cartaRestante();
        mazo.eliminarPrimeraCarta();
        int despues = mazo.cartaRestante();
        assertEquals(antes - 1, despues, "Eliminar una carta debe reducir el tamaño del mazo en 1.");
    }
    @Test
    void testEliminarCartaDevuelveCarta() {
        Mazo mazo = new Mazo();
        Carta carta = mazo.eliminarPrimeraCarta();
        assertNotNull(carta, "Eliminar carta debe devolver una carta válida.");
    }
    @Test
    void testMazoVacioAlFinal() {
        Mazo mazo = new Mazo();
        for (int i = 0; i < 40; i++) {
            mazo.eliminarPrimeraCarta();
        }
        assertEquals(0, mazo.cartaRestante(), "El mazo debe estar vacío tras eliminar todas las cartas.");
    }
    @Test
    void testMezclarCartasCambiaOrden() {
        Mazo mazo1 = new Mazo();
        Mazo mazo2 = new Mazo();

        boolean mismoOrden = true;
        for (int i = 0; i < 40; i++) {
            Carta c1 = mazo1.eliminarPrimeraCarta();
            Carta c2 = mazo2.eliminarPrimeraCarta();
            if (!c1.toString().equals(c2.toString())) {
                mismoOrden = false;
                break;
            }
        }

        assertFalse(mismoOrden, "Dos mazos mezclados no deberían tener el mismo orden.");
    }
    @Test
    void testEliminarCartaEnMazoVacioDevuelveNull() {
        Mazo mazo = new Mazo();
        for (int i = 0; i < 40; i++) {
            mazo.eliminarPrimeraCarta();
        }

        Carta carta = mazo.eliminarPrimeraCarta();
        assertNull(carta, "Debe devolver null si se intenta eliminar una carta de un mazo vacío.");
    }

}