class person {
    private String name;  // private: accessible only within the class

    public void setName(String newName) {
        name = newName;
    }
    public String getName() {
        return name;
    }
}
public class encapsulation {
    public static void main(String[] args) {
        person p = new person();
        p.setName("Shakib");
        System.out.println(p.getName());
    }
}
