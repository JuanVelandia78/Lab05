
package graphs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

public class Graphs extends JFrame {

    // Componentes de la interfaz
    private JComboBox<String> genderComboBox;
    private JComboBox<String> ageRangeComboBox;
    private JComboBox<String> cityComboBox;
    private JComboBox<String> chartTypeComboBox;
    private JButton saveButton;
    private JButton generateButton;
    private JPanel chartPanel;

    // Listas para almacenar las respuestas
    private List<String> genders;
    private List<String> ageRanges;
    private List<String> cities;

    public Graphs() {
        // Inicializar las listas
        genders = new ArrayList<>();
        ageRanges = new ArrayList<>();
        cities = new ArrayList<>();

        // Configurar la ventana principal
        setTitle("Visualización de Datos - JFreeChart");
        setSize(900, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel para ingresar datos
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(4, 2, 10, 10));

        // Filtros de ejemplo
        genderComboBox = new JComboBox<>(new String[]{"Hombre", "Mujer"});
        ageRangeComboBox = new JComboBox<>(new String[]{"<18", "18-35", "35-50", "50+"});
        cityComboBox = new JComboBox<>(new String[]{"Bogotá", "Medellín", "Cali"});
        chartTypeComboBox = new JComboBox<>(new String[]{"Gráfico de Barras", "Gráfico Circular"});

        // Botón para guardar respuestas
        saveButton = new JButton("Guardar Respuesta");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveResponse();
            }
        });

        // Agregar componentes al panel de entrada
        inputPanel.add(new JLabel("Género:"));
        inputPanel.add(genderComboBox);
        inputPanel.add(new JLabel("Rango de Edad:"));
        inputPanel.add(ageRangeComboBox);
        inputPanel.add(new JLabel("Ciudad:"));
        inputPanel.add(cityComboBox);
        inputPanel.add(saveButton);

        // Panel para seleccionar el tipo de gráfico
        JPanel chartTypePanel = new JPanel();
        chartTypePanel.add(new JLabel("Tipo de Gráfico:"));
        chartTypePanel.add(chartTypeComboBox);

        // Botón para generar gráficos
        generateButton = new JButton("Generar Gráfico");
        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generateChart();
            }
        });

        // Panel para el gráfico
        chartPanel = new JPanel();
        chartPanel.setLayout(new BorderLayout());

        // Agregar componentes a la ventana
        add(inputPanel, BorderLayout.NORTH);
        add(chartTypePanel, BorderLayout.CENTER);
        add(generateButton, BorderLayout.EAST);
        add(chartPanel, BorderLayout.SOUTH);
    }

    // Método para guardar las respuestas
    private void saveResponse() {
        String gender = (String) genderComboBox.getSelectedItem();
        String ageRange = (String) ageRangeComboBox.getSelectedItem();
        String city = (String) cityComboBox.getSelectedItem();

        // Guardar las respuestas en las listas
        genders.add(gender);
        ageRanges.add(ageRange);
        cities.add(city);

        JOptionPane.showMessageDialog(this, "Respuesta guardada exitosamente.");
    }

    // Método para generar gráficos
    private void generateChart() {
        String selectedChartType = (String) chartTypeComboBox.getSelectedItem();
        chartPanel.removeAll();

        if ("Gráfico de Barras".equals(selectedChartType)) {
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
            for (int i = 0; i < genders.size(); i++) {
                dataset.addValue(1, ageRanges.get(i), cities.get(i));
            }

            JFreeChart barChart = ChartFactory.createBarChart(
                    "Gráfico de Barras",
                    "Ciudad",
                    "Cantidad",
                    dataset
            );

            ChartPanel barChartPanel = new ChartPanel(barChart);
            chartPanel.add(barChartPanel, BorderLayout.CENTER);
        } else if ("Gráfico Circular".equals(selectedChartType)) {
            DefaultPieDataset pieDataset = new DefaultPieDataset();
            for (int i = 0; i < cities.size(); i++) {
                pieDataset.setValue(cities.get(i), 1);
            }

            JFreeChart pieChart = ChartFactory.createPieChart(
                    "Gráfico Circular",
                    pieDataset,
                    true,
                    true,
                    false
            );

            ChartPanel pieChartPanel = new ChartPanel(pieChart);
            chartPanel.add(pieChartPanel, BorderLayout.CENTER);
        }

        chartPanel.validate();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Graphs().setVisible(true);
            }
        });
    }
}











