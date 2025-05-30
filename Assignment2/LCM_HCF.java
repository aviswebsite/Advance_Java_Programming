import java.util.Scanner;

public class LCM_HCF {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter two numbers: ");
        int a = sc.nextInt();
        int b = sc.nextInt();

        // Find HCF using Euclidean algorithm
        int x = a, y = b;
        while (y != 0) {
            int temp = y;
            y = x % y;
            x = temp;
        }
        int hcf = x;
        int lcm = (a * b) / hcf;

        System.out.println("HCF = " + hcf);
        System.out.println("LCM = " + lcm);
    }
}
