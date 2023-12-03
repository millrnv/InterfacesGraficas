package modelo;

import java.util.ArrayList;
import java.util.List;

public class Intranet {

    private List<Carrera> carreras;
    private List<Estudiante> estudiantes;

    public Intranet(List<Carrera> carreras, List<Estudiante> estudiantes) {
        this.carreras = new ArrayList<>();
        this.estudiantes = new ArrayList<>();
    }

    public List<Carrera> getCarreras() {
        return carreras;
    }

    public void setCarreras(List<Carrera> carreras) {
        this.carreras = carreras;
    }

    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(List<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }

}
