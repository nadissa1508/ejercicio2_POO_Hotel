public class Habitacion {
    private int idHabitacion;
    private int idHuesped;
    private int tipoHabitacion;
    private int capOcupantes;
    private float precioNoche;
    private boolean disponibilidad;

    public Habitacion(){
        idHabitacion = 0;
        idHuesped = 0;
        tipoHabitacion = 0;
        capOcupantes = 0;
        precioNoche = 0.0f;
        disponibilidad = true;
    }

    public Habitacion(int idHabitacion, int idHuesped, int tipoHabitacion, int capOcupantes, float precioNoche, boolean disponibilidad){
        this.idHabitacion = idHabitacion;
        this.idHuesped = idHuesped;
        this.tipoHabitacion = tipoHabitacion;
        this.capOcupantes = capOcupantes;
        this.precioNoche = precioNoche;
        this.disponibilidad = disponibilidad;
    }

    public int getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(int idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public int getIdHuesped() {
        return idHuesped;
    }

    public void setIdHuesped(int idHuesped) {
        this.idHuesped = idHuesped;
    }

    public int getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(int tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }

    public int getCapOcupantes() {
        return capOcupantes;
    }

    public void setCapOcupantes(int capOcupantes) {
        this.capOcupantes = capOcupantes;
    }

    public float getPrecioNoche() {
        return precioNoche;
    }

    public void setPrecioNoche(float precioNoche) {
        this.precioNoche = precioNoche;
    }

     public boolean getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public toString(){
        return "";
    }
}
