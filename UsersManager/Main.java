import java.util.Scanner;
import java.util.HashMap;

public class Main {
    private static String menu =    "1. Agregar usuario\n" +
                                    "2. Iniciar sesión\n"  +
                                    "3. Cambiar contraseña\n" +
                                    "4. Cerrar sesión\n" +
                                    "5. Listar usuarios\n" +
                                    "0. Salir";
    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, User> users = new HashMap<String, User>();

        int option;
        String username;
        String password;
        String newPassword;

        do {
            System.out.println(menu);
            option = sc.nextInt();

            switch (option) {
                case 1: // Agregar usuario
                    System.out.println("Agregar usuario");
                    username = input("Nombre de usuario: ");
                    password = input("Contraseña: ");
                    users.put(username, new User(username, password));
                    break;

                case 2: // Iniciar sesión
                    System.out.println("Iniciar sesión");
                    username = input("Nombre de usuario: ");
                    password = input("Contraseña: ");
                    try {
                        users.get(username).login(username, password);
                    } catch (LoginFailedException e) {
                        System.out.println(e);
                    }
                    break;

                case 3: // Cambiar contraseña
                    System.out.println("Cambiar contraseña");
                    username = input("Nombre de usuario: ");
                    password = input("Contraseña anterior: ");
                    newPassword = input("Nueva contraseña: ");
                    try {
                        users.get(username).changePassword(username, password, newPassword);
                    } catch (LoginFailedException | InvalidDataException e) {
                        System.out.println(e);
                    }
                    break;

                case 4: // Cerrar sesión
                    System.out.println("Cerrar sesión");
                    username = input("Nombre de usuario: ");
                    users.get(username).logout();
                    break;

                case 5: // Listar usuarios
                    System.out.println("Usuarios * (Activos)");
                    for (User user : users.values()) {
                        System.out.println(user.getUsername() + " " + (user.isActive() ? "*" : ""));
                    }
                    break;
            
                case 0: // Salir
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("La opción " + option + "no existe");
                    break;
            }

        } while (option != 0);

        sc.close();
    }

    public static String input(String message) {
        Scanner sc = new Scanner(System.in);
        System.out.print(message);
        String result = sc.nextLine();
        return result;
    }
}
