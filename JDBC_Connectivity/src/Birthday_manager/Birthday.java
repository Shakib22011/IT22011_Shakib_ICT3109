package Birthday_manager;

import java.time.LocalDate;

public class Birthday {
    private int id;
    private String name;
    private LocalDate dob;

    public Birthday(int id, String name, LocalDate dob) {
        this.id = id;
        this.name = name;
        this.dob = dob;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public LocalDate getDob() { return dob; }

    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setDob(LocalDate dob) { this.dob = dob; }
}