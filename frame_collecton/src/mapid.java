import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class mapid {
    public static void main(String[] args) {

        TreeMap<Integer, String> studentMap = new TreeMap<>();
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter student ID (integer): ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter student details (e.g., name, department): ");
            String details = sc.nextLine();

            studentMap.put(id, details);
        }

        System.out.println("\n--- Student Details (Sorted by ID) ---");
        for (Map.Entry<Integer, String> entry : studentMap.entrySet()) {
            System.out.println("ID: " + entry.getKey() + " → Details: " + entry.getValue());
        }
    }
}