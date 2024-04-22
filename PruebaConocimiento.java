package examen;

import java.util.Scanner;
public class PruebaConocimiento {
    Scanner sc = new Scanner(System.in);

    String usuario;
    String contraseña;
    String nuevoUsuario;
    String nuevaContraseña;
    boolean existeUsuario;

        String[] Usuarios = new String[5];
        String[] Contraseña = new String[3];
        String[][] Matriz = new String[5][3];
        int Registros = 0;

        public void Registro(){

            int menu = 0;

            while (menu <=3){
                System.out.println("\n" + "Bienvenido al sistema: "+ "\n");
                System.out.println("1. Registrarse");
                System.out.println("2. Iniciar sesión");
                System.out.println("3. Salir"+ "\n");
                System.out.print("Ingrese su opción: ");
                menu = sc.nextInt();
                sc.nextLine();

                switch (menu) {
                    case 1:
                        registrarUsuario();
                        break;
                    case 2:
                        iniciarSesion();
                        break;
                    case 3:
                        System.out.println("Gracias, regrese pronto");
                        break;
                    default:
                        System.out.println("Opción incorrecta. Por favor, ingrese una opción válida.");
                }
            }
            System.out.println("El programa a finalizado");
            sc.close();

        }

        // Método para registrar un nuevo usuario
        public void registrarUsuario() {
            System.out.println("Por favor, ingrese su nombre de usuario:");
            nuevoUsuario = sc.nextLine();
            System.out.println("Por favor, ingrese su contraseña:");
            nuevaContraseña = sc.nextLine();

            // Validar si el usuario ya existe
            if (existeUsuario) {
                System.out.println("Usuario existente. Por favor ingrese con otro usuario."+ "\n");
            } else {
                Usuarios[Registros] = nuevoUsuario;
                Contraseña[Registros] = nuevaContraseña;

                // Simular el almacenamiento de otra información relacionada con el usuario
                System.out.println("Ingrese su nombre completo:");
                Matriz[Registros][0] = sc.nextLine();
                System.out.println("Ingrese su edad:");
                Matriz[Registros][1] = sc.nextLine();
                System.out.println("Ingrese su correo electrónico:");
                Matriz[Registros][2] = sc.nextLine();

                Registros++;
                System.out.println("***Registro exitoso***");
            }
        }

        // Método para iniciar sesión
        public void iniciarSesion() {
            System.out.println("Ingrese su nombre de usuario:");
            usuario = sc.nextLine();
            System.out.println("Ingrese su contraseña:");
            contraseña = sc.nextLine();

            // Validar las credenciales de inicio de sesión
            boolean credencialesValidas = false;
            for (int i = 0; i < Registros; i++) {
                if (Usuarios[i].equals(usuario) && Contraseña[i].equals(contraseña)) {
                    credencialesValidas = true;
                    System.out.println("Inicio de sesión exitoso. Bienvenido, " + usuario);

                    System.out.println("Nombre completo: " + Matriz[i][0]);
                    System.out.println("Edad: " + Matriz[i][1]);
                    System.out.println("Correo electrónico: " + Matriz[i][2]);
                    break;
                }
            }

            if (!credencialesValidas) {
                System.out.println("Nombre de usuario o contraseña incorrecto. Intente de nuevo" + "\n" + "--------------------------------------------------------------------------" );
            }
        }

        // Método para verificar si un usuario ya está registrado
        boolean existeUsuario() {
            for (int i = 0; i < Registros; i++) {
                if (Usuarios[i].equals(usuario)) {
                    return true;
                }
            }
            return false;
        }
    }
