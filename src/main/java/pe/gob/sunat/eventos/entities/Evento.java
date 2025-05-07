package pe.gob.sunat.eventos.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "EVENTO")
public class Evento {

    @Id
    @Column(name = "CODIGO_EVENTO", length = 20)
    private String codigoEvento;

    private String nombre;
    private String descripcion;

    @Column(name = "FECHA_HORA", nullable = false)
    private LocalDateTime fechaHora;

    private String ubicacion;

    @Column(name = "CAPACIDAD_MAXIMA", nullable = false)
    private int capacidadMaxima;

    // Getters y setters
    public String getCodigoEvento() {
        return codigoEvento;
    }

    public void setCodigoEvento(String codigoEvento) {
        this.codigoEvento = codigoEvento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public void setCapacidadMaxima(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }
}