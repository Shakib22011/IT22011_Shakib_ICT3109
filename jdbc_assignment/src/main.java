import java.sql.*;
import java.util.Scanner;
public class main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("\nMenu:");
        System.out.println("1. Add student");
        System.out.println("2. View all students");
        System.out.println("3. Delete a Student");
        System.out.println("4. Exit");
        System.out.print("Choose an option: ");
        int choice = sc.nextInt();
        sc.nextLine();
            if(choice==1)
            {
                System.out.println("Name: ");
                Scanner scanner = new Scanner(System.in);
                String name = scanner.nextLine();
                //System.out.print(name);
                queries q = new queries();
                q.InsetDB(name);
            }
            if(choice==2)
            {
                queries r=new queries();
                r.ReadFromDB();
            }
            if(choice==3)
            {
                System.out.println("ID which student you wanna delete: ");
                int i = sc.nextInt();
                queries t= new queries();
                t.deleteStudent(i);
            }
            else
            {
                System.out.println("successfullu terminated.");

            }
        }
    }

