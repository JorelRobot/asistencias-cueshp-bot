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
public class FormValues {
    
    private String materia;
    private int semestre;
    private String videoconferencia;
    private String actividad;
    private String recurso;
    private String retroalimentacion;
    private String evaluacion;
    private String otra_actividad;

    public FormValues() {
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public String getVideoconferencia() {
        return videoconferencia;
    }

    public void setVideoconferencia(String videoconferencia) {
        this.videoconferencia = videoconferencia;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public String getRecurso() {
        return recurso;
    }

    public void setRecurso(String recurso) {
        this.recurso = recurso;
    }

    public String getRetroalimentacion() {
        return retroalimentacion;
    }

    public void setRetroalimentacion(String retroalimentacion) {
        this.retroalimentacion = retroalimentacion;
    }

    public String getEvaluacion() {
        return evaluacion;
    }

    public void setEvaluacion(String evaluacion) {
        this.evaluacion = evaluacion;
    }

    public String getOtra_actividad() {
        return otra_actividad;
    }

    public void setOtra_actividad(String otra_actividad) {
        this.otra_actividad = otra_actividad;
    }
}
