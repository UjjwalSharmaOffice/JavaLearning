package inherit;

public class Main {
    public static void main(String[] args) {

//        upcasting
        Animal d1 = new Dog();

//        downcasting

        Dog d2 = (Dog) d1;
        Dog d3 = new Dog();

        d1.speak();
        d2.m1();
    }
}
