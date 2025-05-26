import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class smallest {
    public static int KthSmallest(ArrayList<Integer> Array, int x)
    {
        if(x<0 || x>Array.size())
        {
            throw new IllegalArgumentException("Invalid value of x");
        }
        else
        {
            Collections.sort(Array);
            return Array.get(x - 1);

        }
    }
    public static void main(String[] args)
    {

        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> Array = new ArrayList<>();
        System.out.println("Enter the number of elements:");
        int n = sc.nextInt();
        System.out.println("Enter " + n + " elements:");
        for(int i=0;i<n;i++)
        {
            Array.add(sc.nextInt());
        }
        System.out.println("Enter the xth element to be searched:");
        int x = sc.nextInt();

        try
        {
            int kthsmallest = KthSmallest(Array,x);
            System.out.println("The " + x + "th smallest element is: " + kthsmallest);
        }
        catch(IllegalArgumentException e)
        {
            System.out.println(e.getMessage());
        }
    }
}