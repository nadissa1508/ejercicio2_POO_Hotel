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

    public Hotel(){
        banderaHuesped = true;
        cantHuespedes = 0;
        habitaciones = new Habitacion[5];
        huespedes = new Huesped[30];
        listaEspera = new Huesped[30];
        llenarArregloHabitaciones();
    }

    /**
     * habitaciones[0] -> estandar
     *  habitaciones[1] -> estandar
     *  habitaciones[2] -> estandar
     *  habitaciones[3] -> deluxe
     *  habitaciones[4] -> suite
     */
    public void llenarArregloHabitaciones(){
        for(int i = 0; i < 3; i++){
            Habitacion h1 = new Habitacion((i+1), 0, 3, 4, 250, true);
            habitaciones[i] = h1;
        }
        Habitacion h2 = new Habitacion(4, 0, 2, 2, 500, true);
        habitaciones[3] = h2;
        Habitacion h3 = new Habitacion(5, 0, 1, 2, 1000, true);
        habitaciones[4] = h3;
    }

    public void recibirHuesped(String nombre, String telefono, int cantVeces, int capOcupantes, int tipoHabitacion){
        if(banderaHuesped){
            Huesped hues = new Huesped((cantHuespedes+1), nombre, telefono, cantVeces, capOcupantes, tipoHabitacion);
            huespedes[cantHuespedes] = hues;
            banderaHuesped = false;
            cantHuespedes++;
        }else{
            System.out.println("\nError, verificar si el huesped recien ingresado puede reservar una habitación antes de ingresar otro huesped");
        }
    }

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
                        guardarListaEspera(huespedes[index]);
                    }
                }
            }else{
                guardarListaEspera(huespedes[index]);
            }
        }
        banderaHuesped = true;
    }

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
    }

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
