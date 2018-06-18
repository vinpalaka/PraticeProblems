package java8;

public class Animal {
    private String species;
    Gender gender;
    private boolean canHop;
    private Double weight;
    private boolean canSwim;
    public Animal( String speciesName, boolean hopper, boolean swimmer) {
        species = speciesName;
        canHop = hopper;
        canSwim = swimmer;
    }

    public Animal(Animal animal) {
        this.species = animal.species;
        this.weight = animal.weight;
        this.gender = animal.gender;
    }

    public Animal( String speciesName, boolean hopper, Double weight) {
        species = speciesName;
        canHop = hopper;
        this.weight = weight;
    }

    public Animal( String speciesName, Gender m) {
        species = speciesName;
        this.gender = m;
    }

    public Animal(String species, Double weight) {
        this.species = species;
        this.weight = weight;
    }

    public Double getWeight(){
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public void setGender(Gender gender){
        this.gender = gender;
    }

    public boolean canHop() {
        return canHop; }
    public boolean canSwim() {
        return canSwim; }
    public String toString() {
        return species; } }





