
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    static List<String> lista= crearLista();
    static Scanner teclado = new Scanner(System.in);
    public static void main(String[] args) {

        Inicializador();

    }



    //solo menu


    private static void Inicializador() {
        boolean cerrar = true;
        do {
            String usuario;
            int verificacion = 0;
            int verificacion2 = 0;
            do {
                usuario = IngreseUsuario();
                verificacion = verificarUsuario(usuario);
            } while (verificacion == 0);
            String contraseña;
            do {
                contraseña = IngreseContraseña();
                verificacion2 = verificarContraseña(verificacion, contraseña);
            } while (verificacion2 == 0);
            cerrar = esAdminoChofer(verificacion2);

        }while (cerrar==true);
    }

    private static boolean esAdminoChofer(int verificacion2) {
        if (verificacion2==1){
            boolean cierre = metodoadmin();
            return cierre;
        } else if (verificacion2==2) {
            metodochofer();
        }else {
            System.out.println("no existe esa opcion, el programa va a finalizar");
        }
        return true;
    }

    private static int verificarContraseña(int usuario,String contraseña) {
        if (usuario==1&&contraseña.equals("1234")){
            System.out.println("usuario ADMIN aceptado");
            return 1;

        }else if (usuario==2&&contraseña.equals("0000")){
            System.out.println("usuario chofer aceptado");
            return 2;

        }else {
            System.out.println("se equivoco en la contraseña, intente otra vez");
        }
        return 0;
    }

    private static java.lang.String IngreseContraseña() {
        System.out.println("ingrese su contraseña");
        String contraseña = teclado.nextLine();
        return contraseña;
    }

    private static java.lang.String IngreseUsuario() {
        System.out.println("ingrese su usuario");
        String usuario = teclado.nextLine();
        return usuario;
    }

    private static int verificarUsuario(String usuario) {
        if (usuario.equals("mauri")||usuario.equals("benja")){
            System.out.println("usuario ADMIN aceptado");
            return 1;

        }else if (usuario.equals("martin")||usuario.equals("tobal")){
            System.out.println("usuario chofer aceptado");
            return 2;

        }else {
            System.out.println("ese usuario no existe, intente otra vez");
        }
        return 0;
    }

    //termina solo menu




    //solo chofer
    private static void metodochofer() {
        System.out.println("aun no tenemos metodos implementados para la clase chofer, por lo que esta area esta en mantenimiento para este prototipo");

    }

    private static void elegirCamionQueVaAUsar() {
        System.out.println("elija que camion va a usar de la lista: ");
        mostrarListaParaChofer(lista);

    }

    private static void mostrarListaParaChofer(List<String> lista) {
        for(int i=0;i< lista.size();i++){
            System.out.println("camion "+1+": "+lista.get(i));
        }
    }


    //termina solo chofer




    //solo admin
    private static boolean metodoadmin() {
        boolean salir = true;
        String opcion;




        while(salir==true){
            String rojo = "\033[31m";
            String normal = "\u001B[0m";

            System.out.println("¿Que desea hacer?");
            System.out.println("1. Agregar camiones.");
            System.out.println("2. Eliminar camiones.");
            System.out.println("3. Mostra la lista");
            System.out.println("4. Cerrar sesion.");
            System.out.println(rojo+"5. Cerrar aplicacion");
            System.out.println(normal);

            opcion =opcionMenu();
            if(opcion.equals("1")){
                agregarCamiones(lista);
            }else if(opcion.equals("2")) {
                eliminarCamion(lista);
            }else if(opcion.equals("3")){
                mostrarLista(lista);
            }else if(opcion.equals("4")){
                salir=false;
            }else if(opcion.equals("5")) {
                boolean confirmarcierre=true;
                do {
                    System.err.println("desea cerrar la aplicacion o dejar abierto (si desea cerrar se borraran archivos, si desea dejar abieto no ocurrira nada y seguida funcionando como siempre )");
                    System.out.println("para seguir abierto (1), para cerrar (SALIR)");
                    String palabracierre = teclado.next();
                    if (palabracierre.equals("1")){
                        confirmarcierre=false;
                    }else if (palabracierre.equals("SALIR")){
                        confirmarcierre=false;
                        return false;
                    }
                }while (confirmarcierre==true);
            } else{
                System.out.println("La opcion que ha ingresado no es aceptable");
            }

        }


        return true;
    }

    public static void volver(){
        System.out.println();
        System.out.println("1. Agregar camiones.");
        System.out.println("2. eliminar camiones.");
        System.out.println("3. salir.");
    }
    public static String opcionMenu(){
        Scanner sc = new Scanner(System.in);
        System.out.println("ingrese su opción");
        String numero=sc.nextLine();

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

    //termina solo admin
}