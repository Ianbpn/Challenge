package OOP_Challenge;

import java.time.LocalDate;
import java.util.Objects;


public class Person {

    // Atributos basicos de la clase
    private String FirstName;
    private String LastName;
    private LocalDate Birthday;

    // Constructor parametrizado
    public Person(String firstName, String lastName, LocalDate birthday) {
        FirstName = firstName;
        LastName = lastName;
        Birthday = birthday;
    }
    // Constructor sin parametrizar
    public Person() {
        FirstName = null;
        LastName = null;
        Birthday = null;
    }

    // Getters & Setters, usados para tener accesos a los atributos de la clase
    public String getFirstName() {
        return FirstName;
    }
    public void setFirstName(String firstName) {
        FirstName = firstName;
    }
    public String getLastName() {
        return LastName;
    }
    public void setLastName(String lastName) {
        LastName = lastName;
    }
    public LocalDate getBirthday() {
        return Birthday;
    }
    public void setBirthday(LocalDate birthday) {
        Birthday = birthday;
    }

    // Sobrescritura de metodo toString para traer datos deseados, en este caso nombrew y apellido
    @Override
    public String toString() {
        return "Person{" +
                "FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                '}';
        //Este toString retornara un String para uso posterior, como para el uso de un print
    }

    //MyInfo solamente mostrara por pantalla los atributos
    public void MyInfo(){
        System.out.println("FirstName = "+FirstName+"\n"+
                            "LastName = "+LastName+"\n"+
                            "Birthday = "+Birthday +"\n"+
                            "Hashcode " + this.hashCode());
    }

    //Sobrescribimos el equals y el hashcode, estos se sobrescriben a la par
    //el equals por defecto compara la identidad (id) de la instancia del objeto, lo cambio para que compare los atributos en su lugar
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(FirstName, person.FirstName) && Objects.equals(LastName, person.LastName) && Objects.equals(Birthday, person.Birthday);
    }
    //Al comparar los 2 objetos, ademas de tener los atributos iguales, necesitamos que imiten la id de instancia para que resulten completamente iguales
    @Override
    public int hashCode() {
        return Objects.hash(FirstName, LastName, Birthday);
    }
}
