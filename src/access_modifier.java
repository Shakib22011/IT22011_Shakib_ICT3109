public class access_modifier{
    public static void main(String[] args) {
        student1 stdnt=new student1();
        stdnt.setName("Shakib");
        stdnt.id="IT22011";
        stdnt.versity="MBSTU";
        stdnt.biodata();
    }
}

class student1{
    private String name;
    protected String id;
    public String versity;

    public void setName(String Name) {
        this.name = Name;
    }

    public String getName() {
        return name;
    }

    void biodata(){
        System.out.println(name);
        System.out.println(id);
        System.out.println(versity);
    }
}