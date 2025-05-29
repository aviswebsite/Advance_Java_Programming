import java.util.Scanner;

public class Average {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        for (int i = 1; i <= 5; i++) {
            System.out.print("Enter number " + i + ": ");
            sum += sc.nextInt();
        }
        double avg = sum / 5.0;
        System.out.println("Average = " + avg);
        sc.close();
    }
}
