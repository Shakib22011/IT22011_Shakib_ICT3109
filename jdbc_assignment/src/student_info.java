public class student_info {
    private int id;
    private String name;

    public student_info() {
    }
    public student_info(int id, String name) {
        this.id=id;
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
