import java.util.Scanner;

class SumOfArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum=0;
        System.out.println("Enter 5 numbers");
        int []arr = new int[5];
        for (int i=0;i<5;i++){
            arr[i]=sc.nextInt();
            sum += arr[i];
        }
        System.out.println("Sum of array = " + sum);
    }
}
