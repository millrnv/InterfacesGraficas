package vista;


import data.GestorDatos;
import modelo.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class MenuPrincipal extends JFrame {
    private final Intranet intranet;


    //Menu Principal
    public MenuPrincipal() {
        intranet = new Intranet(new ArrayList<>(), new ArrayList<>());
        GestorDatos gestorDatos = new GestorDatos();

        // Configuración del marco principal
        setTitle("Menú Principal");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Creación de componentes
        JButton btnRegistrarCarrera = new JButton("Registrar Carrera");
        JButton btnRegistrarEstudiante = new JButton("Registrar Estudiante");
        JButton btnBuscarEstudiante = new JButton("Buscar Estudiante");

        // Configuración de acciones para los botones
        btnRegistrarCarrera.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarCarrera();
            }
        });

        btnRegistrarEstudiante.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarEstudiante();
            }
        });

        btnBuscarEstudiante.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarEstudiante();
            }
        });

        // Configuración del diseño
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        add(btnRegistrarCarrera);
        add(btnRegistrarEstudiante);
        add(btnBuscarEstudiante);

        // Mostrar el marco principal
        setVisible(true);
    }

    private void registrarCarrera() {
        String nombreCarrera = JOptionPane.showInputDialog("Ingrese el nombre de la carrera:");
        int codCarrera = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el código de la carrera:"));
        int cantSemestres = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de semestres:"));

        // Validaciones de la carrera
        if (nombreCarrera.isEmpty() || codCarrera <= 0 || cantSemestres <= 0) {
            JOptionPane.showMessageDialog(this, "Datos de carrera inválidos. Por favor, inténtelo de nuevo.");
            return;
        }

        Carrera nuevaCarrera = new Carrera(nombreCarrera, Integer.toString(codCarrera), cantSemestres);

        // Verificar que la carrera no exista actualmente
        if (intranet.getCarreras().contains(nuevaCarrera)) {
            JOptionPane.showMessageDialog(this, "La carrera ya existe. Por favor, elija una carrera diferente.");
            return;
        }
        if (GestorDatos.registrarDatos(nuevaCarrera, "ruta_del_archivo_carreras")) {
            intranet.getCarreras().add(nuevaCarrera);
            JOptionPane.showMessageDialog(this, "Carrera registrada con éxito.");
        } else {
            JOptionPane.showMessageDialog(this, "Error al registrar la carrera. Por favor, contacte con el administrador.");
        }
    }

    private void registrarEstudiante() {
        // Obtener la información del estudiante
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del estudiante:");
        String apellido = JOptionPane.showInputDialog("Ingrese el apellido del estudiante:");
        String rut = JOptionPane.showInputDialog("Ingrese el rut del estudiante:");
        int nMatricula = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de matrícula:"));

        // Validar que exista al menos una carrera
        if (intranet.getCarreras().isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay carreras registradas. Registre una carrera antes de agregar estudiantes.");
            return;
        }

        // Mostrar lista de carreras para que el usuario seleccione una
        Carrera[] carrerasArray = intranet.getCarreras().toArray(new Carrera[0]);
        Carrera carreraSeleccionada = (Carrera) JOptionPane.showInputDialog(
                this,
                "Seleccione la carrera:",
                "Seleccionar Carrera",
                JOptionPane.QUESTION_MESSAGE,
                null,
                carrerasArray,
                carrerasArray[0]);

        // Verificar que el usuario no haya cerrado la ventana o cancelado la selección
        if (carreraSeleccionada == null) {
            return;
        }

        Estudiante nuevoEstudiante = new Estudiante(nombre, apellido, rut, nMatricula);

        // Validar que el estudiante no exista actualmente en la carrera seleccionada
        if (carreraSeleccionada.estudianteExiste(nuevoEstudiante)) {
            JOptionPane.showMessageDialog(this, "El estudiante ya existe en la carrera seleccionada.");
            return;
        }

        // Agregar el estudiante a la carrera seleccionada
        if (GestorDatos.registrarDatos(nuevoEstudiante, "ruta_del_archivo_estudiantes")) {
            carreraSeleccionada.agregarEstudiante(nuevoEstudiante);
            JOptionPane.showMessageDialog(this, "Estudiante registrado con éxito.");
        } else {
            JOptionPane.showMessageDialog(this, "Error al registrar el estudiante. Por favor, contacte con el administrador.");
        }
    }

    private void buscarEstudiante () {
        // Obtener el nombre y la carrera para la búsqueda
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del estudiante:");
        // Validar que exista al menos una carrera
        if (intranet.getCarreras().isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay carreras registradas. Registre una carrera antes de buscar estudiantes.");
            return;
        }
        // Mostrar lista de carreras para que el usuario seleccione una
        Carrera[] carrerasArray = intranet.getCarreras().toArray(new Carrera[0]);
        Carrera carreraSeleccionada = (Carrera) JOptionPane.showInputDialog(
                this,
                "Seleccione la carrera :",
                "Seleccionar Carrera",
                JOptionPane.QUESTION_MESSAGE,
                null,
                carrerasArray,
                carrerasArray[0]);

        // Verificar que el usuario no haya cerrado la ventana o cancelado la selección
        if (carreraSeleccionada == null) {
            return;
        }

        // Realizar la búsqueda según los criterios proporcionados
        List<Estudiante> estudiantesEncontrados = carreraSeleccionada.buscarEstudiantes(nombre);

        // Mostrar los estudiantes encontrados
        if (estudiantesEncontrados.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No se encontraron estudiantes que coincidan con los criterios de búsqueda.");
        } else {
            StringBuilder mensaje = new StringBuilder("Estudiantes encontrados:\n");
            for (Estudiante estudiante : estudiantesEncontrados) {
                mensaje.append(estudiante.toString()).append("\n");
            }
            JOptionPane.showMessageDialog(this, mensaje.toString());
        }
    }


}
