/**
 * Universidad del Valle de Guatemala
 * @author Angie Nadissa Vela López, 23764
 * @description Clase que modela un huespéd que se hospedará en el hotel
 * @date creación 28/08/2023 última modificación 28/08/23
 */

public class Huesped {

    private int idHuesped;
    private String nombre;
    private String telefono;
    private int cantVeces;
    private int capOcupantes;
    
    public Huesped(){
        idHuesped = 0;
        nombre = "";
        telefono = "";
        cantVeces = 0;
        capOcupantes= 0;
    }

    /** 
     * @param idHuesped
     * @param nombre
     * @param telefono
     * @param cantVeces
     * @param capOcupantes
     */
    public Huesped(int idHuesped, String nombre, String telefono, int cantVeces, int capOcupantes){
        this.idHuesped = idHuesped;
        this.nombre = nombre;
        this.telefono = telefono;
        this.cantVeces = cantVeces;
        this.capOcupantes= capOcupantes;
    }


    
    /** 
     * @return int
     */
    public int getIdHuesped() {
        return idHuesped;
    }

    
    /** 
     * @param idHuesped
     
    public void setIdHuesped(int idHuesped) {
        this.idHuesped = idHuesped;
    }
    */
    
    
    /** 
     * @return String
     */
    public String getNombre() {
        return nombre;
    }

    
    /** 
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    /** 
     * @return String
     */
    public String getTelefono() {
        return telefono;
    }

    /** 
     * @param telefono
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    /** 
     * @return int
     */
    public int getCantVeces() {
        return cantVeces;
    }

    
    /** 
     * @param cantVeces
     */
    public void setCantVeces(int cantVeces) {
        this.cantVeces = cantVeces;
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
     * @return String
     */
    public toString(){
        return "";
    }

}
