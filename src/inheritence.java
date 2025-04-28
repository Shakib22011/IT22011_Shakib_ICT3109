class cars{
    String brand;
    String color;
    String model;
}
public class inheritence{
    static
    class data extends cars {
       void print() {
           System.out.println(brand);
           System.out.println(color);
           System.out.println(model);
       }
    }
    public static void main(String[] args) {
        data obj=new data();
        obj.brand="Toyota";
        obj.color="Blue";
        obj.model="2019";
        obj.print();
        }
}

