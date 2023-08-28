/**
 * Universidad del Valle de Guatemala
 * @author Angie Nadissa Vela López, 23764
 * @description Clase para la administración de las reservas del Hotel y creación de nuevos clientes
 * @date creación 28/08/2023 última modificación 28/08/23
 */

public class Hotel {
    private boolean banderaHuesped;
    private int cantHuespedes;
    private Habitacion[] habitaciones;
    private Huesped[] huespedes;
    private Huesped[] listaEspera;
    
    //Uso constructor vacio para apartar los espacios en memoria de los objetos de cada arreglo
    public Hotel(){
        banderaHuesped = true;
        cantHuespedes = 0;
        habitaciones = new Habitacion[5];
        huespedes = new Huesped[30];
        listaEspera = new Huesped[30];
        llenarArregloHabitaciones();
    }
    
    
    /** 
     * @return boolean
     */
    public boolean getBanderaHuesped() {
        return banderaHuesped;
    }
    /**
     * habitaciones[0] -> habitacion estandar
     *  habitaciones[1] -> habitacion estandar
     *  habitaciones[2] -> habitacion estandar
     *  habitaciones[3] -> habitacion deluxe
     *  habitaciones[4] -> habitacion suite
     */
    public void llenarArregloHabitaciones(){//aca utilizo los constructores con parametros para llenar los objetos de los arreglos
        //lleno las 3 habitaciones estandar
        for(int i = 0; i < 3; i++){
            Habitacion h1 = new Habitacion((i+1), 0, 3, 4, 250, true);
            habitaciones[i] = h1;
        }
        //lleno habitacion deluxe
        Habitacion h2 = new Habitacion(4, 0, 2, 2, 500, true);
        habitaciones[3] = h2;
        //lleno habitacion suite
        Habitacion h3 = new Habitacion(5, 0, 1, 2, 1000, true);
        habitaciones[4] = h3;
    }

    
    /** 
     * @param nombre
     * @param telefono
     * @param cantVeces
     * @param capOcupantes
     * @param tipoHabitacion
     * metodo para guardar huespedes
     */
    public void recibirHuesped(String nombre, String telefono, int cantVeces, int capOcupantes, int tipoHabitacion){
        if(banderaHuesped){
            Huesped hues = new Huesped((cantHuespedes+1), nombre, telefono, cantVeces, capOcupantes, tipoHabitacion);
            huespedes[cantHuespedes] = hues;
            banderaHuesped = false;
            cantHuespedes++;
        }
    }

    
    /** 
     * @param tipoHabitacion
     * @param indexHuesped
     * @return boolean
     * Este metodo valida si la cantidad de huespedes que se quieren hospedar es menor a la capacidad de ocupantes
     * verifica si hay disponibilidad y el estatus del cliente (cantidad de veces que se ha hospedado en el hotel)
     * Esto se realiza por habitacion 
     */
    public boolean validarHabitacion(int tipoHabitacion, int indexHuesped){
        boolean flag = false;
        if(tipoHabitacion == 1){//quiere suite
            if((huespedes[indexHuesped].getCapOcupantes() <= habitaciones[4].getCapOcupantes()) && (habitaciones[4].getDisponibilidad()) && (huespedes[indexHuesped].getCantVeces() >= 10)){
                 flag = true;
            }

        }else if(tipoHabitacion == 2){//quiere deluxe
            if((huespedes[indexHuesped].getCapOcupantes() <= habitaciones[3].getCapOcupantes()) && (habitaciones[3].getDisponibilidad()) && (huespedes[indexHuesped].getCantVeces() >= 5)){
                 flag = true;
            }

        }else if(tipoHabitacion == 3){//quiere estandar
            
            if(huespedes[indexHuesped].getCapOcupantes() <= habitaciones[0].getCapOcupantes()){
                 flag = true;
            }
        }

        return flag;
    }

    /*
     * Aqui se realiza la reserva de las habitaciones
     * se actualiza la disponibilidad y se actualiza el valor de idHuesped en la habitacion
     * esto para saber cual huesped se hospeda en la habitacion
     */
    public void asignarHabitacion(){
        int index = obtenerIndexHuesped();
        if(index != -1){
            int tipoHabitacion = huespedes[index].getTipoHabitacion();
            if(validarHabitacion(tipoHabitacion, index)){
                
                if(tipoHabitacion == 1){//quiere suite

                    habitaciones[4].setDisponibilidad(false);
                    habitaciones[4].setIdHuesped(huespedes[index].getIdHuesped());
                    System.out.println("\nSuite reservada con éxito!");

                }else if(tipoHabitacion == 2){//quiere deluxe

                    habitaciones[3].setDisponibilidad(false);
                    habitaciones[3].setIdHuesped(huespedes[index].getIdHuesped());
                    System.out.println("\nHabitacion Deluxe reservada con éxito!");

                }else if(tipoHabitacion == 3){//quiere estandar

                    if(habitaciones[0].getDisponibilidad()){

                        habitaciones[0].setDisponibilidad(false);
                        habitaciones[0].setIdHuesped(huespedes[index].getIdHuesped());
                        System.out.println("\nHabitacion No.1 estandar reservada con éxito!");

                    }else if(habitaciones[1].getDisponibilidad()){

                        habitaciones[1].setDisponibilidad(false);
                        habitaciones[1].setIdHuesped(huespedes[index].getIdHuesped());
                        System.out.println("\nHabitacion No.2 estandar reservada con éxito!");

                    } else if(habitaciones[2].getDisponibilidad()){

                        habitaciones[2].setDisponibilidad(false);
                        habitaciones[2].setIdHuesped(huespedes[index].getIdHuesped());
                        System.out.println("\nHabitacion No.3 estandar reservada con éxito!");

                    }else{
                        System.out.println("\nNo es posible reservar la habitación");
                        guardarListaEspera(huespedes[index]);
                    }
                }
            }else{
                System.out.println("\nNo es posible reservar la habitación");
                guardarListaEspera(huespedes[index]);
            }
        }
        banderaHuesped = true;
    }

    
    /** 
     * @param huesped
     * Se registran a los huespedes en la lista de espera
     */
    public void guardarListaEspera(Huesped huesped){
        int index = 0, lastIndex = -1;
        for(Huesped currentHuesped:listaEspera){
            if (currentHuesped == null){
                lastIndex = index;  
            } 
            index++;
        }
        if(lastIndex != -1){
            listaEspera[lastIndex] = huesped;
        }
        System.out.println("\nEl huesped se ha registrado en la lista de espera");
    }

    
    /** 
     * @return int
     * funcion que devuelve el index del ultimo huesped registrado
     */
    public int obtenerIndexHuesped(){
        int index = 0, lastIndex = -1;
        for(Huesped currentHuesped:huespedes){
            if (currentHuesped != null){
                lastIndex = index;  
            } 
            index++;
        }
        return lastIndex;
    }

}
