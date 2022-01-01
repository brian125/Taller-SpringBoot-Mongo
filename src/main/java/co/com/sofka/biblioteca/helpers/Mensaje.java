package co.com.sofka.biblioteca.helpers;

import java.util.Date;

public class Mensaje {

    private Boolean disponible;
    private String mensaje;

    public Mensaje() {
    }

    public Mensaje(Boolean disponible, String mensaje) {
        this.disponible = disponible;
        this.mensaje = mensaje;
    }

    public Boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Mensaje mostrarMensajeDisponible(Boolean disponible, Date fechaPrestamo){
        if (disponible){
            return new Mensaje(true, "El recurso esta disponible");
        }
        return new Mensaje(false, "El recurso no esta disponible y fue prestado el " + fechaPrestamo);
    }

    public Mensaje mostrarMensajePrestamo (Boolean disponible, Date fechaPrestamo){
        if (disponible){
            return new Mensaje(true, "El recurso esta disponible");
        }
        return new Mensaje(false, "El recurso no esta disponible y fue prestado el: " +fechaPrestamo);
    }

    public Mensaje mostrarMensajeDevolucion(Boolean disponible, Date fechaPrestamo){
        if(!disponible){
            return new Mensaje(true, "Recurso entregado, devolucion exitosa");
        }
        return new Mensaje(false, "El recurso no esta en prestamo");
    }
}
