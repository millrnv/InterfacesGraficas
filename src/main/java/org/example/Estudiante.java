package org.example;

public class Estudiante {

    private String nombre;
    private String apellido;
    private String rut;
    private int nMatricula;

    public Estudiante(String nombre, String apellido, String rut, int nMatricula){

        this.nombre = nombre;
        this.apellido = apellido;
        this.rut = rut;
        this.nMatricula = nMatricula;

    }

    public Estudiante(){

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public int getnMatricula() {
        return nMatricula;
    }

    public void setnMatricula(int nMatricula) {
        this.nMatricula = nMatricula;
    }


}
