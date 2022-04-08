package DB_Challenge.Models;

public class Grades {
    private int id;
    private int qualification;

    public Grades(int id, int qualification) {
        this.id = id;
        this.qualification = qualification;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQualification() {
        return qualification;
    }

    public void setQualification(int qualification) {
        this.qualification = qualification;
    }
}
