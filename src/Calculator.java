import java.util.Scanner;

public class Calculator {

    static int add(int x, int y) { return x + y; }
    static int subtract(int x, int y) { return x - y; }
    static int multiply(int x, int y) { return x * y; }

    static double divide(int x, int y) {
        if (y == 0) {
            System.out.println("Division by zero is undefined.");
            return 0;
        }
        return (double) x / y;
    }

    static int modulus(int x, int y) {
        if (y == 0) {
            System.out.println("Cannot perform modulus with zero.");
            return 0;
        }
        return x % y;
    }

    static double power(int base, int exp) {
        return Math.pow(base, exp);
    }

    static double average(int x, int y) {
        return (x + y) / 2.0;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("🔢 Welcome to MyCalculator!");
        System.out.print("Enter first number: ");
        int num1 = input.nextInt();

        System.out.print("Enter second number: ");
        int num2 = input.nextInt();

        System.out.println("Choose an operation:");
        System.out.println(" +  Addition");
        System.out.println(" -  Subtraction");
        System.out.println(" *  Multiplication");
        System.out.println(" /  Division");
        System.out.println(" %  Modulus");
        System.out.println(" ^  Power");
        System.out.println(" a  Average");

        System.out.print("Your choice: ");
        char operator = input.next().charAt(0);

        double result;

        switch (operator) {
            case '+':
                result = add(num1, num2);
                break;
            case '-':
                result = subtract(num1, num2);
                break;
            case '*':
                result = multiply(num1, num2);
                break;
            case '/':
                result = divide(num1, num2);
                break;
            case '%':
                result = modulus(num1, num2);
                break;
            case '^':
                result = power(num1, num2);
                break;
            case 'a':
                result = average(num1, num2);
                break;
            default:
                System.out.println(" Unknown operation. Try again.");
                return;
        }

        System.out.println(" Result: " + result);
    }
}