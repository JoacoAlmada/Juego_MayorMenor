package org.example;

public class Carta {
    private Palo Palo;
    private int valor;

    public Carta(Palo palo, int valor)
    {
        this.Palo = palo;
        this.valor = valor;
    }
    @Override
    public String toString() {
        return valor + " de " + Palo;
    }

    public int getValor() {
        return valor;
    }
    public Palo getPalo() {
        return Palo;
    }
}
