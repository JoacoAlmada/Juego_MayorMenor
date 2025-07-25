package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Mazo {
    private List<Carta> cartas;

    public Mazo()
    {
        cartas = inicializarMazo();
        mezclarCartas();
    }

    public void mezclarCartas() {
        Collections.shuffle(cartas);
    }


    private List<Carta> inicializarMazo() {
        cartas = new ArrayList<>();
        int[]valor = {1,2,3,4,5,6,7,10,11,12};
        for (Palo palo : Palo.values())
        {
            for(int valores :valor)
            {
                cartas.add(new Carta(palo,valores));
            }
        }
        return cartas;
    }

    public Carta eliminarPrimeraCarta()
    {
        if (cartas.isEmpty()) return null;
        return cartas.remove(0);
    }
    public int cartaRestante()
    {
        return cartas.size();
    }
}
