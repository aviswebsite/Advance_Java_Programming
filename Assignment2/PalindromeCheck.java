import java.util.Scanner;

public class PalindromeCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        int original = num, rev = 0;

        while (num != 0) {
            int digit = num % 10;
            rev = rev * 10 + digit;
            num /= 10;
        }

        if (original == rev)
            System.out.println(original + " is a Palindrome");
        else
            System.out.println(original + " is not a Palindrome");
    }
}
