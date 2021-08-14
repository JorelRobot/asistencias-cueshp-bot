/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Joel
 */
public class Materia {
    
    private final String nombre;
    private final int semestre;

    public Materia(String nombre, int semestre) {
        this.nombre = nombre;
        this.semestre = semestre;
    }

    public String getNombre() {
        return nombre;
    }

    public int getSemestre() {
        return semestre;
    }

    @Override
    public String toString() {
        return "Matria: " + nombre.toUpperCase() + ", Semestre: " + semestre;
    }
}
