package OOP_Challenge;

import java.time.LocalDate;
import java.util.Date;

public class Employee extends Person {
    //Hereda los atributos de Person que necesita
    private String File;
    private String Department;

    //Constructor con parametros
    public Employee(String firstName, String lastName, LocalDate birthday, String file, String department) {
        super(firstName, lastName, birthday);   //Utilizamos el constructor de Person para estos datos
        File = file;
        Department = department;
    }

    //Getters & Setters
    public String getFile() {
        return File;
    }
    public void setFile(String file) {
        File = file;
    }
    public String getDepartment() {
        return Department;
    }
    public void setDepartment(String department) {
        Department = department;
    }

    @Override
    public String toString() {
        return super.toString()+" -> " +"Employee{" +
                "File='" + File + '\'' +
                ", Department='" + Department + '\'' +
                '}';
    }
}
