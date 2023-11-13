class Solution {
    public boolean isPalindrome(int x) {
        // Handle negative numbers
        if (x < 0) {
            return false;
        }

        // Reverse the number
        int reversedNumber = 0;
        int originalNumber = x;
        while (originalNumber > 0) {
            reversedNumber = reversedNumber * 10 + originalNumber % 10;
            originalNumber /= 10;
        }

        // Check if the reversed number is equal to the original number
        return reversedNumber == x;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int x = 121;

        boolean isPalindrome = solution.isPalindrome(x);

        if (isPalindrome) {
            System.out.println("The number " + x + " is a palindrome.");
        } else {
            System.out.println("The number " + x + " is not a palindrome.");
        }
    }
}