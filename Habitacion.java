/**
 * Universidad del Valle de Guatemala
 * @author Angie Nadissa Vela López, 23764
 * @description Clase que modela la habitación de un hotel
 * @date creación 28/08/2023 última modificación 28/08/23
 */

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

    /** 
     * @param idHabitacion
     * @param idHuesped
     * @param tipoHabitacion
     * @param capOcupantes
     * @param precioNoche
     * @param Disponibilidad
     */
    public Habitacion(int idHabitacion, int idHuesped, int tipoHabitacion, int capOcupantes, float precioNoche, boolean disponibilidad){
        this.idHabitacion = idHabitacion;
        this.idHuesped = idHuesped;
        this.tipoHabitacion = tipoHabitacion;
        this.capOcupantes = capOcupantes;
        this.precioNoche = precioNoche;
        this.disponibilidad = disponibilidad;
    }

    
    /** 
     * @return int
     */
    public int getIdHabitacion() {
        return idHabitacion;
    }

    
    /** 
     * @param idHabitacion
     */
    public void setIdHabitacion(int idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    
    /** 
     * @return int
     */
    public int getIdHuesped() {
        return idHuesped;
    }

    
    /** 
     * @param idHuesped
     */
    public void setIdHuesped(int idHuesped) {
        this.idHuesped = idHuesped;
    }

    
    /** 
     * @return int
     */
    public int getTipoHabitacion() {
        return tipoHabitacion;
    }

    
    /** 
     * @param tipoHabitacion
     */
    public void setTipoHabitacion(int tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }

    
    /** 
     * @return int
     */
    public int getCapOcupantes() {
        return capOcupantes;
    }

    
    /** 
     * @param capOcupantes
     */
    public void setCapOcupantes(int capOcupantes) {
        this.capOcupantes = capOcupantes;
    }

    
    /** 
     * @return float
     */
    public float getPrecioNoche() {
        return precioNoche;
    }

    
    /** 
     * @param precioNoche
     */
    public void setPrecioNoche(float precioNoche) {
        this.precioNoche = precioNoche;
    }

     
     /** 
      * @return boolean
      */
     public boolean getDisponibilidad() {
        return disponibilidad;
    }

    
    /** 
     * @param disponibilidad
     */
    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    /** 
     * @return String
     */
    public toString(){
        return "";
    }
}
