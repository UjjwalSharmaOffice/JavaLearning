package Code;

public class test {
   public static void main(String[] args) {
        Car c = new Car();
        c.setName("Maruti");
        c.setModelYear(2022);
        c.accelerate(2);
       System.out.println("Car Name : " + c.getName()+ "Model year: " + c.getModelYear() );

    }
}
