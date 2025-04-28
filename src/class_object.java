public class class_object{
    public static void main(String[] args) {
        student std=new student();
        std.name="Shakib";
        std.id="IT22011";
        std.age=22;
        std.biodata();
    }
}
class student{
    String name;
    String id;
    int age;
    void biodata(){
        System.out.println(name);
        System.out.println(id);
        System.out.println(age);
    }
}
