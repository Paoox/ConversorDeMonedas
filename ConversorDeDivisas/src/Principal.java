import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        int opcion = 0;

        try {
            while (opcion != 9 ) {
                //mostrando el menú de opciones
                System.out.println(Menu.menu);
                System.out.println("Escribe la opción deseada del menu");
                //creando un objeto de la clase Scanner para leer el teclado la opcion del menu elegida
                Scanner opcionMenu = new Scanner(System.in);
                opcion = opcionMenu.nextInt();
                if (opcion == 9){
                    System.out.println("Elegiste salir");
                    System.out.println("Gracias por usar nuestro programa");
                    System.out.println("Cerrando programa");
                    System.out.println("Vuelve pronto");
                    break;
                }
                if(opcion > 10  || opcion < 1 ) {
                    System.out.println("Intentalo nuevamente recuerda solo numeros del 1 al 9");
                    System.out.println("Reiniciando");
                }
                else{
                    System.out.println("Escribe la cantidad que quieres convertir");
                    //leemos la opcion de la cantidad a convertir
                    Scanner entrada = new Scanner(System.in);
                    int cantidad = Integer.valueOf(entrada.nextInt());
                    if (cantidad <= 0) {
                        System.out.println("No se puede convertir una cantidad negativa");
                        System.out.println("Reiniciando");
                        opcion = 0;
                    }

                    ConversorMoneda consulta = new ConversorMoneda();

                    switch (opcion) {
                        case 1:
                            System.out.println("Has seleccionado la Conversión de Dolares a Pesos Argentinos");
                            System.out.println(cantidad + " " + "dolares equivale a" + " " + consulta.conversor(cantidad, "USD", "ARS")
                                    + " " + "pesos argentinos");
                            break;
                        case 2:
                            System.out.println("Has seleccionado la Conversión de Pesos Argentinos a Dolares");
                            System.out.println(cantidad + " " + "pesos argentinos equivale a" + " " + consulta.conversor(cantidad, "ARS", "USD")
                                    + " " + "dolares");
                            break;
                        case 3:
                            System.out.println("Has seleccionado la Conversión de Dolares a Real Brasileños");
                            System.out.println(cantidad + " " + "dolares equivale a" + " " + consulta.conversor(cantidad, "USD", "BRL")
                                    + " " + "reales brasileños");
                            break;
                        case 4:
                            System.out.println("Has seleccionado la Conversión de Real Brasileños a Dolares");
                            System.out.println(cantidad + " " + "reales brasileños equivale a" + " " + consulta.conversor(cantidad, "BRL", "USD")
                                    + " " + "dolares");
                            break;
                        case 5:
                            System.out.println("Has seleccionado la Conversión de Dolares a Peso Colombiano ");
                            System.out.println(cantidad + " " + "dolares equivale a" + " " + consulta.conversor(cantidad, "USD", "COP")
                                    + " " + "peso colombiano");
                            break;
                        case 6:
                            System.out.println("Has seleccionado la Conversión de Peso Colombiano a Dolares");
                            System.out.println(cantidad + " " + "peso colombiano equivale a" + " " + consulta.conversor(cantidad, "COP", "USD")
                                    + " " + "dolares");
                            break;
                        case 7:
                            System.out.println("Has seleccionado la Conversión de Dolares a Peso Mexicano");
                            System.out.println(cantidad + " " + "dolares equivale a" + " " + consulta.conversor(cantidad, "USD", "MXN")
                                    + " " + "pesos mexicanos");
                            break;
                        case 8:
                            System.out.println("Has seleccionado la Conversión de Peso Mexicano a Dolares");
                            System.out.println(cantidad + " " + "pesos mexicanos equivale a" + " " + consulta.conversor(cantidad, "MXN", "USD")
                                    + " " + "dolares");
                            break;
                        default:
                            System.out.println("Opción no valida, por favor vuelva a intentarlo");
                            opcion = 0;
                            break;
                    }}
            }
        } catch (NumberFormatException e) {
            System.out.println("No se pudo completar la información" );
        } catch (RuntimeException e) {
            System.out.println("El caracter introducido no es un numero" );
            System.out.println("Finalizando la aplicación");
        }
    }
}
