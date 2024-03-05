import java.util.Scanner;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Ingrese la dirección:");
        String direccion = scanner.nextLine();
        
        System.out.println("Ingrese la distancia:");
        double distancia = scanner.nextDouble();
        
        // Convertir la distancia a metros (SI) o pies (inglés)
        double distanciaSI = distancia;
        double distanciaIngles = distancia;
        if (direccion.equalsIgnoreCase("si")) {
            distanciaIngles = distancia / 0.3048; // 1 pie = 0.3048 metros
        } else {
            distanciaSI = distancia * 0.3048; // 1 metro = 3.28084 pies
        }
        
        // Crear una serie de datos para la distancia en sistema internacional (SI)
        XYSeries seriesSI = new XYSeries("Distancia (SI)");
        seriesSI.add(0, 0);
        seriesSI.add(Math.cos(Math.toRadians(45)) * distanciaSI, Math.sin(Math.toRadians(45)) * distanciaSI);
        
        // Crear una serie de datos para la distancia en sistema inglés
        XYSeries seriesIngles = new XYSeries("Distancia (Inglés)");
        seriesIngles.add(0, 0);
        seriesIngles.add(Math.cos(Math.toRadians(45)) * distanciaIngles, Math.sin(Math.toRadians(45)) * distanciaIngles);
        
        // Agregar las series de datos a un conjunto de datos
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(seriesSI);
        dataset.addSeries(seriesIngles);
        
        // Crear el gráfico
        JFreeChart chart = ChartFactory.createXYLineChart("Gráfico de Distancia", "X", "Y", dataset);
        
        // Mostrar el gráfico en un panel
        ChartPanel chartPanel = new ChartPanel(chart);
        
        // Crear una ventana para mostrar el gráfico
        JFrame frame = new JFrame("Gráfico de Distancia");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(chartPanel);
        frame.pack();
        frame.setVisible(true);
    }
}