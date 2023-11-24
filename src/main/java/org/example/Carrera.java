package org.example;

import java.util.List;

public class Carrera {

    private String nombreCarrera;
    private String codCarrera;
    private int cantSemestres;
    private List<Estudiante> estudiantes;


    public void setNombreCarrera(String nombreCarrera){
        this.nombreCarrera = nombreCarrera;
    }

    public String getNombreCarrera(){
        return nombreCarrera;
    }

    public void setCodCarrera(String codCarrera){
        this.codCarrera = codCarrera;
    }

    public String getCodCarrera(){
        return codCarrera;
    }

    public void setCantSemestres(int cantSemestres){
        this.cantSemestres = cantSemestres;
    }

    public int getCantSemestres(){
        return cantSemestres;
    }

    public List<Estudiante> getEstudiantes(){
        return estudiantes;
    }


    public boolean EstudianteExiste(Estudiante estudiante){

        for (Estudiante e : this.estudiantes){
            if(estudiante.getRut().equals(e.getRut())){
                return true;
            }
        }
        return false;
    }

    public Estudiante agregarEstudiante(Estudiante estudiante){
        this.estudiantes.add(estudiante);
        return estudiante;

    }

    public Estudiante eliminarEstudiante(Estudiante estudiante){
        this.estudiantes.remove(estudiante);
        return estudiante;

    }







}
