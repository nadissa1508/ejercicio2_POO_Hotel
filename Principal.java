import java.util.Scanner;
/**
 * Universidad del Valle de Guatemala
 * @author Angie Nadissa Vela López, 23764
 * @description Clase principal para guardar clientes y realizar reservas del hotel
 * @date creación 28/08/2023 última modificación 28/08/23
 */
public class Principal {

    /**
     * Menú para gestionar el hotel
     */
    public static void menu(){
        Scanner teclado = new Scanner(System.in);
        Hotel hotel = new Hotel();
        int opcion = 0;
        String opUser = "";

        while (opcion != 3){
            
            System.out.println("\n***************************");
            System.out.println("\nSerene Heaven Hotel");
            System.out.println("\n***************************");
            System.out.println("\nOpciones: \n1.Recibir Huesped \n2.Asignar huesped a habitacion \n3.Salir");
            System.out.println("\nSeleccione su opción: ");
            opUser = teclado.nextLine();

            try{
                opcion = Integer.parseInt(opUser);      
            }catch(Exception e){
                System.out.println("\nError, ingrese un número");
            }

            if(opcion < 1 || opcion > 3){
                System.out.println("\nError, ingrese una opción del menú");
            }else {
                
                if(opcion == 1){

                    String nombre = "", telefono = "", cantV = "", cantO= "", tipoHabitacion="";
                    int cantVeces = 0, cantOcupantes = 0, tipoHabitacion = 0 ;

                    System.out.println("\n\nIngrese nombre del huesped: ");
                    nombre = teclado.nextLine();

                    System.out.println("\nIngrese telefono de emergencia: ");
                    telefono = teclado.nextLine();

                    System.out.println("\nCantidad de veces que el huesped ha visitado el hotel: ");
                    cantV = teclado.nextLine();  

                    try{
                        cantVeces = Integer.parseInt(cantV);
                    }catch(Exception e){
                        System.out.println("\nError, ingrese un número");
                    }

                    if(cantVeces > 0){
                        System.out.println("\nCantidad de ocupantes de la habitacion: ");
                        cantO = teclado.nextLine();

                        try {
                            cantOcupantes = Integer.parseInt(cantO);
                        } catch (Exception e) {
                             System.out.println("\nError, numero invalido");
                        }

                        System.out.println("\nIngrese el tipo de habitación que desea 1)Suite 2)Deluxe 3)Estandar: ");
                        tipoHabitacion = teclado.nextLine();

                        try {
                            tipoHabitacion = Integer.parseInt(tipoHabitacion);
                        } catch (Exception e) {
                             System.out.println("\nError, numero invalido");
                        }
                        if(tipoHabitacion >= 1 && tipoHabitacion <=3){
                            hotel.recibirHuesped(nombre, telefono, cantVeces, cantOcupantes, tipoHabitacion);
                        }

                    }else{
                        System.out.println("\nError, número invalido");
                    }


                }else if(opcion == 2){
                    hotel.asignarHabitacion();
                }

            }
        }   
    }
    
    public static void main(String[] args){
        //iniciar el menu principal del juego
        menu();
    }
}
