public class interfaces {
    public static void main(String[] args) {
        Person p=new Person();
         p.cgpa();
    }
}

interface Student{
    abstract void cgpa();
}

class Person implements Student{
    public void cgpa(){
        System.out.println("CGPA = 3.00");
    }
}




