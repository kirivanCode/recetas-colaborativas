import javax.swing.*;
import java.util.Scanner;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        GestorRecetas gestor = new GestorRecetas();
        Scanner scanner = new Scanner(System.in);

        String nombre = JOptionPane.showInputDialog("Ingrese el nombre de la receta:");

        String ingredientesInput = JOptionPane.showInputDialog("Ingrese los ingredientes (separados por coma):");
        String[] ingredientes = ingredientesInput.split(",");

        String instrucciones = JOptionPane.showInputDialog("Ingrese las instrucciones:");

        Receta nuevaReceta = new Receta(nombre, ingredientes, instrucciones);
        gestor.agregarReceta(nuevaReceta);

        JOptionPane.showMessageDialog(null, "Receta agregada: " + nuevaReceta.getNombre());

        // Construimos la lista de recetas en un String
        List<Receta> recetas = gestor.obtenerRecetas();
        StringBuilder listaRecetas = new StringBuilder("Recetas guardadas:\n");

        for (Receta receta : recetas) {
            listaRecetas.append("- ").append(receta.getNombre()).append("\n");
        }

        // Mostramos las recetas guardadas en un JOptionPane
        JOptionPane.showMessageDialog(null, listaRecetas.toString(), "Lista de Recetas", JOptionPane.INFORMATION_MESSAGE);
    }
}
