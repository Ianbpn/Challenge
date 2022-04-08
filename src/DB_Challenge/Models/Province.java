package DB_Challenge.Models;

import java.util.List;

public class Province {
    private int id;
    private String name;
    private List<City> cities; //al ser una relación OneToMany genero una lista para todos los posibles objetos

    public Province(int id, String name) {
        this.id = id;
        this.name = name;
        //no pido la lista en el constructor para evitar tener que crear los objetos en orden
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }
}
