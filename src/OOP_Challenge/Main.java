package OOP_Challenge;

import java.time.LocalDate;


public class Main {
    public static void main(String[] args) {
        /*creadas las instancias de persona,
         p1 y p3 utilizan constructor con parametros, intencionalmente creados con los mismos datos
         p2 utiliza constructor sin parametros*/
        Person p1 = new Person("Ian","Pereyra", LocalDate.of(1998,8,22));
        Person p2 = new Person();
        Person p3 = new Person("Ian","Pereyra", LocalDate.of(1998,8,22));

        //Llamada al toString modificado
        System.out.println(p1.toString());

        //Funcion que mostrara por pantalla
        p1.MyInfo();

        if (areEquals(p1,p3)){
            System.out.println("Son iguales");
        }
        else{
            System.out.println("Son distintos");
        }

        //Creada instancia de Employee
        Employee e1 = new Employee("Brian", "Noreiko", LocalDate.now(), "...","IT");

        //Comparte Behaviours del Padre
        System.out.println(e1);
        e1.MyInfo();
    }

    //Funcion para comparar 2 objetos Person
    public static boolean areEquals(Person person1, Person person2){
        //Utiliza la funcion equals del objeto
        return person1.equals(person2);
    }
}
