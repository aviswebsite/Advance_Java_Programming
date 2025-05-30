import java.util.Scanner;

public class AddOneToDigit
 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        int result = 0, place = 1;

        while (num > 0) {
            int digit = num % 10;
            digit = (digit + 1) % 10;  // Handles 9 -> 0
            result = result + digit * place;
            place *= 10;
            num /= 10;
        }

        System.out.println("New number: " + result);
    }
}
