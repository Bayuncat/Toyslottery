package org.example;

public class Toy implements Comparable {
    int id;
    String toyName;

    public Toy(int id, String toyName) {
        this.id = id;
        this.toyName = toyName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getToyName() {
        return toyName;
    }

    public void setToyName(String toyName) {
        this.toyName = toyName;
    }

    @Override
    public String toString() {
        return "Toy{" +
                "id=" + id +
                ", toyName='" + toyName + '\'' +
                '}';
    }


    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
