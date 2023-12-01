package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.text.InternationalFormatter;



public class Ventana extends JFrame implements ActionListener{

    private final Font fuenteTitulo;
    private final Font fuenteTexto;

    private JMenuBar menuBar;


    public Ventana(String nombre, int largoX, int largoY){

        super(nombre);
        super.setVisible(true);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.setSize(largoX,largoY);
        //para centrar la ventana
        super.setLocationRelativeTo(null);
        //evitar expandir pantalla
        super.setResizable(false);
        //indica que se debe colocar las coordenadas de cada objeto gráfico
        this.setLayout(null);
        this.fuenteTitulo = new Font("Calibri",3,20);
        this.fuenteTexto = new Font("Calibri",1,14);



    }

    protected void generarJLabelEncabezado(JLabel label, String texto, int posicionX, int posicionY, int largoX, int
            largoY){
        label= new JLabel(texto);
        label.setBounds(posicionX, posicionY, largoX, largoY);
        label.setFont(this.fuenteTitulo);
        this.add(label);
    }

    protected JButton generarBoton(String texto, int posicionX, int posicionY, int largoX, int largoY){
        JButton boton= new JButton(texto);
        boton.setBounds(posicionX, posicionY, largoX, largoY);
        boton.setFont(this.fuenteTexto);
        return boton;
    }
    protected void generarJLabel(JLabel label, String texto, int posicionX, int posicionY, int largoX, int largoY) {
        label= new JLabel(texto);
        label.setBounds(posicionX, posicionY, largoX, largoY);
        label.setFont(this.fuenteTexto);
        this.add(label);
    }

    //Genera campo de texto con un formato en específico
    protected JFormattedTextField generarJFormattedTextField(InternationalFormatter formato, int posicionX, int
            posicionY, int largoX, int largoY) {
        JFormattedTextField textField = new JFormattedTextField(formato);
        textField.setBounds(posicionX, posicionY, largoX, largoY);
        return textField;

    }

    //Genera un formato, en este caso, que el campo de texto debe tener un número mayor o igual al mínimo para ser válido
    protected InternationalFormatter generarFormato(int minimo){
        InternationalFormatter formato=new InternationalFormatter();
        formato.setMinimum(minimo);
        return formato;
    }
    protected InternationalFormatter generarFormato(int minimo, int maximo){
        InternationalFormatter formato=new InternationalFormatter();
        formato.setMinimum(minimo);
        formato.setMaximum(maximo);
        return formato;
    }
    protected JTextField generarJTextField(int posicionX, int posicionY, int largoX, int largoY){
        JTextField textField= new JTextField();
        textField.setBounds(posicionX, posicionY, largoX, largoY);
        return textField;
    }
    protected JRadioButton generarJRadioButton(String texto, int posicionX, int posicionY, int largoX, int largoY){
        JRadioButton boton= new JRadioButton(texto);
        boton.setBounds(posicionX, posicionY, largoX, largoY);
        return boton;
    }
    protected JComboBox generarListaDesplegable(Object[] datosLista, int posicionX, int posicionY, int largoX, int
            largoY){
        JComboBox lista= new JComboBox(datosLista);
        lista.setBounds(posicionX, posicionY, largoX, largoY);
        return lista;
    }


    @Override
    public void actionPerformed(ActionEvent e) {



    }




}
