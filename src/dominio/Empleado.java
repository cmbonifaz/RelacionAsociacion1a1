package dominio;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Empleado {

    Calendar fecha = new GregorianCalendar();

    int diaA = fecha.get(Calendar.DAY_OF_MONTH);
    int mesA = fecha.get(Calendar.MONTH) + 1;
    int anioA = fecha.get(Calendar.YEAR);

    private String nombre;
    private Fecha fechaN;
    private Fecha fechaI;

    public Empleado(String nombre, Fecha fechaN, Fecha fechaI) {
        this.nombre = nombre;
        this.fechaN = fechaN;
        this.fechaI = fechaI;
    }

    public String getNombre() {
        return nombre;
    }

    public Fecha getFechaN() {
        return fechaN;
    }

    public Fecha getFechaI() {
        return fechaI;
    }

    public void calculoDeEdad() {
        int anioEmpl = anioA - fechaN.getAnio();
        int mesEmpl = mesA - fechaN.getMes();
        int diaEmpl = diaA - fechaN.getDia();
        if (mesEmpl < 0 || (mesEmpl == 0 && diaEmpl < 0)) {
            anioEmpl--;
        }
        if (mesEmpl == 0 && diaEmpl == 0) {
            mesEmpl = 0;
        } else if ((mesEmpl == 0 && diaEmpl < 0) || (mesEmpl < 0 && diaEmpl == 0)
                || (mesEmpl < 0 && diaEmpl < 0)) {
            mesEmpl += 11;
        } else if (mesEmpl < 0 && diaEmpl > 0) {
            mesEmpl += 12;
        } else if (mesEmpl > 0 && diaEmpl < 0) {
            mesEmpl--;
        }

        if (diaEmpl == 0) {
            diaEmpl = 0;
        } else if (diaEmpl < 0) {

            diaEmpl += 31;
        }

        System.out.println("Fecha de nacimiento: " + fechaN.getAnio() + "/" + fechaN.getMes() + "/" + fechaN.getDia()
                + ", su edad actual es: " + anioEmpl + " anios, " + mesEmpl + " meses, " + diaEmpl + " dias");
    }

    public void calculoDeTiempoEmpresa() {
        int anioIng = anioA - fechaI.getAnio();
        int mesIng = mesA - fechaI.getMes();
        int diaIng = diaA - fechaI.getDia();

        if (mesIng < 0 || (mesIng == 0 && diaIng < 0)) {
            anioIng--;
        }
        if (mesIng == 0 && diaIng == 0) {
            mesIng = 0;
        } else if ((mesIng == 0 && diaIng < 0) || (mesIng < 0 && diaIng == 0)
                || (mesIng < 0 && diaIng < 0)) {
            mesIng += 11;
        } else if (mesIng < 0 && diaIng > 0) {
            mesIng += 12;
        } else if (mesIng > 0 && diaIng < 0) {
            mesIng--;
        }

        if (diaIng == 0) {
            diaIng = 0;
        } else if (diaIng < 0) {

            diaIng += 31;
        }

        System.out.println("Fecha de Ingreso: " + fechaI.getAnio() + "/" + fechaI.getMes() + "/" + fechaI.getDia()
                + ", su tiempo es: " + anioIng + " anios, " + mesIng + " meses, " + diaIng + " dias");
    }

    public void verDatos() {
        System.out.println("Nombre: " + this.nombre);
        calculoDeEdad();
        calculoDeTiempoEmpresa();
    }
}
