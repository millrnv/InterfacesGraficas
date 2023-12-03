package modelo;

import java.util.ArrayList;
import java.util.List;

public class Carrera {

    private String nombreCarrera;
    private String codCarrera;
    private int cantSemestres;
    private List<Estudiante> estudiantes;

    public Carrera(String nombreCarrera, String codCarrera, int cantSemestres) {
        this.nombreCarrera = nombreCarrera;
        this.codCarrera = codCarrera;
        this.cantSemestres = cantSemestres;
    }

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


    public boolean estudianteExiste(Estudiante estudiante){

        for (Estudiante e : this.estudiantes){
            if(estudiante.getRut().equals(e.getRut())){
                return true;
            }
        }
        return false;
    }

    public List<Estudiante> buscarEstudiantes(String nombre) {
        List<Estudiante> estudiantesEncontrados = new ArrayList<>();
        for(Estudiante estudiante : estudiantes){
            if(estudiante.getNombre().equals(nombre)){
                estudiantesEncontrados.add(estudiante);
            }
        }
        return estudiantesEncontrados;
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
