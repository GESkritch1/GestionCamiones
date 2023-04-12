
import java.util.Scanner;
import java.util.*;
public class Main {

    public static void main(String[] args) {
        menu();

    }

    public static void menu() {
        boolean salir = true;
        int opcion;


        List<String> lista= crearLista();

        while(salir==true){
            System.out.println("¿Que desea hacer?");
            System.out.println("1. Agregar camiones.");
            System.out.println("2. Eliminar camiones.");
            System.out.println("3. Mostra la lista");
            System.out.println("4. Salir.");

            opcion =opcionMenu();
            if(opcion==1){
                agregarCamiones(lista);
            }if(opcion==2) {
                eliminarCamion(lista);
            }if(opcion==3){
                mostrarLista(lista);
            }
            if(opcion==4){
                salir=false;}
            else{
                System.out.println("La opcion que ha ingresado no es aceptable");
            }

        }



    }
    public static void volver(){
        System.out.println();
        System.out.println("1. Agregar camiones.");
        System.out.println("2. eliminar camiones.");
        System.out.println("3. salir.");
    }
    public static int opcionMenu(){
        Scanner sc = new Scanner(System.in);
        System.out.println("ingrese su opción");
        int numero=sc.nextInt();

        return numero;
    }

    public static String pedirDatos() {
        Scanner sc = new Scanner(System.in);
        String Teclado = sc.nextLine();
        return Teclado;
    }

    public static List<String> crearLista() {

        ArrayList Lista = new ArrayList();
        return Lista;
    }

    public static List<String> agregarCamiones(List<String> cam) {
        System.out.println("Añada un camión:");
        String agregar = pedirDatos();
        cam.add(agregar);

        return cam;

    }
    public static List<String> eliminarCamion(List<String> cam){
        System.out.println("Que desea eliminar:");
        String elimnar = pedirDatos();
        if(!cam.isEmpty()){
            cam.remove(elimnar);}
        else{
            System.out.println("La lista esta vacia");
        }
        return cam;
    }

    public static void mostrarLista(List<String> lista){
        for(int i=0;i< lista.size();i++){
            System.out.println(lista.get(i));
        }

    }

}
