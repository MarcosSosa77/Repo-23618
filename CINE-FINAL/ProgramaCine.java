import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class ProgramaCine
{

    public static void IniciarProgramaCine()
    {

        Scanner scanner = new Scanner(System.in);
        List<Pelicula> peliculas = new ArrayList<>();


        //Colores
        String colorRojo = "\033[0;31m";
        String colorVerde = "\033[0;32m";
        String colorAmarillo = "\033[0;33m";
        String resetColor = "\033[0;37m";
        String colorVioleta = "\033[0;33m";

         // Agregar películas por defecto
         peliculas.add(new Pelicula("Avatar", 2022, true));
         peliculas.add(new Pelicula("Avengers", 2021, true));
         peliculas.add(new Pelicula("Barbie", 2023, true));


         



        // Usuario y contraseña
        System.out.println(colorVioleta + "Bienvenido al sistema de gestión de películas."+resetColor);
        System.out.print(colorVioleta+ "Usuario: " + resetColor);
        String usuario = scanner.nextLine();
        System.out.print(colorVioleta + "Contraseña: " + resetColor);
        String contraseña = scanner.nextLine();

        if (!usuario.equals("marcos") || !contraseña.equals("1234")) {
            System.out.println(colorRojo+"Usuario o contraseña incorrectos. Saliendo del programa."+resetColor);
            return;
        }

        while (true) {
            // Menú principal
            System.out.println(colorVioleta+"\nMenú principal:"+resetColor);
            System.out.println(colorVioleta+"1."+resetColor+" Mostrar listado de películas");
            System.out.println(colorVioleta+"2."+resetColor+" Agregar película");
            System.out.println(colorVioleta+"3."+resetColor+" Editar películas en exhibición");
            System.out.println(colorVioleta+"4."+resetColor+" Eliminar película");
            System.out.println(colorVioleta+"5."+resetColor+" Salir");

            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();  // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    // Mostrar listado de películas
                    System.out.println(colorAmarillo+"-----Listado de películas-----"+resetColor);
                    for (int i = 0; i < peliculas.size(); i++) {
                        Pelicula pelicula = peliculas.get(i);
                        if(pelicula.isEnExhibicion())
                        System.out.println((i + 1) + ". " + pelicula.getNombre() + " (" + pelicula.getAño() + ") - En exhibición: " + colorVerde + pelicula.isEnExhibicion() + resetColor);
                        else
                        System.out.println((i + 1) + ". " + pelicula.getNombre() + " (" + pelicula.getAño() + ") - En exhibición: " + colorRojo + pelicula.isEnExhibicion() + resetColor);
                       
                    }

                    System.out.println(colorAmarillo+"------------------------"+resetColor);
                    System.out.println("");
                    break;

                case 2:
                    // Agregar película
                    System.out.print("Nombre de la película: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Año de la película: ");
                    int año = scanner.nextInt();
                    scanner.nextLine();  // Consumir el salto de línea
                    System.out.print("¿En exhibición? (true/false): ");
                    boolean enExhibicion = scanner.nextBoolean();
                    scanner.nextLine();  // Consumir el salto de línea

                    Pelicula nuevaPelicula = new Pelicula(nombre, año, enExhibicion);
                    peliculas.add(nuevaPelicula);
                    System.out.println(colorVerde+"Pelicula agregada con éxito."+resetColor);
                    break;

                case 3:
                    // Editar películas en exhibición
                    System.out.println("Seleccione una película para editar (por número):");
                    for (int i = 0; i < peliculas.size(); i++) {
                        Pelicula pelicula = peliculas.get(i);
                        System.out.println((i + 1) + ". " + pelicula.getNombre() + " (" + pelicula.getAño() + ") - En exhibición: " + pelicula.isEnExhibicion());
                    }
                    int seleccion = scanner.nextInt();
                    scanner.nextLine();  // Consumir el salto de línea

                    if (seleccion >= 1 && seleccion <= peliculas.size()) {
                        Pelicula peliculaSeleccionada = peliculas.get(seleccion - 1);
                        System.out.print("Cambiar estado de exhibición (true/false): ");
                        boolean nuevoEstado = scanner.nextBoolean();
                        scanner.nextLine();  // Consumir el salto de línea
                        peliculaSeleccionada.setEnExhibicion(nuevoEstado);
                        System.out.println(colorVerde+"Estado de exhibición actualizado con éxito."+resetColor);
                    } else {
                        System.out.println(colorRojo+"Opción inválida. No se realizó ningún cambio."+resetColor);
                    }
                    break;

                case 4:
                   // Eliminar película
                System.out.print(colorAmarillo+"Ingrese su contraseña para confirmar la eliminación: "+resetColor);
                String confirmacion = scanner.nextLine();

                if (confirmacion.equals(contraseña)) {
                    System.out.println(colorVerde+"Contraseña VALIDADA con EXITO"+resetColor);
                    System.out.println("---------------------------------------");
                    System.out.println(colorAmarillo+"Seleccione una película para eliminar (por número):"+resetColor);
                    for (int i = 0; i < peliculas.size(); i++) {
                        Pelicula pelicula = peliculas.get(i);
                        System.out.println((i + 1) + ". " + pelicula.getNombre() + " (" + pelicula.getAño() + ") - En exhibición: " + pelicula.isEnExhibicion());
                    }
                    int eliminar = scanner.nextInt();
                    scanner.nextLine();  // Consumir el salto de línea

                    if (eliminar >= 1 && eliminar <= peliculas.size()) {
                        peliculas.remove(eliminar - 1);
                        System.out.println(colorVerde+"Película eliminada con éxito."+resetColor);
                    } else {
                        System.out.println(colorRojo+"Opción inválida. No se realizó ninguna eliminación."+resetColor);
                    }
                } else {
                    System.out.println(colorRojo+"Contraseña incorrecta. No se permitió la eliminación de la película."+resetColor);
                }
                break;

                case 5:
                    // Salir del programa
                    System.out.println(colorRojo+"Saliendo del programa."+resetColor);
                    System.exit(0);
                    break;

                default:
                    System.out.println(colorRojo+"Opción inválida. Por favor, seleccione una opción válida."+resetColor);
                    break;
            }
        }
    }
}