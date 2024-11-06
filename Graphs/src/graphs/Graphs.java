
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

    private List<String> genders = new ArrayList<>();
    private List<String> ageRanges = new ArrayList<>();
    private List<String> cities = new ArrayList<>();

    public Graphs() {
        setTitle("Visualización de Datos");
        setSize(500, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2));

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

        // Agregar componentes
        add(new JLabel("Género:"));
        add(genderComboBox);
        add(new JLabel("Rango de Edad:"));
        add(ageRangeComboBox);
        add(new JLabel("Ciudad:"));
        add(cityComboBox);
        add(new JLabel("Tipo de Gráfico:"));
        add(chartTypeComboBox);
        add(saveButton);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Graphs().setVisible(true));
    }
}







