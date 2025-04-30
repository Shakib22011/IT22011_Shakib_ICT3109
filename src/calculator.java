import java.util.Scanner;

public class calculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter first number:");
        double num1 = input.nextDouble();

        System.out.println("Enter second number:");
        double num2 = input.nextDouble();

        System.out.println("Choose operation (+, -, *, /):");
        char op = input.next().charAt(0);

        double result = 0;

        switch(op) {
            case '+': result = num1 + num2; break;
            case '-': result = num1 - num2; break;
            case '*': result = num1 * num2; break;
            case '/':
                if(num2 != 0)
                    result = num1 / num2;
                else
                    System.out.println("Cannot divide by zero!");
                break;
            default: System.out.println("Invalid operation");
        }

        System.out.println("Result: " + result);
    }
}