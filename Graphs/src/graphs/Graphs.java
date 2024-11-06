
package graphs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Graphs extends JFrame {

    private JComboBox<String> genderComboBox;
    private JComboBox<String> ageRangeComboBox;
    private JComboBox<String> cityComboBox;
    private JComboBox<String> chartTypeComboBox;
    private JButton saveButton;
    private JButton generateButton;
    private JPanel chartPanel;

    // Listas para almacenar las respuestas
    private List<String> genders = new ArrayList<>();
    private List<String> ageRanges = new ArrayList<>();
    private List<String> cities = new ArrayList<>();

    public Graphs() {
        setTitle("Visualización de Datos");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel superior para los filtros y el botón de guardar
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(5, 2));

        genderComboBox = new JComboBox<>(new String[]{"Hombre", "Mujer"});
        ageRangeComboBox = new JComboBox<>(new String[]{"<18", "18-35", "35-50", "50+"});
        cityComboBox = new JComboBox<>(new String[]{"Bogotá", "Medellín", "Cali"});
        chartTypeComboBox = new JComboBox<>(new String[]{"Gráfico de Barras", "Gráfico Circular"});

        saveButton = new JButton("Guardar Respuesta");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                genders.add((String) genderComboBox.getSelectedItem());
                ageRanges.add((String) ageRangeComboBox.getSelectedItem());
                cities.add((String) cityComboBox.getSelectedItem());
                JOptionPane.showMessageDialog(Graphs.this, "Respuesta guardada exitosamente.");
            }
        });

        // Botón para generar gráficos (sin lógica aún)
        generateButton = new JButton("Generar Gráfico");
        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí se generarán los gráficos (lógica en la siguiente versión)
                JOptionPane.showMessageDialog(Graphs.this, "Se generará el gráfico.");
            }
        });

        // Panel para gráficos
        chartPanel = new JPanel();
        chartPanel.setLayout(new BorderLayout());

        // Agregar componentes al panel de entrada
        inputPanel.add(new JLabel("Género:"));
        inputPanel.add(genderComboBox);
        inputPanel.add(new JLabel("Rango de Edad:"));
        inputPanel.add(ageRangeComboBox);
        inputPanel.add(new JLabel("Ciudad:"));
        inputPanel.add(cityComboBox);
        inputPanel.add(new JLabel("Tipo de Gráfico:"));
        inputPanel.add(chartTypeComboBox);
        inputPanel.add(saveButton);
        inputPanel.add(generateButton);

        // Agregar paneles a la ventana principal
        add(inputPanel, BorderLayout.NORTH);
        add(chartPanel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Graphs().setVisible(true));
    }
}










