public class PalindromeArray {
    public static void main(String[] args) {
        // Example Input
        int[] arr = {1, 2, 3, 2, 1};

        boolean isPalindrome = true;
        int n = arr.length;

        // Check each element from start and end moving towards the middle
        for (int i = 0; i < n / 2; i++) {
            if (arr[i] != arr[n - 1 - i]) {
                isPalindrome = false;
                break;
            }
        }

        // Output the result
        System.out.println("Palindrome: " + isPalindrome);
    }
}
