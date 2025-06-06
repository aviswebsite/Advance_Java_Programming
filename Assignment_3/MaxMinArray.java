public class MaxMinArray {
    public static void main(String[] args) {
        int[] arr = {7, 2, 9, 4, 1};

        int max = arr[0];
        int min = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] < min) {
                min = arr[i];
            }
        }

        System.out.println("Max: " + max);
        System.out.println("Min: " + min);
    }
}
