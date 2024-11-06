
package graphs;

import javax.swing.*;
import java.awt.*;

public class Graphs extends JFrame {

    private JComboBox<String> genderComboBox;
    private JComboBox<String> ageRangeComboBox;
    private JComboBox<String> cityComboBox;
    private JButton saveButton;

    public Graphs() {
        setTitle("Visualización de Datos");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2));

        genderComboBox = new JComboBox<>(new String[]{"Hombre", "Mujer"});
        ageRangeComboBox = new JComboBox<>(new String[]{"<18", "18-35", "35-50", "50+"});
        cityComboBox = new JComboBox<>(new String[]{"Bogotá", "Medellín", "Cali"});

        saveButton = new JButton("Guardar Respuesta");

        add(new JLabel("Género:"));
        add(genderComboBox);
        add(new JLabel("Rango de Edad:"));
        add(ageRangeComboBox);
        add(new JLabel("Ciudad:"));
        add(cityComboBox);
        add(saveButton);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Graphs().setVisible(true));
    }
}




