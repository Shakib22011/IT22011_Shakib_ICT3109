import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class hashmap {

    public static void main(String[] args) {

        HashMap<Integer, String> employeeMap = new HashMap<>();

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of employees: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.println("Enter employee ID (integer): ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.println("Enter department: ");
            String department = sc.nextLine();

            employeeMap.put(id, department);
        }

        System.out.println("\n--- Employee Department Mappings ---");
        for (Map.Entry<Integer, String> entry : employeeMap.entrySet()) {
            System.out.println("Employee ID: " + entry.getKey() + " → Department: " + entry.getValue());
        }
    }
}