import java.util.Scanner;

public class SumOfDigits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a two-digit number: ");
        int num = sc.nextInt();
        int sum = (num / 10) + (num % 10);
        System.out.println("Sum of digits: " + sum);
    }
}
