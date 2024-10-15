package model;

import javax.persistence.*;

@Entity
@Table(name = "ruta_bus")
public class RutaBus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombre_ruta")
    private String nombreRuta;

    @Column(name = "cantidad_pasajeros")
    private int cantidadPasajeros;

    public RutaBus() {}

    public RutaBus(String nombreRuta, int cantidadPasajeros) {
        this.nombreRuta = nombreRuta;
        this.cantidadPasajeros = cantidadPasajeros;
    }

    public int getId() {
        return id;
    }

    public String getNombreRuta() {
        return nombreRuta;
    }

    public void setNombreRuta(String nombreRuta) {
        this.nombreRuta = nombreRuta;
    }

    public int getCantidadPasajeros() {
        return cantidadPasajeros;
    }

    public void setCantidadPasajeros(int cantidadPasajeros) {
        this.cantidadPasajeros = cantidadPasajeros;
    }

    @Override
    public String toString() {
        return "RutaBus [id=" + id + ", nombreRuta=" + nombreRuta + ", cantidadPasajeros=" + cantidadPasajeros + "]";
    }

    // Callback methods

    @PrePersist
    public void prePersist() {
        System.out.println("Preparando para persistir la ruta: " + nombreRuta);
    }

    @PostPersist
    public void postPersist() {
        System.out.println("Ruta persistida: " + nombreRuta);
    }

    @PreUpdate
    public void preUpdate() {
        System.out.println("Preparando para actualizar la ruta: " + nombreRuta);
    }

    @PostUpdate
    public void postUpdate() {
        System.out.println("Ruta actualizada: " + nombreRuta);
    }

    @PreRemove
    public void preRemove() {
        System.out.println("Preparando para eliminar la ruta: " + nombreRuta);
    }

    @PostRemove
    public void postRemove() {
        System.out.println("Ruta eliminada: " + nombreRuta);
    }
}
