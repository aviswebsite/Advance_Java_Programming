import java.util.Scanner;

public class ReverseArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 5 numbers");
        int []arr = new int[5];
        for (int i=0;i<5;i++){
            arr[i]=sc.nextInt();
        }
        int i=0;
        int j=arr.length -1;
        int temp=0;
        while(i<j){
            temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            i++;j--;
        }
        System.out.println("Reversed Array is");
        for (int k=0;k<5;k++){
            System.out.println(arr[k]);
        }
    }
}
