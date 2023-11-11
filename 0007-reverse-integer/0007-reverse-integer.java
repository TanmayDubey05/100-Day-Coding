class Solution {
    public int reverse(int x) {
      int reversedInteger = 0;
       while (x != 0) {
    int digit = x % 10;
    x /= 10;
    if (reversedInteger > Integer.MAX_VALUE / 10 || reversedInteger < Integer.MIN_VALUE / 10) {
      return 0;
    }
    reversedInteger = reversedInteger * 10 + digit;
  }
  return reversedInteger;
} 
}