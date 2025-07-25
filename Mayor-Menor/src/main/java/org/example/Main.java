package org.example;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Hello, Practica  - MAYOR/MENOR.");

        boolean sigueJuego = true;
        int partidasJugadas = 0;
        int partidasGanadas = 0;
        int partidasPerdidas = 0;

        while (sigueJuego)
        {
            Mazo mazo = new Mazo();
            Carta cartaActual = mazo.eliminarPrimeraCarta();
            System.out.println("Primera Carta: " + cartaActual);

            boolean partidaEnCurso = true;

            while (partidaEnCurso && mazo.cartaRestante() > 0)
            {
                System.out.println("¿La siguiente carta es mayor o menor?");
                String respuesta = sc.nextLine();

                Carta siguienteCarta = mazo.eliminarPrimeraCarta();
                System.out.println("Siguiente Carta: " + siguienteCarta);

                if (siguienteCarta == null)
                {
                    System.out.println("No quedan cartas , Ganaste");
                    partidasGanadas++;
                    partidasJugadas++;
                    partidaEnCurso = false;
                    break;
                }

                boolean esMayor = siguienteCarta.getValor() >= cartaActual.getValor();
                boolean respuestaCorrecta = (respuesta.equalsIgnoreCase("Mayor") && esMayor)
                        || (respuesta.equalsIgnoreCase("Menor") && !esMayor);

                if (respuestaCorrecta)
                {
                    if (mazo.cartaRestante() == 0)
                    {
                        System.out.println("Era la última carta , Ganaste");
                        partidasGanadas++;
                        partidasJugadas++;
                        partidaEnCurso = false;
                    }
                    else
                    {
                        cartaActual = siguienteCarta;
                        System.out.println(" Quedan " + mazo.cartaRestante() + " cartas.");
                    }
                }
                else
                {
                    System.out.println("Perdiste");
                    partidasPerdidas++;
                    partidasJugadas++;
                    partidaEnCurso = false;
                }
            }

            System.out.println("¿Quieres volver a jugar? (s/n)");
            String opcion = sc.nextLine();
            sigueJuego = opcion.equalsIgnoreCase("s");
        }

        System.out.println("Gracias por jugar");
        sc.close();
    }
}