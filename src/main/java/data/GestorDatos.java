package data;

import modelo.*;

import java.io.*;


public class GestorDatos {

    public static void leerArchivosCarrera(Intranet intranet, String direccionArchivo){
        String textoArchivo = "Carreras";
        try {
            File archivo = new File(direccionArchivo);
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            while((textoArchivo = br.readLine()) != null){
                String[] data = textoArchivo.split(",");
                intranet.getCarreras().add(new Carrera
                        (data[0], data[1], Integer.parseInt(data[2])));
            }
        } catch (Exception e){
            System.out.println("Documento no disponible, favor contactar con administrador");
        }
    }
    public static void leerArchivosEstudiantes(Carrera carrera, String direccionArchivo){
        String textoArchivo = "Estudiantes";
        try {
            File archivo = new File(direccionArchivo);
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            while((textoArchivo = br.readLine()) != null){
                String[] data = textoArchivo.split(",");
                carrera.getEstudiantes().add(new Estudiante
                        (data[0], data[1], data[2],Integer.parseInt(data[4])));
            }
        } catch (Exception e){
            System.out.println("Documento no disponible, favor contactar con administrador");
        }
    }
    public static boolean registrarDatos(Object objeto, String direccionArchivo) {
        boolean lineaVacia = false;
        try {
            File file = new File(direccionArchivo);
            if (!file.exists()) {
                file.createNewFile();
                lineaVacia = true;
            }
            FileWriter fw = new FileWriter(file,true);
            BufferedWriter bw = new BufferedWriter(fw);
            if(!lineaVacia){
                bw.newLine();
            }
            bw.write(objeto.toString());
            bw.close();
            return true;
        } catch (Exception e) {
            System.out.println("Error al ingresar dato, favor contactar con administrador");
            return false;
        }
    }

}
