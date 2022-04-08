package Algorithm_Challenge;


import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Console console = System.console(); //Generamos el objeto console para verificar que tenemos una consola
        if (console != null)
        {
            Scanner scanner = new Scanner(console.reader());  //Fuente para la insercion de usuario
            int option ;
            do {
            console.writer().println("\nElija una opcion:\n1- Intervalo entre numeros\n2- Suma de numeros\n3- Ordenar arreglo\n4- Pierda, Papel o Tijera\n5- Calcular salario\n6- Par,Par,Impar\n0- Finalizar programa");
            option = scanner.nextInt();
            //Un Switch para facilitar la transicion
            switch (option){
                case 1:
                    Act1();
                    break;
                case 2:
                    Act2();
                    break;
                case 3:
                    Act3();
                    break;
                case 4:
                    Act4();
                    break;
                case 5:
                    Act5();
                    break;
                case 6:
                    Act6();
                    break;
                default:
                    break;
            }
            }while (option!=0);
            scanner.close();
            System.out.flush();
            System.out.println("Adios que tenga un buen dia :)");
        }
        else{
            System.out.println("No se a detectado una consola, intentelo nuevamente utilizando una consola.");
        }
    }
//-----------------------------------------------------------------------------------
    public static void Act1(){
        Console console = System.console();
        Scanner scanner = new Scanner(console.reader());
        System.out.println("Ingrese 2 numeros para ver su intervalos");
        int n1 = scanner.nextInt();
        int n2 = scanner.nextInt();
        scanner.close();  //cierro el scanner cuando termine de usarlo para ahorrar recursos
            for (int i = n1; i < n2+1; i++) {
                if(CheckPrime(i)){
                    System.out.println(i+" Es Primo");
                }
                else{
                    System.out.println(i+" No es Primo");
                }
            }
        }
    public static boolean CheckPrime(int check){
        if (check<=1){return false;} //Si el valor es 1 o menor, se sabe que no es primo
        else{
            for (int i = 2; i < check/2; i++) { //i arranca en 2 porque ya verificamos los valores previos, check/2 es para reducir a la mitad el numero de ciclos y que sea mas performante
                if ((check % i) == 0){return false;} //Para que sea Prime check % i solamente puede dar 0 si i==check, si da 0 en otro caso, no Primo
            }
            return true;}
    }
    //-----------------------------------------------------------------------------------
    public static void Act2(){
        Console console = System.console();

            Scanner scanner = new Scanner(console.reader());
            System.out.println("Ingrese 5 numeros:");
            int sum = 0;
            List<Integer> numeros= new ArrayList<>(); // Generado el arreglo de Interger
            for (int i = 0; i < 5; i++) {
                numeros.add(scanner.nextInt());
                sum=sum+numeros.get(i); //en cada iteracion, sumamos el numero nuevo
            }
            scanner.close(); //Liberamos memoria
            System.out.println("La suma de los numeros es "+sum+"\nArray en orden opuesto: ");
            for (int i = 4; i >= 0; i--) { //Recorro el Array en orden opuesto
                System.out.print(numeros.get(i)+ " ");
            }
        }
    //-----------------------------------------------------------------------------------
    public static void Act3(){
        Console console = System.console();
        Scanner scanner = new Scanner(console.reader());
        System.out.println("Ingrese 5 numeros:");
        ArrayList<Integer> array= new ArrayList<>(); // Generado el arreglo de Interger
        for (int i = 0; i < 5; i++) {
            array.add(scanner.nextInt());
        }
        ArrayList<Integer> copyArray = new ArrayList<>(array); //copia para probar segundo sort
        scanner.close();
        System.out.println(array);
        System.out.println("primer sort");
        array=sortArray(array); //prueba primer sort
        System.out.println(array);
        System.out.println("segundo sort");
        sortArrayAlternative(copyArray);//prueba segundo sort
        System.out.println(copyArray);
        int repeated= -1;
        for (Integer integer : array) {
            if (repeated == integer) { //una vez los array ordenados, es mas sencillo determinan si estan continuos los iguales
                    System.out.println("el valor: " + repeated + " se repite");
                }
                repeated = integer;
            }
        }

    //Este sort creara un nuevo array vacio en el cual va agarrando el valor mas mas pequeño del array principal y eliminando dicho valor del array principal
    public static ArrayList<Integer> sortArray(ArrayList<Integer> array){
        ArrayList<Integer> sortedArray = new ArrayList<>(); //nuevo array creado
        while(!array.isEmpty()){ //el proceso se repite hasta el array principal quede vacio
            int smallestValue= array.get(0); //el menor valor que usamos para comparar, empezamos con el primer valor del array
            int savedPosition=0; //la posicion con el menor valor
            for (int i = 0; i < array.size(); i++) {
                if(array.get(i)<smallestValue){ //si el valor actual del array es menor que smallestValue, guardamos el nuevo valor y la posicion en la que se encuentra
                    smallestValue=array.get(i);
                    savedPosition=i;
                }
            }
            sortedArray.add(smallestValue); //Guardamos el valor menor utilizando la posicion registrada
            array.remove(savedPosition); //Borramos el valor una vez transferido para poder repetir el proceso de sort
        }
        return sortedArray;
    }

    //Este sort intercambiara de posicion los valores, dejando los menores al inicio
    public static void sortArrayAlternative(ArrayList<Integer> array){
        int savedValue; //valor guardado para transferencia
        for (int i = 0; i < array.size(); i++) { //Se utilizara un doble for, el primero se utilizara para determinar que valor menor ira en esa posicion
            for (int j = i; j < array.size(); j++) { //El segundo para poder comparar la posicion actual con el resto del array
                if (array.get(j)<array.get(i)){
                    savedValue=array.get(i); //Guardo el valor a transferir
                    array.set(i, array.get(j)); //Acomodo el menor actual a su nueva posicion
                    array.set(j,savedValue); //Dejo en la posicion del cursor el valor guardado, para su nueva posicion
                    j=i; //hago un reset de j para que pueda comparar el array nuevamente
                }
            }
        }
    }
    //-----------------------------------------------------------------------------------
    public static void Act4(){
        Console console = System.console();
            Scanner scanner = new Scanner(console.reader());
            System.out.println("Jugador 1 elija una opcion: P (Piedra) | A (Papel) | T (Tijera)");
            String j1Action = scanner.nextLine(); // Agarramos la accion del Jugador 1
            if (j1Action.equalsIgnoreCase("P")|| j1Action.equalsIgnoreCase("T") || j1Action.equalsIgnoreCase("A")) //Verificamos que sea una opcion valida
            {
            System.out.println("Jugador 2 elija una opcion: P (Piedra) | A (Papel) | T (Tijera)");
            String j2Action = scanner.nextLine();// Agarramos la accion del Jugador 2
                scanner.close();
                if (j2Action.equalsIgnoreCase("P")|| j2Action.equalsIgnoreCase("T") || j2Action.equalsIgnoreCase("A")) //Verificamos que sea una opcion valida
                {
                    DetermineWinner(j1Action,j2Action); //Funcion para mejorar visibilidad
                }
                else{
                    System.out.println("Valor Invalido!!!");
                    }
            }
            else{
                System.out.println("Valor Invalido!!!");
            }
        }

    public static void DetermineWinner (String j1Action,String j2Action){ //Determinara quien es el ganador mediante un print
        switch (j1Action){ //Utilizo un switch para simplificar las comparaciones
            case "P":
                switch (j2Action) { //Utilizo un segundo switch para volver evitar usar comparadores
                    case "P" -> System.out.println("Es un Empate!");
                    case "A" -> System.out.println("El Jugador 2 Gana!");
                    case "T" -> System.out.println("El Jugador 1 Gana!");
                }
                break;
            case "A":
                switch (j2Action) {
                    case "P" -> System.out.println("El Jugador 1 Gana!");
                    case "A" -> System.out.println("Es un Empate!");
                    case "T" -> System.out.println("El Jugador 2 Gana!");
                }
                break;
            case "T":
                switch (j2Action) {
                    case "P" -> System.out.println("El Jugador 2 Gana!");
                    case "A" -> System.out.println("El Jugador 1 Gana!");
                    case "T" -> System.out.println("Es un Empate!");
                }
                break;
        }
    }
    //-----------------------------------------------------------------------------------
    public static void Act5(){
        Console console = System.console();
        Scanner scanner = new Scanner(console.reader());
        System.out.println("Ingrese el Nombre de la Persona: ");
        String name = scanner.nextLine();
        System.out.println("Ingrese la Edad de la Persona: ");
        int age = scanner.nextInt();
        System.out.println("Ingrese el Salario de la Persona: ");
        float salary = scanner.nextFloat();  //Salario en Float por si tiene centavos
        scanner.close();
        if (age<16){ //Comparamos edad
            System.out.println("Esta Persona no deberia estar Trabajando!!!");
        }else if (age>=19 && age<=50){
            System.out.println("El Salario de "+name+" es de $"+salary*1.05); //Calculo de +%5 de salario
        }
        else if (age>=51 && age<=60){
            System.out.println("El Salario de "+name+" es de $"+salary*1.10); //Calculo de +%10 de salario
        }
        else if(age>60){
            System.out.println("El Salario de "+name+" es de $"+salary*1.15); //Calculo de +%15 de salario
        }
    }
    //-----------------------------------------------------------------------------------
    public static void Act6(){
        Console console = System.console();
        Scanner scanner = new Scanner(console.reader());
        boolean success = false; //Flag de logro, cuando se cumpla
        int tries=0;
        while(!success){ //cuando se consiga "Par-Par-Impar" se termina el bucle
            tries++; // contador de intentos
            double random1 =Math.random()*1000; // Math.random genera un valor entre 0.0 y 0.999
        double random2 =Math.random()*1000;
        double random3 =Math.random()*1000;
        int rng1 = (int)random1; //Por algun motivo no se castear directamente del Math.random double a int, por eso la extra linea
        int rng2 = (int)random2;
        int rng3 = (int)random3;
        System.out.println(rng1);
        System.out.println(rng2);
        System.out.println(rng3);
        if (rng1%2==0 && rng2%2==0 && rng3%2==1){  // Condicion para determinar Par,Par,Impar
            success=true;
        }
        else{
            System.out.println("no se consiguio par, par, impar");
            System.out.println("Ingrese cualquier tecla para intentar de nuevo");
            scanner.nextLine();
        }
        }
        scanner.close();
        System.out.println("Se ha conseguido el Par, Par, Impar!!!\nNumero de intentos requeridos: "+tries);
    }
}
