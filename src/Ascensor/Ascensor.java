/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ascensor;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Student
 */
public class Ascensor {
    private int pisoActual;
    private Estado estado;
    private Queue<Integer> llamadas;

    public Ascensor() {
        pisoActual = 1;
        estado = Estado.DETENIDO;
        llamadas = new LinkedList<>();
    }

    public int getPisoActual() {
        return pisoActual;
    }

    public Estado getEstado() {
        return estado;
    }

    public Queue<Integer> getLlamadas() {
        return llamadas;
    }

    public void agregarLlamada(int pisoDestino) {
        if (pisoDestino >= 1 && pisoDestino <= 10) {
            llamadas.add(pisoDestino);
        }
    }

    public void mover() {
        if (!llamadas.isEmpty()) {
            int destino = llamadas.poll();
            if (destino > pisoActual) {
                estado = Estado.SUBIENDO;
                while (pisoActual < destino) {
                    pisoActual++;
                }
            } else if (destino < pisoActual) {
                estado = Estado.BAJANDO;
                while (pisoActual > destino) {
                    pisoActual--;
                }
            }
            estado = Estado.DETENIDO;

        }
    }
}
