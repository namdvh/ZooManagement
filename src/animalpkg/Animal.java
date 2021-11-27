package animalpkg;

import java.util.Comparator;

public class Animal implements Comparable<Animal> {
    private String id;
    private String name;
    AnimalTypes type;
    private String color;
    private double weight;

    public Animal() {
    }

    public Animal(String id, String name, AnimalTypes type, String color, double weight) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.color = color;
        this.weight = weight;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AnimalTypes getType() {
        return type;
    }

    public void setType(AnimalTypes type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public int compareTo(Animal o) {
        int d = this.type.getType() - o.type.getType();
        return d < 0 ? -1 : d == 0 ? 0 : 1;
    }
    //Create data string for printing to monitor

    @Override
    public String toString() {
        return "Animal{" + "ID=" + id + ", name=" + name + ", color=" + color + ", weight=" + weight + "\n\t" + ", type=" + type + '}';
    }

    //Create da ta string for writing to file
    public String strtoFile() {
        return id + ";" + name + ";" + type.getType() + ";" + color + ";" + weight;
    }
}
