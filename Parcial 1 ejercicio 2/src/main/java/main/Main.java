package main;

import model.RutaBus;
import repository.JpaRutaBusRepository;
import service.RutaBusService;
import service.RutaBusServiceImpl;

import javax.swing.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Inicializar el repositorio y el servicio
        JpaRutaBusRepository repository = new JpaRutaBusRepository();
        RutaBusService service = new RutaBusServiceImpl(repository);

        // Crear una nueva ruta de bus
        RutaBus nuevaRuta = new RutaBus("Ruta A", 30);
        service.agregarRuta(nuevaRuta);
        String nombreRuta = JOptionPane.showInputDialog("¿Cual es el nmbre de la ruta?");
        nuevaRuta.setNombreRuta(nombreRuta);


        // Obtener todas las rutas
        List<RutaBus> rutas = service.obtenerTodasLasRutas();
        JOptionPane.showInputDialog("Rutas disponibles:");
        for (RutaBus ruta : rutas) {
            JOptionPane.showInputDialog(ruta);
        }

        // Actualizar una ruta
        if (!rutas.isEmpty()) {
            RutaBus rutaParaActualizar = rutas.get(0);
            rutaParaActualizar.setCantidadPasajeros(40); // Usando el setter para cambiar el valor
            service.actualizarRuta(rutaParaActualizar);
            JOptionPane.showInputDialog("Ruta actualizada: " + rutaParaActualizar);
        }

        // Eliminar una ruta
        if (!rutas.isEmpty()) {
            service.eliminarRuta(rutas.get(0).getId());
            JOptionPane.showInputDialog("Ruta eliminada");
        }
    }
}
