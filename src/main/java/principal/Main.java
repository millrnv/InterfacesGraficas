package principal;

import vista.*;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            String[][] datos = {{"Dato1", "Dato2"}, {"Dato3", "Dato4"}};
            String[] nombreColumnas = {"Columna1", "Columna2"};

        Ventana ventana1= new Ventana("Menu Intranet",400,500);
        //VentanaTabla ventanaTabla1 = new VentanaTabla(datos,nombreColumnas);











        });
    }
}