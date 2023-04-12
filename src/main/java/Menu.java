import java.util.Scanner;

public class Menu {
    static Scanner teclado = new Scanner(System.in);
    public static void main(String[] args) {
        Inicializador();
    }

    private static void Inicializador() {
        String usuario;
        int verificacion=0;
        int verificacion2=0;
        do {
            usuario = IngreseUsuario();
            verificacion=verificarUsuario(usuario);
        }while (verificacion==0);
        String contraseña;
        do {
            contraseña=IngreseContraseña();
            verificacion2=verificarContraseña(verificacion,contraseña);

        }while (verificacion2==0);

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







    private static void metodochofer() {
        System.out.println("por ahora no hay metodos para chofer estamos en un prototipo :)");
    }

    private static void metodoadmin() {
        System.out.println("por ahora no hay metodos para ADMIN estamos en un prototipo :)");
    }

}