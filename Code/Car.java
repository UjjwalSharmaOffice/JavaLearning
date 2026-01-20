package Code;

public class Car {

//    all the fields by default stays private and accessed and edited by getters and setters
    private String name;
    private int modelYear;

    Car(String name, int modelYear) {
        this.name = name;
        this.modelYear = modelYear;
    }
    Car(){}

    void accelerate(int input) {
        System.out.println("Accelerating with value " + input);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getModelYear() {
        return modelYear;
    }

    public void setModelYear(int modelYear) {
        this.modelYear = modelYear;
    }
}
