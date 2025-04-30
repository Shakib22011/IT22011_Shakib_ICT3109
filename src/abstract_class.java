public class abstract_class {
    public static void main(String[] args) {
        person1 p=new person1();
        p.teach();
        p.salary();
    }
}

class person1 extends teacher{
    void salary(){
        System.out.println("He gets paid about 80k pre month.");
    }
}

abstract class teacher{   //no objects in abstract class
    void teach(){
        System.out.println("He is a Teachet.");
    }
    abstract void salary();
}
