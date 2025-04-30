public class Multiple_inheri {
    public static void main(String[] args) {
        per p=new per();
        p.teach();
        p.name();
    }
}

interface Teacher{
    void teach();
}

interface stdnt{
    void name();
}

class per implements Teacher,stdnt{
    public void teach(){
        System.out.println("Mr. Anisul Islam teacher C++");
    }
    public void name(){
        System.out.println("His students name is Rakib");
    }
}
